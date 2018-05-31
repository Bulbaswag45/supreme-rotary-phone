import java.util.Random;
/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy
{
    // instance variables - replace the example below with your own
    String name="testEnemy";
    int health;
    int damage;
    boolean isAlive=true;
    /**
     * Constructor for objects of class Enemy
     */
    public Enemy()
    {
        Random rnd = new Random();
        this.health = rnd.nextInt(15) + 10;
        this.damage = rnd.nextInt(6) + 6;
    }
    public void setName(String newName)
    {
        this.name=newName;
    }
    public void changeHealth(int amountChanged)
    {
        this.health += amountChanged;
    }
    public void dealDamage(Player player)
    {
        //Calculate and deal damage to player object in parameters
        Random rnd = new Random();
        int damageDealt = rnd.nextInt(this.damage/2) + (this.damage/2);
        player.changeHealth(-damageDealt);
        System.out.println(this.name + " deals " + damageDealt + " damage to " + player.getName());
    }
    public boolean checkIsAlive() {
        if (this.health <= 0){
            this.isAlive=false;
        }
        return this.isAlive;
    }
    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
}
