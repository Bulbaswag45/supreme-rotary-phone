/**
 * Write a description of class RPGGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RPGGame
{
    public static void main(String[] args)
    {
        Player player = new Player();
        player.takeItem(new FireballTome());
        player.takeItem(new HealthPotion());
        player.takeItem(new ManaPotion());
        Combat.Combat(player);
        //player.displayInventory();
    }
}
class Combat
{
    Enemy enemy;
    Player player;
    public Combat(Player newPlayer)
    {
        enemy = new Enemy();
        player = newPlayer;
    }
    
    public static void Combat(){
        System.out.println("You encounter an enemy!");
        //Initial Player action
        playerTurn();
        while (enemy.isAlive = true){
            //Enemy deals damage to player
            enemy.dealDamage(player);
            //Player input and do an action based off of item in inventory
            
            
        }
    }
    public static void playerTurn(){
        System.out.println("What item will you use?");
        player.displayInventory();
    }
    public static void enemyTurn(){
        
    }
}
