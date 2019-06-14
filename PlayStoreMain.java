import java.util.*;

public class PlayStoreMain {
	// Declare the variables needed.
	static int menuOptions = 0, userOptions = 0, options = 0;
	static boolean done = false, iDone = false, uDone = false, eDone = false;
    static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//Define the objects 
		PlayStore store = new PlayStore();
		ArrayList<Book> book = new ArrayList<Book>();
        
        // Creating the publicatin objects.
        String[] authors1 = {"L. Tolstoy"};
        Book b1 = new Book ("b1", "War and Peace", 12.55, "The Russian Messenger", 1225, authors1);
        
        String[] authors2 = {"F. Scott Fitzgerald"};
        Book b2 = new Book ("b2", "The great gatsby", 10, "Charles Scribner's Sons", 180, authors2);
                
        String[] authors3 = {"Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein"};
        Book b3 = new Book ("b3", "Introduction to algorithms", 100, "MIT Press", 1312, authors3);
           
        Magazine m1 = new Magazine("m1", "Forbes", 8.99, "Forbes Media", 50, 201904);
        
        //Adding the comments for the publications.
        store.addContent(b1);
        store.addContent(b2);
        store.addContent(b3);
        store.addContent(m1);
                
        // Creating the Application objects.        
        Application g1 = new Application("g1", "Pokemon", 5.3, "androidV4");    
        Application g2 = new Application("g2", "Pokemon", 5, "iOSV10");
        //a free app
        Application app1 = new Application("app1", "Calendar", "androidV3"); 

        //Stores the application objects to the store.        
        store.addContent(g1);
        store.addContent(g2);
        store.addContent(app1);
             
        // Adding and creating new users
        User u1 = new User("u1", "John Doe", "0412000", 200);
        User u2 = new User("u2", "Mary Poppins", "0433191");  
        User u3 = new User("u3", "Dave Smith", "0413456", 1000);
        User u4 = new User("u4", "Jackie Chan", "0417654");
                
        store.addUser(u1);
        store.addUser(u2);
        store.addUser(u3);
        store.addUser(u4);
        
        //Adding the comments on a particular content.
        Comment comment1 = new Comment(u1, "This is a fantastic game!");
        g1.addReview(comment1);
                
        Comment comment2 = new Comment(u2, "I never liked this game!");
        g1.addReview(comment2);
                
        g1.addReview(new Comment(u3, "The game crashes frequently"));
 
        b1.addReview(new Comment(u2, "I love Tolstoy!"));
                                
