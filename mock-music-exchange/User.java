
import java.util.ArrayList;
public class User implements Cloneable{
  private String userName;
  private boolean online;
  private ArrayList<Song> songList;

  public User() {
    this("");
  }

  public User(String u) {
    userName = u;
    online = false;
    songList = new ArrayList<>();
  }

  public String getUserName() {
    return userName;
  }

  public boolean isOnline() {
    return online;
  }

  public String toString() {
    String s = "" + userName + ": " + songList.size() + " songs (";
    if (!online) s += "not ";
    return s + "online)";
  }

  public void addSong(Song s) {
    if (s.getOwner()==null) {
      s.setOwner(this);
    }
    songList.add(s);
  }

  public ArrayList<Song> getSongList() {
    return songList;
  }

  public int totalSongTime() {
    int duration = 0;
    for (Song s : songList) {
      duration += s.getDuration();
    }
    return duration;
  }

  public void register(MusicExchangeCenter m) {
    m.registerUser(this);
  }

  public void logon() {
    this.online=true;
  }

  public void logoff() {
    this.online=false;
  }

  public ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m) {
    ArrayList<String> requestedSonglist = new ArrayList<>();
    int counter = 0;
    requestedSonglist.add(String.format("%-34s", "TITLE")+String.format("%-17s", "ARTIST")+String.format("%-7s", "TIME")+"OWNER\n");
    for (Song s : m.allAvailableSongs()) {
      counter += 1;
      requestedSonglist.add(String.format("%-4s", counter+".")+String.format("%-30s", s.getTitle())+String.format("%-17s", s.getArtist())+String.format("%-7s", s.getMinutes()+":"+String.format("%02d", s.getSeconds()))+s.getOwner().getUserName());
    }
    return requestedSonglist;
  }

  public ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m, String artist) {
    ArrayList<String> artistSonglist = new ArrayList<>();
    int counter = 0;
    artistSonglist.add(String.format("%-34s", "TITLE")+String.format("%-17s", "ARTIST")+String.format("%-7s", "TIME")+"OWNER\n");
    for (Song s : m.availableSongsByArtist(artist)) {
      counter += 1;
      artistSonglist.add(String.format("%-4s", counter+".")+String.format("%-30s", s.getTitle())+String.format("%-17s", s.getArtist())+String.format("%-7s", s.getMinutes()+":"+String.format("%02d", s.getSeconds()))+s.getOwner().getUserName());
    }
    return artistSonglist;
  }

  public void downloadSong(MusicExchangeCenter m, String title, String ownerName) {
    if (m.getSong(title, ownerName)!=null) {
      addSong(m.fetchSong(title, ownerName));
      m.fetchSong(title, ownerName).addDownload();
    }
  }
}
