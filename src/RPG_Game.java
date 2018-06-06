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
	private JFrame combatFrame;
	private JLabel enemyLabel;
	private JLabel playerLabel;
	private JLabel inventoryLabel;
	private JPanel controlPanel;

	public static void main(String[] args)
    {
        Player player = new Player();
        Enemy enemy = new Enemy();
        //Combat combat = new Combat(player);
        player.takeItem(new FireballTome());
        player.takeItem(new HealthPotion());
        player.takeItem(new ManaPotion());
        player.takeItem(new FireballTome());
		SwingControlDemo swingControlDemo = new SwingControlDemo();
		swingControlDemo.showListDemo(player, enemy);
        
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

class SwingControlDemo {
	private JFrame combatFrame;
	private JLabel combatLabel;
	private JLabel itemLabel;
	private JSplitPane splitPane;
	private JScrollPane inventoryListScrollPane;
	
	private JLabel enemyLabel;
	private JLabel playerLabel;
	private JLabel inventoryLabel;
	private JPanel controlPanel;
	
	public SwingControlDemo() {
		prepareGUI();
	}
	private void prepareGUI(){
		combatFrame = new JFrame("Java Swing Examples");
		combatFrame.setSize(400,400);
	      combatFrame.setLayout(new GridLayout(3, 1));
	      
	      combatFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      combatLabel = new JLabel("", JLabel.CENTER);        
	      itemLabel = new JLabel("",JLabel.CENTER);    

	      controlPanel = new JPanel();
	      splitPane = new JSplitPane();
	      splitPane.setLeftComponent(inventoryListScrollPane);
	      splitPane.setRightComponent(controlPanel);
	      splitPane.setLayout(new FlowLayout());
	      controlPanel.add(itemLabel);
	      controlPanel.setLayout(new FlowLayout());
	      
	      combatFrame.add(combatLabel);
	      combatFrame.add(splitPane);
	      combatFrame.setVisible(true);  
	   }
	   public void showListDemo(Player player, Enemy enemy){                                       
	      combatLabel.setText("Control in action: JList"); 
	      final DefaultListModel<Item> inventoryListModel = new DefaultListModel<Item>();

	      for(Item item : player.returnInventory()) {
	    	  inventoryListModel.addElement(item);
	        }

	      final JList<Item> inventoryList = new JList<Item>(inventoryListModel);
	      inventoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      inventoryList.setSelectedIndex(0);
	      inventoryList.setVisibleRowCount(3);        

	      inventoryListScrollPane = new JScrollPane(inventoryList);   
	      
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
	            
	         }
	      }); 
	      controlPanel.add(inventoryListScrollPane);    
	      //controlPanel.add(vegListScrollPane);    
	      //controlPanel.add(useItemButton);    
		  combatFrame.add(useItemButton);
	      combatFrame.setVisible(true);             
	   }
}