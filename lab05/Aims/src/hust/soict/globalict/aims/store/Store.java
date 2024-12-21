package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> itemsInStore;

    // Constructor
    public Store() {
        itemsInStore = new ArrayList<>();
    }

    // Thêm sản phẩm vào cửa hàng
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added: " + media.getTitle());
        } else {
            System.out.println(media.getTitle() + " is already in the store.");
        }
    }

    // Xóa sản phẩm khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println(media.getTitle() + " is not in the store.");
        }
    }

    // Lấy danh sách sản phẩm trong cửa hàng
    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
}
