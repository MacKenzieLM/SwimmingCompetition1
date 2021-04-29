package assessment;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * This class describes the competitors history.
 * @author 19016480 Lauren Smart
 */
public class CompHistory {
     
    // variables which are non modifiable through final
    private String mostRecentWin;
    private int careerWins;
    private ArrayList<String> medals;
    private double personalBest;
  
public CompHistory() 
{
    mostRecentWin = "";
    careerWins = 0;
    medals = new ArrayList<String>();
    personalBest = 00.00;
    }

public CompHistory(String mostRecentWin, int careerWins, ArrayList<String> medals, double personalBest) 
{
    this.mostRecentWin = mostRecentWin;
    this.careerWins = careerWins;
    this.medals = medals;
    this.personalBest = personalBest;
}

/**
 * This method returns the most recent win for the competitor.
 * @return 
 */
public String getMostRecentWin() 
{
    return mostRecentWin;
    }

/**
 * this method sets the most recent win for the competitor.
 * @param mostRecentWin 
 */
public void setMostRecentWin(String mostRecentWin)
{
    this.mostRecentWin = mostRecentWin;
    }

/**
 * This method return the career wins for the competitor.
 * @return 
 */
public int getCareerWins() 
{
    return careerWins;
    }

/**
 * This method sets the career wins for the competitor.
 * @param careerWins 
 */
public void setCareerWins(int careerWins)
{
   this.careerWins = careerWins;
    }

/**
 * This returns the medals won by the competitors.
 * @return 
 */
public ArrayList<String> getMedals() 
{
    return medals;
    }

/**
 * This method sets the medals gained as an arraylist and separates 
 * them in a string.
 * @param medals 
 */
public void setMedals(String medals) 
{
    String[] tokens = medals.split(",");
    this.medals = new ArrayList<>(Arrays.asList(tokens));
    }    

/**
 * This method returns the personal best for the competitors.
 * @return 
 */
public double getPersonalBest() 
{
    return personalBest;
    }

/**
 * this method sets the personal best time for the competitors.
 * @param personalBest
 */
public void setPersonalBest(double personalBest) 
{
    this.personalBest = personalBest;
    }



/**
 * This returns the most recent win, career wins, medal haul and 
 * personal best for the competitors as a string and it is over-ridden
 * from object.
 * @return 
 */
@Override
public String toString()
{
    String str = "";

    str += "\n\n--COMPETITOR HISTORY--"
    + "\nMost Recent Win: " + this.getMostRecentWin()
    + "\nCareer Wins: " + this.getCareerWins()
    + "\nMedals: " + this.getMedals()
    + "\nPersonal Best: " + this.getPersonalBest();

    return str;
    }   

/**
 * This saves the most recent win, career wins, medal haul and 
 * personal best for the competitors to the file.
 * @return 
 */           
public String toFile()
{
    String str = "";

    str += this.getMostRecentWin()
        + "," + this.getCareerWins()
        + "," + this.getMedals().size() //look through arraylist to find tokens
        + this.getMedals()
        + this.getPersonalBest();

    return str;
    }
}

    

