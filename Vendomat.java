package vendomat;

//Importing the scanner utility which allows user input.
import java.util.Scanner; 

public class Vendomat {
	
//Assigning the scanner to a variable
public static Scanner userInput = new Scanner(System.in);
  
    public static void main(String[] args) 
    {
        //Defining the items in the  vending machine, their prices and quantities, all put into arrays. ---------------------------
        String []snacks = {"Crisps", "Mars Bar", "Coca-Cola", "Eugenia", "Water"};
        double []price =  {75, 70, 100, 50, 85};
        int []qty =       {10, 10, 10, 10, 10};
        //Coins available for insertion. -----------------------------------------------------------------------------------------
        double []coins = {0.05, 0.10, 0.20, 0.50, 1.00};
        int    []changeQty = {20, 20, 20, 20, 10};
        
        while (true) {
        	
        //Printing out the menu with the choices. ---------------------------------------------------------------------------------
        System.out.println("***** 10000 Steps healthy snacks ***** ");
        System.out.println("Snacks             Price          QTY  ");
        System.out.println("1. Crisps          £0.75           "+ qty[0]) ;
        System.out.println("2. Mars Bar        £0.70           "+ qty[1]);
        System.out.println("3. Coca-Cola       £1.00           "+ qty[2]);     
        System.out.println("4. Eugenia         £0.50           "+ qty[3]);
        System.out.println("5. Water           £0.85           "+ qty[4]);
        System.out.print  ("Make a selection: ");
        
        
        //Takes user input of the selected item. ---------------------------------------------------------------------------------  
        
        int userOpt= userInput.nextInt() -1;
        int password = 12345;
       
        	
        while (userOpt < 0 || userOpt >= 5){   
        	
        //Power user mode.
        	
        	 if (userOpt == 10975) {   
        		 System.out.println("Enter your password");
        		 userOpt = userInput.nextInt();
        		 	if (userOpt == password) {
        		 
        		 	}
        			 	System.out.println("   **Admin mode** ");
        			 	System.out.println("1. Coins available");
        			 	System.out.println("2. Total profit");
        			 	System.out.println("3. Exit");
        			 	userOpt = userInput.nextInt();
        			 	
        //Coins remaining.
        			 	if (userOpt == 1) {
        			 		for (int j = 4; j >= 0; j--){
        			        System.out.println("£"+ coins[j] + " coin -- " + changeQty[j]);
        			        }
        			 	}
        			 	else if (userOpt ==2) {
        			 		int profit1 = (int) ((10 - qty[0]) * price[0] );
        			 		int profit2 = (int) ((10 - qty[1]) * price[1] );
        			 		int profit3 = (int) ((10 - qty[2]) * price[2] );
        			 		int profit4 = (int) ((10 - qty[3]) * price[3] );
        			 		int profit5 = (int) ((10 - qty[4]) * price[4] );
        			 		double profit = profit1 + profit2 + profit3 + profit4 + profit5;
        			 			System.out.println("Total profit is £" + profit/100);
        			 	}
             }
        	 else if (userOpt ==3)
        		 
        		 System.out.println("Invalid option, please select a number from 1 to 5.");
        	 
        	userOpt= userInput.nextInt() -1   ;
        										}
        //Request of the amount.///////////////
        System.out.println("How many?");
        int userAmount = userInput.nextInt();
        
        //If user selects more than the available amount in stock.//
        while (userAmount <= 0 || userAmount > qty[userOpt]) {
        	
        	System.out.println("Not enough in stock");
        	System.out.println("Maximum number is " + qty[userOpt]);
        	userAmount = userInput.nextInt() ;
        	
        }
        
        //This saves the stock amount after purchase.
        qty[userOpt] = qty[userOpt] - userAmount;
        
        //Total price if more than 1 product is selected.//
        double priceTotal ;
        	priceTotal = (price[userOpt] * userAmount);    
                
        System.out.println("You chose: " + snacks[userOpt] + " " + "\nPrice is: " + 
        				"£"+priceTotal/100 + " " + "\nIn stock: " + qty[userOpt] + "\nPlease insert coins");                    
                  
        //The remaining amount to be paid after the user inserts a certain coin.    
        while (priceTotal > 0) {
    	   System.out.println(priceTotal / 100 + " is left to pay.");
    	   
        double userPay = userInput.nextDouble() *100;
       
        	for (int i = 4; i >= 0; i--) {
        		if (userPay == coins[i] * 100) {
       
        			priceTotal = priceTotal - userPay;
        			userPay = 1;
    	    }
        }
        if (userPay != 1) {
    	   System.out.println("Please insert correct coins.");
       			}
       							}
         
        //If the full amount is paid, the item is being dispensed. 
        if (priceTotal == 0){
        	System.out.println("Enjoy your item!");
        }
        
        //If the user puts in more money than the full amount, he is due some change.
        if (priceTotal < 0 ){ 
        	System.out.println("You are due: " + "£" + -priceTotal/100);
        
        //The loop that goes through the change array to take out the required amount
        //to give back to the customer until it reaches 0.
        priceTotal = -priceTotal;
        while (priceTotal > 0)
        {
        	for (int u = 4; u >= 0;u-- ){
        		while (coins[u]<=priceTotal/100)
                
            {
                priceTotal= priceTotal - coins[u]*100;
                changeQty[u] -= 1;
                System.out.println("You have been paid:" + coins[u]);           
            }      
        }
            priceTotal = 0;   
        }
        }
        
        
        }
        
    }
}
    


 
    
    

