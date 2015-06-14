package com.academy.patterns.memento;

/**
 * Created by Kelheor on 14.06.2015.
 */
public class Monster {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemento(Memento memento) {
        if(memento instanceof MonsterMemento) {
            this.name = ((MonsterMemento) memento).getName();
        }
    }

    public MonsterMemento getMemento() {
        return new MonsterMemento(name);
    }

    private static class MonsterMemento implements Memento {
        private String name;

        public MonsterMemento(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
