package com.emreozgenc.spacesurfer.objects.tools.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objects.movement.EnemyMove;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.WeaponEvening;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.Weapon;

public class Shield extends Weapon {
    private Sprite sprite;
    private float timer;

    public Shield(boolean isEnemy, WeaponEvening weaponManager) {
        super(isEnemy, weaponManager);
        preventAttacked = true;
        sprite = new Sprite(new Texture(Gdx.files.internal("game-sprites/health.png")));
        sprite.setColor(new Color(0, 128f/256, 240f/256, 0.3f));
    }

    @Override
    public void update(float delta) {
        EnemyMove move = weaponEvening.getMoving();
        sprite.setBounds(move.posX, move.posY, Constant.ENEMY_WIDTH, Constant.ENEMY_HEIGHT);

        timer += delta;
        if(timer > Constant.SHIELD_TIME_INACTIVE){
            weaponEvening.setShieldActive(true);
            timer = 0;
        }else if(timer > Constant.SHIELD_TIME_ACTIVE && weaponEvening.getShieldActive()){
            weaponEvening.setShieldActive(false);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        if(weaponEvening.getShieldActive()){
            sprite.draw(batch);
        }
    }
}
