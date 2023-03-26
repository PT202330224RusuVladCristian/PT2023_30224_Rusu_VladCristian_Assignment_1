package BussinesLogic;

import Data_Models.Monomial;
import Data_Models.Pair;
import Data_Models.Polynomial;

import java.io.IOException;
import java.util.Objects;

public class Operations {
    public Operations()
    {

    }

    public Polynomial add(Polynomial x,Polynomial y) throws IOException, ClassNotFoundException {
        Polynomial res=new Polynomial();
        res=x.deepCopy();
        for(Integer degree:y.getMapMonomial().keySet())
        {
            int ok=0;
            for(Integer degree2:res.getMapMonomial().keySet())
            {
                if(degree.equals(degree2)) {
                    ok=1;
                    res.getMapMonomial().put(degree, y.getMapMonomial().get(degree) + res.getMapMonomial().get(degree));
                }
            }
            if(ok==0)
             res.addMonomial(new Monomial(y.getMapMonomial().get(degree),degree));
            res.getMapMonomial().values().remove(0.0);
        }

        return res;
    }
    public Polynomial subtract(Polynomial x,Polynomial y) throws IOException, ClassNotFoundException {
        Polynomial res2=new Polynomial();
        res2=x.deepCopy();
        for(Integer degree:y.getMapMonomial().keySet())
        {
            int ok=0;
            for(Integer degree2:res2.getMapMonomial().keySet())
            {
                if(degree.equals(degree2)) {
                    ok=1;
                    res2.getMapMonomial().put(degree2, res2.getMapMonomial().get(degree) - y.getMapMonomial().get(degree));
                }
            }
            if(ok==0)
                res2.addMonomial(new Monomial(-y.getMapMonomial().get(degree),degree));
            res2.getMapMonomial().values().remove(0.0);
        }

        return res2;
    }

    public Polynomial multiply(Polynomial x,Polynomial y)
    {
        Polynomial res=new Polynomial();
        for(Integer degree:x.getMapMonomial().keySet()) {
            for (Integer degree2 : y.getMapMonomial().keySet()) {
                Integer auxDegree = degree + degree2;
                Double auxCoefficient = x.getMapMonomial().get(degree) * y.getMapMonomial().get(degree2);
                if (res.getMapMonomial().containsKey(auxDegree))
                    auxCoefficient += res.getMapMonomial().get(auxDegree);
                res.addMonomial(new Monomial(auxCoefficient,auxDegree));
            }
            res.getMapMonomial().values().remove(0.0);
        }

        return res;
    }
    public Pair divide(Polynomial x, Polynomial y) throws IOException, ClassNotFoundException {
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial();



        if (y.getMapMonomial().isEmpty()) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }

        while (!x.getMapMonomial().isEmpty() && x.getMapMonomial().keySet().stream().max(Integer::compare).get() >= y.getMapMonomial().keySet().stream().max(Integer::compare).get()) {
            int maxDegreeX = x.getMapMonomial().keySet().stream().max(Integer::compare).get();
            int maxDegreeY = y.getMapMonomial().keySet().stream().max(Integer::compare).get();
            double coef = x.getMapMonomial().get(maxDegreeX) / y.getMapMonomial().get(maxDegreeY);
            Monomial monomial = new Monomial(coef, maxDegreeX - maxDegreeY);
            Polynomial tempPoly = new Polynomial();
            tempPoly.addMonomial(monomial);
            quotient = add(quotient, tempPoly);
            x = subtract(x, multiply(y, tempPoly));
        }
        remainder = x;

        return new Pair(quotient, remainder);
    }
    public Polynomial derivative(Polynomial x)
    {
        Polynomial res=new Polynomial();
        for(Integer degree:x.getMapMonomial().keySet())
        {
            if(degree!=0)
            {
                res.addMonomial(new Monomial(x.getMapMonomial().get(degree)*degree,degree-1 ));
            }
        }
        return res;
    }
    public Polynomial integral(Polynomial x)
    {
        Polynomial res=new Polynomial();
        for(Integer degree:x.getMapMonomial().keySet())
        {
            Double aux=x.getMapMonomial().get(degree)/(degree+1);
            res.addMonomial(new Monomial(aux,degree+1 ));

        }
        return res;
    }


}
