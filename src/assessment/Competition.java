package assessment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This program simulates a swimming competition system.  There are
 * classes related to swimmers details, their competition history, results
 * medal haul and events.
 * @author 19016480 Lauren Smart
 */
public class Competition  {   

    private final ArrayList<Competitor> competitors;
   
    public Competition()
    {
            competitors = new ArrayList<Competitor>();
        }

    /**
     * This method checks for the competitor and adds them
     * to the system if they are not already in the system.
     * @param competitor
     */    
    public void addCompetitor(Competitor competitor)
    {
        if(!competitors.contains(competitor)) 
        {
            competitors.add(competitor);
            System.out.println("Competitor added to the swimming competition");
            }
                else
            {
                System.out.println("Competitor is already in the swimming competition");
            }
        }
    /**
     * This method checks for the competitor and removes them 
     * from the system if they are found.
     * 
     *
         * @param competitor
     */


    public void removeCompetitor(Competitor competitor) //
        {
            if(competitors.contains(competitor))//
            {
                competitors.remove(competitor.compNumber);//
                System.out.println("Competitor has been removed from competiton");//
            }
            else//
            {
                System.out.println("Competitor not found in competition");//
            }
        }  

    /**
     * This method removes all competitors from the system.
     */
    public void clearAll()
    {
            competitors.clear();
        }

    /**
     * This method checks for the competitors competing at 
     * an event chosen by the user by inputting which event.
     * @param eventNo
     */
    public void getAllByEvent(int eventNo)
    {
      int count = 0;
        System.out.println("\nCompetitors competing at: " + eventNo);

        for(Competitor competitor: competitors)
        {
           if(competitor.getCompEvent().getEventNo()==(eventNo))
           {
                System.out.println("\n--EVENT INFORMATION--" 
                    + "\nCompetitor Number: " + competitor.getCompNumber()  
                    + "\nCompetitor Name: " + competitor.getCompName()          
                    + "\nEvent Number: " + competitor.getCompEvent().getEventNo()
                    + "\nEvent Venue: " + competitor.getCompEvent().getVenue()
                    + "\nEvent Venue ID: " + competitor.getCompEvent().getVenueID()
                    + "\nEvent Date and Time: " + competitor.getCompEvent().getEventDateTime()
                    + "\nEvent Record: " + competitor.getCompEvent().getRecord());
                    count++;
            }
        }
        if(count<1)
        {
            System.out.println("No competitors in this event");
        }
    }


