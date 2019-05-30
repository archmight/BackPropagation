package com.company.Graphics;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawGraphics extends JFrame {
    public DrawGraphics(ArrayList<Integer> Errors, String functionName){
        super("Graphic");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(510,450);
        setVisible(true);
        panel Panelka = new panel(Errors, functionName);
        add(Panelka);
        Panelka.paint(getGraphics());

    }
}

class panel extends JPanel{

    ArrayList<Integer> Errors;
    String functionName;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.MAGENTA);
        int x = 0;

        g.drawString("250", 2, 250);
        g.drawString("200", 2, 200);
        g.drawString("150", 2, 250);
        g.drawString("100", 2, 300);
        g.drawString("50", 2, 350);
        for (Integer i = 0; i < Errors.size()-1; ++i) {
            g.drawLine(15+i*5, 400 - Errors.get(i), 20+i*5, 400 - Errors.get(i+1));

            g.drawString(( String.valueOf(i%10)),15+5*i,410);
        }
    }



    panel(ArrayList<Integer> Error, String functionName){
        setFunctionName(functionName);
        setErrors(Error);
    }

    public ArrayList<Integer> getErrors() {
        return Errors;
    }
    public void setErrors(ArrayList<Integer> errors) {
        Errors = errors;
    }

    public String getFunctionName() { return functionName; }
    public void setFunctionName(String functionName) { this.functionName = functionName;}
}

