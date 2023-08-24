package com.emreozgenc.spacesurfer.objects.tools.weapons.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;

public abstract class Weapon {
    protected boolean isEnemy;
    protected boolean preventAttacked;
    protected WeaponEvening weaponEvening;

    public Weapon(boolean isEnemy, WeaponEvening weaponEvening) {
        this.isEnemy = isEnemy;
        this.preventAttacked = false;
        this.weaponEvening = weaponEvening;
        if(isEnemy){
            ObjectArrays.weaponEnemies.add(this);
        }else{
            ObjectArrays.weaponMains.add(this);
        }

    }

    public abstract void update(float delta);
    public abstract void draw(SpriteBatch batch);
}
