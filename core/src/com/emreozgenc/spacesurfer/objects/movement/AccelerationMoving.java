package com.emreozgenc.spacesurfer.objects.movement;

import com.emreozgenc.spacesurfer.SpaceSurfer;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.utils.CalculateUtils;

public class AccelerationMoving extends EnemyMove{
    private float targetX, targetY;
    private float speedTimer = 0;
    private float appearTimer = 0;
    private float[] velocity = new float[]{0,0};

    @Override
    public void init(MoveEvening moveEvening) {
        super.init(moveEvening);
        randomTarget(0.03f);
    }

    @Override
    public void updatePosition(float delta) {
        speedTimer += delta;
        appearTimer += delta;
        if(posY > Constant.ENEMY_POS_Y_DESTROY){
            moveEvening.destroy();
        }else if(appearTimer >= Constant.ENEMY_ACCELERATE_APPEAR_TIME && velocity[0] != 0){
            velocity[0] = 0;
            velocity[1] = delta * Constant.ENEMY_ACCELERATE_SPEED;
        }else if(speedTimer >= Constant.ENEMY_ACCELERATE_TIME){
            randomTarget(delta);
            speedTimer = 0;
        }else if(Math.abs(targetX - posX) < Math.abs(velocity[0])
                && Math.abs(targetY - posY) < Math.abs(velocity[1])){
            velocity = new float[]{0,0};
            posX = targetX;
            posY = targetY;
        }

        posX += velocity[0];
        posY += velocity[1];
    }

    private void randomTarget(float delta){
        int halfW = SpaceSurfer.WIDTH / 2;
        int halfH = SpaceSurfer.HEIGHT / 2;

        targetX = (float)(Math.random() * halfW);
        if(posX < halfW){
            targetX += halfW - Constant.ENEMY_WIDTH;
        }
        targetY = (float)(Math.random() * halfH) + halfH - Constant.ENEMY_HEIGHT;
        velocity = CalculateUtils.getVelocity(posX,posY, targetX,targetY,delta * Constant.ENEMY_ACCELERATE_SPEED);
    }
}
