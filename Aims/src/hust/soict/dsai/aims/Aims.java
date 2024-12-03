package hust.soict.dsai.aims;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Scanner scanner = new Scanner(System.in);

    // Hàm hiển thị menu chính
    public static void showMenu() {
        System.out.println("Mục tiêu:");
        System.out.println("--------------------------------");
        System.out.println("1. Xem cửa hàng");
        System.out.println("2. Cập nhật cửa hàng");
        System.out.println("3. Xem giỏ hàng hiện tại");
        System.out.println("0. Thoát");
        System.out.println("--------------------------------");
        System.out.print("Vui lòng chọn một số: 0-1-2-3: ");
    }

    // Hàm hiển thị menu cửa hàng
    public static void storeMenu() {
        System.out.println("Tùy chọn:");
        System.out.println("--------------------------------");
        System.out.println("1. Xem chi tiết của phương tiện");
        System.out.println("2. Thêm phương tiện vào giỏ hàng");
        System.out.println("3. Phát phương tiện");
        System.out.println("4. Xem giỏ hàng hiện tại");
        System.out.println("0. Quay lại");
        System.out.println("--------------------------------");
        System.out.print("Vui lòng chọn một số: 0-1-2-3-4: ");
    }

    // Hàm hiển thị menu chi tiết phương tiện
    public static void mediaDetailsMenu() {
        System.out.println("Tùy chọn:");
        System.out.println("--------------------------------");
        System.out.println("1. Thêm vào giỏ hàng");
        System.out.println("2. Chơi");
        System.out.println("0. Trở lại");
        System.out.println("--------------------------------");
        System.out.print("Vui lòng chọn một số: 0-1-2: ");
    }

    // Hàm hiển thị menu giỏ hàng
    public static void cartMenu() {
        System.out.println("Tùy chọn:");
        System.out.println("--------------------------------");
        System.out.println("1. Lọc phương tiện trong giỏ hàng");
        System.out.println("2. Sắp xếp phương tiện trong giỏ hàng");
        System.out.println("3. Xóa phương tiện khỏi giỏ hàng");
        System.out.println("4. Phát phương tiện");
        System.out.println("5. Đặt hàng");
        System.out.println("0. Quay lại");
        System.out.println("--------------------------------");
        System.out.print("Vui lòng chọn một số: 0-1-2-3-4-5: ");
    }

    // Hàm xử lý menu chính
    public static void main(String[] args) {
        Store store = new Store();  // Cửa hàng
        Cart cart = new Cart();  // Giỏ hàng

        // Tạo một số phương tiện mẫu
        Book book1 = new Book(1, "Harry Potter", "Fantasy", 10.5f);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(2, "Avengers", "Action", 20.0f, 120, "Joss Whedon");
        CompactDisc cd1 = new CompactDisc(3, "Top Hits", "Music", 15.0f, "Various Artists");

        // Thêm phương tiện vào cửa hàng
        store.addMedia(book1);
        store.addMedia(dvd1);
        store.addMedia(cd1);

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Xem cửa hàng
                    storeMenu();
                    int storeChoice = scanner.nextInt();
                    switch (storeChoice) {
                        case 1:
                            // Xem chi tiết phương tiện
                            System.out.print("Nhập tiêu đề phương tiện: ");
                            scanner.nextLine();  // Đọc dòng mới
                            String title = scanner.nextLine();
                            Media media = store.searchByTitle(title);
                            if (media != null) {
                                System.out.println(media);
                                mediaDetailsMenu();
                                int mediaChoice = scanner.nextInt();
                                switch (mediaChoice) {
                                    case 1:
                                        // Thêm vào giỏ hàng
                                        cart.addMedia(media);
                                        System.out.println("Đã thêm vào giỏ hàng.");
                                        break;
                                    case 2:
                                        // Phát phương tiện
                                        if (media instanceof Playable) {
                                            ((Playable) media).play();
                                        } else {
                                            System.out.println("Phương tiện này không thể phát.");
                                        }
                                        break;
                                    case 0:
                                        // Trở lại
                                        break;
                                }
                            } else {
                                System.out.println("Không tìm thấy phương tiện có tiêu đề: " + title);
                            }
                            break;
                        case 2:
                            // Thêm phương tiện vào giỏ hàng
                            System.out.print("Nhập tiêu đề phương tiện để thêm vào giỏ hàng: ");
                            scanner.nextLine();  // Đọc dòng mới
                            String titleToAdd = scanner.nextLine();
                            Media mediaToAdd = store.searchByTitle(titleToAdd);
                            if (mediaToAdd != null) {
                                cart.addMedia(mediaToAdd);
                                System.out.println("Đã thêm vào giỏ hàng.");
                            } else {
                                System.out.println("Không tìm thấy phương tiện.");
                            }
                            break;
                        case 3:
                            // Phát phương tiện
                            System.out.print("Nhập tiêu đề phương tiện để phát: ");
                            scanner.nextLine();  // Đọc dòng mới
                            String titleToPlay = scanner.nextLine();
                            Media mediaToPlay = store.searchByTitle(titleToPlay);
                            if (mediaToPlay != null && mediaToPlay instanceof Playable) {
                                ((Playable) mediaToPlay).play();
                            } else {
                                System.out.println("Không thể phát phương tiện này.");
                            }
                            break;
                        case 4:
                            // Xem giỏ hàng hiện tại
                            cart.displayCart();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                            break;
                    }
                    break;
                case 2:
                    // Cập nhật cửa hàng
                    System.out.println("1. Thêm phương tiện vào cửa hàng");
                    System.out.println("2. Xóa phương tiện khỏi cửa hàng");
                    int updateChoice = scanner.nextInt();
                    switch (updateChoice) {
                        case 1:
                            // Thêm phương tiện vào cửa hàng
                            System.out.print("Nhập tiêu đề phương tiện: ");
                            scanner.nextLine();  // Đọc dòng mới
                            String titleToAddStore = scanner.nextLine();
                            System.out.print("Nhập thể loại: ");
                            String category = scanner.nextLine();
                            System.out.print("Nhập giá: ");
                            float cost = scanner.nextFloat();
                            store.addMedia(new Book(0, titleToAddStore, category, cost));
                            System.out.println("Đã thêm phương tiện vào cửa hàng.");
                            break;
                        case 2:
                            // Xóa phương tiện khỏi cửa hàng
                            System.out.print("Nhập tiêu đề phương tiện cần xóa: ");
                            scanner.nextLine();  // Đọc dòng mới
                            String titleToRemove = scanner.nextLine();
                            Media mediaToRemove = store.searchByTitle(titleToRemove);
                            if (mediaToRemove != null) {
                                store.removeMedia(mediaToRemove);
                                System.out.println("Đã xóa phương tiện khỏi cửa hàng.");
                            } else {
                                System.out.println("Không tìm thấy phương tiện.");
                            }
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                            break;
                    }
                    break;
                case 3:
                    // Xem giỏ hàng hiện tại
                    cartMenu();
                    int cartChoice = scanner.nextInt();
                    switch (cartChoice) {
                        case 1:
                            // Lọc phương tiện trong giỏ hàng
                            System.out.println("Lọc theo ID hoặc tiêu đề? (1: ID, 2: Tiêu đề): ");
                            int filterChoice = scanner.nextInt();
                            if (filterChoice == 1) {
                                System.out.print("Nhập ID: ");
                                int id = scanner.nextInt();
                                cart.searchById(id);
                            } else {
                                System.out.print("Nhập tiêu đề: ");
                                scanner.nextLine();  // Đọc dòng mới
                                String searchTitle = scanner.nextLine();
                                cart.searchByTitle(searchTitle);
                            }
                            break;
                        case 2:
                            // Sắp xếp phương tiện trong giỏ hàng
                            System.out.println("Sắp xếp theo tiêu đề hay chi phí? (1: Tiêu đề, 2: Chi phí): ");
                            int sortChoice = scanner.nextInt();
                            if (sortChoice == 1) {
                                cart.sortByTitle();
                            } else {
                                cart.sortByCost();
                            }
                            break;
                        case 3:
                            // Xóa phương tiện khỏi giỏ hàng
                            System.out.print("Nhập tiêu đề phương tiện cần xóa: ");
                            scanner.nextLine();  // Đọc dòng mới
                            String titleToRemoveCart = scanner.nextLine();
                            Media mediaToRemoveCart = cart.searchByTitle(titleToRemoveCart);
                            if (mediaToRemoveCart != null) {
                                cart.removeMedia(mediaToRemoveCart);
                            }
                            break;
                        case 4:
                            // Phát phương tiện
                            cart.playMedia();
                            break;
                        case 5:
                            // Đặt hàng
                            cart.placeOrder();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);
    }
}
