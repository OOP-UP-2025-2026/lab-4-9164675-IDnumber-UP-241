package ua.opnu;

public class GroceryBill {
    private Employee clerk;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
    }

    public void add(Item item) {
    }

    public double getTotal() {
        return 0.0;
    }

    public Employee getClerk() {
        return clerk;
    }
}