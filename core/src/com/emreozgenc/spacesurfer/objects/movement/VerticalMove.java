package com.emreozgenc.spacesurfer.objects.movement;

import com.emreozgenc.spacesurfer.constant.Constant;

public class VerticalMove extends EnemyMove{

    @Override
    public void updatePosition(float delta) {
        posY -= delta * Constant.VERTICAL_SPEED;

        if (posY < Constant.ENEMY_MIN_POS_Y) {
            moveEvening.destroy();
        }
    }
}
