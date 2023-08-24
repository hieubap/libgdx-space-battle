package com.emreozgenc.spacesurfer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.emreozgenc.spacesurfer.SpaceSurfer;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.managers.CloudManager;
import com.emreozgenc.spacesurfer.managers.EnemyManager;
import com.emreozgenc.spacesurfer.managers.ExplosionManager;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.objects.Cloud;
import com.emreozgenc.spacesurfer.objects.enemy.Enemy;
import com.emreozgenc.spacesurfer.objects.Explosion;
import com.emreozgenc.spacesurfer.objects.MainShip;
import com.emreozgenc.spacesurfer.objects.ScoreText;
import com.emreozgenc.spacesurfer.objects.tools.items.core.Item;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.Weapon;


public class GameScreen implements Screen {
    // Access main game class
    private SpaceSurfer game;


    private Stage stage;
    private Table table;

    // Sprite batch for drawing
    private SpriteBatch batch;

    // Background texture
    private Texture background;

    // Main ship
    public MainShip mainShip;

    // Cloud manager
    private CloudManager cloudManager;

    // Enemy manager
    private EnemyManager enemyManager;

    // Explosion manager
    private ExplosionManager explosionManager;

    // Player score
    public static int score;
    private ScoreText scoreText;

    // Screen constructor
    public GameScreen(SpaceSurfer game) {
        this.game = game;
        batch = new SpriteBatch();
        Gdx.graphics.setVSync(true);
        background = new Texture(Gdx.files.internal("game-sprites/background.png"));
        mainShip = new MainShip((float) (SpaceSurfer.WIDTH / 2 - Constant.MAIN_SHIP_WIDTH / 2),
                20,game.cam);
        cloudManager = new CloudManager();
        enemyManager = new EnemyManager();
        explosionManager = new ExplosionManager();
        scoreText = new ScoreText();
        score = 0;
        stageInit();
    }

    private void stageInit() {
        stage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(stage);
        table = new Table();
        Skin skin = new Skin(Gdx.files.internal("ui-sprites/ui_skin.json"));
        table.setBounds(0, 0, SpaceSurfer.WIDTH, SpaceSurfer.HEIGHT);
        table.setFillParent(true);
        table.align(Align.right | Align.top);

        final TextButton exitButton = new TextButton("X", skin);

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SpaceSurfer temp = (SpaceSurfer) Gdx.app.getApplicationListener();
                temp.setScreen(new MainMenuScreen(temp));
            }
        });

        table.add(exitButton).size(25, 25).padTop(10).padRight(10);
        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    private void update(float delta) {

        mainShip.update(delta);
        cloudManager.update(delta);
        enemyManager.update(delta);
        scoreText.update();

        // Main bullets update
        for (Item item : ObjectArrays.itemMain) {
            item.update(delta);
        }
        // Main bullets update
        for (Item item : ObjectArrays.itemEnemy) {
            item.update(delta);
        }

        // Main weapon update
        for (Weapon item : ObjectArrays.weaponMains) {
            item.update(delta);
        }
        // Enemy weapon update
        for (Weapon item : ObjectArrays.weaponEnemies) {
            item.update(delta);
        }

        // Clouds update
        for (Cloud cloud : ObjectArrays.clouds) {
            cloud.update(delta);
        }

        // Enemies update
        for (Enemy enemy : ObjectArrays.enemies) {
            enemy.update(delta);
        }

        // Explosions update
        for (Explosion explosion : ObjectArrays.explosions) {
            explosion.update(delta);
        }
    }

    private void render2(SpriteBatch batch) {
        batch.draw(background, 0, 0, SpaceSurfer.WIDTH, SpaceSurfer.HEIGHT);

        for (Cloud cloud : ObjectArrays.clouds) {
            cloud.render(batch);
        }

        for (Item item : ObjectArrays.itemMain) {
            item.draw(batch);
        }

        for (Item item : ObjectArrays.itemEnemy) {
            item.draw(batch);
        }

        for (Weapon item : ObjectArrays.weaponMains) {
            item.draw(batch);
        }

        for (Weapon item : ObjectArrays.weaponEnemies) {
            item.draw(batch);
        }

        for (Enemy enemy : ObjectArrays.enemies) {
            enemy.render(batch);
        }

        for (Explosion explosion : ObjectArrays.explosions) {
            explosion.render(batch);
        }
        mainShip.render(batch);
        scoreText.render(batch);
    }

    private void remove(float delta) {
        for (Item item : ObjectArrays.Ritems) {
            ObjectArrays.itemMain.removeValue(item, true);
            ObjectArrays.itemEnemy.removeValue(item, true);
        }
        ObjectArrays.Ritems.clear();

        for (Weapon item : ObjectArrays.Rweapons) {
            ObjectArrays.weaponMains.removeValue(item, true);
            ObjectArrays.weaponEnemies.removeValue(item, true);
        }
        ObjectArrays.Rweapons.clear();


        for (Cloud cloud : ObjectArrays.Rclouds) {
            ObjectArrays.clouds.removeValue(cloud, true);
        }
        ObjectArrays.Rclouds.clear();

        for (Enemy enemy : ObjectArrays.Renemies) {
            ObjectArrays.enemies.removeValue(enemy, true);
        }
        ObjectArrays.Renemies.clear();

//        for (RedBullet bullet : ObjectArrays.Rweapons) {
//
//            ObjectArrays.Rweapons.removeValue(bullet, true);
//        }
//        ObjectArrays.RenemyBullets.clear();

        for (Explosion explosion : ObjectArrays.Rexplosions) {
            ObjectArrays.explosions.removeValue(explosion, true);
        }
        ObjectArrays.Rexplosions.clear();
    }

    int count = 0;
    @Override
    public void render(float delta) {
        long tStart = System.currentTimeMillis();
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Before drawing we need update our objects
        update(delta);

        //Sprite batch settings
        batch.setProjectionMatrix(game.cam.combined);
        game.cam.update();
        long tUpdate = System.currentTimeMillis();

        batch.begin();
        render2(batch);
        batch.end();

        stage.act(delta);
        stage.draw();
        //After draw if we need remove something in scene
        remove(delta);
        if(System.currentTimeMillis() - tStart > 16){
            count++;
        }
//        System.out.println("update: " + (tUpdate - tStart) + ", render: " + (System.currentTimeMillis() - tUpdate) + ", total: " + (System.currentTimeMillis() - tStart) + ", count: " + count);
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        background.dispose();
        mainShip.dispose();
    }
}
