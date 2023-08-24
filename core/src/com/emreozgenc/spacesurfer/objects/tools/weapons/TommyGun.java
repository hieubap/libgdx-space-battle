package com.emreozgenc.spacesurfer.objects.tools.weapons;

import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.objects.movement.EnemyMove;
import com.emreozgenc.spacesurfer.objects.tools.items.RedBullet;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.WeaponEvening;

public class TommyGun extends PistolGun {
    public TommyGun(WeaponEvening manager) {
        super(true,manager);
    }

    @Override
    public void update(float delta) {
        fireTimer += delta;
        if(fireTimer > Constant.TOMMY_GUN_TIME){
            EnemyMove move = weaponEvening.getMoving();
            for (int i=0;i<5;i++){
                ObjectArrays.itemEnemy.add(
                        new RedBullet(move.posX - Constant.BULLET_WIDTH/2  + i * Constant.ENEMY_WIDTH / 4,
                                move.posY,
                                0,
                                -Constant.BULLET_SPEED_x5)
                );
            }
            fireTimer = 0;
        }
    }
}
