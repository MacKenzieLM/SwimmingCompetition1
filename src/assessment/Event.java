package assessment;

import java.time.format.DateTimeFormatter;

/**
 * @author Lauren Smart 19016480
 */
abstract class Event {
    
    private int eventNo;
    private String venue;
    private int venueID;
    private String eventDateTime;
    protected double record;

    
    public Event(int eventNo, String venue, int venueID, String eventDateTime, double record) 
    {
        this.eventNo = eventNo;
        this.venue = venue;
        this.venueID = venueID;
        this.eventDateTime = eventDateTime;
        this.record = record;
    }
    
    
public Event() 
{
    eventNo = 0;
    venue = null;
    venueID = 0;
    eventDateTime = "";
    record = 00.00;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss:SSS");


}

public int getEventNo()
{
  return eventNo;  
}

public void setEventNo(int eventNo)
{
    this.eventNo = eventNo;
}

 public String getVenue()
{
  return venue;  
}

public void setVenue(String venue)
{
    this.venue = venue;

}

public int getVenueID()
{
  return venueID;  
}

public void setVenue(int venueID)
{
    this.venueID = venueID;
}

public String getEventDateTime()
{
  return eventDateTime;  
}

public void setEventDateTime(String eventDateTime)
{
    this.eventDateTime = eventDateTime;
}

public Double getRecord() {
  return record;
}

public void setRecord(Double record) {
    this.record = record;
}

@Override
public String toString()
{
    String str = "";

    str += "\nEvent Number: " + this.getEventNo()
        + "\nVenue: " + this.getVenue()
        + "\nVenue ID: " + this.getVenueID()
        + "\nEvent date and time: " + this.getEventDateTime() 
        + "\nEvent record: " + this.getRecord();
    
    return str;
}    

public String toFile()
{
    String str = "";

    str += "," + this.getEventNo()
        + "," + this.getVenue()
        + "," + this.getVenueID()
        + "," + this.getEventDateTime()
        + "," + this.getRecord();

    return str;
}
}    



