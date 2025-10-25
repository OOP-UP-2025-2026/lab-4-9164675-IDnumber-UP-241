package ua.opnu;

public class MinMaxAccount extends BankingAccount {
    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        int initialBalance = getBalance();
        this.minBalance = initialBalance;
        this.maxBalance = initialBalance;
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        updateMinMaxBalance();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        updateMinMaxBalance();
    }

    private void updateMinMaxBalance() {
        int currentBalance = getBalance();
        if (currentBalance < this.minBalance) {
            this.minBalance = currentBalance;
        }
        if (currentBalance > this.maxBalance) {
            this.maxBalance = currentBalance;
        }
    }

    public int getMin() {
        return this.minBalance;
    }

    public int getMax() {
        return this.maxBalance;
    }
}