package com.emreozgenc.spacesurfer.objects.tools.items.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.emreozgenc.spacesurfer.collisions.CollisionRectangle;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;

public abstract class Item {
    protected float posX;
    protected float posY;
    protected int damage;
    public boolean ignoreEffect = false;

    protected float width;
    protected float height;
    protected CollisionRectangle collision;

    public Item(float posX, float posY, CollisionRectangle collision){
        this.posX = posX;
        this.posY = posY;
        this.damage = 1;
        this.collision = collision;
//        collision = new CollisionRectangle(posX,posY,1,1);
    }

    public void update(float delta) {
        updatePosition(delta);
        collision.updatePosition(posX, posY);
        updateRender(delta);
        remove();
    }

    protected abstract void updatePosition(float delta);
    protected abstract void updateRender(float delta);
    public abstract void draw(SpriteBatch batch);
    public abstract void remove();

    public boolean readyAttack(Object target){
        return true;
    }

    public void destroy(){
        ObjectArrays.Ritems.add(this);
    }

    public int getDamage() {
        return damage;
    }

    public CollisionRectangle getCollision() {
        return collision;
    }

}
