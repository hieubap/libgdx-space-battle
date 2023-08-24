package com.emreozgenc.spacesurfer.objects.movement;

import com.emreozgenc.spacesurfer.SpaceSurfer;
import com.emreozgenc.spacesurfer.constant.Constant;

public class ZigzagMove extends EnemyMove{
    private float direct = 1;

    @Override
    public void updatePosition(float delta) {
        posY -= delta * Constant.ZIGZAG_SPEED;
        if(posY > Constant.ENEMY_MIN_POS_Y){
            posX += direct * delta * Constant.ZIGZAG_SPEED;
            if(posX < 0 || posX > SpaceSurfer.WIDTH - Constant.ENEMY_WIDTH){
                direct = -direct;
            }
        } else {
            moveEvening.destroy();
        }
    }
}
