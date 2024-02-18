import java.util.Random;

public class AlterBattle {
    int length;
    int bright;
    int quantityOfArmies;
    ElfsArmy elfsArmy;
    OrcsArmy orcsArmy;

    public AlterBattle(int quantityOfArmies) {
        this.quantityOfArmies = quantityOfArmies;

        elfsArmy = new ElfsArmy(quantityOfArmies);
        orcsArmy = new OrcsArmy(quantityOfArmies);

    }

/*      В данном классе были чуть изменен код, в котором используется изменение переменных, например health не через
    оператор " = ", а через для этого созданные методы. Плюс ещё одно существенное изменение. Когда один из эльфов или
    орков побеждает, то цикл не переходит к следующей паре. Вместо этого происходит следующее - здоровье (health)
    одержавшего победу регенерируется, и он бьётся со следующим противником, так как только цикл проигравшей стороны
    увеличивается на 1.                                                                                               */

    public void startBattle() {

        int elfsIndex = 0;
        int orcsIndex = 0;

/*          Внешний цикл for был заменён на цикл while. Цикл while позволяет в ручную прописывать, при каких условиях
*       цикл увеличивается. Кроме этого он позволяет использовать несколько разных индексов, а так же условие выхода из
*       цикла подгонять под разные индексы.
*           В данном цикле используются два индекса: elfsIndex и orcsIndex (26, 27). Эти два индекса задействованы в
*       качестве условия для выхода из цикла, так как индексы обеих сторон не меняются одинаково, то-есть один может
*       увеличиться, а другой нет, и таким образом индекс одного из двух может быстрее достичь конца массива, но заранее
*       не известно какой из них дойдёт до конца.
*           Выход из цикла происходит, если индекс эльфов (elfsIndex) дошёл до конца массива эльфов, или если индекс
*       орков (orcsIndex) дошёл до конца массива орков.
*           Или, что является более правильной формулировкой, цикл продолжается до тех пор, пока индекс ельфа меньше
*       значения массива эльфов И индекс орка меньше значения массива орков.                                          */

        while (elfsIndex < (elfsArmy.elfs.length) && orcsIndex < (orcsArmy.orcs.length)) {

/*          Нижние три строки такие же, как и в методе класса Battlefield.                                            */

            Random random = new Random();
            int whoHits;
            message(1, elfsIndex, orcsIndex);

/*              Логика внутреннего цикла while такая же, как и в классе Battlefield, единственное в нём используются
*           два индекса elfsIndex и orcsIndex, а так же для изменения health используются методы getHited() классов
*           Elfs и Orcs.                                                                                              */

            while (elfsArmy.elfs[elfsIndex].health > 0 && orcsArmy.orcs[orcsIndex].health > 0) {
                whoHits = random.nextInt(2);
                if (whoHits == 0) {
                    message(2, elfsIndex, orcsIndex);

/*                      Если значение whoHits равно 0, то жребий выпал бить эльфу. В таком случае значение переменной
*                   power эльва присваивается временной переменной elfsPower, а оно в свою очередь передаётся в
*                   качестве аргумента методу getHited(elfsPower), класса Орков.
*
*                       Использование временной переменной elfsPower с передачей её после методу getHited() используется
*                   исключительно для читабельности кода. Альтернативно можно сразу же переменную power эльфа
*                   передавать методу getHited() орка. Делалось бы это следующим образом:
*
*                   orcsArmy.orcs[orcsIndex].getHited(elfsArmy.elfs[elfsIndex].power);     */

                    int elfsPower = elfsArmy.elfs[elfsIndex].power;
                    orcsArmy.orcs[orcsIndex].getHited(elfsPower);

                } else {
                    message(3, elfsIndex, orcsIndex);

                    int orcsPower = orcsArmy.orcs[orcsIndex].power;
                    elfsArmy.elfs[elfsIndex].getHited(orcsPower);

                }
            }

/*              В двух ниже последующих конструкциях if происходит почти то же самое, что и в классе Battlefield; если
*           значение health эльфа или орка меньше/равно нулю, то его имя меняется на "killed by тем-то и тем-то",
*           но делается это при помощи метода kill обоих классов Эльфов и Орков (108, 110) (120, 122).
*
*               Алгоритм изменения имени происходит по той-же логике, как и изменение значения health во внутреннем
*           цикле - имя "победившего" передаётся временной переменной orcsName или elfsName, а после аргументом методу
*           kill (108, 110). Как уже говорилось выше, использование временной переменной orcsName или elfsName связано
*           исключительно для читабельности кода. Туже операцию можно было бы реализовать напрямую, через передачу
*           переменной name сразу же методу kill(), тесть - elfsArmy.elfs[elfsIndex].kill(orcsArmy.orcs[orcsIndex].name);.
*
*               В следующей строке вызывается метод decreaseNumberOfElfs() класса ElfsArmy через созданный в
*           конструкторе AlterBattlefield объект elfsArmy. Этот метод уменьшает значение количество эльфов или орков
*           на единицу (111) (123).
*
*               Далее вызывается новый метод - regenerateHealth(). Этот метод выполняет функцию регенерации здоровья
*           победившего, что бы тот мог вступить в бой со следующим противником (112) (124).
*
*               Под конец происходит увеличение индекса проигравших, таким образом мы в ручную прописываем, при каком
*           условии цикл делает следующий круг, при этом учитывая, что у нас как бы два цикла (так как два индекса в
*           одном цикле), соединённые в условии цикла (53). То-есть, если эльф "погибает", то индекс эльфов
*           увеличивается на единицу (elfsIndex ++), и цикл эльфов движется по следующему кругу, при этом индекс
*           орков остаётся неизменным, и всё тот же орк "бьётся" со следующим эльфом.
*               Если орк погибает, то индекс орков повышается на единицу (orcsIndex ++). Таким образом у нас по одному
*           циклу продвигается эльф и орк, но у обоих могут быть разные индексы, и это происходит до тех пор, пока один
*           из индексов не достигнет конца соответствующего массива (41).                                             */

            if (elfsArmy.elfs[elfsIndex].health <= 0) {

                String orcsName = orcsArmy.orcs[orcsIndex].name;

                elfsArmy.elfs[elfsIndex].kill(orcsName);// elfsArmy.elfs[elfsIndex].kill(orcsArmy.orcs[orcsIndex].name);
                elfsArmy.decreaseNumberOfElfs();        // elfsArmy.numberOfElfs --;
                orcsArmy.orcs[orcsIndex].regenerateHealth();

                message(4, elfsIndex, orcsIndex);
                elfsIndex ++;
            }

            if (orcsArmy.orcs[orcsIndex].health <= 0) {

                String elfsName = elfsArmy.elfs[elfsIndex].name;

                orcsArmy.orcs[orcsIndex].kill(elfsName);
                orcsArmy.decreaseNumberOfOrcs();
                elfsArmy.elfs[elfsIndex].regenerateHealth();

                message(5, elfsIndex, orcsIndex);
                orcsIndex ++;
            }
        }
    }

