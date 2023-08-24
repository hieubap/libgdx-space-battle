package com.emreozgenc.spacesurfer.managers;

import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.objects.enemy.AccelerationEnemy;
import com.emreozgenc.spacesurfer.objects.enemy.HorizontalEnemy;
import com.emreozgenc.spacesurfer.objects.enemy.SineGraphEnemy;
import com.emreozgenc.spacesurfer.objects.enemy.ZigzagEnemy;
import com.emreozgenc.spacesurfer.objects.enemy.VerticalEnemy;

import java.util.Random;

public class EnemyManager {
    private Random rand;
    private float spawnTime;
    private float spawnTimer;
    private boolean canCreate;

    public EnemyManager() {
        rand = new Random();
        spawnTimer = 0;
        canCreate = true;
    }

    public void update(float delta) {
        spawnTimer += delta;
        createSpawnTime();

        if (Math.abs(spawnTimer) > spawnTime) {
//            spawnEnemy((int)(Math.round(Math.random()*4)));
            spawnEnemy(2);
            spawnTimer = 0;
            canCreate = true;
        }
    }

    public void spawnEnemy(int type){
        if(ObjectArrays.enemies.size > 1) return;

        if(type == 1){
            ObjectArrays.enemies.add(new ZigzagEnemy());
        }else if(type == 2){
            ObjectArrays.enemies.add(new VerticalEnemy());
        }else if(type == 3){
            ObjectArrays.enemies.add(new AccelerationEnemy());
        }else if(type == 4){
            ObjectArrays.enemies.add(new SineGraphEnemy());
        }else{
            ObjectArrays.enemies.add(new HorizontalEnemy());
        }
    }

    private void createSpawnTime() {
        if (canCreate) {
            spawnTime = Constant.ENEMY_MANAGER_SPAWN_MIN_TIME +
                    rand.nextFloat() *
                            (Constant.ENEMY_MANAGER_SPAWN_MAX_TIME - Constant.ENEMY_MANAGER_SPAWN_MIN_TIME);
            canCreate = false;
        }
    }
}
