/**
 * Write a description of class RPGGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Frame;
import javax.swing.*;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class RPG_Game
{
    public static void main(String[] args)
    {
        Player player = new Player();
        //Combat combat = new Combat(player);
        player.takeItem(new FireballTome());
        player.takeItem(new HealthPotion());
        player.takeItem(new ManaPotion());
    	
    	
    	//Map Frame Code
    	JFrame map_UI = new JFrame();
    	map_UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	final Map applet = new Map();
    	map_UI.add(applet);
    	map_UI.setSize(1000,900);
    	map_UI.setVisible(true);
		
    	//Combat Frame Code
    	JFrame combat_UI = new JFrame();
    	combat_UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	JList<Item> playerInventoryUI = new JList<Item>((Item[]) player.returnInventory());
    	playerInventoryUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	playerInventoryUI.setVisibleRowCount(3);
    	
    	JScrollPane listScroller = new JScrollPane(playerInventoryUI);
    	listScroller.setPreferredSize(new Dimension(250, 80));
    	
    	combat_UI.add(playerInventoryUI);
    	combat_UI.pack();
    	combat_UI.setVisible(true);
    	
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
/*
class PlayerInput extends Applet implements ActionListener {
	
	
	public void createPlayerInputUI() {
		list = new JList(player.returnInventory());
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}*/