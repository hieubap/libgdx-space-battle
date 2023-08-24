package com.emreozgenc.spacesurfer.objects.tools.items;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.emreozgenc.spacesurfer.SpaceSurfer;
import com.emreozgenc.spacesurfer.collisions.CollisionRectangle;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.managers.AssetManager;
import com.emreozgenc.spacesurfer.objects.tools.items.core.Item;

public class RedBullet extends Item {
    protected Animation<TextureRegion> bulletAnim;
    protected TextureRegion renderTexture;
    protected float animTimer;

    protected float velocityX;
    protected float velocityY;

    public RedBullet(float posX, float posY, float velocityX, float velocityY) {
        super(posX, posY,
                new CollisionRectangle(posX, posY,
                        Constant.BULLET_WIDTH,Constant.BULLET_HEIGHT)
        );
        width = Constant.ENEMY_BULLET_WIDTH;
        height = Constant.ENEMY_BULLET_HEIGHT;

        animTimer = 0;
        this.bulletAnim = AssetManager.bulletAnimEnemy;
        renderTexture = bulletAnim.getKeyFrame(animTimer, true);

        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    @Override
    protected void updatePosition(float delta) {
        posX += velocityX * delta;
        posY += velocityY * delta;
    }

    @Override
    protected void updateRender(float delta) {
        animTimer += delta;
        renderTexture = bulletAnim.getKeyFrame(animTimer, true);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(renderTexture,posX, posY,width,height);
    }

    @Override
    public void remove() {
        if(posX < -Constant.BULLET_WIDTH || posY < 0 || posX > SpaceSurfer.WIDTH || posY > SpaceSurfer.HEIGHT){
            destroy();
        }
    }

}
