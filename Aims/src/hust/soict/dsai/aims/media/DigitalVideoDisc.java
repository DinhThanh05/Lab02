package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {
    private int length;  // Độ dài (phút)
    private String director;  // Đạo diễn

    // Constructor
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    // Getter và Setter
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return super.toString() + ", length=" + length + " minutes, director=" + director;
    }
}
