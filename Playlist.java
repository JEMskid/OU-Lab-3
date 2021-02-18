
/*
    Sources that have helped me:
    -Chase Lindquist -helped me with understanding addSong, addSongs, & removeSong
        as well as finding issues with code and coding suggestions
        
    -stackedoverflow -helped me with moving array elements

*/
import java.util.Arrays;

public class Playlist 
{
    private Song[] songs;
    private int numSongs;
    private static final int MIN_CAPACITY = 3;

    public Playlist()
    {
        Song[] songArray = new Song[MIN_CAPACITY];
        this.songs = songArray;
    }

    public Playlist(int capacity)
    {
        if (capacity < MIN_CAPACITY)
        {
            Song[] songArrayCap = new Song[MIN_CAPACITY];
            this.songs = songArrayCap;
        }
        else
        {
            Song[] songArrayCap = new Song[capacity];
            this.songs = songArrayCap;
        }
    }

    public int getCapacity()
    {
        return songs.length;
    }

    public int getNumSongs()
    {
        return this.numSongs;
    }

    public Song getSong(int index)
    {
        if(index < 0 || index > songs.length - 1)
        {
            return null;
        }
        else
        {
            return songs[index];
        }
    }

    public Song[] getSongs()
    {
        //copy songs array
        Song[] songsCopy = Arrays.copyOf(this.songs, this.songs.length);

        //varaible to store capacity
        int capacity = 0;

        //find how much capacity to give songsInArray
        for (int index = 0; index < songsCopy.length; index++)
        {
            if(songsCopy[index] != null)
            {
                capacity++;
            }
        }
        
        //make new array to store songs into 
        Song[] songsInArray = new Song[capacity];

        //now fill songsInArray with the songs found in songsCopy with the same
        //for loop above
        for (int index = 0; index < songsCopy.length; index++)
        {
            if(songsCopy[index] != null)
            {
                songsInArray[index] = songsCopy[index];
            }
        }

        return songsInArray;
    }

    public boolean addSong(Song song)
    {
        //make sure song doesn't equal null, return false if so
        if(song == null)
        {
            return false;
        }

        //if array is full, return false
        if(this.numSongs == getCapacity())
        {
            return false;
        }
        //otherwise add the song and increment numSongs
        else
        {
            this.songs[this.numSongs] = song;
            this.numSongs++;
            return true;
        }

    }

    public boolean addSong(int index, Song song)
    {
        //see if the given song is null; return false if so
        if(song == null)
        {
            return false;
        }

        if(index > this.numSongs)
        {
            return false;
        }

        //see if index is < 0 or > songs.length and return false
        if(index < 0 || index > songs.length)
        {
            return false;
        }

        //if theres no more room in the songs array, return false
        if(this.numSongs == getCapacity())
        {
            return false;
        }

        //shift the songs up to make room for a new one starting at the end
            //of the songs array
        //using numSongs on the assumption that index is in the middle of 
            //the songs array
        for (int mover = this.numSongs - 1; mover >= index && mover < getCapacity(); mover--)
        {
            this.songs[mover + 1] = this.songs[mover];
            this.songs[mover] = null;
        }

        //there should now be a null spot at index to put the given song in
        if(this.songs[index] == null)
        {
            this.songs[index] = song;
            this.numSongs++;
            return true;
        }
        else
        {
            return false;
        }

        
    }

    public int addSongs(Playlist playlist)
    {
        //if the playlist given is null, return zero
        if(playlist == null)
        {
            return 0;
        }

        //counter variable
        int counter = 0;

        //if array songs is filled stop and if playlist array is filled stop
        Song[] copy = Arrays.copyOf(playlist.songs, playlist.songs.length);

        //use a for loop to put all of the songs into copy array; start at numSongs
            //use a counter to count the loops and return the number stored
        for(int index = this.numSongs; index < this.songs.length
             && counter < playlist.songs.length ; index++)
        {
            //put songs into copy?
            copy[index] = playlist.songs[index];
            this.numSongs++;
        }
            
        return counter; 
    }

    public Song removeSong()
    {
        return null;
        //calls removeSong(int index) EASY
    }

    public Song removeSong(int index)
    {
        return null;
    }



}
