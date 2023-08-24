package com.emreozgenc.spacesurfer.objects.tools.items;

import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.utils.CalculateUtils;

public class TargetBullet extends RedBullet{
    public TargetBullet(float posX, float posY, float targetX, float targetY) {
        super(posX, posY, 0, 0);

        float[] velocity = CalculateUtils.getVelocity(posX,posY,
                targetX,targetY,
                Constant.ENEMY_ACCELERATE_SPEED*0.16f);
        velocityX = velocity[0];
        velocityY = velocity[1];
    }
}
