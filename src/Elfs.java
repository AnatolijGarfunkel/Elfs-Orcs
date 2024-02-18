public class Elfs {
    public String name;
    public int health;
    public int power;
    public Elfs(String name, int power, int health){
        this.name = name;
        this.power = power;
        this.health = health;
    }

/*      Ниже методы вызываются только из класса AlterBatte.
*
*       Данный метод служит для регенерации здоровья эльфа. (AlterBattle - 124).                                      */
    public void regenerateHealth () {
        this.health = (int) (this.health * 1.3);
    }

/*      Метод служит изменению значения переменной health. Методу передаётся значение силы противника - power, на
*   величину которого уменьшается здоровье эльфа. (AlterBattle - 75).                                                 */
    public void getHited (int power) {
        this.health = this.health - power;
    }

/*      Метод служит переименованию имени, в случае, если значение health стало <= 0. (AlterBattle - 110).            */
    public void kill(String orcsName) {
        this.name = this.name + " killed by " + orcsName;
    }
}
