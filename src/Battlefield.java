import java.util.Random;

public class Battlefield {
    int length;
    int bright;
    int quantityOfArmies;
    ElfsArmy elfsArmy;
    OrcsArmy orcsArmy;
/*  Конструктор
        ему передаётся через параметр (int quantityOfArmies) количество создаваемых армий эльфов и орков. Параметр
        quantityOfArmies передаётся дальше как аргумент при создании величины массива объектов elfsArmy и orcsArmy.   */

    public Battlefield(int quantityOfArmies) {
        this.quantityOfArmies = quantityOfArmies;

        elfsArmy = new ElfsArmy(quantityOfArmies);
        orcsArmy = new OrcsArmy(quantityOfArmies);

    }

/*  Метод startBattle
    В этом методе происходит битва каждого отдельного эльфа с орком.                                                  */

    public void startBattle () {

/*               Запускается внешний цикл for, который проходит от первого до последнего эльфа и орка. В качестве
        условия выхода из цикла используется параметр quantityOfArmies, который был передан через конструктор
        Battlefield (строка 13)                                                                                       */

        for (int i = 0; i < (quantityOfArmies); i++) {

/*                Запускается внутренний цикл while, который симулирует удары эльфов и орков друг друга. Создаётся
            переменная random и whoHits (40 - 41). Переменной whoHits присваивается через random случайные значения
            от 0 до 1 включительно (45).
                    В качестве условия выхода из цикла используются значения переменных health классов Elfs и Orcs.
            Пока значения health выше нуля, цикл продолжается. Как только значения health конкретного эльфа или орка
            становится меньше или ровно нулю, то внутренний цикл завершается, внешний цикл увеличивает индекс i на
            единицу, и снова происходит вход во внутренний цикл while, но уже пропуская следующую пару эльвов и орков.*/

            Random random = new Random();
            int whoHits;

            message(1, i);
            while (elfsArmy.elfs[i].health > 0 && orcsArmy.orcs[i].health > 0) {
                whoHits = random.nextInt(1, 3);

/*                    Внутри цикла сперва рассматривается значение переменной whoHits. Если значение равно 0, то
                "бьёт" конкретный эльф конкретного орка. Если значение 1, то соответственно "бьёт" орк эльва. Данное
                действие происходит за счёт того, что от того, кого бьют, отнимается значение power бьющего от значения
                health, того, кого бьют (54, 57).                                                                     */

                if (whoHits == 1) {
                    message(2, i);
                    orcsArmy.orcs[i].health = orcsArmy.orcs[i].health - elfsArmy.elfs[i].power;
                } else {
                    message(3, i);
                    elfsArmy.elfs[i].health = elfsArmy.elfs[i].health - orcsArmy.orcs[i].power;
                }
            }

/*              После каждого выхода из цикла while происходит замена значения name того, у кого health стал меньше или
            равно 0. Оно меняется на "был убит тем-то и тем-то" (69, 76), что используется при выводе на экран, что бы
            видеть, кто кого убил.
                Плюс уменьшается значение переменной numberOfElfs на 1 (69, 76). Значения этих перемен используются
            после для вычисления, какая армия выиграла.                                                               */

            if (elfsArmy.elfs[i].health <= 0) {

                elfsArmy.elfs[i].name = elfsArmy.elfs[i].name + " killed by " + orcsArmy.orcs[i].name;
                message(4, i);
                elfsArmy.numberOfElfs --;
            }

            if (orcsArmy.orcs[i].health <= 0) {

                orcsArmy.orcs[i].name = orcsArmy.orcs[i].name + " killed by " + elfsArmy.elfs[i].name;
                message(5, i);
                orcsArmy.numberOfOrcs --;
            }
        }
    }

/*      Данный метод используется для вывода текста на экран. В качестве переменных передаются номер вывода и индекс,
    что бы через него выводить данные конкретных эльфов и орков. Метод вызывается в строках (43, 53, 56, 70, 77).     */
    public void message(int i, int index) {
        switch (i) {
            case 1:
                System.out.println("\nБьётся " + elfsArmy.elfs[index].name + " (" + elfsArmy.elfs[index].health + ")  с " + orcsArmy.orcs[index].name + " ( " + orcsArmy.orcs[index].health + ")  с \n");
                break;
            case 2:
                System.out.println(elfsArmy.elfs[index].name + " бьет");
                System.out.print("  Здоровье " + orcsArmy.orcs[index].name + ": " + orcsArmy.orcs[index].health + " - " + elfsArmy.elfs[index].power + " -> ");
                System.out.println(orcsArmy.orcs[index].health - elfsArmy.elfs[index].power);
                break;
            case 3:
                System.out.println(orcsArmy.orcs[index].name + " бьет");
                System.out.print("  Здоровье " + elfsArmy.elfs[index].name + ": " + elfsArmy.elfs[index].health + " - " + orcsArmy.orcs[index].power + " -> ");
                System.out.println(elfsArmy.elfs[index].health - orcsArmy.orcs[index].power);
                break;
            case 4:
                System.out.println(elfsArmy.elfs[index].name);
                break;
            case 5:
                System.out.println(orcsArmy.orcs[index].name);
                break;
        }
    }
}
