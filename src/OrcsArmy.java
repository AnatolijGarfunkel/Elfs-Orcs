import java.util.Random;

public class OrcsArmy {
    Random random = new Random();
    int numberOfOrcs; // - хранит значение общего количества Орков.
    public Orcs[] orcs;

/*  Конструктор
        ему передаётся через параметр (int numberOfOrcss) количество создаваемых орков. Значение параметра
        numberOfOrcss используется при создании массива орков.                                                        */
    public OrcsArmy (int numberOfOrcs) {
        this.numberOfOrcs = numberOfOrcs;

        orcs = new Orcs[numberOfOrcs];
        orcs[0] = new Orcs("Wulf", random.nextInt(15, 21), random.nextInt(50, 61));


        for (int i = 1; i < orcs.length; i ++) {
            orcs[i] = new Orcs("Orc" + (i + 1), random.nextInt(15, 21), random.nextInt(50, 61));
        }
    }

    public void decreaseNumberOfOrcs() {
        numberOfOrcs = numberOfOrcs - 1;
    }
}
