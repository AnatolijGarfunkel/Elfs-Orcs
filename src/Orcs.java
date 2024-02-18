public class Orcs {
    public String name;
    public int health;
    public  int power;
    public Orcs(String name, int power, int health){
        this.name = name;
        this.power = power;
        this.health = health;
    }

/*      Описание методов соответствуют описание в классе Elfs.                                                        */
    public void regenerateHealth () {
        this.health = (int) (this.health * 1.3);
    }

    public void getHited (int power) {
        this.health = this.health - power;
    }

    public void kill(String elfsName) {
        this.name = this.name + " killed by " + elfsName;
    }
}
