package com.emreozgenc.spacesurfer.objects.movement;

// quản lý di chuyển và biến mất khỏi khung hình
// bao gồm bị tấn công

import com.emreozgenc.spacesurfer.constant.Constant;

public abstract class EnemyMove{
    public float posX;
    public float posY;

    public MoveEvening moveEvening;

    public void init(MoveEvening moveEvening) {
        posY = Constant.ENEMY_POS_Y_DESTROY;
        posX = (float)(Math.random() * Constant.ENEMY_MAX_POS_X);
        this.moveEvening = moveEvening;
    }

    // thực hiện cập nhật vị trí và xử lý biến mất khỏi khung hình
    public abstract void updatePosition(float delta);
}
