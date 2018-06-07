/**
 * Write a description of class RPGGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
public class RPG_Game
{
	private static Object monitor;
	private JFrame combatFrame;
	private JLabel enemyLabel;
	private JLabel playerLabel;
	private JLabel inventoryLabel;
	private JPanel controlPanel;

	public static void main(String[] args)
    {
        Player player = new Player();
        Combat combat = new Combat(player);
        player.takeItem(new FireballTome());
        player.takeItem(new HealthPotion());
        player.takeItem(new ManaPotion());
        player.takeItem(new FireballTome());
		SwingControlDemo swingControlDemo = new SwingControlDemo(combat);
        //combat.NewFight();
		//swingControlDemo.showListDemo(player, enemy);
        
    	/*
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
	*/
    }
}
class Combat
{
    Enemy enemy;
    Player player;
    Object monitor;
    public Combat(Player newPlayer)
    {
        enemy = new Enemy();
        player = newPlayer;
    }

    public synchronized void oneRound(){
        System.out.println("You encounter an enemy!");
        while (enemy.checkIsAlive() && player.checkIsAlive()){
        	if (player.getIsAlive()==true) {

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

    /*
    public void playerTurn(Object monitor){
    	try {
			monitor.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    */
    public void enemyTurn(){
    	enemy.dealDamage(player);
    	enemy.checkIsAlive();
    }
    public Enemy returnEnemy() {
    	return enemy;
    }
    public Player returnPlayer() {
    	return player;
    }
}

class SwingControlDemo {
	private JFrame combatFrame;
	private JLabel combatLabel;
	private JTextArea itemLabel;
	private JSplitPane splitPane;
	private JPanel controlPanel;
	
	public SwingControlDemo(Combat combat) {
		prepareGUI(combat);
	}
	private void prepareGUI(Combat combat){
		Player player = combat.returnPlayer();
		Enemy enemy = combat.returnEnemy();
		combatFrame = new JFrame("Combat");
		combatFrame.setSize(800,400);
	    combatFrame.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    combatFrame.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent windowEvent){
	    		System.exit(0);
	        }        
	     });  
	    
	    final DefaultListModel<Item> inventoryListModel = new DefaultListModel<Item>();

	    for(Item item : player.returnInventory()) {
	    	inventoryListModel.addElement(item);
	    }

	    final JList<Item> inventoryList = new JList<Item>(inventoryListModel);
	    inventoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    inventoryList.setSelectedIndex(0);
	    inventoryList.setVisibleRowCount(3);        
	      
	    inventoryList.addListSelectionListener(new ListSelectionListener() {

	    	@Override
	    	public void valueChanged(ListSelectionEvent e) {
	    		// TODO Auto-generated method stub
	    		Item item = inventoryList.getSelectedValue();
	    		itemLabel.setText(item.returnDesc());
	    		
	    	}
	    });
	      
	    JButton useItemButton = new JButton("Use Item");

	    useItemButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) { 
	            //Code to use the item Selected
	    		Item item = inventoryList.getSelectedValue();
	    		
	    		System.out.println("You encounter an enemy!");
	            	if (player.getIsAlive()==true) {
	            		item.useItem(combat);
	            	}
	                if (enemy.getIsAlive()==true) {

	                	enemy.dealDamage(player);      
	                }
	            if (!enemy.getIsAlive()) {
	            	System.out.println("You defeated " + enemy.getName() + "!");
	            }
	            if (!player.getIsAlive()) {
	            	System.out.println("You were defeated! Game over...");
	            }
	    	   }
	    });    
	    
	    itemLabel = new JTextArea ("");
	    itemLabel.setLineWrap(true);
	    itemLabel.setSize(500, 100);
	    combatLabel = new JLabel("", JLabel.CENTER); 
	    controlPanel = new JPanel();
	    controlPanel.add(itemLabel);
	    splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	    splitPane.setLeftComponent(new JScrollPane(inventoryList));
	    splitPane.setRightComponent(controlPanel);
	    c.gridx=0;
	    c.gridy=2;
	    combatFrame.add(useItemButton, c);
	    c.gridheight=6;
	    c.gridwidth=1000;
	    c.gridx=1;
	    c.gridy=0;
	    combatFrame.add(splitPane,c);       
	    combatFrame.add(combatLabel);
	    combatFrame.setVisible(true);  
	 	}
}