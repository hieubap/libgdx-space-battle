package com.emreozgenc.spacesurfer.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.emreozgenc.spacesurfer.SpaceSurfer;
import com.emreozgenc.spacesurfer.collisions.CollisionRectangle;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.objects.tools.items.RedBullet;
import com.emreozgenc.spacesurfer.objects.tools.items.core.Item;
import com.emreozgenc.spacesurfer.screens.MainMenuScreen;

public class MainShip {
    private float posX;
    private float posY;
    private Texture shipTexture;
    private HealthBar healthBar;
    private TextureRegion renderTexture;
    private Animation<TextureRegion> idle;
    private Animation<TextureRegion> left1;
    private Animation<TextureRegion> left2;
    private Animation<TextureRegion> right1;
    private Animation<TextureRegion> right2;
    private CollisionRectangle col;
    private Sound fireSound;
    private Sound takeDamageSound;

    // Animation timers
    private float stateTimer;
    private float changeTimer;
    private int state;

    // Bullet texture
    private Texture bulletTexture;

    private Animation<TextureRegion> bulletAnim;
    private float fireTimer;

    public MainShip(float posX, float posY, OrthographicCamera camera) {
        this.posX = posX;
        this.posY = posY;
        col = new CollisionRectangle(posX, posY,
                Constant.MAIN_SHIP_WIDTH,
                Constant.MAIN_SHIP_HEIGHT);
        stateTimer = 0;
        changeTimer = 0;
        state = 0;
        fireTimer = 0;
        takeDamageSound = Gdx.audio.newSound(Gdx.files.internal("sounds/takedamage.wav"));
        fireSound = Gdx.audio.newSound(Gdx.files.internal("sounds/mainfire.wav"));
        shipTexture = new Texture(Gdx.files.internal("game-sprites/mainship.png"));
        bulletTexture = new Texture((Gdx.files.internal("game-sprites/bullets.png")));
        healthBar = new HealthBar(Constant.HEALTH_BAR_PADDING, SpaceSurfer.WIDTH, Constant.MAIN_SHIP_HEALTH);
        healthBar.setHeight(5);
        // Ship animation initialize

        TextureRegion[][] tmp = TextureRegion.split(shipTexture,
                Constant.MAIN_SHIP_TILE_WIDTH,
                Constant.MAIN_SHIP_TILE_HEIGHT);

        left2 = new Animation<TextureRegion>(Constant.MAIN_SHIP_FRAME_TIME, tmp[0]);
        left1 = new Animation<TextureRegion>(Constant.MAIN_SHIP_FRAME_TIME, tmp[1]);
        idle = new Animation<TextureRegion>(Constant.MAIN_SHIP_FRAME_TIME, tmp[2]);
        right1 = new Animation<TextureRegion>(Constant.MAIN_SHIP_FRAME_TIME, tmp[3]);
        right2 = new Animation<TextureRegion>(Constant.MAIN_SHIP_FRAME_TIME, tmp[4]);

        // Bullet animation initialize

        TextureRegion[][] tmp2 = TextureRegion.split(bulletTexture,
                Constant.MAIN_BULLET_TILE_WIDTH,
                Constant.MAIN_BULLET_TILE_HEIGHT);
        bulletAnim = new Animation<TextureRegion>(Constant.MAIN_BULLET_FRAME_TIME, tmp2[1]);

    }

    public void render(SpriteBatch batch) {
        batch.draw(renderTexture, posX, posY, Constant.MAIN_SHIP_WIDTH, Constant.MAIN_SHIP_HEIGHT);
        healthBar.draw(batch);
    }

    public void update(float delta) {
        handleMovement(delta);
        handleAnimation(delta);
        fire(delta);
        col.updatePosition(posX, posY);
        takeDamage();
    }

    private void takeDamage() {
        for (Item bullet : ObjectArrays.itemEnemy) {
            if (bullet.getCollision().isCollide(col)) {
                if(!bullet.ignoreEffect){
                    bullet.destroy();
                }
                if (bullet.readyAttack(this)){
                    decreaseHealth(bullet.getDamage());
                }
                if (SpaceSurfer.preferences.getBoolean("sound_setting")) {
//                    takeDamageSound.play(0.7f);
                }
                if (SpaceSurfer.preferences.getBoolean("vibrate_setting")) {
//                    Gdx.input.vibrate(100);
                }
            }
        }
    }

