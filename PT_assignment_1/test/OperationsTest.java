import BussinesLogic.Operations;
import BussinesLogic.Parser;
import Data_Models.Polynomial;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    @Test
    public void addTestT() throws IOException, ClassNotFoundException {
        Parser parser=new Parser();
        Operations op=new Operations();
        Polynomial poly1=new Polynomial();
        Polynomial poly2=new Polynomial();
        Polynomial polyRes=new Polynomial();
        poly1=parser.parsing("X^2+X^3+X^4");
        poly2=parser.parsing("2X^2+3X^3+5X^4");
        polyRes=parser.parsing("3X^2+4X^3+6X^4");
        assertEquals(op.add(poly1,poly2),polyRes);
    }
    @Test
    public void addTestF() throws IOException, ClassNotFoundException {
        Parser parser=new Parser();
        Operations op=new Operations();
        Polynomial poly1=new Polynomial();
        Polynomial poly2=new Polynomial();
        Polynomial polyRes=new Polynomial();
        poly1=parser.parsing("X^2+X^3+X^4");
        poly2=parser.parsing("2X^2+3X^3+5X^4");
        polyRes=parser.parsing("1X^2+4X^3+6X^4");
        assertEquals(op.add(poly1,poly2),polyRes);
    }
    @Test
    public void subtractTestT() throws IOException, ClassNotFoundException {
        Parser parser=new Parser();
        Operations op=new Operations();
        Polynomial poly1=new Polynomial();
        Polynomial poly2=new Polynomial();
        Polynomial polyRes=new Polynomial();
        poly1=parser.parsing("X^2+X^3+X^4");
        poly2=parser.parsing("2X^2+3X^3+5X^4");
        polyRes=parser.parsing("-X^2-2X^3-4X^4");
        assertEquals(op.subtract(poly1,poly2),polyRes);
    }
    @Test
    public void subtractTestF() throws IOException, ClassNotFoundException {
        Parser parser=new Parser();
        Operations op=new Operations();
        Polynomial poly1=new Polynomial();
        Polynomial poly2=new Polynomial();
        Polynomial polyRes=new Polynomial();
        poly1=parser.parsing("X^2+X^3+X^4");
        poly2=parser.parsing("2X^2+3X^3+5X^4");
        polyRes=parser.parsing("3X^2+4X^3+6X^4");
        assertEquals(op.subtract(poly1,poly2),polyRes);
    }
    @Test
    public void multiplyTestT() throws IOException, ClassNotFoundException {
        Parser parser=new Parser();
        Operations op=new Operations();
        Polynomial poly1=new Polynomial();
        Polynomial poly2=new Polynomial();
        Polynomial polyRes=new Polynomial();
        poly1=parser.parsing("3X^2-X^1+X^0");
        poly2=parser.parsing("X^1-2X^0");
        polyRes=parser.parsing("3X^3-7X^2+3X^1-2X^0");
        assertEquals(op.multiply(poly1,poly2),polyRes);
    }
    @Test
    public void multiplyTestF() throws IOException, ClassNotFoundException {
        Parser parser=new Parser();
        Operations op=new Operations();
        Polynomial poly1=new Polynomial();
        Polynomial poly2=new Polynomial();
        Polynomial polyRes=new Polynomial();
        poly1=parser.parsing("3X^2-X^1+X^0");
        poly2=parser.parsing("X^1-2X^0");
        polyRes=parser.parsing("3X^2+4X^3+6X^4");
        assertEquals(op.multiply(poly1,poly2),polyRes);
    }
    @Test
    public void divideTestT() throws IOException, ClassNotFoundException {
        Parser parser=new Parser();
        Operations op=new Operations();
        Polynomial poly1=new Polynomial();
        Polynomial poly2=new Polynomial();
        Polynomial polyRem=new Polynomial();
        Polynomial polyQuo=new Polynomial();
        poly1=parser.parsing("X^3-2 X^2+6X^1-5X^0");
        poly2=parser.parsing("X^2-X^0");
        polyQuo=parser.parsing("X^1-2X^0");
        polyRem= parser.parsing("7X^1-7X^0");
        assertEquals(op.divide(poly1,poly2).getRemainder(),polyRem);
        assertEquals(op.divide(poly1,poly2).getQuotient(),polyQuo);
    }
    @Test
    public void divideTestF() throws IOException, ClassNotFoundException {
        Parser parser=new Parser();
        Operations op=new Operations();
        Polynomial poly1=new Polynomial();
        Polynomial poly2=new Polynomial();
        Polynomial polyRem=new Polynomial();
        Polynomial polyQuo=new Polynomial();
        poly1=parser.parsing("3X^3-2 X^2+6X^1-5X^0");
        poly2=parser.parsing("5X^2-X^0");
        polyQuo=parser.parsing("X^1-2X^0");
        polyRem= parser.parsing("7X^1-7X^0");
        assertEquals(op.divide(poly1,poly2).getRemainder(),polyRem);
        //assertEquals(op.divide(poly1,poly2).getQuotient(),polyQuo);
    }
    @Test
    public void derivateTestT() throws IOException, ClassNotFoundException {
        Parser parser=new Parser();
        Operations op=new Operations();
        Polynomial poly1=new Polynomial();
        Polynomial poly2=new Polynomial();
        Polynomial polyRes=new Polynomial();
        poly1=parser.parsing("X^3-2X^2+6X^1-5X^0");
        polyRes=parser.parsing("3X^2-4X^1+6X^0");
        assertEquals(op.derivative(poly1),polyRes);
    }
    @Test
    public void derivateTestF() throws IOException, ClassNotFoundException {
        Parser parser=new Parser();
        Operations op=new Operations();
        Polynomial poly1=new Polynomial();
        Polynomial polyRes=new Polynomial();
        poly1=parser.parsing("X^3-2X^2+6X^1-5X^0");
        polyRes=parser.parsing("2X^2-4X^1+6X^0");
        assertEquals(op.derivative(poly1),polyRes);
    }
    @Test
    public void integrateTestT() throws IOException, ClassNotFoundException {
        Parser parser=new Parser();
        Operations op=new Operations();
        Polynomial poly1=new Polynomial();
        Polynomial polyRes=new Polynomial();
        poly1=parser.parsing("5X^4+8X^3+9X^2");
        polyRes=parser.parsing("X^5+2X^4+3X^3");
        assertEquals(op.integral(poly1),polyRes);
    }
    @Test
    public void integrateTestF() throws IOException, ClassNotFoundException {
        Parser parser=new Parser();
        Operations op=new Operations();
        Polynomial poly1=new Polynomial();
        Polynomial polyRes=new Polynomial();
        poly1=parser.parsing("5X^4+8X^3+9X^2");
        polyRes=parser.parsing("5X^5+3X^4+3X^3");
        assertEquals(op.integral(poly1),polyRes);
    }
}
