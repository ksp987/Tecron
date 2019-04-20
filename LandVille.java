// Importing required packages.
import java.util.*;

class LandVille {
private int[][] land;
	
	// you will need to add the variable 'hasHouse'.
	boolean hasHouse = false;
	
	//constructor and setting default value of each cell to character '0'.
	public LandVille(int maxRows, int maxColumns) {
		 int rows = maxRows;
		 int columns = maxColumns;
		 
		 // Creating the array that the land variable above will reference (using the 'new' operator).
		 land = new int[rows][columns];
		 
		 //Initializing the land so that each cell is set to character '0'.
		 for (int i = 0; i < rows; i++)
			 for (int j = 0; j < columns; j++) {
				 land[i][j] = 0;
			 }
	}
		
	
	// Display of land.
	public void displayLand() {
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) 
				System.out.print(land[i][j] + " ");
			System.out.println();
		}
	}
	
	
	// Clearing out the land and setting each cell to be the character '0'.
	public void clearLand() {
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) 
				land[i][j] = 0;
		}
		
		hasHouse = false;
		
		System.out.println("Land cleared");
		displayLand();
	}
	
	
	//Building the house as per specifications.
	public void buildHouse(int rows, int columns) {
		//Setting the fence variables m and n to its values.		
		int m = rows + 2;
		int n = columns + 2;
		
		//Looping through array and assigning '8' for building and '1' for fence.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n ; j++) {
				//checking whether the cell is in boundary and assigning respective values.
				if ( (i > 0 && j > 0) && (i <= rows && j <= columns) ) {
					land[i][j] = 8;
				} else {
					
					land[i][j] = 1;
				}
			}	
		}
		
		hasHouse = true;
	}

	
	//Main method which takes all inputs and passes them to respective methods.
	public static void main(String[] args) {
		// Creating a Scanner object for input.
        Scanner input = new Scanner(System.in);
        
        //initializing the required variables to use inside program.
        int maxRows = 0, maxColumns = 0, menuOptions = 0, rowOfHouse = 0, columnOfHouse = 0;
                    
        // Input of rows for the land size and checking if it is valid input.
        do {
        	System.out.println("Enter row number of the land: ");
        	maxRows = input.nextInt();
        	
        	if (maxRows <= 0 || maxRows > 10) {
        		System.out.println("Row should be greater than 0 and less than or equal to 10");
        	} 
        	
        } while (maxRows <= 0 || maxRows > 10);
        
        // Input of columns for the land size and checking if it is valid input.
        do {
        	System.out.println("Enter column number of the land: ");
            maxColumns = input.nextInt();
            
        	if (maxColumns <= 0 || maxColumns > 10) {
        		System.out.println("Column should be greater than 0 and less than or equal to 10");
        	} 
        	
        } while (maxColumns <= 0 || maxColumns > 10);
       
        // Create an object of class LandVille using the 'new' operator, calling on the LandVille constructor.
        LandVille myHouse = new LandVille(maxRows, maxColumns);
        
        // Building a loop to display the menu, prompting for input and processing it as per requirements.
        do {
        	//Displaying of the menu and taking menu input.
        	System.out.println("Choose from the menu: 1. Build a house, 2. Display land 3. Clear the land 4. Quit");
        	menuOptions = input.nextInt();
        	
        	//checking if the menu input is valid.
        	if (menuOptions < 1 || menuOptions > 4) {
        		System.out.println("Incorrect input!!");
        	}
        	
        	//Action according to input
        	switch( menuOptions ) {
            case 1:
            	//Building house.
            	if ( !(myHouse.hasHouse) ) {
            		//Input of rows of the house to be built.
            		System.out.println("Enter row of the house:");
                	rowOfHouse = input.nextInt();
                	
                	//check if given rows is valid
                	if ( (rowOfHouse > (maxRows - 2) ) || (rowOfHouse < 1) ) {
                		System.out.println("Invalid input. Row of house needs to be greater than 0 and less than or equal to" + " " + (maxRows - 2) + ". No house is built.");
                		menuOptions = 0;
                		continue;
                	}
                	
                	//Input of column of the house to be built.
                	System.out.println("Enter column of the house:");
                	columnOfHouse = input.nextInt();
                	
                	//check if given columns is valid
                	if ( (columnOfHouse > (maxColumns - 2) ) || (columnOfHouse < 1) ) {
                		System.out.println("Invalid input. Colomn of house needs to be greater than 0 less than or equal to" + " " + (maxColumns - 2) + ". No house is built.");
                		menuOptions = 0;
                		continue;
                	}
                	
                	//Calling 'buildHouse' method to build house with above dimensions.
            		myHouse.buildHouse(rowOfHouse, columnOfHouse);
            		
            	} else {
            		//If house already exists, printing the output
            		System.out.println("House already exists!");
            		menuOptions = 0;
            		continue;
            	}
            	
            case 2:
            	//Displaying land
            	//Calling 'displayLand' method to display current land.
            	myHouse.displayLand();
            	menuOptions = 0;
            	break;
            	
            case 3:
            	//Clearing the land 
            	//Calling 'clearLand' method to clear the land.
            	myHouse.clearLand();
            	menuOptions = 0;
            	break;
            	
            case 4:
            	//displaying the user that the program ended.
            	System.out.println("Program ends.");
            	break;
            }
        	
        }while(menuOptions < 1 || menuOptions > 4);
       
	}

}
