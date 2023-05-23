package efs.task.oop;

public abstract class Monsters {

    static final Monster andariel = new Monster(10, 70) {

        @Override
        public void attack(Fighter victim) {
            victim.takeHit(getDamage());
        }

        @Override
        public void takeHit(int damage) {
            //setHealth(getHealth() - damage);
            andariel.health = getHealth() - damage;
            monstersHealth -= damage;
        }
    };

    static final Monster blacksmith = new Monster(100, 25) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(getDamage());
        }

        @Override
        public void takeHit(int damage) {
            damage += 5;
            //setHealth(getHealth() - damage);
            blacksmith.health = getHealth() - damage;
            monstersHealth -= damage;
        }
    };

    public static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();

    public static int getMonstersHealth() {
        return monstersHealth;
    }
}
