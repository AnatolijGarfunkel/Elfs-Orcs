import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Какую версию исполнить?");
        System.out.println("Школьная        - нажать 1");
        System.out.println("Альтернативная  - нажать 2");
        int input = scanner.nextInt();

/*              Создаётся объект battle класса Battlefield. При создании вызывается конструктор, которому передаётся
*       целочисленный аргумент (в данном случае 5), и который в свою очередь передаётся переменной quantityOfArmies в
*       конструкторе (смотрите конструктор Battlefield в классе Battlefield).                                         */

        Battlefield battle = new Battlefield(5);

/*      То же самое, только в отношении альтернативного класса                                                        */
        AlterBattle alternateBattle = new AlterBattle(5);




        switch (input) {
            case 1:
//          Вызывается метод startBattle() через объект battle класса Battlefield;.
                battle.startBattle();

//          Вызывается метод getBattleResult класса Main (39).
                getBattleResult(battle);

                break;
            case 2:
                alternateBattle.startBattle();
                getBattleResult(alternateBattle);
                break;
        }
    }

/*      Ниже два одинаковых метода, только один вызывается при передаче объекта battle класса Battlefield (27), а другой
*   при передаче объекта alternateBattle класса AlterBattle (32).                                                     */
    public static void getBattleResult(Battlefield battle) {

/*          В данном методе происходит вычисление победившей стороны. Сравнивается значения переменных numberOfElfs и
*       numberOfOrcs. Если значения равны, то происходит один вывод на экран, а если какое-то значение больше, то
*       соответственные им выводы.                                                                                    */

        if (battle.elfsArmy.numberOfElfs == battle.orcsArmy.numberOfOrcs) {
            System.out.println("\nНичья");
            System.out.println("Ельфов осталось " + battle.elfsArmy.numberOfElfs);
            System.out.println("Орков осталось " + battle.orcsArmy.numberOfOrcs);
        }
        else if (battle.elfsArmy.numberOfElfs > battle.orcsArmy.numberOfOrcs) {
            System.out.println("\nElfs won, there are " + battle.elfsArmy.numberOfElfs + " elfs left");
        }
        else {
            System.out.println("\nOrcs won, there are " + battle.orcsArmy.numberOfOrcs + " orcs left");
        }
    }
    public static void getBattleResult(AlterBattle battle) {

        if (battle.elfsArmy.numberOfElfs == battle.orcsArmy.numberOfOrcs) {
            System.out.println("\nНичья");
            System.out.println("Ельфов осталось " + battle.elfsArmy.numberOfElfs);
            System.out.println("Орков осталось " + battle.orcsArmy.numberOfOrcs);
        }
        else if (battle.elfsArmy.numberOfElfs > battle.orcsArmy.numberOfOrcs) {
            System.out.println("\nElfs won, there are " + battle.elfsArmy.numberOfElfs + " elfs left");
        }
        else {
            System.out.println("\nOrcs won, there are " + battle.orcsArmy.numberOfOrcs + " orcs left");
        }
    }
}
