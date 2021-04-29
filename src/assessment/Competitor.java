package assessment;

/**
 * This class describes the competitor's details.  
 * @author 19016480 Lauren Smart
 */
public class Competitor {
   
    int compNumber;
    private String compName;
    private int compAge;
    private String hometown;
    //private double personalBest;
    private boolean newPB;
    private BreastStroke compEvent;
    private Result result;
    private CompHistory history;

public Competitor()   
{
    compNumber = 0;
    compName = "";
    compAge = 0;
    hometown = "";
   //personalBest = 0.0;
    newPB = false;
    compEvent = new BreastStroke();
    result = new Result();
    history = new CompHistory();
  }

/**
 * This constructor holds the parameters for the Competitor.
 * @param compNumber
 * @param compName
 * @param compAge
 * @param hometown
 * @param compEvent
 * @param result
 * @param history
 */
public Competitor(int compNumber, String compName, int compAge, String hometown, BreastStroke compEvent, Result result, CompHistory history) {
    this.compNumber = compNumber;
    this.compName = compName;
    this.compAge = compAge;
    this.hometown = hometown;
   //this.personalBest = personalBest;
    this.newPB = false;
    this.compEvent = compEvent;
    this.result = result;
    this.history = history;
}

/**
 * This method returns the competitor's number.
 * @return 
 */
public int getCompNumber() 
{
    return compNumber;
    }

/**
 * This method sets the competitor's number.
 * @param compNumber 
 */
public void setCompNumber(int compNumber) 
{
   
    this.compNumber = compNumber;
    
}
/**
 * This method returns competitor's name.
 * @return 
 */
public String getCompName() 
{
    return compName;
    } 

/**
 * This method sets up the competitor's name.
 * @param compName 
 */
public void setCompName(String compName) 
{
    this.compName = compName;
    }

/**
 * This method returns the competitor's age.
 * @return 
 */
public int getCompAge() 
{
    return compAge;
    }

/**
 * This method sets up competitor's age.
 * @param compAge 
 */
public void setCompAge(int compAge) 
{
    
    this.compAge = compAge;
    }

/**
 * This method returns the competitor's hometown.
 * @return 
 */
public String getHometown() 
{
    return hometown;
    }

/**
 * This method sets up the competitor's hometown.
 * @param hometown 
 */
public void setHometown(String hometown) 
{
    this.hometown = hometown;
    }


/**
 * This method returns the competitor's event in BreastStroke event.
 * @return 
 */
public BreastStroke getCompEvent() 
{
    return compEvent;
    }

/**
 * This method sets up the competitor's event in BreastStroke event.
 * @param compEvent 
 */
public void setCompEvent(BreastStroke compEvent) 
{
    this.compEvent = compEvent;
    }

/**
 * This method returns the competitors results.
 * @return 
 */
public Result getResults() 
{
    return result;
    }

/**
 * This method sets up the competitor's results.
 * @param result 
 */
public void setResults(Result result) 
{
    this.result = result;
    }

/**
 * This method returns the competitor's history.
 * @return 
 */
public CompHistory getHistory() 
{
    return history;
    } 

/**
 * This method sets the competitors history.
 * @param history 
 */
public void setHistory(CompHistory history) 
{
        this.history = history;
    }

/**
 * This method works out if the newest race time is the fastest
 * and returns the competitor's new personal best.
 * @return 
 */
public boolean isNewPB()
{
    if(this.getResults().getRaceTime() < this.getHistory().getPersonalBest())
    {
        newPB = true;
        this.history.setPersonalBest(this.getResults().getRaceTime());
    }
    return newPB;

    }

/**
 * This method returns all the setters below into a string.
 * @return 
 */
@Override
 public String toString()
{
String str = "";

str += "\n--COMPETITOR DETAILS-- "
    + "\nCompetitor Number: " + this.getCompNumber()
    + "\nCompetitor Name: " + this.getCompName()
    + "\nCompetitor Age: " + this.getCompAge()
    + "\nCompetitor Hometown: " + this.getHometown()
    + "\nCompetitor New Personal Best: " + this.isNewPB()
    +  this.getCompEvent().toString() 
    +  this.getResults().toString()
    +  this.getHistory().toString();
    return str;
}

 /**
  * This method saves all the getters to file. 
  * @return 
  */
public String toFile()
{
String str = "";

   
       str += this.getCompNumber()
        + "," + this.getCompName()
        + "," + this.getCompAge()
        + "," + this.getHometown()
        + "," + this.getCompEvent().toFile()
        + "," + this.getResults().toFile() 
        + "," + this.getHistory().toFile();    
        return str;    
}


}



