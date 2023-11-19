package com.emreozgenc.spacesurfer.objects.enemy;

import com.emreozgenc.spacesurfer.objects.movement.SineGraphMove;
import com.emreozgenc.spacesurfer.objects.tools.weapons.LazeGun;
import com.emreozgenc.spacesurfer.objects.tools.weapons.Shield;
import com.emreozgenc.spacesurfer.objects.tools.weapons.TommyGun;

public class SineGraphEnemy extends Enemy<SineGraphMove>{
    public SineGraphEnemy() {
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
