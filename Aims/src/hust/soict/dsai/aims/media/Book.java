package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors; // Danh sách tác giả

    // Constructor
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.authors = new ArrayList<>();
    }

    // Thêm tác giả
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    // In thông tin
    @Override
    public String toString() {
        return super.toString() + ", authors=" + authors;
    }
}
