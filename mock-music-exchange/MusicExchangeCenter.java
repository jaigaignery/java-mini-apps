import java.util.*;

public class MusicExchangeCenter {
    private ArrayList<User> users;
    private HashMap<String, Float> royalties;
    private ArrayList<Song> downloadedSongs;

    public MusicExchangeCenter(){
        users = new ArrayList<>();
        royalties = new HashMap<>();
        downloadedSongs = new ArrayList<>();
    }

    public ArrayList<User> onlineUsers(){
        ArrayList<User> usersOnline = new ArrayList<>();
        for (User u:users){
            if (u.isOnline()){
                usersOnline.add(u);
            }
        }
        return usersOnline;
    }

    public ArrayList<Song> allAvailableSongs(){
        ArrayList<Song> availableSongs = new ArrayList<>();
        for (User u:onlineUsers()){
            availableSongs.addAll(u.getSongList());
        }
        return availableSongs;
    }

    public String toString(){
        return "Music Exchange Center, (" + onlineUsers().size() + " users online, "+allAvailableSongs().size() + " songs available)";
    }

    public User userWithName(String s){
        for (int i = 0 ; i <= users.size()-1 ; i++) {
            if (users.get(i).getUserName().equals(s)) {
                return users.get(i);
            }
        }
        return null;
    }

    public void registerUser(User x) {
        if (userWithName(x.getUserName())==null){
            users.add(x);
        }
    }

    public ArrayList<Song> availableSongsByArtist(String artist){
        ArrayList<Song> songsByArtist = new ArrayList<>();
        for (Song s:allAvailableSongs()){
            if (s.getArtist().equals(artist) && !songsByArtist.contains(s)){
                songsByArtist.add(s);
            }
        }
        return songsByArtist;
    }

    public Song getSong(String title, String ownerName) {
        for (Song s: userWithName(ownerName).getSongList()){
            if ((s.getTitle().equals(title)) && (userWithName(ownerName).isOnline())) {
                downloadedSongs.add(s);
                if (!royalties.containsKey(s.getArtist())) {
                    royalties.put(s.getArtist(), 0.0f);
                }
                royalties.put(s.getArtist(), royalties.get(s.getArtist()) + 0.25f);
                return s;
            }
        }
        return null;
    }

    public void displayRoyalties(){
        System.out.println("Amount    Artist\n-----------------");
        for (String a:royalties.keySet()){
            System.out.println("$"+String.format("%.2f", royalties.get(a))+"     "+a);
        }
    }

    public TreeSet<Song> uniqueDownloads(){
        return new TreeSet<>(downloadedSongs);
    }

    public ArrayList<Song> getDownloadedSongs() {
        return downloadedSongs;
    }

    public ArrayList<Pair<Integer,Song>> songsByPopularity(){
        ArrayList<Pair<Integer,Song>> songPairs = new ArrayList<>();
        for (Song s : uniqueDownloads()){
            songPairs.add(new Pair(s.getDownloads(),s));
        }
        songPairs.sort(Comparator.comparing(p -> -p.getKey()));
        return songPairs;
    }

    public Song fetchSong(String title, String ownerName){
        for (Song s : userWithName(ownerName).getSongList()){
            if (s.getTitle().equals(title)){
                return s;
            }
        }
        return null;
    }
}

