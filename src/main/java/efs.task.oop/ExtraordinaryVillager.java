package efs.task.oop;

public class ExtraordinaryVillager extends Villager {
    private final Skill skill;

    public ExtraordinaryVillager(String name, int age, Skill skill) {
        super(name, age);
        this.skill = skill;
    }

    public enum Skill {
        IDENTIFY("I will identify items for you at no charge."),
        SHELTER("I can offer you poor shelter.");

        private final String description;

        Skill(String skill_description) {
            this.description = skill_description;
        }
        public String getDescription() {
            return description;
        }
    }

    public Skill getSkill() {
        return skill;
    }

    @Override
    public void sayHello() {
        System.out.print("Greetings traveler... I'm " + getName() + " and I'm " + getAge() + " years old. " + getSkill().getDescription() + "\n");
    }

    @Override
    public void attack(Fighter victim) {
        victim.takeHit(0);
    }

    @Override
    public void takeHit(int damage) {health = 0;}
}
