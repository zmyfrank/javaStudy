package testAccount;

public class CheckingAccount extends Account {
    private double overdraftProtection;

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, double overdraftProtection) {
        super(balance);
        this.overdraftProtection = overdraftProtection;
    }

    public double getOverdraftProtection() {
        return overdraftProtection;
    }

    @Override
    public void withdraw(double amt) throws OverdrafException {
        if (amt > overdraftProtection + balance) {
            throw new OverdrafException("超过了限额", amt - (overdraftProtection + balance));
        } else if (amt < balance) {
            balance -= amt;
        } else if (amt > balance && amt < balance + overdraftProtection) {
            balance = 0;
            overdraftProtection -= (amt - balance);
        }
    }

    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(2000,200);
        System.out.println("可用额度为"+checkingAccount.getOverdraftProtection());
        try {
            checkingAccount.withdraw(20000);
        } catch (OverdrafException e) {
            e.printStackTrace();
        }

    }
}
