package com.emreozgenc.spacesurfer.utils;

public class CalculateUtils {
    public static float[] getVelocity(float x1, float y1, float x2, float y2, float v){
        float deltaX = x2 - x1;
        float deltaY = y2 - y1;
        double deltaAngle = Math.atan(deltaX/deltaY);

        float vx = (float)(v*Math.sin(deltaAngle));
        float vy = (float)(v*Math.cos(deltaAngle));

        if(deltaX * vx < 0) vx = -vx;
        if(deltaY * vy < 0) vy = -vy;

        return new float[]{vx,vy};
    }
    public static boolean nearest(float x1, float y1, float x2, float y2, float v   ){
        float deltaX = x2 - x1;
        float deltaY = y2 - y1;
        double deltaAngle = Math.atan(deltaX/deltaY);

        return true;
    }
}
