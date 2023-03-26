package Data_Models;

public class Pair {
    private Polynomial quotient;
    private Polynomial remainder;

    public Pair(Polynomial x,Polynomial y)
    {
        this.quotient=x;
        this.remainder=y;
    }

    public Polynomial getQuotient() {
        return this.quotient;
    }

    public Polynomial getRemainder() {
        return this.remainder;
    }

    public String toString()
    {
        return "quotient"+": "+quotient.toString()+" remainder"+": "+remainder.toString();
    }
}
