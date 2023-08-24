package com.emreozgenc.spacesurfer.objects.tools.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.objects.movement.EnemyMove;
import com.emreozgenc.spacesurfer.objects.tools.items.RedBullet;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.WeaponEvening;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.Weapon;

public class PistolGun extends Weapon {
    protected float fireTimer;

    public PistolGun(boolean isEnemy, WeaponEvening manager) {
        super(isEnemy, manager);
        this.fireTimer = 0;
    }

    @Override
    public void update(float delta) {
        fireTimer += delta;
        if(fireTimer > Constant.GUN_TIME){
            EnemyMove move = weaponEvening.getMoving();
            if(isEnemy){
                ObjectArrays.itemEnemy.add(new RedBullet(move.posX + Constant.ENEMY_WIDTH / 4, move.posY, 0, -Constant.BULLET_SPEED));
            }else{
                ObjectArrays.itemMain.add(new RedBullet(move.posX, move.posY, 0, Constant.BULLET_SPEED));
            }

            fireTimer = 0;
        }
    }

    @Override
    public void draw(SpriteBatch batch) {

    }
}
