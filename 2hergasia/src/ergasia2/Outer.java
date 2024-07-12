package ergasia2;

import java.awt.event.*;
import java.io.*;
import java.util.Calendar;

public class Outer implements ActionListener{  //TOUMPA GEORGIA 01793
	Form obj; // create a Form variable 
	float sum = 0; // Initialize variables we are going to need
	float i;
	int j = 0;
	int l;
	String temp;
	int k = 1;
	int time;
	int total = 0;
	String prev;
	int ready = 0;
	String[] items = new String[200];
	
	//---------------------------------------------------------------------------------------------------------
	
	Outer(Form obj){  // Constructor for the Outer class
		this.obj=obj;  
	}  
	
	//---------------------------------------------------------------------------------------------------------
	
	public void actionPerformed(ActionEvent e){  
		if (e.getActionCommand() == "Get cheapest drink item") { // if the button: Get cheapest drink item is selected
			prev = obj.aText.getText(); // keep in the variable prev the previous message that the main text area had
			items[j] = obj.menu[6].substring(2, 12); // save the name of the cheapest drink product in an array
			i = Integer.parseInt(obj.menu[6].substring(19, 20)); // take the prize of this product from the menu array
			time = Integer.parseInt(obj.menu[6].substring(21, 22)); // take the time of this specific product

			//---------------------------------------------------------------------------------------------------------
			
			if(obj.textField.getText().isEmpty()) { // if the text field with the Quantity of this product is empty
				obj.aText.setText(obj.aText.getText() + "Hot Coffee,2,5" + "\n"); // then just keep the previous text
			}                                                             // and also write under it the name of the new product
			else {
				obj.aText.setText(obj.aText.getText() + "Hot Coffee,2,5" + "\t\tx " + obj.textField.getText() + "\n");
			} // else keep the previous message of the text field, write the name of the new product and then the Quantity of it
			
			j++; // one item in the array
			
			//---------------------------------------------------------------------------------------------------------
			
			if(obj.textField.getText().equals("")) { // if Quantity text is empty 
        		sum = sum + 2; // summary + 2 because the cheapest drink item has 2 euro
        		total = total + 5; // total time + 5 because the cheapest drink item takes 5 minutes to get ready
        	}
        	else {
        		sum = sum + 2 * Integer.parseInt(obj.textField.getText()); // else multiply with the Quantity
        		total = total + 5 * Integer.parseInt(obj.textField.getText());
        	}
		}
		//---------------------------------------------------------------------------------------------------------
		else if (e.getActionCommand() == "Get cheapest food item") {
			prev = obj.aText.getText();
			items[j] = obj.menu[3].substring(2, 7); // save the name of the cheapest food product in an array
			i = Integer.parseInt(obj.menu[3].substring(13, 14)); // take the prize of this product from the menu array
			time = Integer.parseInt(obj.menu[3].substring(15, 17)); // take the time of this specific product

			//---------------------------------------------------------------------------------------------------------
			
			if(obj.textField.getText().isEmpty()) { 
				obj.aText.setText(obj.aText.getText() + "Tacos,4,10" + "\n"); // then just keep the previous text
			}                                                             // and also write under it the name of the new product
			else {
				obj.aText.setText(obj.aText.getText() + "Tacos,4,10" + "\t\tx " + obj.textField.getText() + "\n");
			}
			j++; // one item added in the array of the products
			
			//---------------------------------------------------------------------------------------------------------
			
			if(obj.textField.getText().equals("")) { // just like the cheapest drink if Quantity text is empty
        		sum = sum + 4; // summary + 4 because the cheapest drink item has 4 euro
        		total = total + 10; // total time + 10 because the cheapest drink item takes 10 minutes to get ready
        	}
        	else {
        		sum = sum + 4 * Integer.parseInt(obj.textField.getText()); // else multiply with the Quantity
        		total = total + 10 * Integer.parseInt(obj.textField.getText());
        	}
		}
		//---------------------------------------------------------------------------------------------------------
		else if (e.getActionCommand() == "Enter Item") { // if the button enter item is selected
			prev = obj.aText.getText(); // keep the previous text of the main text area
			                            // and check which radio button is selected by the costumer
			//---------------------------------------------------------------------------------------------------------
			if(obj.burger.isSelected()) {
				temp = obj.menu[0].substring(2, 8); // keep the name of the product from the menu array
				i = Integer.parseInt(obj.menu[0].substring(14, 15)); // keep the prize of it
				time = Integer.parseInt(obj.menu[0].substring(16, 18)); // keep the time of it
				
				//---------------------------------------------------------------------------------------------------------
				
				if(obj.textField.getText().isEmpty()) { // check the Quantity text field
					obj.aText.setText(obj.aText.getText() + obj.menu[0].substring(2, 9) + obj.menu[0].substring(14, 18) + "\n");
				} // print in the text area the name, the prize and the time for this specific product
				else {
					obj.aText.setText(obj.aText.getText() + obj.menu[0].substring(2, 9) + obj.menu[0].substring(14, 18) + "\t\tx " + obj.textField.getText() + "\n");
				} // print in the text area the name, the prize and the time for this specific product multiply by the Quantity
			}
			//---------------------------------------------------------------------------------------------------------
			else if(obj.club.isSelected()) { // do the exact same thing with the other radio buttons
				temp = obj.menu[2].substring(2, 15);  // and every time change the name, prize and time for this specific product
				i = Integer.parseInt(obj.menu[2].substring(21, 22));
				time = Integer.parseInt(obj.menu[2].substring(23, 25));
				
				//---------------------------------------------------------------------------------------------------------
				
				if(obj.textField.getText().isEmpty()) {
					obj.aText.setText(obj.aText.getText() + obj.menu[2].substring(2, 15) + obj.menu[2].substring(20, 25) +"\n");
				}
				else {
					obj.aText.setText(obj.aText.getText() + obj.menu[2].substring(2, 15) + obj.menu[2].substring(20, 25) + "\tx " + obj.textField.getText() + "\n");
				}
			}
			//---------------------------------------------------------------------------------------------------------
			else if(obj.salad.isSelected()) {
				temp = obj.menu[1].substring(2, 7);
				i = Integer.parseInt(obj.menu[1].substring(13, 14));
				time = Integer.parseInt(obj.menu[1].substring(15, 16));
				
				//---------------------------------------------------------------------------------------------------------
				
				if(obj.textField.getText().isEmpty()) {
					obj.aText.setText(obj.aText.getText() + obj.menu[1].substring(2,7) + obj.menu[1].substring(12,16) + "\n");
				}
				else {
					obj.aText.setText(obj.aText.getText() + obj.menu[1].substring(2,7) + obj.menu[1].substring(12,16) + "\t\tx " + obj.textField.getText() + "\n");
				}
			}
			//---------------------------------------------------------------------------------------------------------
			else if(obj.tacos.isSelected()) {
				temp = obj.menu[3].substring(2, 7);
				i = Integer.parseInt(obj.menu[3].substring(13, 14));
				time = Integer.parseInt(obj.menu[3].substring(15, 17));
				
				//---------------------------------------------------------------------------------------------------------
				
				if(obj.textField.getText().isEmpty()) {
					obj.aText.setText(obj.aText.getText() + obj.menu[3].substring(2, 7) + obj.menu[3].substring(12, 17) + "\n");
				}
				else {
					obj.aText.setText(obj.aText.getText() + obj.menu[3].substring(2, 7) + obj.menu[3].substring(12, 17) + "\t\tx " + obj.textField.getText() + "\n");
				}
			}
			//---------------------------------------------------------------------------------------------------------
			else if(obj.sushi.isSelected()) {
				temp = obj.menu[4].substring(2, 7);
				i = Integer.parseInt(obj.menu[4].substring(13, 14));
				time = Integer.parseInt(obj.menu[4].substring(15, 16));
				
				//---------------------------------------------------------------------------------------------------------
				
				if(obj.textField.getText().isEmpty()) {
					obj.aText.setText(obj.aText.getText() + obj.menu[4].substring(2, 7) + obj.menu[4].substring(12, 16) + "\n");
				}
				else {
					obj.aText.setText(obj.aText.getText() + obj.menu[4].substring(2, 7) + obj.menu[4].substring(12, 16) + "\t\tx " + obj.textField.getText() + "\n");
				}
			}
			//---------------------------------------------------------------------------------------------------------
			else if(obj.juice.isSelected()) {
				temp = obj.menu[5].substring(2, 14);
				i = Integer.parseInt(obj.menu[5].substring(21, 22));
				time = Integer.parseInt(obj.menu[5].substring(23, 24));
				
				//---------------------------------------------------------------------------------------------------------
				
				if(obj.textField.getText().isEmpty()) {
					obj.aText.setText(obj.aText.getText() + obj.menu[5].substring(2, 14) + obj.menu[5].substring(20, 24) + "\n");
				}
				else {
					obj.aText.setText(obj.aText.getText() + obj.menu[5].substring(2, 14) + obj.menu[5].substring(20, 24) + "\tx " + obj.textField.getText() + "\n");
				}
			}
			//---------------------------------------------------------------------------------------------------------
			else if(obj.cola.isSelected()) {
				temp = obj.menu[9].substring(3, 12);
				i = Float.parseFloat(obj.menu[9].substring(19, 22));
				time = Integer.parseInt(obj.menu[9].substring(23, 24));
				
				//---------------------------------------------------------------------------------------------------------
				
				if(obj.textField.getText().isEmpty()) {
					obj.aText.setText(obj.aText.getText() + obj.menu[9].substring(3, 12) + obj.menu[9].substring(18, 24) + "\n");
					
				}
				else {
					obj.aText.setText(obj.aText.getText() + obj.menu[9].substring(3, 12) + obj.menu[9].substring(18, 24) + "\tx " + obj.textField.getText() + "\n");
				}
			}
			//---------------------------------------------------------------------------------------------------------
			else if(obj.tea.isSelected()) {
				temp = obj.menu[8].substring(2, 9);
				i = Integer.parseInt(obj.menu[8].substring(16, 17));
				time = Integer.parseInt(obj.menu[8].substring(18, 19));
				
				//---------------------------------------------------------------------------------------------------------
				
				if(obj.textField.getText().isEmpty()) {
					obj.aText.setText(obj.aText.getText() + obj.menu[8].substring(2, 9) + obj.menu[8].substring(15, 19) + "\n");
					
				}
				else {
					obj.aText.setText(obj.aText.getText() + obj.menu[8].substring(2, 9) + obj.menu[8].substring(15, 19) + "\t\tx " + obj.textField.getText() + "\n");
				}
			}
			//---------------------------------------------------------------------------------------------------------
			else if(obj.ice.isSelected()) {
				temp = obj.menu[7].substring(2, 12);
				i = Float.parseFloat(obj.menu[7].substring(19, 22));
				time = Integer.parseInt(obj.menu[7].substring(23, 24));
				
				//---------------------------------------------------------------------------------------------------------
				
				if(obj.textField.getText().isEmpty()) {
					obj.aText.setText(obj.aText.getText() + obj.menu[7].substring(2, 12) + obj.menu[7].substring(18, 24) + "\n");
				}
				else {
					obj.aText.setText(obj.aText.getText() + obj.menu[7].substring(2, 12) + obj.menu[7].substring(18, 24) + "\t\tx " + obj.textField.getText() + "\n");
				}
			}
			//---------------------------------------------------------------------------------------------------------
			else if(obj.hot.isSelected()) {
				temp = obj.menu[6].substring(2, 12);
				i = Integer.parseInt(obj.menu[6].substring(19, 20));
				time = Integer.parseInt(obj.menu[6].substring(21, 22));
				
				//---------------------------------------------------------------------------------------------------------
				
				if(obj.textField.getText().isEmpty()) {
					obj.aText.setText(obj.aText.getText() + obj.menu[6].substring(2, 12) + obj.menu[6].substring(18, 22) + "\n");
				}
				else {
					obj.aText.setText(obj.aText.getText() + obj.menu[6].substring(2, 12) + obj.menu[6].substring(18, 22) + "\t\tx " + obj.textField.getText() + "\n");
				}
			}  // when i find which radio button the costumer selected
			
			//---------------------------------------------------------------------------------------------------------
			
			items[j] = temp; // put the name of the product in the array with the items
			j++; // one item added in the array
			
			//---------------------------------------------------------------------------------------------------------
			
			if(obj.textField.getText().equals("")) { // if Quantity text field is empty 
        		sum = sum + i;  // just add in the total summary the summary of the selected product
        		total = total + time; // and in the total time add the time for the specific product
        	}
        	else { // the Quantity text field isn't empty
        		sum = sum + i * Integer.parseInt(obj.textField.getText()); // do the same thing as above but multiply the prize with the Quantity 
        		total = total + time * Integer.parseInt(obj.textField.getText()); // multiply time with Quantity
        	}
         }
		//---------------------------------------------------------------------------------------------------------
         else if(e.getActionCommand() == "Total Cost") { // Total Cost button is selected
        	 obj.aText.setText(obj.aText.getText() + "\nTotal cost: " + sum + "\n\n"); // print in the main text area the total summary for all the products
         }
		//---------------------------------------------------------------------------------------------------------
         else if(e.getActionCommand() == "Total time for the order") { // Total time for this order button is selected
        	 obj.aText.setText(obj.aText.getText() + "\nTotal time for the order: " + total + "\n\n"); // print in the main text area the total time
         }
		//---------------------------------------------------------------------------------------------------------
         else if(e.getActionCommand() == "Delete Previous") { // delete previous button is selected
        	 if(obj.textField.getText().equals("")) { // if Quantity text field is empty 
          		sum = sum - i; // just abstract in the total summary the summary of the previous selected product
          		total = total - time; // and in the total time abstract the time for the specific product
          	}
          	else {
          		sum = sum - i * Integer.parseInt(obj.textField.getText()); // do the same but multiply with Quantity
          		total = total - time * Integer.parseInt(obj.textField.getText());
          	}
        	 
        	//---------------------------------------------------------------------------------------------------------
        	 
        	 obj.aText.setText(prev); // remove from the main text area the last added product
        	 items[j] = null; // delete the name of the previous selected item from the array
        	 j--; // one item removed
         }
		//---------------------------------------------------------------------------------------------------------
         else if(e.getActionCommand() == "New Order") { // new order is selected
        	 
			 Calendar now = Calendar.getInstance(); // create a calendar
		     int hour = now.get(Calendar.HOUR_OF_DAY); // get the hour of the day the order has placed
		     int minute = now.get(Calendar.MINUTE); // get the minutes of the day the order has placed
		     int end = 12 * 60; // the shop is closed at 12:00 to 24:00 so it's closed 12 hours of the day multiply by 60 minutes per hour
		     int currentMinuteOfDay = ((hour * 60) + minute - end); // the current minute of the day is the hour the order has placed
		                                     // plus the minutes of it decrease by the hours the shop is closed
		     
		   //---------------------------------------------------------------------------------------------------------
		     
		     int[] array = new int[2]; // i want the method to return the serial number of the order and the
		                                // time the order will be ready included the past orders that haven't been completed
		     
		     array = fulfillOrder(total, currentMinuteOfDay, ready, k); // call the method to calculate the time the order will be ready
		     ready = array[0]; // the time is in the first place of the array
		     k = array[1]; // the serial number of the order is in the 2nd
		     
		   //---------------------------------------------------------------------------------------------------------
		     
		     obj.aText.setText(null); // remove everything from the main text area
			 obj.textField.setText(null); // empty the quantity text field
			 sum = 0; // initialize the total summary
			 j = 0; // initialize the item array with the products
			 total = 0; // initialize the total time for the order
			 obj.aText.setText("Items:   Prize:   Minutes:\n"); // write a message to the main text area
         }
	} // end of the application
	//---------------------------------------------------------------------------------------------------------
	public int[] fulfillOrder(int total, int currentMinuteOfDay, int ready, int k) {

		if(currentMinuteOfDay > ready) { // if the time the previous orders will have been complete
			                           // is greater than the current minutes that the new order has been placed
	    	 ready = currentMinuteOfDay + total; // then the new order will be ready in the current minute
	     }                                            // plus the total time for the order
	     else { // else the previous orders hasn't been complete
	    	 ready = ready + total; // so the new order will be ready by the time the last order will be ready
	     }                         // plus the total time the new order needs to be ready
		
		//---------------------------------------------------------------------------------------------------------
		
		try {
			FileWriter fstream = new FileWriter(obj.file2,true); // create a file writer
			  BufferedWriter out = new BufferedWriter(fstream); // create a buffer writer
			  out.write(k + "," + currentMinuteOfDay  + "," + ready + ","); // add under the text that the order.txt has this message
			  for(l = 0; l < j-1; l++) {
				  out.write(items[l] + ","); // write the names of all the product in the order.txt file
			  }
			  
			  out.write(items[j-1] + "\n");
			  out.close(); // close the buffer writer
			  for(l = 0; l < j; l++) {
				  items[l] = null; // initialize the item array with nothing
			  }
			k++; // one order has been placed
			
			//---------------------------------------------------------------------------------------------------------
			
		} catch (IOException e1) { // cannot execute then there is an error
			System.out.println("an error executed");
			e1.printStackTrace(); // print where the exception occurred
		}
		//---------------------------------------------------------------------------------------------------------
		int[] array = new int[2]; // return the serial number of the orders
		array[0] = ready;       // and the time the last order will be ready
		array[1] = k;
		return array;
	}
}  