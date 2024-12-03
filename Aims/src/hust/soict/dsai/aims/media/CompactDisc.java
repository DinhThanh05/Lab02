package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Media implements Playable {
    private String artist;           // Nghệ sĩ
    private ArrayList<Track> tracks; // Danh sách các bài hát

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    // Thêm bài hát
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    // Phát tất cả các bài hát
    @Override
    public void play() {
        System.out.println("Playing Compact Disc: " + getTitle());
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", artist=" + artist + ", tracks=" + tracks;
    }
}
