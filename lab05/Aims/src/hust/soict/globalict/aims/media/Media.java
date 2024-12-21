package hust.soict.globalict.aims.media;

public class Media {
    private String title;
    private String category;
    private double cost;

    // Constructor
    public Media(String title, String category, double cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getCost() {
        return cost;
    }

    // Xác định khả năng phát (mặc định là false, lớp con có thể override)
    public boolean isPlayable() {
        return false;
    }

    // Ghi đè phương thức equals để so sánh theo tiêu đề
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return title.equalsIgnoreCase(media.title);
    }

    @Override
    public int hashCode() {
        return title.toLowerCase().hashCode();
    }
}
