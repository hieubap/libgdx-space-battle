package com.emreozgenc.spacesurfer.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HealthBar {
    private Sprite sprite;
    public float maxWidth, maxHealth;
    public int padding;
    public float width, height, health;
    public float x,y;


    public HealthBar(int padding,int maxWidth,int maxHealth) {
        this.maxWidth = maxWidth - padding*2;
        this.maxHealth = maxHealth;
        this.padding = padding;

        x = 0;
        y = 0;
        width = this.maxWidth;
        height = 5;
        health = maxHealth;
        sprite = new Sprite(new Texture(Gdx.files.internal("game-sprites/health.png")));
        sprite.setColor(new Color(0, 1, 0, 1));
        sprite.setBounds(padding, 10, width, height);
    }

    public void changeLife(int delta){
        this.health += delta;
        this.width = (maxWidth / maxHealth) * this.health;
        if(health <= maxHealth/4)
            sprite.setColor(new Color(1, 0, 0, 1));
        else if(health <= maxHealth/2)
            sprite.setColor(new Color(1, 1, 0, 1));
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

    public void setHeight(int height){
        this.height = height;
        sprite.setRegionHeight(height);
    }

    public void update(){
        sprite.setBounds(this.x + padding,y+10,width,height);
    }

    public void update(float x, float y){
        this.x = x;
        this.y = y;
        sprite.setBounds(x+padding,y,width,height);
    }
}
