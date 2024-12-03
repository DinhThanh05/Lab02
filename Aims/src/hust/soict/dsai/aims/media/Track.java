package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter và Setter
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // Triển khai phương thức play() từ Playable
    @Override
    public void play() {
        System.out.println("Playing track: " + title + ", Length: " + length + " seconds");
    }

    @Override
    public String toString() {
        return "Track [title=" + title + ", length=" + length + " seconds]";
    }
}
