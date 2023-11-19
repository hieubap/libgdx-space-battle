package com.emreozgenc.spacesurfer.objects.enemy;

import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objects.movement.AccelerationMoving;
import com.emreozgenc.spacesurfer.objects.tools.weapons.LazeGun;
import com.emreozgenc.spacesurfer.objects.tools.weapons.Shield;
import com.emreozgenc.spacesurfer.objects.tools.weapons.TommyGun;
import com.emreozgenc.spacesurfer.utils.CalculateUtils;

public class AccelerationEnemy extends Enemy<AccelerationMoving>{
    public AccelerationEnemy() {
        super();
    }


    @Override
    public void initWeapon() {
        super.initWeapon();
        weapons.add(new LazeGun(this));
        weapons.add(new Shield(true, this));
        weapons.add(new TommyGun(this));
    }
}