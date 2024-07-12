package ergasia2;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

@SuppressWarnings("serial")
public class Form extends JFrame implements ActionListener{ //TOUMPA GEORGIA 01793
	String[] menu; // array with the menu
	File file2; // file order.txt
	
	JTextArea aText;  // create all the buttons and the texts i need
	JTextField textField;
	JRadioButton burger;
	JRadioButton club;
	JRadioButton salad;
	JRadioButton tacos;
	JRadioButton sushi;
	JRadioButton juice;
	JRadioButton cola;
	JRadioButton tea;
	JRadioButton ice;
	JRadioButton hot;
	
	//---------------------------------------------------------------------------------------------------------
	
	Form(String[] aMenu, File aFile) { // create the constructor for the class Form
		setMenu(aMenu);
		setFile(aFile);
	}
	
	public String[] getMenu() {  //also create getters and setters for the two arguments
		return menu;
	}

	public void setFile(File aFile) {
		file2 = aFile;
	}
	
	public File getFile() {
		return file2;
	}

	public void setMenu(String[] aMenu) {
		menu = aMenu;
	}
	
	//---------------------------------------------------------------------------------------------------------
	
	public void Form1(){ // method to create the window application
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit the application with "X"
		setTitle("Cofee-Shop Panda"); // set the title of the application with the name of the coffee shop
		
		//---------------------------------------------------------------------------------------------------------
		
		JScrollPane scrollPane = new JScrollPane(); // create a scroll pane in the main text area of the application
		scrollPane.setBounds(600, 40, 900, 600); // set the size of the bar as also the text areas
		add(scrollPane); // add it to the application
		
		aText = new JTextArea(); // crate the main text area for the application
		aText.setBackground(Color.white); // make it white color
		scrollPane.setViewportView(aText); // and add the text area to the scroll pane
		
		JLabel aLabel = new JLabel("Order Entry Screen"); // label above the main text area
		aLabel.setBounds(700, 0, 150, 30); // set size and place
		add(aLabel); // add it to the application
		
		//------------------------------------------------------------------------------------------------------
		
		JPanel panel = new JPanel(); // crate a panel 
		panel.setBounds(0, 36, 75, 600); // set the size and the place of panel
		panel.setBorder(BorderFactory.createTitledBorder("Type")); // and the title "Type" in the panel
		add(panel); // add the panel to the application
		panel.setLayout(new GridLayout(0, 1, 0, 0)); // set the grid layout to the panel
		
		ButtonGroup buttonGroup = new ButtonGroup(); // create a new button group so the costumers can choose 
		                                             // only drink or food option every time
		JRadioButton drink = new JRadioButton("Drinks"); // create a button for the drinks
		buttonGroup.add(drink); // add it to the group
		drink.setBounds(75, 277, 103, 21); // set the size and place of it
		panel.add(drink); // add it to the panel "Type"
		
		JRadioButton food = new JRadioButton("Food"); // create a button for the food
		buttonGroup.add(food);  // add it to the group
		food.setBounds(75, 101, 103, 21);  // set the size and place of it
		panel.add(food);  // add it to the panel "Type"
		
		//---------------------------------------------------------------------------------------------------------
		
		JPanel panel_2 = new JPanel(); // crate a panel for the food products
		panel_2.setBorder(BorderFactory.createTitledBorder("Products")); // set title Products for it
		panel_2.setBounds(101, 400, 141, 165); // set the size and the place of panel
		add(panel_2); // add the panel to the application
		panel_2.setLayout(new GridLayout(0, 1, 0, 0)); // set the grid layout to the panel
		
		ButtonGroup buttonGroup_1 = new ButtonGroup(); // create another button group for all the products of the menu
		                                                // so the costumers can pick one option at the time
		
		// create 5 different buttons for each food product of the menu
		// take only the name of the product of the array menu for each item
		burger = new JRadioButton(menu[0].substring(2, 8)); // product: burger
		buttonGroup.add(burger); // add the radio button to the button group
		panel_2.add(burger); // add burger to the panel with the products
		
		club = new JRadioButton(menu[2].substring(2, 15)); // product: club sandwich
		buttonGroup.add(club);  // add the radio button to the button group
		panel_2.add(club); // add club sandwich to the panel with the products
		
		salad = new JRadioButton(menu[1].substring(2,7)); // product: salad
		buttonGroup.add(salad);
		panel_2.add(salad);
		
		tacos = new JRadioButton(menu[3].substring(2, 7)); // product: tacos
		buttonGroup.add(tacos);
		panel_2.add(tacos);
		
		sushi = new JRadioButton(menu[4].substring(2, 7)); // product: sushi
		buttonGroup.add(sushi);
		panel_2.add(sushi);
		
		//---------------------------------------------------------------------------------------------------------
		
		JPanel panel_3 = new JPanel(); // create a third panel for the drink products
		panel_3.setBorder(BorderFactory.createTitledBorder("Products")); // set title Products for the panel
		panel_3.setBounds(101, 100, 141, 165); // set the size and place you want to put it in the application
		add(panel_3); // and add it
		panel_3.setLayout(new GridLayout(0, 1, 0, 0)); // then set the grid layout for the panel
		
		
		// create 5 different buttons for each drink product of the menu
		// take only the name of the product of the array menu for each item
		juice = new JRadioButton(menu[5].substring(2, 14)); // product: Orange Juice. The juice belong to the 5th place of the array 
		                                                    // and the name for the product is between 2nd to 14th place of this line 
		buttonGroup_1.add(juice); // add it to the previous button group we create
		panel_3.add(juice);  // add it to the panel for the drink products
		
		
		// we do the exact same thing to all the other products as we do to the Orange Juice but every time
		// change the line and the place of the name 
		cola = new JRadioButton(menu[9].substring(3, 12)); // product: coca-cola          
		buttonGroup_1.add(cola);
		panel_3.add(cola);
		
		tea = new JRadioButton(menu[8].substring(2, 9)); // product: ice-tea
		buttonGroup_1.add(tea);
		panel_3.add(tea);
		
		ice = new JRadioButton(menu[7].substring(2, 12)); // product: ice coffee
		buttonGroup_1.add(ice);
		panel_3.add(ice);
		
		hot = new JRadioButton(menu[6].substring(2, 12)); // product: hot coffee
		buttonGroup_1.add(hot);
		panel_3.add(hot);
		
		//---------------------------------------------------------------------------------------------------------
		
		panel_3.setVisible(false);  // make invisible the panel for the food products and the panel for the
		panel_2.setVisible(false); // drink products of the application 
		
		drink.addActionListener(new ActionListener() { // create an action listener for the radio button drink
			public void actionPerformed(ActionEvent e) { // if the costumer choose the drink option
				panel_3.setVisible(drink.isSelected()); // then set the panel for the drinks visible
				panel_2.setVisible(false);              // and the panel for the food invisible
			}                                           // so it can appear one panel at the time
		});
		
		food.addActionListener(new ActionListener() { // do the same for the radio button food
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(food.isSelected()); // if food radio button is selected then set the food panel visible
				panel_3.setVisible(false);             // and the drink panel invisible
			}
		});
		