    public void message(int i, int elfsIndex, int orcsIndex) {
        switch (i) {
            case 1:
                System.out.println("\nБьётся " + elfsArmy.elfs[elfsIndex].name + " (" + elfsArmy.elfs[elfsIndex].health + ")  с " + orcsArmy.orcs[orcsIndex].name + " ( " + orcsArmy.orcs[orcsIndex].health + ")  с \n");
                break;
            case 2:
                System.out.println(elfsArmy.elfs[elfsIndex].name + " бьет");
                System.out.print("  Здоровье " + orcsArmy.orcs[orcsIndex].name + ": " + orcsArmy.orcs[orcsIndex].health + " - " + elfsArmy.elfs[elfsIndex].power + " -> ");
                System.out.println(orcsArmy.orcs[orcsIndex].health - elfsArmy.elfs[elfsIndex].power);
                break;
            case 3:
                System.out.println(orcsArmy.orcs[orcsIndex].name + " бьет");
                System.out.print("  Здоровье " + elfsArmy.elfs[elfsIndex].name + ": " + elfsArmy.elfs[elfsIndex].health + " - " + orcsArmy.orcs[orcsIndex].power + " -> ");
                System.out.println(elfsArmy.elfs[elfsIndex].health - orcsArmy.orcs[orcsIndex].power);
                break;
            case 4:
                System.out.println(elfsArmy.elfs[elfsIndex].name);
                break;
            case 5:
                System.out.println(orcsArmy.orcs[orcsIndex].name);
                break;
        }
    }
}
