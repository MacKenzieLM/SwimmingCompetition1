package assessment;

/**
 * This is the class for competitors results.
 * @author 19016480 Lauren Smart
 */
public class Result 
{
    private int placed;
    private double raceTime;
    private boolean qualified;
    
/*
*
*/    
public Result(int placed, double raceTime) 
{
    this.placed = placed;
    this.raceTime = raceTime;
}

   public Result() 
{
    placed = 0;
    raceTime = 00.00;
    qualified = false;      
}     

/*
* Returns the method for placed
*/
public int getPlaced()
{
    return placed;  
}

/*
* Creates method for placed
*/
public void setPlaced(int placed)
{
    this.placed = placed;
}

/*
* Returns the race time
*/
public double getRaceTime()
{
    return raceTime;
}

/*
* Creates the method for setting the race time.
*/
public void setRaceTime(double raceTime)
{
    this.raceTime = raceTime;
}

/**
 * Creates the method for the true or false return if a
 * competitor has qualified for the competition.
 * @return 
 */
public boolean isQualified()
{
    if (this.getPlaced() <5)
    {
        qualified = true;
    } 
    return qualified;
}  

/*
* Returns the placing, race time and whether they are 
* qualified or not as a string.  This method is over-ridden
* due to having the same method in Competition class.
*/     
@Override
public String toString()
{
    String string = "";

    string +=("\n\n--COMPETITOR RESULTS-- "
    + "\nPlaced: " + this.getPlaced()
    + "\nRace Time: " + this.getRaceTime()
    + "\nQualified: " + this.isQualified());

    return string;
}    

/**
 * Adds the string of placing, race time and
 * qualified to the file.
 * @return 
 */
public String toFile()
{
    String string = "";

    string += this.getPlaced()
    + "," + this.getRaceTime();
  

    return string;    
}

}
