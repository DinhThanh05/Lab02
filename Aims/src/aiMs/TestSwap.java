package aiMs;

public class TestSwap {
    // Phương thức hoán đổi hai đối tượng
    public static void swap(DigitalVideoDisc[] dvds) {
        if (dvds == null || dvds.length < 2) {
            System.out.println("Invalid input. Array must have at least two elements.");
            return;
        }
        DigitalVideoDisc temp = dvds[0]; 
        dvds[0] = dvds[1];              
        dvds[1] = temp;                  
    }

    public static void main(String[] args) {
        // Tạo hai đối tượng DigitalVideoDisc
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc("Faker", "Science Fiction", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Gumayusi", "Crime", "Francis Ford Coppola", 175, 14.99f);
       

        // Hiển thị thông tin trước khi hoán đổi
        System.out.println("Before swap:");
        System.out.println("DVD1 Title: " + dvd1.getTitle());
        System.out.println("DVD2 Title: " + dvd2.getTitle());

        // Hoán đổi đối tượng bằng cách truyền mảng
        DigitalVideoDisc[] dvds = {dvd1, dvd2};
        swap(dvds);

        // Hiển thị thông tin sau khi hoán đổi
        System.out.println("After swap:");
        System.out.println("DVD1 Title: " + dvds[0].getTitle());
        System.out.println("DVD2 Title: " + dvds[1].getTitle());
    }
}
