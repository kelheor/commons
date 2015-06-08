package com.academy.patterns.builder;

import com.academy.patterns.facade.AbstractSystem;
import com.academy.patterns.property.Weapon;
import com.academy.patterns.property.WeaponPrototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by keos on 08.06.15.
 */
public class CyberBattleship implements WeaponPrototype {

    protected List<AbstractSystem> abstractSystems = new ArrayList<>();

    protected final WeaponPrototype weaponPrototype;
    protected final Map<Weapon, Integer> weapons = new HashMap<>();

    public CyberBattleship() {
        this.weaponPrototype = new WeaponPrototype() {
            @Override
            public Integer getWeapon(Weapon weapon) {
                return null;
            }

            @Override
            public boolean hasWeapon(Weapon weapon) {
                return false;
            }

            @Override
            public void setWeapon(Weapon weapon, Integer value) {

            }

            @Override
            public void removeWeapon(Weapon weapon) {

            }
        };
    }

    public CyberBattleship(WeaponPrototype weaponPrototype) {
        this.weaponPrototype = weaponPrototype;
    }

    public CyberBattleship(List<AbstractSystem> abstractSystems) {
        this.abstractSystems = abstractSystems;
        weaponPrototype = new WeaponPrototype() {
            @Override
            public Integer getWeapon(Weapon weapon) {
                return null;
            }

            @Override
            public boolean hasWeapon(Weapon weapon) {
                return false;
            }

            @Override
            public void setWeapon(Weapon weapon, Integer value) {

            }

            @Override
            public void removeWeapon(Weapon weapon) {

            }
        };
    }

    public CyberBattleship(WeaponPrototype weaponPrototype, List<AbstractSystem> abstractSystems) {
        this.weaponPrototype = weaponPrototype;
        this.abstractSystems = abstractSystems;
    }

    public List<AbstractSystem> getAbstractSystems() {
        return abstractSystems;
    }

    public CyberBattleship(Builder builder) {
        this.abstractSystems = builder.getAbstractSystems();
        this.weaponPrototype = new WeaponPrototype() {
            @Override
            public Integer getWeapon(Weapon weapon) {
                return null;
            }

            @Override
            public boolean hasWeapon(Weapon weapon) {
                return false;
            }

            @Override
            public void setWeapon(Weapon weapon, Integer value) {

            }

            @Override
            public void removeWeapon(Weapon weapon) {

            }
        };
    }

    public void invokeAllSystems() {
        abstractSystems.parallelStream().forEach(AbstractSystem::execute);
    }

    @Override
    public Integer getWeapon(Weapon weapon) {
        boolean containtValue = weapons.containsKey(weapon);
        if(containtValue) {
            return weapons.get(weapon);
        } else {
            return weaponPrototype.getWeapon(weapon);
        }
    }

    @Override
    public boolean hasWeapon(Weapon weapon) {
        return getWeapon(weapon) != null;
    }

    @Override
    public void setWeapon(Weapon weapon, Integer value) {
        weapons.put(weapon, value);
    }

    @Override
    public void removeWeapon(Weapon weapon) {
        weapons.remove(weapon);
    }

}