        // Creating a Menu
        do {
        	//Print the menu
            System.out.println("Please choose from the follownig \n"
            		+ "1. Upgrade a member to premium account\n"
            		+ "2. Purchase one item for one user\n"
            		+ "3. List all available contents\n"
            		+ "4. Showing all purchased items of a user\n"
            		+ "5. Showing all comments of a content\n"
            		+ " Press 6 to quit");
            do {
            	//Dealing with the exceptions
            	try {
            		//Taking input from the menu
                    menuOptions = input.nextInt();
                    if (menuOptions > 0 && menuOptions <=6 )
                    	iDone = true;
                    else {
                    	System.out.println("Invalid Input. Please enter again");
    					input.nextLine();
                    }
                    	
            	} catch (InputMismatchException ex) {
					System.out.println("Invalid Input. Please enter again");
					input.nextLine();
				}
            	
            }while(!iDone);
            iDone = false;

            //Switch statement for toggling through the menu.
            switch(menuOptions) {
        	case 1:{
        		//1. Upgrade a member to premium account
        		do {
        			userOptions();
        			
            			switch(userOptions) {
            			case 1:
            				u1.becomePremium();
            				end();
            				break;
            				
            			case 2:
            				u2.becomePremium();
            				end();
            				break;
            				
            			case 3:
            				u3.becomePremium();
            				end();
            				break;
            				
            			case 4:
            				u4.becomePremium();
            				end();
            				break;
            			}
            		
        		}while(userOptions > 0 && userOptions < 5);
        		break;
        	}
        	case 2:{
        		//2. Purchase one item for one user
        		System.out.println("Please enter your choice of user(1,2,3,4).");
        		   do {
                   		//Dealing with the exceptions.
        			   try {
                   		//Taking input from the menu
                           options = input.nextInt();
                           if (options > 0 && options < 5 )
                           	done = true;
                           else {
                           	System.out.println("Invalid Input. Please enter again");
           					input.nextLine();
                           }
                           	
                   	} catch (InputMismatchException ex) {
       					System.out.println("Invalid Input. Please enter again");
       					input.nextLine();
       				}
                   	
                   }while(!done);
                   done = false;
                   
                   //Options to purchase the products. 
                   switch(options) {
                   case 1:{
                	   System.out.println(" Please enter from options below \n"
               				+ " 1. To buy books \n "
               				+ "2. To buy Applications "
               				+ "\n 3. To buy magazine");
                	   selectCont();
                	   if (options == 1) {
                		   selectBook();
                   	   		if (options == 1) {
                   	   			u1.buyContent(b1);
                   	   			end();
                   	   			break;
                   	   		}else if (options == 2) {
                   	   			u1.buyContent(b2);
                   	   			end();
                   	   			break;
                   	   		} else {
                   	   			u1.buyContent(b3);
                   	   			end();
                   	   			break;
                   	   	}
                	   } else if (options == 2) {
                		   selectApp();
                		   if (options == 1) {
                			   u1.buyContent(g1);
                			   end();
                			   break;
                		   }else if (options == 2) {
                			   u1.buyContent(g2);
                			   end();
                			   break;
                		   } else {
                			   u1.buyContent(app1);
                			   end();
                			   break;
                		   }
                	   } else {
                		   u1.buyContent(m1);
                		   end();
                		   break;
                	   }
                	   
                	   
                   }
                   case 2:{
                	   System.out.println(" Please enter from options below \n"
                  				+ " 1. To buy books \n "
                  				+ "2. To buy Applications "
                  				+ "\n 3. To buy magazine");
                	   selectCont();
                   	   if (options == 1) {
                   		   selectBook();
                      	   		if (options == 1) {
                      	   			u2.buyContent(b1);
                      	   			end();
                      	   			break;
                      	   		}else if (options == 2) {
                      	   			u2.buyContent(b2);
                      	   			end();
                      	   			break;
                      	   		} else {
                      	   			u2.buyContent(b3);
                      	   			end();
                      	   			break;
                      	   	}
                   	   } else if (options == 2) {
                   		   selectApp();
                   		   if (options == 1) {
                   			   u2.buyContent(g1);
                   			   end();
                   			   break;
                   		   }else if (options == 2) {
                   			   u2.buyContent(g2);
                   			   end();
                   			   break;
                   		   } else {
                   			   u2.buyContent(app1);
                   			   end();
                   			   break;
                   		   }
                   	   } else {
                   		   u2.buyContent(m1);
                   		   end();
                   		   break;
                   	   }
                   }
                   case 3:{
                	   System.out.println(" Please enter from options below \n"
                  				+ " 1. To buy books \n "
                  				+ "2. To buy Applications "
                  				+ "\n 3. To buy magazine");
                	   selectCont();
                   	   if (options == 1) {
                   		   selectBook();
                      	   		if (options == 1) {
                      	   			u3.buyContent(b1);
                      	   			end();
                      	   			break;
                      	   		}else if (options == 2) {
                      	   			u3.buyContent(b2);
                      	   			end();
                      	   			break;
                      	   		} else {
                      	   			u3.buyContent(b3);
                      	   			end();
                      	   			break;
                      	   		}
                   	   } else if (options == 2) {
                   		   selectApp();
                   		   if (options == 1) {
                   			   u3.buyContent(g1);
                   			   end();
                   			   break;
                   		   }else if (options == 2) {
                   			   u3.buyContent(g2);
                   			   end();
                   			   break;
                   		   } else {
                   			   u3.buyContent(app1);
                   			   end();
                   			   break;
                   		   }
                   	   } else {
                   		   u3.buyContent(m1);
                   		   end();
                   		   break;
                   	   }
                   }
                   case 4: {
                	   System.out.println(" Please enter from options below \n"
                  				+ " 1. To buy books \n "
                  				+ "2. To buy Applications "
                  				+ "\n 3. To buy magazine");
                	   selectCont();
                   	   if (options == 1) {
                   		   selectBook();
                      	   		if (options == 1) {
                      	   			u4.buyContent(b1);
                      	   			end();
                      	   			break;
                      	   		}else if (options == 2) {
                      	   			u4.buyContent(b2);
                      	   			end();
                      	   			break;
                      	   		} else {
                      	   			u4.buyContent(b3);
                      	   			end();
                      	   			break;
                      	   	}
                   	   } else if (options == 2) {
                   		   selectApp();
                   		   if (options == 1) {
                   			   u4.buyContent(g1);
                   			   end();
                   			   break;
                   		   }else if (options == 2) {
                   			   u4.buyContent(g2);
                   			   end();
                   			   break;
                   		   } else {
                   			   u4.buyContent(app1);
                   			   end();
                   			   break;
                   		   }
                   	   } else {
                   		   u4.buyContent(m1);
                   		   end();
                   		   break;
                   	   }
                   }   
                }
                   break;
        	}
        	case 3:{ 
        		//3. List all available contents
        		store.showContent();
        		end();
        		break;
        	}
        	case 4: {
        		//4. Showing all purchased items of a user
        		userOptions();
        		switch(userOptions) {
        		case 1: 
        			u1.showContentBought();
        			end();
        			break;
        		case 2:
        			u2.showContentBought();
        			end();
        			break;
        		case 3:
        			u3.showContentBought();
        			end();
        			break;
        		case 4:
        			u4.showContentBought();
        			end();
        			break;
        		}
              break;
        	}
        	case 5:{
        		//5. Showing all comments of a content
        		System.out.println(" Please enter from options below \n"
        				+ " 1. To view comments on books \n "
        				+ "2. To view comments on Applications "
        				+ "\n 3. To view comments on magazines");
        		   selectCont();
                   
                   switch(options) {
                   case 1:{
                	   do {
                		   //Dealing with the exception.
                      		try {
                      			options = 0;
                      			//Taking input from the menu
                      			System.out.println("please chose the book from (1,2,3).");
                      			options = input.nextInt();
                      			if (options > 0 && options < 4 )
                      				done = true;
                      			else {
                      				System.out.println("Invalid Input. Please enter again");
                      				input.nextLine();
                      			}
                              	
                      		} catch (InputMismatchException ex) {
          					System.out.println("Invalid Input. Please enter again");
          					input.nextLine();
                      		} 
                	   }while(!done);
                	   done = false;
                	   if (options == 1) {
                		   b1.showComments();
                		   end();
                		   break;
                	   }else if (options == 2) {
                		   b2.showComments();
                		   end();
                		   break;
                	   } else {
                		   b3.showComments();
                		   end();
                		   break;
                	   }
                	   
                   }
                   case 2: {
                	   do {
                     		try {
                     			options = 0;
                     			//Taking input from the menu
                     			System.out.println("please chose the Applications from (1,2,3).");
                     			options = input.nextInt();
                     			if (options > 0 && options < 4 )
                     				done = true;
                     			else {
                     				System.out.println("Invalid Input. Please enter again");
                     				input.nextLine();
                     		 	}
                             	
                     		} catch (InputMismatchException ex) {
         					System.out.println("Invalid Input. Please enter again");
         					input.nextLine();
                     		} 
                	   }while(!done);
                	   done = false;
                	   if (options == 1) {
                		   g1.showComments();
                		   end();
                		   break;
                	   }else if (options == 2) {
                		   g2.showComments();
                		   end();
                		   break;
                	   } else {
                		   app1.showComments();
                		   end();
                		   break;
                	   }
                   }
                   case 3: {
                	   m1.showComments();
                	   end();
                	   break;
                   }
        	}
        }    	
       }   		
     }while(menuOptions > 0 && menuOptions <=6);

       
       
    	}
	
	
	public static void selectCont() {
		 do {
        		try {
        			options = 0;
        			//Taking input from the menu
        			options = input.nextInt();
        			if (options > 0 && options < 4 )
        				done = true;
        			else {
        				System.out.println("Invalid Input. Please enter again");
        				input.nextLine();
        			}
                	
        		} catch (InputMismatchException ex) {
        			System.out.println("Invalid Input. Please enter again");
        			input.nextLine();
        		}
        	
		 }while(!done);
		 done = false;
	}
	public static void selectApp() {
		do {
     		try {
     			options = 0;
     			//Taking input from the menu
     			System.out.println("please chose the Applications from (1,2,3).");
     			options = input.nextInt();
     			if (options > 0 && options < 4 )
     				done = true;
     			else {
     				System.out.println("Invalid Input. Please enter again");
     				input.nextLine();
     			}
             	
     		} catch (InputMismatchException ex) {
				System.out.println("Invalid Input. Please enter again");
				input.nextLine();
     		} 
	   }while(!done);
	   done = false;
	   
	}
	
	public static void selectBook() {
		 do {
       		try {
       			options = 0;
       			//Taking input from the menu
       			System.out.println("please chose the book from (1,2,3).");
       			options = input.nextInt();
       			if (options > 0 && options < 4 )
       				done = true;
       			else {
       				System.out.println("Invalid Input. Please enter again");
       				input.nextLine();
       			}
               	
       		} catch (InputMismatchException ex) {
				System.out.println("Invalid Input. Please enter again");
				input.nextLine();
       		} 
 	   }while(!done);
 	   done = false;
 	   
	}
	
	 public static void end() {
 		userOptions = 0;
 		do {
 			try {
 				System.out.println("Press 0 to quit or 1 for Main menu.");
 				int quit = input.nextInt();
 				
 				switch(quit) {
 				case 0:
 					eDone = true;
 					menuOptions = 0;
 					break;
 				case 1:
 					eDone = true;
 					continue;
 				}
 				
 			} catch (InputMismatchException ex) {
 				System.out.println("Invalid Input. Please enter again");
 				input.nextLine();
 			}
 		} while(!eDone);
 		eDone = false;
	}
	 public static void userOptions() {
		
		 
 			System.out.println("Please chose user among 1 - 4 : ");
     		
 			do {
             	try {
             		//Input of user to be upgraded.
             		userOptions = input.nextInt();
                     if (userOptions > 0 && userOptions < 5 )
                     	uDone = true;
                     else {
                     	System.out.println("Invalid Input. Please enter again");
     					input.nextLine();
                     }
             	} catch (InputMismatchException ex) {
 					System.out.println("Invalid Input. Please enter again");
 					input.nextLine();
 				}
             	
             }while(!uDone);
 			uDone = false; 
	 }
}
