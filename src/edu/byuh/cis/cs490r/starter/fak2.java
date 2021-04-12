//package edu.byuh.cis.cs490r.starter;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.*;
//import javax.swing.Timer;
//import javax.swing.JFrame;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import java.awt.Component;
//
//public class Main extends JFrame {
//
//    private Vis mainPanel;
//    private ArrayList<Integer> gim;
//    Timer time;
//    ActionListener sorting;
//
//    public Main() {
//
//        JMenuBar mb = setupMenu();
//        setJMenuBar(mb);
//
//        mainPanel = new Vis();
//        setContentPane(mainPanel);
//
//        setSize(800,600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setTitle("Put the title of your program here");
//        setVisible(true);
//        gim = new ArrayList<>(Arrays.asList(53, 58, 34, 98, 72, 85, 35, 78, 18,81));
//    }
//    public void bubble(){
////                int comparisons = 0;
////                int exchanges = 0;
////                for (int i = 0; i<=mainPanel.gilmo.size()-2; i++) {
////                    for (int j = mainPanel.gilmo.size()-1; j >= i+1; j--) {
////                        int a = mainPanel.gilmo.get(j);
////                        int b = mainPanel.gilmo.get(j-1);
////                        if (a < b) {
////                            exchanges++;
////                            Collections.swap(mainPanel.gilmo, j - 1, j);
////                            time.start();
////                            repaint();
////                            System.out.print("GIlmo in Bubble: ");
////                            for (var v: mainPanel.gilmo){
////                                System.out.print(v+", ");
////                            }
////                            System.out.println(" ");
////                            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
////                            time.stop();
//////                            try {
//////                                Thread.sleep(500);
//////                            } catch (InterruptedException e) {
//////                                e.printStackTrace();
//////                            }
////
////                        }
////                        comparisons++;
////                    }
////                }
//
//    }
//
//    private JMenuBar setupMenu() {
//        //instantiate menubar, menus, and menu options
//        //JMenu subMenu = new JMenu("Submenu");
//        JMenuBar menuBar = new JMenuBar();
//        JMenu fileMenu = new JMenu("File");
//        JMenu sortingMenu = new JMenu("Sorting");
//        JMenuItem item0 = new JMenuItem("bar chart");
//        JMenuItem item1 = new JMenuItem("Bubble");
//        JMenuItem item2 = new JMenuItem("NOting");
//
////        item1.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                System.out.println("Just clicked menu item 1");
////                int gilmo = runSimpleCountQuery("SELECT COUNT(*) FROM MyTable");
////                System.out.println("I found " + gilmo + " rows in the table.");
////                mainPanel.setText("I found " + gilmo + " rows in the table.");
////            }
////        });
//        item0.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                mainPanel.setBarChart();
//
//            }
//        });
//        item1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainPanel.setStart(gim);
//                mainPanel.bubble(gim);
//                repaint();
////                //bubble();
////                //mainPanel.bubble(gilmo);
////                sorting = new ActionListener() {
////                    @Override
////                    public void actionPerformed(ActionEvent e) {
////                        //System.out.println("maingilm"+mainPanel.gilmo);
////                        bubble();
////                        repaint();
////                    }
////                };
////                time = new Timer(1000, sorting);
////                time.start();
//
//            }
//        });
//        item2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainPanel.setStart(gim);
//                repaint();
//            }
//        });
//
//
//        //now hook them all together
//        //subMenu.add(item2);
//        //fileMenu.add(subMenu);
//        menuBar.add(fileMenu);
//        menuBar.add(sortingMenu);
//        fileMenu.add(item0);
//        sortingMenu.add(item1);
//        sortingMenu.add(item2);
//
//
//        return menuBar;
//    }
//
//
//    public static void main(String[] args) {
//
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new Main();
//            }
//        });
//    }
//}