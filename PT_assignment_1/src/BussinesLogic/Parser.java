package BussinesLogic;

import Data_Models.Monomial;
import Data_Models.Polynomial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Parser(){}
    public Polynomial parsing(String exp)
    {
        exp=exp.trim();
        Polynomial parseRes=new Polynomial();
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(exp);
        int i=0;
        while (matcher.find()) {
            i++;
            String group = matcher.group(1);
            String[] monomials = group.split("(?=[+-])");
            for (String monomial : monomials) {
                monomial = monomial.trim();
                Double coef = 0.0;
                int degree = 0;
                if (monomial.contains("X^")) {
                    String[] parts = monomial.split("X\\^");
                    if(parts[0].equals("+") || parts[0].equals(""))
                        coef=1.0;
                    else
                        if(parts[0].equals("-"))
                            coef=-1.0;
                        else
                            coef=Double.parseDouble(parts[0]);

                    degree = Integer.parseInt(parts[1]);
                    parseRes.addMonomial(new Monomial(coef,degree));
                }
            }
        }
        return parseRes;
    }
}
