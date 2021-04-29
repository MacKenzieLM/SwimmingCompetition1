package assessment;

/**
 *
 * @author 19016480 Lauren Smart
 */
public class ManualTest {
       
    public void test()
    {
        BreastStroke B1 = new BreastStroke();  // constructors
        B1.setEventNo(12); // setters
        B1.setVenue("Birmingham");
        B1.setEventDateTime("2016-12-20 14.45");
        B1.setRecord(214.34);
        B1.setEventType("Breaststroke");
        B1.setDistance(250);
        B1.setWinningTime(215.13);
        
     
          
        BreastStroke B2 = new BreastStroke();
        B2.setEventNo(15);
        B2.setVenue("Southampton");
        B2.setEventDateTime("2016-11-15 12.30");
        B2.setRecord(54.09);
        B2.setEventType("Breaststroke");
        B2.setDistance(100);
        B2.setWinningTime(54.01);
//        
        BreastStroke B3 = new BreastStroke();
        B3.setEventNo(17);
        B3.setVenue("York");
        B3.setEventDateTime("2016-09-12 11.50");
        B3.setRecord(765.58);
        B3.setEventType("Breaststroke");
        B3.setDistance(1000);
        B3.setWinningTime(766.90);
        
//        
        Result R1 = new Result();
        R1.setRaceTime(222.45);
        R1.setPlaced(3);
        
      //  R1.toString(); // one comp history and 1 competitor (to string) as demos
//       
        Result R2 = new Result();
        R2.setRaceTime(217.08);
        R2.setPlaced(1);
//        
        Result R3 = new Result();
        R3.setRaceTime(225.76);
        R3.setPlaced(7);
//        
        Result R4 = new Result();
        R4.setRaceTime(54.01);
        R4.setPlaced(1);
//        
        Result R5 = new Result();
        R5.setRaceTime(54.45);
        R5.setPlaced(3);
//        
        Result R6 = new Result();
        R6.setRaceTime(760.65);
        R6.setPlaced(5);
//        
//        
        CompHistory CH1 = new CompHistory();
        CH1.setMostRecentWin("Sydney");
        CH1.setCareerWins(15);
        CH1.setMedals("5G,2S,7B");
        CH1.setPersonalBest(217.11);
//                
        CompHistory CH2 = new CompHistory();
        CH2.setMostRecentWin("Montreal");
        CH2.setCareerWins(18);
        CH2.setMedals("2G,1S,3B");
        CH2.setPersonalBest(217.10);
        
        CompHistory CH3 = new CompHistory();
        CH3.setMostRecentWin("Tokyo");
        CH3.setCareerWins(2);
        CH3.setMedals("1S,3B");
        CH3.setPersonalBest(220.47);
        
        CompHistory CH4 = new CompHistory();
        CH4.setMostRecentWin("Blackpool");
        CH4.setCareerWins(22);
        CH4.setMedals("7G,7B");
        CH4.setPersonalBest(54.98);
//        
        CompHistory CH5 = new CompHistory();
        CH5.setMostRecentWin("Milan");
        CH5.setCareerWins(9);
        CH5.setMedals("2G,1S,1B");
        CH5.setPersonalBest(54.46);
//        
        CompHistory CH6 = new CompHistory();
        CH6.setMostRecentWin("New York");
        CH6.setCareerWins(3);
        CH6.setMedals("1G,2S");
        CH6.setPersonalBest(769.45);
//        
        Competitor C1 = new Competitor();
        C1.setCompNumber(224);
        C1.setCompName("Tom Thorpe");
        C1.setCompAge(30);
        C1.setHometown("Basildon");
        C1.setCompEvent(B1);
        C1.setResults(R1);
        C1.setHistory(CH1);
        System.out.println(C1.toString());
        
        
        Competitor C2 = new Competitor();
        C2.setCompNumber(228);
        C2.setCompName("James Bell");
        C2.setCompAge(24);
        C2.setHometown("Torquay");
        C2.setCompEvent(B1);
        C2.setResults(R2);
        C2.setHistory(CH2);
        System.out.println(C2.toString());
        
        Competitor C3 = new Competitor();
        C3.setCompNumber(346);
        C3.setCompName("Matt Stone");
        C3.setCompAge(27);
        C3.setHometown("London");
        C3.setCompEvent(B1);
        C3.setResults(R3);
        C3.setHistory(CH3);
        System.out.println(C3.toString());
        
        Competitor C4 = new Competitor();
        C4.setCompNumber(424);
        C4.setCompName("David Drake");
        C4.setCompAge(30);
        C4.setHometown("Belfast");
        C4.setCompEvent(B2);
        C4.setResults(R4);
        C4.setHistory(CH4);
        System.out.println(C4.toString());
        
        Competitor C5 = new Competitor();
        C5.setCompNumber(100);
        C5.setCompName("Alex Moss");
        C5.setCompAge(19);
        C5.setHometown("Glasgow");
        C5.setCompEvent(B2);
        C5.setResults(R5);
        C5.setHistory(CH5);
        System.out.println(C5.toString());
        
        Competitor C6 = new Competitor();
        C6.setCompNumber(762);
        C6.setCompName("Bill Sykes");
        C6.setCompAge(21);
        C6.setHometown("Basildon");
        C6.setCompEvent(B3);
        C6.setResults(R6);
        C6.setHistory(CH6);
        System.out.println(C6.toString());
        
  //      System.out.println(B1.toString()); // getters
   //     System.out.println(B2.toString());
   //     System.out.println(B3.toString());
        
        Competition C02 = new Competition();
        System.out.println(C02.toString()); // add a competitor but display before its added
        C02.addCompetitor(C2);
        C02.addCompetitor(C3);
        C02.addCompetitor(C4);
        C02.addCompetitor(C5);
        C02.addCompetitor(C6);
        
        
        // 1 - add competitor
        // C02.addCompetitor();

        // 2 - delete competitor 
        // C02.deleteCompetitor();
        
        // 3 clear competitors 
     //    C02.clearAll();
        
        // 4 - print out all competitors      
        // C02.printComp();
        
        // 5 - select competitors by event number
        // C02.getAllByEvent(12);
        // C02.getAllByEvent(15);
        // C02.getAllByEvent(17);
        
        // 6 - load competitors from file
      //   C02.loadFromFile();
         
        // 7 - Save the details to file
      //   C02.saveToFile();
        
        // 8 - index competitor with competitor number
        // C02.getCompIndex(); 
    
        // 9 - sort competitors by age    
        // C02.sortCompetitorsByAge();
      
        // 10 - list competitors with wins over 10    
        // C02.winners(10); 

        // 11 - get competitors who have qualified      
        // C02.getQualifiers();
    
       //  C02.clearAll(); 
       //  C02.saveToFile();  
          C02.loadFromFile();
         
         
    }
}
     
   
     
    
      

    
       
       