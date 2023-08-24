package com.emreozgenc.spacesurfer.objects.movement;

import com.emreozgenc.spacesurfer.constant.Constant;

public class SineGraphMove extends EnemyMove{
    private int directX = 1;
    private int directY = 1;
    private float startY = 0;

    @Override
    public void init(MoveEvening moveEvening) {
        super.init(moveEvening);
        directX = (int)Math.round(Math.random())*2 - 1;
        startY = (float)(Math.random() * Constant.SIN_GRAPH_RANGE_Y_RANDOM) + Constant.SIN_GRAPH_RANGE_Y_FROM;
        posY = startY;

        if(directX > 0){
            posX = Constant.SIN_GRAPH_LEFT;
        }else{
            posX = Constant.SIN_GRAPH_RIGHT;
        }
    }

    @Override
    public void updatePosition(float delta) {
        posX += directX * delta * Constant.SIN_GRAPH_SPEED;
        if(posX < Constant.SIN_GRAPH_LEFT || posX > Constant.SIN_GRAPH_RIGHT){
            directX = -directX;
            startY -= 2*Constant.ENEMY_HEIGHT;
            posY = startY;
            if(posY < Constant.SIN_GRAPH_POS_Y_DESTROY){
                moveEvening.destroy();
            }
        }

        posY += directY * delta * Constant.SIN_GRAPH_SPEED;
        if(Math.abs(posY - startY) > Constant.ENEMY_HEIGHT){
            directY = -directY;
        }


    }
}