    /**
     * This method loads all the class information from file to a 
     * string that users can read.
     */
    public void loadFromFile()
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            sc = new Scanner(new File("Competitors.txt"));
            while(sc.hasNextLine())
            {
                while(sc.hasNext())
                {
                    String newLine = sc.nextLine();
                    StringTokenizer st = new StringTokenizer(newLine, "[,]");

                    // Competitor details
                    int compNumber = Integer.parseInt(st.nextToken());
                    String compName = st.nextToken();
                    int compAge = Integer.parseInt(st.nextToken());
                    String hometown = st.nextToken();

                    // BreastStroke details
                    String eventType = st.nextToken();
                    int distance = Integer.parseInt(st.nextToken());
                    double winningTime = Double.parseDouble(st.nextToken());


                    // event details
                    int eventNo = Integer.parseInt(st.nextToken());
                    String venue = st.nextToken();
                    int venueID = Integer.parseInt(st.nextToken());
                    String eventDateTime = st.nextToken();
                    double record = Double.parseDouble(st.nextToken());

                    // result details
                    int placed = Integer.parseInt(st.nextToken()); //
                    double raceTime = Double.parseDouble(st.nextToken());

                    // competitor history details
                    String mostRecentWin = st.nextToken();
                    int careerWins = Integer.parseInt(st.nextToken());

                    int medalSize = Integer.parseInt(st.nextToken());
                    ArrayList<String> medals = new ArrayList<String>();
                    for(int x = 0; x <medalSize; x++)
                    {
                        medals.add(st.nextToken());
                    }


                    double personalBest = Double.parseDouble(st.nextToken());

                    BreastStroke B1 = new BreastStroke(eventType, distance, winningTime, eventNo, venue, venueID, eventDateTime, record); 
                    Result R1 = new Result(placed, raceTime);  
                    CompHistory CH1 = new CompHistory(mostRecentWin, careerWins, medals, personalBest);
                    Competitor C1 = new Competitor(compNumber, compName, compAge, hometown, B1, R1, CH1);                
                    Event E1 = new Event() {};
                    this.addCompetitor(C1); 
                }
            }
            sc.close();
        }
         catch(FileNotFoundException ex)
            {
                System.out.println("Where is the file?");
            }
        }

    /**
    * This method saves a competitors details to file
    */
    public void saveToFile()
    {
         try
            {
                FileWriter f = new FileWriter("Competitors.txt");
                BufferedWriter b =new BufferedWriter(f);

                for(Competitor competitor: competitors)
                {
                    b.write(competitor.toFile());
                    b.newLine();
                }
                System.out.println("File saved!");
                b.close();
            }
            catch (IOException ex)
            {
                  System.out.println("There has been an IO Exception!");      
            }
        }

    /**
    * This method indexes competitor number with competition event
    * and stores as a HashMap.  The HashMap stores keys and values.
    * @return 
    */
    public HashMap<Integer, Integer> getCompIndex()
    {
         // Create a HashMap object called people
        HashMap<Integer, Integer> compIndex = new HashMap<>();
        for (Competitor competitor : competitors) 
        {
            // Add keys and values (Name, Age)
            compIndex.put(competitor.getCompNumber(), competitor.getCompEvent().getEventNo());
            }
            return compIndex;
    }

    /**
     * This method prints out the the HashMap on separate lines,
     * that has been programmed above in the getCompIndex method.
     */
    public void showCompIndex() 
        {
            System.out.println("Details for competitor index: \nCompetitor Number \tEvent Number\n");
            for(Map.Entry<Integer, Integer>entryPair: getCompIndex().entrySet())
            {
                System.out.println(entryPair.getKey() + ":\t\t"
                + entryPair.getValue());
            }
        }
    /**
     * This method checks the competitors and returns the output 
     * of competitors and their ages in ascending order.
     */        
    public void sortCompetitorsByAge()
    { 
        Collections.sort(competitors, byAge());
        for(Competitor competitor: competitors)
        {
            System.out.println(competitor.toString() + "\n");
        }
    }

    /**
     * This method does the comparing of the ages in order to 
     * return them.
     * @return 
     */
    public static Comparator<Competitor> byAge()
    {
        return new Comparator<Competitor>()
        {
            @Override
            public int compare (Competitor C1, Competitor C2)
            {
             return C1.getCompAge() - C2.getCompAge(); 
            }
        };
    }

    /**
     * This method checks the wins of competitors and returns
     * a certain amount.  I have put 10 wins as my target.
     * @param target
     */
    public void winners(int target) //(Competition C02)
    {
        int counter = 0;

        ArrayList<Competitor> winners = new ArrayList<Competitor>();
        for(Competitor competitor: competitors)
        {
           if(competitor.getHistory().getCareerWins() >= target)
            {
                winners.add(competitor);
                counter++;
            }
        }

            //Remove duplicate competitors
    //        for(int x = 0; x < winners.size(); x++)
    //        {
    //            for(int z = 0; z <winners.size(); z++)
    //            {
    //               if(winners.get(x).equals(winners.get(z))) 
    //               {
    //                   winners.remove(z);
    //               }
    //            }     
    //        }

        //Display competitor details
        if(counter <1)
        {
            System.out.println("No competitors with wins exceeding: " + target);
        }
        else
        {
          //  for(int z = 0; z <winners.size(); z++)
           for(Competitor competitor: winners)
            {
                System.out.println("\nCompetitor Name: " + competitor.getCompName()
                    + "\nCompetitor Number: " + competitor.getCompNumber()
                    + "\nAge: " + competitor.getCompAge()
                    + "\nHometown: " + competitor.getHometown()
                    + "\nCareer wins: " + competitor.getHistory().getCareerWins()
                    + "\nMost Recent Win: " + competitor.getHistory().getMostRecentWin()
                    + "\nMedals: " + competitor.getHistory().getMedals()
                    + "\nPersonal Best: " + competitor.getHistory().getPersonalBest());
            }
        }
    }

    /**
     * This method returns the competitors who have qualified by way of their race times. 
    */
    public void getQualifiers()
    {
        int count = 0;

         for(Competitor competitor: competitors)
        {
            if(competitor.getResults().isQualified())
            {
                System.out.println("\n--COMPETITION QUALIFIERS--"  
                    + "\nCompetitor Name: " + competitor.getCompName()
                    + "\nCompetition Number: " + competitor.getCompEvent().getEventNo()
                    + "\nRace time: " + competitor.getResults().getRaceTime());
                    count++;
            }
        }
        if(count<1)
        {
            System.out.println("No qualified competitors in this event");
        }
    }



    /**
     * This method returns the details of the competition
     * @return 
     */
    @Override
    public String toString()
    {
        String string = "";
        
        for(Competitor competitor: competitors)
        {
            string += competitor.toString(); // is true - look through competitor  // change back to competitor 26/02/21 12.46
            //if statement
        }
        
        string += "\n\nCompetition: "
        + "\n";
        
        return string;
    }        

    /**
     * This returns a string of competitors
     * @return 
     */
    public String toFile()
    {
        String string = "";
        
        for(Competitor competitor: competitors)
        {
           string += competitor.toFile();
        }

        return string;
    }

    /**
     * This method deletes the 
     * @param compNumber 
     */
    public void deleteCompetitor(int compNumber)
    {
        for(Competitor competitor: competitors)
        {
            if(competitor.getCompName().equals(compNumber))  //.checkCompetitor(compNumber).
            {
                competitors.remove(compNumber);
            }
        }
    }

    /**
     * This method checks if the competitor is in the event.
         * @param compNumber
     * @return 
     */
    public boolean checkCompetitor(int compNumber) 
    {
        boolean found = false;
        for(Competitor competitor: competitors)
        {
            if(competitor.getCompNumber()==(compNumber)) //   if(competitor.getCompName().equals(compNumber)) 
            {
                found = true;
            }
        }

        if(found==true)
        {
            System.out.println("Competitor Number " + compNumber + " already in competition");
        }
        else
        {
            System.out.println("Competitor Number " + compNumber + " not in competiton. Please add details of competitor:");        
        }

        return found;
    }

    /**
     * This method checks the event number of the event to see if it is in the file.
     * @param eventNo
     * @return 
     */
    public boolean checkEvent(int eventNo)
    {
        boolean found = false;
        for(Competitor competitor: competitors)//  for(Competitor competitor: competitors)
        {
           if(competitor.getCompEvent().getEventNo()==(eventNo))  //if(competitor.getCompEvent().equals(eventNo))
           {
                found = true;
            }
        }

        if(found==true)
        {
            System.out.println("Event " + eventNo + " already exists!");
        }
        else
        {
            System.out.println("Event " + eventNo + " does not exist.  Please add details:");        
        }

        return found;
    }

    /**
     * This method returns the event 
     * @param eventNo
     * @param event
     * @return 
     */
    public BreastStroke getEvent(int eventNo, BreastStroke event) //public BreastStroke getEvent(int eventNo, BreastStroke event)
    {
        for(Competitor competitor: competitors)
        {

            if(competitor.getCompEvent().getEventNo()==(eventNo))
            {
               event = competitor.getCompEvent();  //.getCompEvent();
            }
        }
        return event;
    }

   
}