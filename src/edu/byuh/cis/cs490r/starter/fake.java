//package edu.byuh.cis.cs490r.starter;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//import javax.swing.*;
//import java.awt.Component;
//
//
//public class Vis extends JPanel {
//
//    private String textToDisplay;
//    private LinkedHashMap<String, Double> data;
//    private LinkedHashMap<String, Double> relativeData;
//    public ArrayList<Integer> gilmo;
//    private ArrayList<ArrayList> result;
//    private boolean start;
//    ActionListener sorting;
//    private final int h;
//    private final int w;
//    int count;
//    private boolean firstrun;
//
//
//    public Vis() {
//        super();
//        textToDisplay = "";
//        relativeData = new LinkedHashMap<>();
//        //gilmo = new ArrayList<>(Arrays.asList(53, 58, 34, 98, 72, 85, 35, 78, 18,81));
//        gilmo = new ArrayList<>();
//        result = new ArrayList<>();
//        start =false;
//        h= getHeight();
//        w = getWidth();
//        firstrun =true;
//        count=0;
//
//
//    }
//
//    public boolean setStart(ArrayList<Integer> arr){
//        gilmo =arr;
//        System.out.println(gilmo);
//        return start=true;
//    }
//
//    public void bubble(ArrayList<Integer> array){
//        int comparisons = 0;
//        int exchanges = 0;
//        for (int i = 0; i<=array.size()-2; i++) {
//            for (int j = array.size()-1; j >= i+1; j--) {
//                int a = array.get(j);
//                int b = array.get(j-1);
////swap
//                if (a < b) {
//                    exchanges++;
//                    Collections.swap(array, j - 1, j);
//                    ArrayList<Integer> sortingResults = new ArrayList<>();
//                    for (var v: array){
//                        sortingResults.add(v);
//                    }
//                    result.add(sortingResults);
////                    System.out.print("GIlmo in Bubble: ");
////                    for (var v: array){
////                        System.out.print(v+", ");
////                        }
////				    System.out.println(" ");
////                    try {
////                        Thread.sleep(2000);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////
//                }
//
//                comparisons++;
//            }
//        }
//        System.out.println("Done sorting");
//        System.out.println("First resout: "+result.size());
//
//    }
//
//
//    @Override
//    public void paintComponent(Graphics g1) {
//        System.out.println("repaint: "+count);
//        count++;
//
//        Graphics2D g = (Graphics2D)g1;
//
//        //draw blank background
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, getWidth(), getHeight());
//
//        //render visualization
//        g.setColor(Color.BLACK);
//        g.drawString(textToDisplay, 10, 20);
//
//        //draw y axis
//        int index_count= 5;
//        final int h= getHeight();
//        int w =getWidth();
//
//        g.drawLine(w/17,(h/12),w/17,h-(h/12));
//
//        //draw x axis & graph
//        g.drawLine(w/17,h-(h/12),w,h-(h/12));
//
//        //bubble(gilmo);
//        for(var b: result){
//            System.out.println("result array: "+b);
//        }
//
//
//        if(result.size()>0){
//            int howManyBars = gilmo.size();
//            System.out.println("gilmo size"+ gilmo.size());
//            int x_count =0;
//            int x, y=10;
//            int xSpacing = getWidth() / (howManyBars+1);
//            x = xSpacing;
//
//            for (var index: result){
//                for (var values: index){
//                    System.out.println("&&&&&&&&&&");
//                    g.drawString(values.toString(), (w / howManyBars) * x_count + (w / 14), h - (h / 18));
//                    double barHeight = (int)values *h/120;
//                    //barHeight = barHeight * 0.84;
//                    g.setColor(Color.BLACK);
//                    g.fillRect((w / howManyBars) * x_count + (w / 17), h - (int) barHeight - (h / 12), w / 2 / howManyBars, (int) barHeight);
//                    x += xSpacing;
//                    x_count++;
//                    //System.out.println("chart is drawn");
//                }
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//
//
//            System.out.println("gilmo:"+gilmo);
//        }
//    }
//
//}
