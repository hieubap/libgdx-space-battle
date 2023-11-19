package com.emreozgenc.spacesurfer.constant;

import com.emreozgenc.spacesurfer.SpaceSurfer;

public final class Constant {
    // Main ship constants
    public static final int MAIN_SHIP_WIDTH = 64/2;
    public static final int MAIN_SHIP_HEIGHT = 96/2;
    public static final float MAIN_SHIP_FRAME_TIME = 0.1f;
    public static final int MAIN_SHIP_TILE_WIDTH = 16;
    public static final int MAIN_SHIP_TILE_HEIGHT = 24;
    public static final int MAIN_SHIP_SPEED = 400;
    public static final float MAIN_SHIP_CHANGE_TIME = 0.1f;
    public static final float MAIN_SHIP_FIRE_RATE = 0.5f;
    public static int MAIN_SHIP_HEALTH = 150;

    // Main bullet constants
    public static final int MAIN_BULLET_TILE_WIDTH = 16;
    public static final int MAIN_BULLET_TILE_HEIGHT = 16;
    public static final float MAIN_BULLET_FRAME_TIME = 0.25f;
    public static final int MAIN_BULLET_MAX_POS_Y = SpaceSurfer.HEIGHT + 20;
    public static final int MAIN_BULLET_WIDTH = 32;
    public static final int MAIN_BULLET_HEIGHT = 32;
    public static final int MAIN_BULLET_SPEED = 750;

    // Cloud manager constants
    public static final float CLOUD_MANAGER_SPAWN_MAX_TIME = 15f;
    public static final float CLOUD_MANAGER_SPAWN_MIN_TIME = 7.5f;
    public static final int CLOUD_MANAGER_CLOUD_COUNT = 2;

    // Cloud constants
    public static final int CLOUD_SPEED_MAX = 200;
    public static final int CLOUD_SPEED_MIN = 100;
    public static final int CLOUD_WIDTH = 450;
    public static final int CLOUD_HEIGHT = 220;
    public static final int CLOUD_POS_Y = SpaceSurfer.HEIGHT + CLOUD_HEIGHT + 20;
    public static final int CLOUD_POS_X = 0;
    public static final int CLOUD_MIN_POS_Y = -300;

    // Enemy manager constants
    public static final float ENEMY_MANAGER_SPAWN_MAX_TIME = 3f;
    public static final float ENEMY_MANAGER_SPAWN_MIN_TIME = 1f;

    // Enemy constants
    public static final int ENEMY_TILE_WIDTH = 32;
    public static final int ENEMY_TILE_HEIGHT = 32;
    public static final int ENEMY_SPEED = 50;
    public static final float ENEMY_FIRE_RATE = 2.75f;
    public static final int ENEMY_WIDTH = 64;
    public static final int ENEMY_HEIGHT = 64;
    public static final float ENEMY_FRAME_TIME = 0.1f;
    public static final int ENEMY_POS_Y_DESTROY = SpaceSurfer.HEIGHT + ENEMY_HEIGHT + 20;
    public static final int ENEMY_MAX_POS_X = SpaceSurfer.WIDTH - ENEMY_WIDTH;
    public static final int ENEMY_MIN_POS_Y = -100;
    public static final int ENEMY_HEALTH = 20;

    // Enemy move horizontal
    public static final float HORIZONTAL_SPEED = ENEMY_SPEED;
    public static final int ENEMY_HOR_POS_Y = SpaceSurfer.HEIGHT - 3*ENEMY_HEIGHT;
    public static final float ENEMY_HOR_APPEAR_TIME = 15f;

    // Enemy move vertical
    public static final float VERTICAL_SPEED = ENEMY_SPEED;

    // Enemy move zigzag
    public static final float ZIGZAG_SPEED = ENEMY_SPEED;

    // Enemy move acceleration
    public static final float ENEMY_ACCELERATE_TIME = 2f;
    public static final float ENEMY_ACCELERATE_SPEED = 500;
    public static final float ENEMY_ACCELERATE_APPEAR_TIME = 10f;

    // Enemy move sin graph
    public static final float SIN_GRAPH_SPEED = ENEMY_SPEED;
    public static final float SIN_GRAPH_LEFT = - 1*ENEMY_WIDTH;
    public static final float SIN_GRAPH_RIGHT = SpaceSurfer.WIDTH + 1*ENEMY_WIDTH;
    public static final float SIN_GRAPH_RANGE_Y_TO = SpaceSurfer.HEIGHT - ENEMY_HEIGHT;
    public static final float SIN_GRAPH_RANGE_Y_FROM = SpaceSurfer.HEIGHT * 0.4f;
    public static final float SIN_GRAPH_RANGE_Y_RANDOM = SIN_GRAPH_RANGE_Y_TO - SIN_GRAPH_RANGE_Y_FROM;
    public static final float SIN_GRAPH_POS_Y_DESTROY = SpaceSurfer.HEIGHT * 0.4f - ENEMY_HEIGHT - 2;

    // Enemy shield
    public static final float ENEMY_SHIELD_MUTATE_TIME = 15f;

    // Enemy bullet constants
    public static final int ENEMY_BULLET_SPEED = 300;
    public static final int ENEMY_BULLET_MIN_POS_Y = -300;
    public static final int ENEMY_BULLET_WIDTH = 32;
    public static final int ENEMY_BULLET_HEIGHT = 32;
    public static final int ENEMY_BULLET_TILE_WIDTH = 16;
    public static final int ENEMY_BULLET_TILE_HEIGHT = 16;
    public static final float ENEMY_BULLET_FRAME_TIME = 0.1f;

    //Explosion constants
    public static final int EXPLOSION_TILE_WIDTH = 16;
    public static final int EXPLOSION_TILE_HEIGHT = 16;
    public static final int EXPLOSION_HEIGHT = 64;
    public static final int EXPLOSION_WIDTH = 64;
    public static final float EXPLOSION_FRAME_TIME = 0.1f;

    // HealthBar
    public static final int HEALTH_BAR_PADDING = 10;

    // Item bullet
    public static final int BULLET_WIDTH = 32;
    public static final int BULLET_HEIGHT = 32;
    public static final int BULLET_SPEED = 200;
    public static final int BULLET_SPEED_x5 = 600;
    public static final int BULLET_SPEED_x8 = 2000;

    // Weapon Gun
    public static final float GUN_TIME = 2.75f;

    // Weapon RandomGun
    public static final float RANDOM_GUN_TIME = 2f;

    // Weapon LazeGun
    // time fire > time shoot
    public static final float LAZE_GUN_TIME_FIRE = 5f;
    public static final float LAZE_GUN_TIME_SHOOT = 3f;
    public static final float LAZE_WIDTH = 10;


    // Weapon shield
    // active: 0 -> SHIELD_TIME_ACTIVE;
    // inactive: SHIELD_TIME_ACTIVE -> SHIELD_TIME_INACTIVE;
    public static final float SHIELD_TIME_ACTIVE = 4f;
    public static final float SHIELD_TIME_INACTIVE = 6f;

    // Weapon RandomGun
    public static final float TOMMY_GUN_TIME = 2f;
}