    private void decreaseHealth(int damage) {
        healthBar.changeLife(-damage);
        healthBar.update();
        if(healthBar.health <= 0) {
            SpaceSurfer game = (SpaceSurfer) Gdx.app.getApplicationListener();
            game.setScreen(new MainMenuScreen(game));
            ObjectArrays.clearAll();
        }
    }

    private void handleMovement(float delta) {
        final int screenWidth = Gdx.graphics.getWidth();

        if (Gdx.input.isTouched()) {
            if (Gdx.input.getX() > screenWidth / 2) {
                posX += delta * Constant.MAIN_SHIP_SPEED;
            } else {
                posX -= delta * Constant.MAIN_SHIP_SPEED;
            }

            if (posX < 5)
                posX = 5;

            if (posX > SpaceSurfer.WIDTH - Constant.MAIN_SHIP_WIDTH - 5)
                posX = SpaceSurfer.WIDTH - Constant.MAIN_SHIP_WIDTH - 5;
        }
    }

    private void handleAnimation(float delta) {
        final int screenWidth = Gdx.graphics.getWidth();
        stateTimer += delta;

        if (Gdx.input.isTouched()) {
            changeTimer += delta;
            if (Gdx.input.getX() < screenWidth / 2) {
                if (Math.abs(changeTimer) > Constant.MAIN_SHIP_CHANGE_TIME) {
                    state--;
                    changeTimer = 0;

                    if (state < -2)
                        state = -2;
                }

                if (state == -1)
                    renderTexture = left1.getKeyFrame(stateTimer, true);

                if (state == -2)
                    renderTexture = left2.getKeyFrame(stateTimer, true);
            } else {
                if (Math.abs(changeTimer) > Constant.MAIN_SHIP_CHANGE_TIME) {
                    state++;
                    changeTimer = 0;

                    if (state > 2)
                        state = 2;
                }

                if (state == 1)
                    renderTexture = right1.getKeyFrame(stateTimer, true);

                if (state == 2)
                    renderTexture = right2.getKeyFrame(stateTimer, true);
            }
            if (state == 0)
                renderTexture = idle.getKeyFrame(stateTimer, true);
        } else {
            changeTimer += delta;
            if (state < 0) {
                if (Math.abs(changeTimer) > Constant.MAIN_SHIP_CHANGE_TIME) {
                    state++;
                    changeTimer = 0;
                }
            }

            if (state > 0) {
                if (Math.abs(changeTimer) > Constant.MAIN_SHIP_CHANGE_TIME) {
                    state--;
                    changeTimer = 0;
                }
            }

            if (state == -1)
                renderTexture = left1.getKeyFrame(stateTimer, true);

            else if (state == -2)
                renderTexture = left2.getKeyFrame(stateTimer, true);

            else if (state == 1)
                renderTexture = right1.getKeyFrame(stateTimer, true);

            else if (state == 2)
                renderTexture = right2.getKeyFrame(stateTimer, true);
            else if (state == 0)
                renderTexture = idle.getKeyFrame(stateTimer, true);
        }
    }

    private void fire(float delta) {
        fireTimer += delta;
        if (Math.abs(fireTimer) > Constant.MAIN_SHIP_FIRE_RATE) {
            ObjectArrays.itemMain.add(new RedBullet(
                    posX + Constant.MAIN_BULLET_WIDTH / 2,posY,
                    0,Constant.MAIN_BULLET_SPEED
            ));
//            ObjectArrays.mainWeapons.add(new BlueBullet(
//                    posX + Constant.MAIN_BULLET_WIDTH / 2,
//                    posY
//            ));
            fireTimer = 0;
            if (SpaceSurfer.preferences.getBoolean("sound_setting")) {
                fireSound.play(0.3f);
            }
        }
    }

    public void dispose() {
        shipTexture.dispose();
        fireSound.dispose();
        takeDamageSound.dispose();
        bulletTexture.dispose();
    }
}
