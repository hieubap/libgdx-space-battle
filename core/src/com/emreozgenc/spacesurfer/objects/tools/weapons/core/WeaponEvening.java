package com.emreozgenc.spacesurfer.objects.tools.weapons.core;

import com.emreozgenc.spacesurfer.objects.movement.EnemyMove;

public interface WeaponEvening {
    boolean getShieldActive();

    EnemyMove getMoving();
    void setShieldActive(boolean shieldActive);
}
