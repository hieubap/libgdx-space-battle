package com.emreozgenc.spacesurfer.objects.enemy;

import com.emreozgenc.spacesurfer.objects.movement.ZigzagMove;
import com.emreozgenc.spacesurfer.objects.tools.weapons.LazeGun;
import com.emreozgenc.spacesurfer.objects.tools.weapons.Shield;
import com.emreozgenc.spacesurfer.objects.tools.weapons.TommyGun;

public class ZigzagEnemy extends Enemy<ZigzagMove> {
    public ZigzagEnemy() {
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
