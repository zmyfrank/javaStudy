package testAccount;

public class OverdrafException extends Exception {
    private double deficit;

    public OverdrafException(String message, double deficit) {
        super(message+deficit);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}
