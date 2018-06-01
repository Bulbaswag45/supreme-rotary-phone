import java.util.Random;
public class Item
{

    String name="Small Rock";
    String desc="An item used for testing.";
    static Random rnd = new Random();
    public Item()
    {
        /*
        this.dmgMultiplier=1;
        this.restoreHealth=0;
        
        switch(type)
        {
            case 1: this.createHealthPotion(rnd.nextInt(8) + 6);
            break;
            case 2: this.createManaPotion(rnd.nextInt(20) + 20);
            break;
            case 3: this.createRegenPotion(rnd.nextInt(8) + 10, rnd.nextInt(20) + 30);
            break;
            case 4: this.createFireballTome(rnd.nextInt(3) + 3);
            break;
        }
        */
    }
    /*
    public void createHealthPotion(int x)
    {
        this.name="Health Potion";
        this.restoreHealth=x;
        this.desc="A health potion that restores " + x + " health.";
    }
    public void createManaPotion(int x)
    {
       this.name="Mana Potion";
       this.restoreMana=x;
       this.desc="A mana potion that restores " + x + " mana."; 
    }
    public void createRegenPotion(int x, int y)
    {
       this.name="Regen Potion";
       this.restoreHealth=x;
       this.restoreMana=y;
       this.desc="A special potion that restores " + x + " health and " + y + " mana."; 
    }
    public void createFireballTome(int x)
    {
        this.name="Fireball Tome";
        this.dmgMultiplier=x;
        this.desc="A red and gold tome that can cast fireball, dealing " + x + " damage.";
    }
    */
    public String returnName()
    {
        return name;
    }
    public String returnDesc()
    {
        return desc;
    }
}
class HealthPotion extends Item{
    int restoreHealth;
    public HealthPotion() {
        int x= rnd.nextInt(8) + 6;
        this.name="Health Potion";
        this.restoreHealth=x;
        this.desc="A health potion that restores " + x + " health.";
    }
    public void useItem(Player player) {
        player.changeHealth(this.restoreHealth);
    }
}
class ManaPotion extends Item{
    int restoreMana;
    public ManaPotion() {
       int x=rnd.nextInt(20) + 20;
       this.name="Mana Potion";
       this.restoreMana=x;
       this.desc="A mana potion that restores " + x + " mana."; 
    }
    public void useItem(Player player) {
        player.changeMana(this.restoreMana);
    }
}
class RegenPotion extends Item{   
   int restoreHealth;
   int restoreMana;
   public RegenPotion() {
       int x= rnd.nextInt(8) + 10;
       int y= rnd.nextInt(20) + 30;
       this.name="Regen Potion";
       this.restoreHealth=x;
       this.restoreMana=y;
       this.desc="A special potion that restores " + x + " health and " + y + " mana.";
   }
   public void useItem(Player player) {
       player.changeHealth(this.restoreHealth);
        player.changeMana(this.restoreMana);
    }
}
class FireballTome extends Item{
    int damage;
    public FireballTome() {
        int x = rnd.nextInt(3) + 3;
        this.name="Fireball Tome";
        this.damage=x;
        this.desc="A red and gold tome that can cast fireball, dealing " + x + " damage.";
    }
    /*
    public void useItem(Player player) {
        System.out.println("What enemy would you like to target?");
        Enemy target
        int damageDealt = rnd.nextInt(this.damage/2) + (this.damage/2);
        target.changeHealth(-damageDealt);
        System.out.println(wielder.getName() + " deals " + damageDealt + " damage to " + target.getName());
    }
    */
}
