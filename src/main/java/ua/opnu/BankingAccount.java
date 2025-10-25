package ua.opnu;

public class BankingAccount {
    private int balance;

    public BankingAccount(Startup s) {
        this.balance = s.getInitialBalance();
    }

    public void debit(Debit d) {
        this.balance += d.getAmount();
    }

    public void credit(Credit c) {
        this.balance += c.getAmount();
    }

    public int getBalance() {
        return balance;
    }
}