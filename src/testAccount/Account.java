package testAccount;

public class Account {
    protected double balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public void withdraw(double amt) throws OverdrafException {
        if (amt > balance) {
            double defict = amt - balance;
            throw new OverdrafException("透支额度超标,透支额度为" + defict, defict);
        }
        balance -= amt;
    }

    public static void main(String[] args) {
        Account account = new Account(2000);
        System.out.println(account.getBalance());
        try {
            account.withdraw(20000);
        } catch (OverdrafException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
