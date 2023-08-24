package com.emreozgenc.spacesurfer.objects.tools.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.objects.movement.EnemyMove;
import com.emreozgenc.spacesurfer.objects.tools.items.Laze;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.Weapon;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.WeaponEvening;

public class LazeGun extends PistolGun {
    public LazeGun(WeaponEvening weaponEvening) {
        super(true, weaponEvening);
    }

    @Override
    public void update(float delta) {
        fireTimer += delta;
        if(fireTimer > Constant.LAZE_GUN_TIME_FIRE){
            EnemyMove move = weaponEvening.getMoving();
            ObjectArrays.itemEnemy.add(
                    new Laze(move.posX + Constant.ENEMY_WIDTH / 4,
                            move.posY,
                            weaponEvening)
            );
            fireTimer = 0;
        }
    }
}