		//---------------------------------------------------------------------------------------------------------
		
		textField = new JTextField(); // create a text field so the costumer can choose the Quantity of each product
		textField.setBounds(903, 650, 101, 29); // set size and place of it
		add(textField); // add it to the application
		
		JLabel lblNewLabel_2 = new JLabel("Quantity:"); // create a label with name Quantity
		lblNewLabel_2.setBounds(850, 650, 62, 29); // set size and place of it
		add(lblNewLabel_2); // add it to the application
		
		JButton Button = new JButton("Delete Previous"); // create a button with name: Delete Previous
		Button.setBounds(1013, 650, 150, 29); // set size and place of it
	    add(Button); // add it to the application
		
		JPanel panel_1 = new JPanel(); // create a new panel for the rest of the buttons of the application 
		panel_1.setBackground(Color.BLACK); // make it black color
		panel_1.setBounds(0, 710, 1573, 105); // set size and place of it
		add(panel_1); // add it to the application
		panel_1.setLayout(null); // set layout null so we can position our components absolutely
		
		JButton aButton1 = new JButton("Enter Item"); // create a button: Enter Item
		aButton1.setBounds(170, 20, 174, 40);
		panel_1.add(aButton1); // add it to the panel for the buttons
		
		JButton aButton2 = new JButton("Total Cost"); // create a button: Total Cost
		aButton2.setBounds(367, 20, 164, 40);
		panel_1.add(aButton2);
		
		JButton aButton3 = new JButton("New Order"); // create a button: New Order
		aButton3.setBounds(551, 20, 145, 40);
		panel_1.add(aButton3);
		
		JButton aButton4 = new JButton("Total time for the order"); // create a button: Total time for the order
		aButton4.setBounds(717, 20, 189, 40);
		panel_1.add(aButton4);
		
		JButton aButton5 = new JButton("Get cheapest drink item"); // create a button: get cheapest drink item
		aButton5.setBounds(285, 185, 200, 30);
		add(aButton5);
		
		JButton aButton6 = new JButton("Get cheapest food item"); // create a button: get cheapest food item
		aButton6.setBounds(285, 480, 200, 30);
		add(aButton6);
		
		//---------------------------------------------------------------------------------------------------------
		
		aText.setText("Items:   Prize:   Minutes:\n"); // write a message to the main text area
		
		Outer o=new Outer(this);  // create an object from the class Outer 
		aButton1.addActionListener(o); // pass all the buttons we just create to the outer class instance
		aButton2.addActionListener(o);
		aButton3.addActionListener(o);
		aButton4.addActionListener(o);
		aButton5.addActionListener(o);
		aButton6.addActionListener(o);
		Button.addActionListener(o);
		
		setLayout(null); // set layout null so we can position our components absolutely
		setSize(1550, 835); // set size of the application 
		setVisible(true); // make the application window visible
	}

	@Override
	public void actionPerformed(ActionEvent e) { // cannot execute there is an error
		System.out.println("an error executed");
	}
}