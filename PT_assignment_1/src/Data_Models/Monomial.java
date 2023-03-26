package Data_Models;

public class Monomial {
    private Double coefficient;
    private int degree;

    public Monomial(Double coefficient,int degree)
    {
        this.coefficient=coefficient;
        this.degree=degree;
    }
    Double getCoefficient()
    {
        return this.coefficient;
    }
    int getDegree()
    {
        return this.degree;
    }
    void setCoefficient(Double coefficient)
    {
        this.coefficient=coefficient;
    }
    void setDegree(int degree)
    {
        this.degree=degree;
    }



}
