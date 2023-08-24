package com.emreozgenc.spacesurfer.objects.enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.emreozgenc.spacesurfer.SpaceSurfer;
import com.emreozgenc.spacesurfer.collisions.CollisionRectangle;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.managers.AssetManager;
import com.emreozgenc.spacesurfer.managers.ExplosionManager;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.objects.HealthBar;
import com.emreozgenc.spacesurfer.objects.tools.items.core.Item;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.WeaponEvening;
import com.emreozgenc.spacesurfer.objects.movement.EnemyMove;
import com.emreozgenc.spacesurfer.objects.movement.MoveEvening;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.Weapon;
import com.emreozgenc.spacesurfer.screens.GameScreen;
import com.emreozgenc.spacesurfer.utils.GenericUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Enemy<Move extends EnemyMove>
        implements MoveEvening, WeaponEvening {
    // attribute
    protected boolean shieldActive = false;

    protected Animation<TextureRegion> enemyAnim;
    protected Random rand;
    protected CollisionRectangle col;
    protected float stateTimer;
    protected float fireTimer;
    protected TextureRegion renderTexture;
    protected Sound explosionSound;
    protected HealthBar healthBar;

    protected Move movement;
    protected List<Weapon> weapons;

    public Enemy() {
        this.enemyAnim = AssetManager.enemyAnim;
        rand = new Random();
        healthBar = new HealthBar(10,Constant.ENEMY_WIDTH,Constant.ENEMY_HEALTH);
        healthBar.setHeight(5);
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.wav"));
        stateTimer = 0;
        fireTimer = 0;
        movement = GenericUtils.getInstantGeneric(0,this);
        movement.init(this);

        initWeapon();
        col = new CollisionRectangle(movement.posX, movement.posY, Constant.ENEMY_WIDTH, Constant.ENEMY_HEIGHT);
    }

    public CollisionRectangle getCollision() {
        return col;
    }

    public void update(float delta) {
        stateTimer += delta;
        fireTimer += delta;
        movement.updatePosition(delta);
        col.updatePosition(movement.posX, movement.posY);
        renderTexture = enemyAnim.getKeyFrame(stateTimer, true);
        healthBar.update(movement.posX,movement.posY + Constant.ENEMY_HEIGHT);
        beingAttacked();
    }

    public void render(SpriteBatch batch) {
        batch.draw(renderTexture,
                movement.posX,
                movement.posY,
                Constant.ENEMY_WIDTH,
                Constant.ENEMY_HEIGHT);
        healthBar.draw(batch);
    }

    public void beingAttacked(){
        for (Item bullet : ObjectArrays.itemMain) {
            if (bullet.getCollision().isCollide(col)) {
                bullet.destroy();
                if(!shieldActive){
                    healthBar.changeLife(-bullet.getDamage());
                }
                if(healthBar.health <= 0){
                    destroy();
                    ExplosionManager.createExplosion(movement.posX,movement.posY);
                    GameScreen.score++;
                    if (SpaceSurfer.preferences.getBoolean("sound_setting")) {
                        explosionSound.play(0.3f);
                    }

                    if(SpaceSurfer.highScore.getInteger("high_score") < GameScreen.score) {
                        SpaceSurfer.highScore.putInteger("high_score", GameScreen.score);
                        SpaceSurfer.highScore.flush();
                    }
                }
            }
        }
    }

    @Override
    public void destroy(){
        if(!ObjectArrays.Renemies.contains(this,true)){
            ObjectArrays.Renemies.add(this);
            for (Weapon weapon : weapons){
                ObjectArrays.Rweapons.add(weapon);
            }
        }
    }

    @Override
    public EnemyMove getMoving() {
        return movement;
    }

    @Override
    public boolean getShieldActive() {
        return this.shieldActive;
    }

    @Override
    public void setShieldActive(boolean shieldActive) {
        this.shieldActive = shieldActive;
    }

    public void initWeapon(){
        weapons = new ArrayList<>();
    };
}
