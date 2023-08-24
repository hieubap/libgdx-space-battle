package com.emreozgenc.spacesurfer.objects.movement;

import com.emreozgenc.spacesurfer.SpaceSurfer;
import com.emreozgenc.spacesurfer.constant.Constant;

public class HorizontalMove extends EnemyMove{
    /**
     * 2: di chuyển rời khỏi màn hình,
     * +-1: di chuyển sang trái và phải
     *
     * */
    private float direct = 1;
    private float appearTimer = 0;

    @Override
    public void updatePosition(float delta) {
        if(posY > Constant.ENEMY_HOR_POS_Y && direct != 2){
            posY -= delta * Constant.HORIZONTAL_SPEED;
            return;
        }
        if(posY > Constant.ENEMY_POS_Y_DESTROY){
            moveEvening.destroy();
            return;
        }
        appearTimer += delta;
        if(appearTimer >= Constant.ENEMY_HOR_APPEAR_TIME){
            posY += delta * Constant.HORIZONTAL_SPEED;
            direct = 2;
        } else {
            posX += direct * delta * Constant.HORIZONTAL_SPEED;
            if(posX < 0 || posX > SpaceSurfer.WIDTH - Constant.ENEMY_WIDTH){
                direct = -direct;
            }
        }
    }
}
