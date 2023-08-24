package com.emreozgenc.spacesurfer.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.emreozgenc.spacesurfer.constant.Constant;

public class AssetManager {
    public static Animation<TextureRegion> enemyAnim;
    public static Animation<TextureRegion> bulletAnimEnemy;
    public static Animation<TextureRegion> bulletAnimPlayer;

    public static void loadAsset(){
        Texture enemyTexture = new Texture(Gdx.files.internal("game-sprites/enemy.png"));
        TextureRegion[][] tmp = TextureRegion.split(enemyTexture,
                Constant.ENEMY_TILE_WIDTH,
                Constant.ENEMY_TILE_HEIGHT);
        enemyAnim = new Animation<TextureRegion>(Constant.ENEMY_FRAME_TIME, tmp[0]);


        Texture bulletTexture = new Texture(Gdx.files.internal("game-sprites/bullets.png"));
        TextureRegion[][] tmp2 = TextureRegion.split(bulletTexture,
                Constant.ENEMY_BULLET_TILE_WIDTH,
                Constant.ENEMY_BULLET_TILE_HEIGHT);
        bulletAnimEnemy = new Animation<TextureRegion>(Constant.ENEMY_BULLET_FRAME_TIME, tmp2[0]);
        bulletAnimPlayer = new Animation<TextureRegion>(Constant.MAIN_BULLET_FRAME_TIME, tmp2[1]);
    }
}
