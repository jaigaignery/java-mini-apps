

public class Song implements Comparable<Song>, Cloneable {
  private String title;
  private String artist;
  private int duration;
  private User owner=null;
  private int downloads = 0;
  
  public Song()  {
    this("", "", 0, 0);
  }
  
  public Song(String t, String a, int m, int s)  {
    title = t;
    artist = a;
    duration = m * 60 + s;

  }
  
  public String getTitle() { 
    return title; 
  } 
  
  public String getArtist() { 
    return artist; 
  }
  
  public int getDuration() { 
    return duration; 
  }
  
  public int getMinutes() {
    return duration / 60;
  }
  
  public int getSeconds() {
    return duration % 60;
  }

  public void setOwner(User newOwner) {
      this.owner = newOwner;
  }

  public User getOwner(){
    return owner;
  }

  public String toString()  {
    return("\"" + title + "\" by " + artist + " " + (duration / 60) + ":" + String.format("%02d", duration%60));
  }

  @Override
  public int compareTo(Song s){
    return (this.getTitle().compareTo(s.getTitle()));
  }

  public void addDownload(){
    downloads+=1;
  }

  public int getDownloads(){
    return downloads;
  }
}
