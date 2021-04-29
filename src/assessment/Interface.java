package assessment;
import java.util.Scanner;

/**
 * @author Lauren Smart 19016480
*/
public class Interface {
 
public void Interface()
{
    Competition C02 = new Competition();
    C02.loadFromFile();
        
    int selection = 12;
        while(selection > 0 && selection < 13)
        {
            selection = menuChoice();
            if(selection == 12)
            {
                break;
            }
            else
            {
                performTask(selection, C02);
            }                   
        }
}
/**
 * This creates the menu choices.
 * @return 
 */  
public Integer menuChoice()
{
    //Scanner s = new Scanner(System.in);
    System.out.println("\nPlease select a menu option: "
    // lists the options '\n' and creates new line for each choice
    // option 1 to add competitor
    +"\n\nSelect option 1 to add a competitor"
    // option 2 to delete competitor
    +"\n\nSelect option 2 to delete competitor"
    // option 3 to clear all competitors
    + "\n\nSelect option 3 to clear all competitors"
    // option 4 to print out competitors
    + "\n\nSelect option 4 to print out all competitors"
    // option 5 to select competitors by event
    + "\n\nSelect option 5 to select competitors by event"
    // option 6 to load competitors from file
    + "\n\nSelect option 6 to load competitors from file"
    // option 7 to save competitors to file
    + "\n\nSelect option 7 to save competitors to file"
    // option 8 to index competitors
    + "\n\nSelect option 8 to index competitor with competitor number"
    // option 9 to sort competitors by age
    + "\n\nSelect option 9 to sort competitors by age"
    // option 10 to get winners
    + "\n\nSelect option 10 to list competitors with wins over 10"
    // option 11 to get competitors who have qualified
    + "\n\nSelect option 11 to get competitors who have qualified"
    // option 12 to exit program
    + "\n\nSelect option 12 to exit");

    Scanner s = new Scanner(System.in);
    int choice = 0;
    while(choice <1 || choice > 12)
    {
        System.out.println("\nENTER YOUR MENU SELECTION (1-12): ");
        if(s.hasNextInt())
        {
            choice = s.nextInt();
        }
        else
        {
            String temp = s.next();
            choice = 0;
        }
    }
    return choice;  
}

/**
 * This enables the menu to choose the methods and return the details 
 * for the user to input their answers.
 * @param selection
 * @param C02
 * @return 
 */
public Competition performTask(int selection, Competition C02)
{
    // switch statements call the choice variable below
    switch(selection)
    {
        case 1:
            addCompetitor(C02);
            break;
        case 2:
            deleteCompetitor(C02);
            break;
        case 3:
            clearAll(C02);
            break;
        case 4:
            printComp(C02);
            break;
        case 5:
            getAllByEvent(C02);  
            break;
        case 6:
            loadFromFile(C02);
            break;
        case 7:
            saveToFile(C02);
            break;
        case 8:
            compIndex(C02);
            break;
        case 9:
           sortCompetitorsByAge(C02);
            break;
        case 10:
            winners(C02);
            break;
        case 11:
            getQualifiers(C02);
            break;
        case 12:
            System.out.println("Exiting the menu");
            break;
    }    
    return C02;
}

/**
 * This method adds a competitor to the list
 */
private void addCompetitor(Competition C02) 
{
    Competitor C1 = new Competitor();
    Scanner s = new Scanner(System.in);
   
    // Add competitor
    int compNumber = 0;
    while(compNumber <100 || compNumber > 999)
    {
        System.out.println("Enter the competitor number (100-999): "); // SAVES TO TEXT FILE
        if(s.hasNextInt())
        {
            
            compNumber = s.nextInt();
        }
        else
        {
            String temp = s.next();
            compNumber = 0;
            }
             s.nextLine();
            }
  
   
 if(C02.checkCompetitor(compNumber)==false)
{
    C1.setCompNumber(compNumber);
        System.out.println("Enter competitor's full name: "); // SAVES TO TEXT FILE  
        String compName = s.nextLine();   
        C1.setCompName(compName);


    int compAge = 0;
    while(compAge<1 || compAge>99)
    {
        System.out.println("Enter competitor's age: "); // SAVES TO TEXT FILE
        if(s.hasNextInt())
        {
            compAge = s.nextInt();
            s.nextLine();
        }
        else
        {
            String temp = s.nextLine();
            compAge = 0;
        }
    }   
    C1.setCompAge(compAge);


    System.out.println("Enter competitor's hometown: "); // SAVES TO TXT FILE
    String homeTown = s.nextLine();
    C1.setHometown(homeTown);

    // Event details
    BreastStroke B1 = new BreastStroke();
    System.out.println("Enter event number (1-100):");
    int eventNo = s.nextInt();

    while(eventNo <1 || eventNo > 100)
    {
        System.out.println("Enter event number (1-100):");
        if(s.hasNextInt())
        {

            eventNo = s.nextInt();
            }
                else
                {
                    String temp = s.next();
                    eventNo = 0;
                    }
        } 


if(C02.checkEvent(eventNo)==true)
{
    C1.setCompEvent(C02.getEvent(eventNo, B1));
} 
else
{

    B1.setEventNo(eventNo);  

    int choice = 0;
    int venueID = 0;
    while(choice<1 || choice>2)
    {
         System.out.println("Enter 1 for venue name or 2 for venue number: "); 
         if(s.hasNextInt())
         {
             choice = s.nextInt();
             s.nextLine();

             if(choice==1)
             {
                 String venueName="";
                 while(venueName.isEmpty() || venueName.equals(""))
                 {
                     System.out.println("Enter the venue name: ");
                     venueName=s.nextLine();
                     B1.setVenue(venueName);
                 }
             }
             else if (choice==2)
                 {

                    while(venueID < 1)
                    {
                        System.out.println("Enter venue ID: ");
                        venueID = s.nextInt();
                        B1.setVenue(venueID); // does not set
                        s.nextLine();
                    }
                 }
                     }
                     else
                     {
                         String temp = s.next();
                         choice = 0;
                     }
                 }


    // enter the event date and time  
    String eventDateTime = "";

    while(eventDateTime.isEmpty() || eventDateTime.contains("null"))
    {
        System.out.println("Enter event date and time(yyyy-mm-dd 00.00): ");
        eventDateTime = s.nextLine();
    }

    B1.setEventDateTime(eventDateTime);
  //  C02.getEvent(eventNo, B1).setEventDateTime(eventDateTime);

    // enter the event record
    System.out.println("Enter event record: "); // SAVES TO TEXT FILE
    double record = s.nextDouble();
    B1.setRecord(record);
    s.nextLine();


    // BreastStroke class details
    B1.setEventType("Breaststroke");

    // enter the class distance

    int distance = 0;

    while(distance<50 || distance >1500)
    {
        System.out.println("Enter class distance (50 - 1500): "); // SAVES TO TEXT FILE
        if(s.hasNextInt())
        {
            distance=s.nextInt();
        }
        else
        {
            String temp = s.next();
            distance=0;
        }
    }   
            B1.setDistance(distance);

            s.nextLine();

            C1.setCompEvent(B1);
        }
         
 // enter the winning time
        boolean valid = false;
        System.out.println("Enter winning time: "); // SAVE TO TEXT FILE
        double winningTime = s.nextDouble(); 
                       
        if(winningTime<= 0.0)
        {
            if(valid == true)  
            {  
              B1.setWinningTime(winningTime);
               
                
            }
            else
            {
                 System.out.println("*Invalid winning time*.  Please input valid winning time:");
                winningTime = s.nextDouble();   
            }
                
        }
//    // enter the winning time //like 
//  // Add competitor
//  double winningTime = -1.0;
//  while(winningTime < 0.0)
//
//
//    System.out.println("Enter winning time: "); // SAVES TO TEXT FILE
//       if(s.hasNextDouble())
//       {
//
//        winningTime = s.nextDouble();
//       }
//       else
//       {
//        String temp = s.next();
//        winningTime = -1.0;
//        }
//         s.nextLine();
//            }
//   //  B1.set
//   //  C1.setCompEvent(compEvent).
//  
//   C1.setResults(winningTime);
//   B1.setWinningTime(winningTime); // do the same for racetime and personal best

    // Result details - placing
    //boolean input = false;
    Result R1 = new Result();
    System.out.println("Enter competitor's placing: "); // doesnt loop with continous output if wrong input
    int placed = 0;
    while(placed <1 || placed >8)
    {
        if(s.hasNextInt())
        {
            placed=s.nextInt();
            }
            else
            {
                String temp = s.next();
                }
    }
    R1.setPlaced(placed);
              
       
    // competitor's race time 
    boolean val = false;     
    System.out.println("Enter competitor's race time: "); // SAVES TO TEXT FILE
    double raceTime = s.nextDouble();

    if(raceTime > 0.0)
    {
        if(val == true)  
        {
           // C1.getResults().setRaceTime(raceTime);

        }
        else if(raceTime <0)
        {
            System.out.println("*Invalid race time*.  Please input valid race time: ");
            s.nextDouble(); 
        }
    }     
    R1.setRaceTime(raceTime);

    //Most recent win
    s.nextLine();
        
        C1.setResults(R1);
        
        CompHistory CH1 = new CompHistory();
        
        System.out.println("Enter city of most recent win: ");
        String mostRecentWin = s.nextLine();
        CH1.setMostRecentWin(mostRecentWin);
              
        // Competition career wins
        boolean valIn = false;
        
        System.out.println("Enter competitor's career wins: "); // SAVES TO TEXT FILE
        int careerWins = s.nextInt();
        
        if(careerWins >=0)
        {
                CH1.setCareerWins(careerWins);
        }
        else if(valIn == false)
        {
                System.out.println("*Invalid number*. Please enter number over 1: ");
        }
       

        // Medals to date
        s.nextLine();
        System.out.println("Enter medals to date (comma separated list): ");
        String medals  = s.nextLine();
      
        CH1.setMedals(medals);
    
        
        // Competitors personal best
        boolean input2 = false;
        System.out.println("Competitor's personal best result: "); // SAVES TO TEXT FILE
        double personalBest = s.nextDouble();
         
         if(personalBest > 0.0)
         {

            CH1.setPersonalBest(personalBest);
         }
         else if(personalBest < 0)
         {
             System.out.println("*Invalid personal best*.  Please input valid personal best:");
             s.nextDouble(); 
         }

        C1.setHistory(CH1);
         
        C02.addCompetitor(C1);  
           
     }
   
}
    
/**
 * This method takes the competitor number and deletes it from competition
 * @param C02 
 */  
private void deleteCompetitor(Competition C02) 
        
{
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the competitor number to delete: ");
    int compNumber = s.nextInt();
    
    C02.deleteCompetitor(compNumber);
    System.out.println("Competitor " +compNumber+ " has been deleted");
    }


/**
 * This method clears all from the competition
 * @param C02 
 */
private void clearAll(Competition C02) 
{
    Scanner s = new Scanner(System.in);
    System.out.println("Are you sure you want to clear the competition? (Y/N");
    String choice = s.nextLine();

    if(choice.toUpperCase().equals("Y"))
    {
        System.out.println("Would you like to save first? (Y/N)");
        String choice2  = s.nextLine();
        if(choice2.toUpperCase().equals("Y"))
        {
            C02.saveToFile();
            C02.clearAll();
            System.out.println("Competition saved and cleared");
        }
        else if(choice2.toUpperCase().equals("N"))
        {
            C02.clearAll();
            System.out.println("Competition cleared");
        }
    }
    else
    {
        System.out.println("Clear cancelled");
    }      
}



/**
 * This method prints all the competition details out
 * @param C02 
 */
private void printComp(Competition C02) 
{
    System.out.println("Competition competitors: ");
    System.out.println(C02.toString());
 }



