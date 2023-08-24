package com.emreozgenc.spacesurfer.objects.tools.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.emreozgenc.spacesurfer.SpaceSurfer;
import com.emreozgenc.spacesurfer.collisions.CollisionRectangle;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objects.movement.EnemyMove;
import com.emreozgenc.spacesurfer.objects.tools.items.core.Item;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.WeaponEvening;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Laze extends Item {
    protected final float deltaPosX = Constant.ENEMY_WIDTH/2 - Constant.LAZE_WIDTH/2;
    protected Sprite sprite;
    private WeaponEvening weaponEvening;
    private float timeAppear = 0;
    private List<Object> listAttacked;

    public Laze(float posX, float posY, WeaponEvening weaponEvening) {
        super(posX, posY,
                new CollisionRectangle(posX, posY,
                Constant.BULLET_WIDTH,SpaceSurfer.HEIGHT)
        );
        width = Constant.LAZE_WIDTH;
        height = SpaceSurfer.HEIGHT;
        damage = 10;
        ignoreEffect = true;
        listAttacked = new ArrayList<>();

        this.weaponEvening = weaponEvening;
        sprite = new Sprite(new Texture(Gdx.files.internal("game-sprites/health.png")));
        sprite.setColor(new Color(0.6f, 0, 0, 1));
        EnemyMove move = weaponEvening.getMoving();
        sprite.setBounds(move.posX + deltaPosX, move.posY - SpaceSurfer.HEIGHT, width, height);
    }

    @Override
    protected void updatePosition(float delta) {
        EnemyMove move = weaponEvening.getMoving();
        posX = move.posX + deltaPosX;
        posY = move.posY - SpaceSurfer.HEIGHT;
        timeAppear += delta;
        if(timeAppear > Constant.LAZE_GUN_TIME_SHOOT){
            destroy();
            timeAppear = 0;
        }
    }

    @Override
    protected void updateRender(float delta) {
        sprite.setBounds(posX,posY,width,height);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public void remove() {

    }

    @Override
    public boolean readyAttack(Object target) {
        final Object tg = target;
        if(!listAttacked.contains(tg)){
            listAttacked.add(tg);
            Timer timerRefresh = new Timer();
            timerRefresh.schedule(new TimerTask(){
                @Override
                public void run(){
                    listAttacked.remove(tg);
                    System.out.println("remove ...");
                }
            },1000);

            return true;
        }
        return false;
    }
}
