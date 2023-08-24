package com.emreozgenc.spacesurfer.objects.enemy;

import com.emreozgenc.spacesurfer.objects.movement.VerticalMove;
import com.emreozgenc.spacesurfer.objects.tools.weapons.TommyGun;

public class VerticalEnemy extends Enemy<VerticalMove> {
    public VerticalEnemy() {
        super();
    }

    @Override
    public void initWeapon() {
        super.initWeapon();
//        weapons.add(new Gun(true, this));
//        weapons.add(new Shield(true, this));
        weapons.add(new TommyGun(this));
    }
}
