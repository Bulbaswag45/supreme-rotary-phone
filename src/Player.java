import java.util.ArrayList;
import java.util.Random;
public class Player
{
    String name="defaultName";
    int health = 50;
    int mana = 50;
    boolean isAlive=true;
    ArrayList<Item> inventory = new ArrayList<Item>();
    
    
    
    public Player()
    {
        
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void changeHealth(int amountChanged)
    {
        this.health += amountChanged;
    }
    public void changeMana(int amountChanged)
    {
        this.mana += amountChanged;
    }
    public void takeItem(Item item)
    {
        this.inventory.add(item);
    }
    /*
    public int calculateDamage(int x)
    {
        //search for damage enhancing items in inventory
        Random rnd = new Random();
        int damageDealt = rnd.nextInt(knowledge/2) + (knowledge/2);
        for(Item item : inventory) {
            damageDealt *= item.dmgMultiplier;
        }
        return damageDealt;
    }
    */
    public void displayInventory(){
        for(Item item : this.inventory) {
            System.out.println(item.returnName() + " : " + item.returnDesc());
        }
    }
    /*
    public void displayItemInfo(){
    }
    */
    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
    public int getMana() {
        return this.mana;
    }
    public boolean checkIsAlive() {
        if (this.health <= 0){
            this.isAlive=false;
        }
        return this.isAlive;
    }
    public boolean getIsAlive() {
        return this.isAlive;
    }
}
