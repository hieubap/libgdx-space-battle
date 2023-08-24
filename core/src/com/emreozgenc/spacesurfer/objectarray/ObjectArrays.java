package com.emreozgenc.spacesurfer.objectarray;

import com.badlogic.gdx.utils.Array;
import com.emreozgenc.spacesurfer.objects.Cloud;
import com.emreozgenc.spacesurfer.objects.enemy.Enemy;
import com.emreozgenc.spacesurfer.objects.Explosion;
import com.emreozgenc.spacesurfer.objects.tools.items.core.Item;
import com.emreozgenc.spacesurfer.objects.tools.weapons.core.Weapon;

public class ObjectArrays {

    // Item arrays
    public static Array<Item> Ritems = new Array<>();
    public static Array<Item> itemMain = new Array<>();
    public static Array<Item> itemEnemy = new Array<>();

    // Weapon arrays
    public static Array<Weapon> Rweapons = new Array<>();
    public static Array<Weapon> weaponMains = new Array<>();
    public static Array<Weapon> weaponEnemies = new Array<>();

    // Cloud arrays
    public static Array<Cloud> clouds = new Array<>();
    public static Array<Cloud> Rclouds = new Array<>();

    // Enemy arrays
    public static Array<Enemy> enemies = new Array<>();
    public static Array<Enemy> Renemies = new Array<>();

    // Explosion arrays
    public static Array<Explosion> explosions = new Array<>();
    public static Array<Explosion> Rexplosions = new Array<>();

    public static void clearAll() {
        itemMain.clear();
        itemEnemy.clear();
        weaponMains.clear();
        weaponEnemies.clear();

        clouds.clear();
        Rclouds.clear();
        enemies.clear();
        Renemies.clear();
        explosions.clear();
        Rexplosions.clear();
    }
}
