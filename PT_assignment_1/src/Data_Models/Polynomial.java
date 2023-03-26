package Data_Models;

import java.io.*;
import java.util.*;

public class Polynomial implements Serializable {

    private Map<Integer,Double> mapMonomial;
    public Polynomial()
    {
        mapMonomial=new HashMap<Integer,Double>();
    }
    public void addMonomial(Monomial x)
    {
        this.mapMonomial.put(x.getDegree(),x.getCoefficient());
    }
    public Map<Integer,Double> getMapMonomial()
    {
        return  this.mapMonomial;
    }

    public Polynomial deepCopy() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (Polynomial) ois.readObject();
    }


    public String toString()
    {
        String out="";
        int primTermen=0;
        if(this.mapMonomial.isEmpty())
            out="0";
        else {
            for (int i=this.mapMonomial.keySet().size()-1;i>=0;i--) {
                Integer degree=(Integer) this.mapMonomial.keySet().toArray()[i];
                Double coef = this.mapMonomial.get(degree);
                String term = "";
                if (coef < 0.0) {
                    term += "-";
                    coef = -coef;
                } else if (primTermen == 1)
                    term += "+";
                primTermen = 1;
                if (coef >0.0 && coef!=1.0)
                    term += coef + "X" + "^" + degree;
                else
                    term += "X" + "^" + degree;

                out +=term;
            }
        }
        return out;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Polynomial)) {
            return false;
        }

        Polynomial other = (Polynomial) obj;

        return Objects.equals(this.mapMonomial, other.mapMonomial);
    }
}
