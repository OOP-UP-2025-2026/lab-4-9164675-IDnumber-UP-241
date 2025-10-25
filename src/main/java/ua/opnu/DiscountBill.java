package ua.opnu;

public class DiscountBill extends GroceryBill {
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;
    private double fullPriceTotal;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
        this.fullPriceTotal = 0.0;
    }

    @Override
    public void add(Item item) {
        super.add(item);

        this.fullPriceTotal += item.getPrice();

        if (this.regularCustomer) {
            double itemDiscount = item.getDiscount();

            if (itemDiscount > 0.0) {
                this.discountCount++;
                this.discountAmount += itemDiscount;
            }
        }
    }

    @Override
    public double getTotal() {
        double rawTotal;
        if (this.regularCustomer) {
            rawTotal = this.fullPriceTotal - this.discountAmount;
        } else {
            rawTotal = this.fullPriceTotal;
        }

        // Округлення до двох знаків після коми для грошових сум (10^2)
        double scale = 100.0;
        return Math.round(rawTotal * scale) / scale;
    }

    public int getDiscountCount() {
        return this.regularCustomer ? this.discountCount : 0;
    }

    public double getDiscountAmount() {
        return this.regularCustomer ? this.discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!this.regularCustomer || this.fullPriceTotal == 0.0) {
            return 0.0;
        }

        double priceWithDiscount = getTotal();

        double rawResult = 100.0 - (priceWithDiscount * 100.0) / this.fullPriceTotal;

        double scale = 10_000_000_000_000.0;

        return Math.round(rawResult * scale) / scale;
    }
}