package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
    private ArrayList<Media> itemsOrdered; // Danh sách các phương tiện trong giỏ hàng

    public Cart() {
        this.itemsOrdered = new ArrayList<>();
    }

    // Thêm phương tiện vào giỏ hàng
    public void addMedia(Media media) {
        itemsOrdered.add(media);
    }

    // Tìm kiếm phương tiện trong giỏ hàng theo ID
    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Tìm thấy phương tiện: " + media);
                return media;  // Trả về phương tiện có ID trùng
            }
        }
        System.out.println("Không tìm thấy phương tiện với ID: " + id);
        return null;  // Không tìm thấy phương tiện có ID đó
    }

    // Tìm kiếm phương tiện trong giỏ hàng theo tiêu đề
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Tìm thấy phương tiện: " + media);
                return media;
            }
        }
        System.out.println("Không tìm thấy phương tiện với tiêu đề: " + title);
        return null;
    }

    // Sắp xếp phương tiện theo tiêu đề
    public void sortByTitle() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            @Override
            public int compare(Media m1, Media m2) {
                return m1.getTitle().compareToIgnoreCase(m2.getTitle());
            }
        });
        System.out.println("Đã sắp xếp giỏ hàng theo tiêu đề.");
    }

    // Sắp xếp phương tiện theo chi phí
    public void sortByCost() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            @Override
            public int compare(Media m1, Media m2) {
                return Float.compare(m1.getCost(), m2.getCost());
            }
        });
        System.out.println("Đã sắp xếp giỏ hàng theo chi phí.");
    }

    // Phát phương tiện (nếu phương tiện đó có thể phát được)
    public void playMedia() {
        System.out.print("Nhập tiêu đề phương tiện cần phát: ");
        // Lấy tiêu đề từ người dùng (giả sử đã có cách lấy đầu vào)
        // Scanner scanner = new Scanner(System.in);
        // String titleToPlay = scanner.nextLine();
        // Giả sử tiêu đề là "Avengers"
        String titleToPlay = "Avengers"; // Giả sử

        Media mediaToPlay = searchByTitle(titleToPlay);
        if (mediaToPlay != null && mediaToPlay instanceof Playable) {
            ((Playable) mediaToPlay).play();  // Phát phương tiện nếu là đối tượng Playable
        } else {
            System.out.println("Phương tiện này không thể phát.");
        }
    }

    // Hiển thị tất cả các phương tiện trong giỏ hàng
    public void displayCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Giỏ hàng của bạn hiện tại trống.");
        } else {
            System.out.println("Phương tiện trong giỏ hàng:");
            for (Media media : itemsOrdered) {
                System.out.println(media.toString());
            }
        }
    }

    // Đặt hàng và làm trống giỏ hàng
    public void placeOrder() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Giỏ hàng của bạn trống. Không thể đặt hàng.");
        } else {
            System.out.println("Đặt hàng thành công. Tổng chi phí: " + totalCost());
            itemsOrdered.clear();  // Làm trống giỏ hàng sau khi đặt hàng
        }
    }

    // Tính tổng chi phí của giỏ hàng
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Xóa phương tiện khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xóa phương tiện khỏi giỏ hàng: " + media.getTitle());
        } else {
            System.out.println("Không tìm thấy phương tiện trong giỏ hàng: " + media.getTitle());
        }
    }
}
