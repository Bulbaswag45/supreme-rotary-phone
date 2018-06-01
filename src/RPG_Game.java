/**
 * Write a description of class RPGGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RPG_Game
{
    public static void main(String[] args)
    {
        Player player = new Player();
        //Combat combat = new Combat(player);
        player.takeItem(new FireballTome());
        player.takeItem(new HealthPotion());
        player.takeItem(new ManaPotion());
        //combat.NewFight();
        new Combat(player).NewFight();
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
    
    public void NewFight(){
        System.out.println("You encounter an enemy!");
        while (enemy.checkIsAlive() && player.checkIsAlive()){
        	if (player.getIsAlive()==true) {
        		playerTurn();
        	}
            if (enemy.getIsAlive()==true) {
            	enemy.dealDamage(player);      
            }
            
        }
        if (!enemy.getIsAlive()) {
        	System.out.println("You defeated " + enemy.getName() + "!");
        }
        if (!player.getIsAlive()) {
        	System.out.println("You were defeated! Game over...");
        }
    }
    public void playerTurn(){
        System.out.println("What item will you use?");
        player.displayInventory();
    }
    public void enemyTurn(){
    	enemy.dealDamage(player);
    	enemy.checkIsAlive();
    }
}
