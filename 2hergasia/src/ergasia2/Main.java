package ergasia2;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) { //TOUMPA GEORGIA 01793
		
		if(args.length > 0) {  // i have pass the two .txt files as line command arguments
			
            File file = new File(args[0]); // line command argument args[0]
            File file2 = new File(args[1]); // line command argument args[1]
            try {
            	
				if (file.createNewFile()) { // if menu.txt dosen't exists then create it
				    System.out.println("File created: " + file.getName());
				 }
				 else { // else the menu.txt file exists
				    System.out.println("File already exists.");
				 }
				
				//----------------------------------------------------------------------------------------------
				
				if (file2.createNewFile()) { // if order.txt dosen't exists then create it
				    System.out.println("File created: " + file2.getName());
				 }
				 else {  // else the order.txt file exists
				    System.out.println("File already exists.");
				 }
				
				//----------------------------------------------------------------------------------------------
				
				FileWriter Writer = new FileWriter(file2);  // create a file writer to set empty the order.txt 
				Writer.write("");                        // every time the projects starts again
				Writer.close();                           // and then close it
				
				FileWriter Writer2 = new FileWriter(file);  // create another one file writer to write the menu
				Writer2.write("1,Burger,food,5,10\n"        // of the coffee shop in the menu.txt file
						+ "2,Salad,food,6,5\n" 
						+ "3,Club-Sandwich,food,5,10\n"
						+ "4,Tacos,food,4,10\n"
						+ "5,Sushi,food,7,5\n"
						+ "6,Orange Juice,drink,3,5\n"
						+ "7,Hot Coffee,drink,2,5\n"
						+ "8,Ice Coffee,drink,2.5,5\n"
						+ "9,Ice-Tea,drink,3,3\n"
						+ "10,Coca-Cola,drink,2.5,3");
				Writer2.close();                        // and then close it
				
				//----------------------------------------------------------------------------------------------
				
				Scanner reader = new Scanner(file);  // create a scanner to read the menu from the menu.txt file
				String[] data = new String[10];  // create an array to store the menu
				int i = 0;   // create a variable to pass the arguments of the array
				
				while (reader.hasNextLine()) {  // while the reader finds a new line in menu.txt
			        data[i] = reader.nextLine();  // save it to the array
			        i++;                          // and every time increase the i by 1
			      }
				
			    reader.close();   // then close the scanner
			    
			    //----------------------------------------------------------------------------------------------
			    
			    Calendar now = Calendar.getInstance();  // create a calendar to get the current time zone
			    int hour = now.get(Calendar.HOUR_OF_DAY); // and get the current hour of it
			    
			    int start = 12; // coffee shop opens at 12:00 p.m.
			    int end = 24;   // coffee shop closes at 12:00 a.m.
			    
			    if(hour < start || hour > end) {  // if the coffee shop isn't open. Between 12 and 24 p.m
			    	System.out.println("The coffee-shop Panda it's not open yet"); // print isn't open yet
			    }
			    else {
			    	System.out.println("The coffee-shop Panda is open!"); // else the coffee shop is open so
			    	Form frame = new Form(data, file2);  // create a new object and pass the menu array and the order.txt file
					frame.Form1();                      // execute the Form1() method of Form class
			    }
			    
			    //----------------------------------------------------------------------------------------------
				
			} catch (IOException e) { // if try{} cannot execute then there is an error
				System.out.println("An error occurred.");
				e.printStackTrace(); // print where the exception occurred
			}
        }
		else {  // you don't have pass the two files
			System.out.println("Please give two .txt files as line command arguments");
		}

	}

}
