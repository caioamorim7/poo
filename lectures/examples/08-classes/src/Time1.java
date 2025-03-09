public class Time1 { 
    private int hour; // 0 - 23  
    private int minute; // 0 - 59 
    private int second; // 0 - 59

    public void setTime(int hour, int minute, int second) { 
        if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || second < 0 || second >= 60) { 
            throw new IllegalArgumentException("hour, minute and/or second was out of range");
        } 
18 
19      this.hour = hour; 
20      this.minute = minute; 
21      this.second = second; 
22   } 
23 
24   // convert to String in universal-time format (HH:MM:SS) 
25   public String toUniversalString() { 
26      
27   } 
28 
29   // convert to String in standard-time format (H:MM:SS AM or PM) 
30   public String toString() { 
31      
32      
33      
34   } 
35 } 