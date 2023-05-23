package efs.task.oop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var kashya = new Villager("Kashya", 30);
        var akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        var gheed = new Villager("Gheed", 50);
        var deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        var warriv = new Villager("Warriv", 35);
        var flawia = new Villager("Flawia", 25);

        //can't use ExtraordinaryVillager class methodes because it's now type object so i can use only Object class methodes.
        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;

        System.out.print(objectDeckardCain.getClass() + "\n");

        List<Villager> villagers = new ArrayList<>();
        villagers.add(kashya);
        villagers.add(akara);
        villagers.add(gheed);
        villagers.add(deckardCain);
        villagers.add(warriv);
        villagers.add(flawia);

        for(Villager villager : villagers) {
            villager.sayHello();
        }

        Monster andariel = Monsters.andariel;
        Monster blacksmith = Monsters.blacksmith;

        List<Monster> monsters = new ArrayList<>();
        monsters.add(andariel);
        monsters.add(blacksmith);

        int vil_counter = 0;
        int mon_counter = 0;

        System.out.print("\n-------------ROZPOCZYNAMY BITWE!-------------\n");

        while (true) {
            if (Monsters.getMonstersHealth() > 0) {
                if (vil_counter > villagers.size() - 1) {
                    vil_counter = 0;
                }
                if (mon_counter > 1) {
                    mon_counter = 0;
                }
                if (monsters.get(mon_counter).getHealth() <= 0) {
                    mon_counter += 1;
                    continue;
                }
                if (villagers.get(vil_counter).getHealth() <= 0) {
                    System.out.print("Osadnik: " + villagers.get(vil_counter).getName() + " nie zyje\n");
                    vil_counter += 1;
                    continue;
                }
                if (monsters.get(mon_counter).getHealth() > 0) {
                    System.out.print("\nPotwory posiadaja jeszcze " + Monsters.getMonstersHealth() + " puntków życia\n");
                    villagers.get(vil_counter).attack(monsters.get(mon_counter));
                    System.out.print("Aktualnie walczacy osadnik to " + villagers.get(vil_counter).getName() + "\n");
                    monsters.get(mon_counter).attack(villagers.get(vil_counter));
                    mon_counter += 1;
                    vil_counter += 1;
                }
            } else {
                System.out.print("\nObozowisko ocalone!\n\n");
                break;
            }
        }

        //Now i can use ExtraordinaryVillager class methodes.
        deckardCain = (ExtraordinaryVillager) objectDeckardCain;
        akara = (ExtraordinaryVillager) objectAkara;

        deckardCain.sayHello();
        akara.sayHello();
    }
}
