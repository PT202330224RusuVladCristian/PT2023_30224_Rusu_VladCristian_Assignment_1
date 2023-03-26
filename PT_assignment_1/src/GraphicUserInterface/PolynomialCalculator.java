package GraphicUserInterface;

import BussinesLogic.Operations;
import BussinesLogic.Parser;
import Data_Models.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PolynomialCalculator  {
    private JFrame frame;
    private JTextField inputField1, inputField2;
    private JTextArea outputArea;
    private JButton addButton, subtractButton, multiplyButton, divideButton,integralButton,derivateButton;

    public PolynomialCalculator() {

        frame = new JFrame("Polynomial Calculator");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JLabel inputLabel1 = new JLabel("Polynomial 1:");
        inputField1 = new JTextField();
        JLabel inputLabel2 = new JLabel("Polynomial 2:");
        inputField2 = new JTextField();
        inputPanel.add(inputLabel1);
        inputPanel.add(inputField1);
        inputPanel.add(inputLabel2);
        inputPanel.add(inputField2);
        frame.add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel(new GridLayout(3, 2));
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        integralButton = new JButton("Integrate");
        derivateButton=new JButton("Derivate");

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(integralButton);
        buttonPanel.add(derivateButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String polynomial1 = inputField1.getText();
                String polynomial2 = inputField2.getText();
                Parser parser=new Parser();
                Polynomial poly1=new Polynomial();
                Polynomial poly2=new Polynomial();
                Operations op=new Operations();
                poly1=parser.parsing(polynomial1);
                poly2=parser.parsing(polynomial2);
                String result ;
                try {
                    result = "Result of addition operation: " + op.add(poly1,poly2).toString();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                outputArea.setText(result);
            }
        });
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String polynomial1 = inputField1.getText();
                String polynomial2 = inputField2.getText();
                Parser parser=new Parser();
                Polynomial poly1=new Polynomial();
                Polynomial poly2=new Polynomial();
                Operations op=new Operations();
                poly1=parser.parsing(polynomial1);
                poly2=parser.parsing(polynomial2);
                String result ;
                try {
                    result = "Result of subtraction operation: " + op.subtract(poly1,poly2).toString();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                outputArea.setText(result);
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String polynomial1 = inputField1.getText();
                String polynomial2 = inputField2.getText();
                Parser parser=new Parser();
                Polynomial poly1=new Polynomial();
                Polynomial poly2=new Polynomial();
                Operations op=new Operations();
                poly1=parser.parsing(polynomial1);
                poly2=parser.parsing(polynomial2);
                String result ;
                result = "Result of multiply operation: " + op.multiply(poly1,poly2).toString();

                outputArea.setText(result);
            }
        });
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String polynomial1 = inputField1.getText();
                String polynomial2 = inputField2.getText();
                Parser parser=new Parser();
                Polynomial poly1=new Polynomial();
                Polynomial poly2=new Polynomial();
                Operations op=new Operations();
                poly1=parser.parsing(polynomial1);
                poly2=parser.parsing(polynomial2);
                String result ;
                if( poly1.getMapMonomial().keySet().stream().max(Integer::compare).get()> poly2.getMapMonomial().keySet().stream().max(Integer::compare).get()) {
                    try {
                        result = "Result of divide operation: " + op.divide(poly1, poly2).toString();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else
                {
                    try {
                        result = "Result of divide operation: " + op.divide(poly2, poly1).toString();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                outputArea.setText(result);
            }
        });
        derivateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String polynomial1 = inputField1.getText();
                Parser parser=new Parser();
                Polynomial poly1=new Polynomial();
                Operations op=new Operations();
                poly1=parser.parsing(polynomial1);
                String result ;
                result = "Result of derivative operation: " + op.derivative(poly1).toString();

                outputArea.setText(result);
            }
        });
        integralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String polynomial1 = inputField1.getText();
                Parser parser=new Parser();
                Polynomial poly1=new Polynomial();
                Operations op=new Operations();
                poly1=parser.parsing(polynomial1);
                String result ;
                result = "Result of integrate operation: " + op.integral(poly1).toString()+"+C";

                outputArea.setText(result);
            }
        });
        frame.setVisible(true);
    }

    public JTextField getInputField1()
    {
        return inputField1;
    }
    public JTextField getInputField2()
    {
        return inputField2;
    }

}