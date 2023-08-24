package com.emreozgenc.spacesurfer.objects.tools.weapons;

import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.objects.movement.EnemyMove;
import com.emreozgenc.spacesurfer.objects.tools.items.RedBullet;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.WeaponEvening;

public class DoubleGun extends PistolGun {
    public DoubleGun(WeaponEvening weaponEvening) {
        super(true, weaponEvening);
    }

    @Override
    public void update(float delta) {
        fireTimer += delta;
        if(fireTimer > Constant.RANDOM_GUN_TIME){
            EnemyMove move = weaponEvening.getMoving();
            ObjectArrays.itemEnemy.add(
                    new RedBullet(move.posX + Constant.ENEMY_WIDTH / 4,
                            move.posY,
                            Constant.BULLET_SPEED * 0.2f,
                            -Constant.BULLET_SPEED)
            );
            ObjectArrays.itemEnemy.add(
                    new RedBullet(move.posX + Constant.ENEMY_WIDTH / 4,
                            move.posY,
                            -Constant.BULLET_SPEED * 0.2f,
                            -Constant.BULLET_SPEED)
            );

            fireTimer = 0;
        }
    }
}
