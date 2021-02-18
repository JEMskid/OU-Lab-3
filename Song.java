import java.util.Arrays;

public class Song 
{
    private String title;
    private String artist;
    private int[] time;

    public Song (String title, String artist, int[] time)
    {
        this.title = title;
        this.artist = artist;

        //makes sure that any value put into time is not negative and not zero
        int[] givenTimeCopy = Arrays.copyOf(time, time.length);

        //sort by length of given time array
        //song with just seconds
        if (givenTimeCopy.length == 1)
        {
          if(givenTimeCopy[0] >= 0 && givenTimeCopy[0] < 60)
          {
               this.time = givenTimeCopy;
          }
        }

        //song with seconds and minutes
        if (givenTimeCopy.length == 2)
        {
          if(givenTimeCopy[0] >= 0 && givenTimeCopy[0] < 60
              && givenTimeCopy[1] >= 0 && givenTimeCopy[1] < 60)
          {
               this.time = givenTimeCopy;
          }
        }
          
        //song with seconds, hours, and minutes
        if (givenTimeCopy.length == 3)
        {
          if(givenTimeCopy[0] >= 0 && givenTimeCopy[0] < 60
              && givenTimeCopy[1] >= 0 && givenTimeCopy[1] < 60
               && givenTimeCopy[2] >= 0 && givenTimeCopy[2] < 60)
          {
               this.time = givenTimeCopy;
          }
        }

    } 

   public String getTitle()
   {
        return title;
   }

   public String getArtist()
   {
        return artist;
   }

   public int[] getTime()
   {
       int[] timeCopy = Arrays.copyOf(this.time, this.time.length);
        return timeCopy;
   }

}
