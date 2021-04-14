package edu.byuh.cis.cs490r.starter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;



public class Vis extends JPanel {


    public ArrayList<Integer> gilmo;
    private ArrayList<ArrayList> result;
    private boolean start;
    private final int h;
    private final int w;
    int count;


    public Vis() {
        super();
        gilmo = new ArrayList<>();
        result = new ArrayList<>();
        start =false;
        h= getHeight();
        w = getWidth();
        count=0;

    }

    public boolean setStart(ArrayList<Integer> arr){
        gilmo =arr;
        System.out.println(gilmo);
        return start=true;
    }



    @Override
    public void paintComponent(Graphics g1) {
//        System.out.println(count);
//        count++;

        Graphics2D g = (Graphics2D)g1;

        //draw blank background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        //render visualization
        g.setColor(Color.BLACK);
        //draw y axis
        int index_count= 5;
        final int h= getHeight();
        int w =getWidth();

        g.drawLine(w/17,(h/12),w/17,h-(h/12));

        //draw x axis & graph
        g.drawLine(w/17,h-(h/12),w,h-(h/12));

        //bubble(gilmo);


        if (gilmo.size()!=0){
            int howManyBars = gilmo.size();
            int x_count =0;
            int x, y=10;
            int xSpacing = getWidth() / (howManyBars+1);
            x = xSpacing;

            for (var v : gilmo) {
                g.setColor(Color.BLACK);
                g.drawString(v.toString(), (w / howManyBars) * x_count + (w / 14), h - (h / 18));
                double barHeight = (int)v *h/120;
                //barHeight = barHeight * 0.84;
                g.setColor(Color.BLUE);
                g.fillRect((w / howManyBars) * x_count + (w / 17), h - (int) barHeight - (h / 12), w / 2 / howManyBars, (int) barHeight);
                x += xSpacing;
                x_count++;
                //System.out.println("chart is drawn");
            }
            }
//        for(var x: result){
//            System.out.println("result array: "+x);
//        }
//        System.out.println("gilmo:"+gilmo);
        }

}