     /**
     * this method gets the event details
     * @param C02
     * @param event 
     */
    private void getAllByEvent(Competition C02) 
    {
        Scanner s = new Scanner(System.in);


        System.out.println("Enter the competition event number: ");
        int eventNo = s.nextInt();
      
      C02.getAllByEvent(eventNo);
       }


/**
 * This method saves the details to file
 * @param C02 
 */
private void saveToFile(Competition C02) 
{
      C02.saveToFile();
    }

/**
 * This method returns loads the file details
 * @param C02
 * @return 
 */
private Competition loadFromFile(Competition C02) 
{
    System.out.println("\nSwimming competition loaded from file:");
    C02.loadFromFile();
    
    return C02;
        
}   

/**
 * This method returns the competitor number with event number
 * @param C02 
 */
private void compIndex(Competition C02) 
{
    System.out.println("Paired index of competitor number with event number: ");
       System.out.println(C02.getCompIndex().toString());
            
}

/**
 * This method sorts the competitors by age
 * @param C02 
 */
private void sortCompetitorsByAge(Competition C02) 
{
    System.out.println("Competitors sorted by Age: ");
    C02.sortCompetitorsByAge();
   
    }

/**
 * This method returns the competitors with wins over 10
 * @param C02 
 */
private void winners(Competition C02) 
{
   // Scanner s = new Scanner(System.in);  
    System.out.println("\nReturn competitors with career wins over 10: ");
    int counter = 0;
     
    C02.winners(10);
    counter++;
     }

 
/**
 * This method returns the competitors who have qualified based on their wins 
 * @param C02 
 */
private void getQualifiers(Competition C02) 
{
    C02.getQualifiers();
 
    }
}


