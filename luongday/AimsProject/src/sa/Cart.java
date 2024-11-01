public class Cart {
    private DigitalVideoDisc[] items = new DigitalVideoDisc[20];
    private int qtyOrdered = 0; 

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < 20) {
            items[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The DVD has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += items[i].getCost();
        }
        return total;
    }
}
