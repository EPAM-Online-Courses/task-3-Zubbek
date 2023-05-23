package efs.task.oop;

public class Villager implements Fighter {
    protected String name;
    protected int age;

    protected int health = 100;

    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() { return health; }

    public void sayHello() {
        System.out.print("Greetings traveler... I'm " + getName() + " and I'm " + getAge() + " years old.\n");
    }

    @Override
    public void attack(Fighter victim) {
        int dmg = (int) ((100 - getAge() * 0.5) / 10);
        victim.takeHit(dmg);
    }

    @Override
    public void takeHit(int damage) {
        health = getHealth() - damage;
    }
}
