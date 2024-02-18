import java.util.Random;

public class ElfsArmy {
    Random random = new Random();

    int numberOfElfs;   // - хранит значение общего количества Эльфов.

    public Elfs[] elfs;

/*  Конструктор
        ему передаётся через параметр (int numberOfElfs) количество создаваемых эльфов. Значение параметра
        numberOfElfs используется при создании массива эльфов.                                                        */
    public ElfsArmy(int numberOfElfs) {
        this.numberOfElfs = numberOfElfs;


        elfs = new Elfs[numberOfElfs];
        elfs[0] = new Elfs("Arwen", random.nextInt(15, 21), random.nextInt(50, 61));

        for (int i = 1; i < elfs.length; i++) {
            elfs[i] = new Elfs("Elf" + (i + 1), random.nextInt(15, 21), random.nextInt(50, 61));
        }
    }

/*      Метод служит для уменьшения значения переменной numberOfElfs. (AlterBattle - 111).                            */
    public void decreaseNumberOfElfs() {
        numberOfElfs = numberOfElfs - 1;
    }
}
