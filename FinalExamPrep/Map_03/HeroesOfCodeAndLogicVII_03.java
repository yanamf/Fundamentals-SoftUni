package FinalExamPrep.Map_03;

import java.util.*;

public class HeroesOfCodeAndLogicVII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberHeroes = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Integer>> heroes = new LinkedHashMap<>();
        for (int i = 0; i < numberHeroes; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            //{hero name} {HitPoints} {ManaPoints}
            String heroName = tokens[0];
            int HP = Integer.parseInt(tokens[1]);
            int MP = Integer.parseInt(tokens[2]);

            heroes.put(heroName, new ArrayList<>());
            heroes.get(heroName).add(HP);
            heroes.get(heroName).add(MP);
        }
        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(" - ");
            String hero = tokens[1];

            if (input.contains("CastSpell")) {
                //[CastSpell] [hero name] [MP needed] [spell name]
                int oldMp = heroes.get(hero).get(1);
                int requiredMP = Integer.parseInt(tokens[2]);
                if (oldMp >= requiredMP) {
                    int currentMP = oldMp - requiredMP;
                    heroes.get(hero).set(1, currentMP);
                    System.out.printf
                            ("%s has successfully cast %s and now has %d MP!%n", hero, tokens[3], currentMP);
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", hero, tokens[3]);
                }

            } else if (input.contains("TakeDamage")) {
                // [TakeDamage] [hero name] [damage] [attacker]
                int damage = Integer.parseInt(tokens[2]);
                String attacker = tokens[3];
                int oldHp = heroes.get(hero).get(0);
                int currentHP = oldHp - damage;
                heroes.get(hero).set(0, currentHP);
                if (currentHP > 0) {
                    System.out.printf
                            ("%s was hit for %d HP by %s and now has %d HP left!%n",
                                    hero, damage, attacker, currentHP);
                } else {
                    heroes.remove(hero);
                    System.out.printf("%s has been killed by %s!%n", hero, attacker);
                }
            } else if (input.contains("Recharge")) {
                //  [Recharge] [hero name] [amount]
                int oldAmount = heroes.get(hero).get(1);
                int amount = Integer.parseInt(tokens[2]);
                int difference = 200 - oldAmount;
                if (amount + oldAmount > 200) {
                    amount = 200;
                    heroes.get(hero).set(1, amount);
                    System.out.printf("%s recharged for %d MP!%n", hero, difference);
                } else {
                    heroes.get(hero).set(1, oldAmount + amount);
                    System.out.printf("%s recharged for %d MP!%n", hero, amount);
                }
            } else if (input.contains("Heal")) {
                //  [Heal] [hero name] [amount]
                int amount = Integer.parseInt(tokens[2]);
                int oldAmount = heroes.get(hero).get(0);
                int difference = 100 - oldAmount;

                if (amount + oldAmount > 100) {
                    amount = 100;
                    heroes.get(hero).set(0, amount);
                    System.out.printf("%s healed for %d HP!%n", hero, difference);
                } else {
                    heroes.get(hero).set(0, oldAmount + amount);
                    System.out.printf("%s healed for %d HP!%n", hero, amount);

                }
            }
        }
        for (Map.Entry<String, List<Integer>> entry : heroes.entrySet()) {
            System.out.printf("%s%n" + "  HP: %d%n" + "  MP: %d%n"
                    , entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}