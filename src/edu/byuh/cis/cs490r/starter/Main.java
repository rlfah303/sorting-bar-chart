package edu.byuh.cis.cs490r.starter;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.filechooser.FileSystemView;
import java.awt.Component;

public class Main extends JFrame {

    private Vis mainPanel;
    private ArrayList<Integer> gim;
    private ArrayList<Integer> dummy;
    File ff;
    final int speed;
    int heapSize;

    public Main() {

        JMenuBar mb = setupMenu();
        setJMenuBar(mb);

        mainPanel = new Vis();
        setContentPane(mainPanel);
        ff =null;
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Put the title of your program here");
        setVisible(true);
        gim = new ArrayList<>();
        dummy = new ArrayList<>();
        speed = 5;
    }


    private JMenuBar setupMenu() {
        //instantiate menubar, menus, and menu options
        //JMenu subMenu = new JMenu("Submenu");
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu sortingMenu = new JMenu("Sorting");
        JMenuItem item0 = new JMenuItem("Choose input file");
        JMenuItem item1 = new JMenuItem("Bubble");
        JMenuItem item2 = new JMenuItem("Insertion");
        JMenuItem item3 = new JMenuItem("Selection");
        JMenuItem item4 = new JMenuItem("Quick");
        JMenuItem item5 = new JMenuItem("Merge");
        JMenuItem item6 = new JMenuItem("Heap");
        JMenuItem item7 = new JMenuItem("Count");
        JMenuItem item8 = new JMenuItem("Shell");
        JMenuItem item9 = new JMenuItem("Stooge");
        JMenuItem item10 = new JMenuItem("Cocktail");
        JMenuItem item11 = new JMenuItem("Comb");
        JMenuItem item12 = new JMenuItem("Gnome");
        JMenuItem item13 = new JMenuItem("Pancake");
        JMenuItem item14 = new JMenuItem("Radix");
        JMenuItem item15 = new JMenuItem("Cycle");


        item0.addActionListener(e -> {
            final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView());
            fc.setDialogTitle("Choose a folder");
            fc.setCurrentDirectory(new File("/Users/gilmogim/desktop/sorting_demo"));
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int fcValue = fc.showOpenDialog(getParent());
            if(fcValue == JFileChooser.APPROVE_OPTION){
                File filechosen = fc.getSelectedFile();
                getInputFile(filechosen);
            }
            repaint();

        });
//        item0.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                mainPanel.setBarChart();
//
//            }
//        });
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                bubble();

            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                insertion();
            }
        });
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                selection();
            }
        });
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                quickSort(0,gim.size()-1);
            }
        });
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                merge_sort(0,gim.size()-1);
            }
        });
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                heapSort();
            }
        });
        item7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                countSort(gim.size());
            }
        });
        item8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                shell();
            }
        });
        item9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                stoogeSort(mainPanel.gilmo, 0, gim.size()-1);
            }
        });
        item10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                cocktailSort();
            }
        });
        item11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                combSort();

            }
        });
        item12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                gnomeSort(mainPanel.gilmo,mainPanel.gilmo.size());

            }
        });
        item13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                pancakeSort(mainPanel.gilmo,mainPanel.gilmo.size());

            }
        });
        item14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                radixsort(mainPanel.gilmo,mainPanel.gilmo.size());

            }
        });
        item15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGim();
                mainPanel.setStart(gim);
                mainPanel.repaint();
                cycleSort(mainPanel.gilmo,mainPanel.gilmo.size());

            }
        });


        menuBar.add(fileMenu);
        menuBar.add(sortingMenu);
        fileMenu.add(item0);
        sortingMenu.add(item1);
        sortingMenu.add(item2);
        sortingMenu.add(item3);
        sortingMenu.add(item4);
        sortingMenu.add(item5);
        sortingMenu.add(item6);
        sortingMenu.add(item7);
        sortingMenu.add(item8);
        sortingMenu.add(item9);
        sortingMenu.add(item10);
        sortingMenu.add(item11);
        sortingMenu.add(item12);
        sortingMenu.add(item13);
        sortingMenu.add(item14);
        sortingMenu.add(item15);


        return menuBar;
    }
    public void getInputFile(File f){
        gim.clear();
        dummy.clear();
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNextInt()) {
                int data = sc.nextInt();
                gim.add(data);
                dummy.add(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("list successfully: "+gim);

    }

    public void resetGim(){
        gim.clear();
        for (var v:dummy){
            gim.add(v);
        }

    }
    public void setTimer(int t){
        try {
            Thread.sleep(t);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Bubble Sort
     */
    public void bubble(){
        int comparisons = 0;
        int exchanges = 0;
        for (int i = 0; i<=mainPanel.gilmo.size()-2; i++) {
            for (int j = mainPanel.gilmo.size()-1; j >= i+1; j--) {
                int a = mainPanel.gilmo.get(j);
                int b = mainPanel.gilmo.get(j-1);
                if (a < b) {
                    exchanges++;
                    Collections.swap(mainPanel.gilmo, j - 1, j);
                    mainPanel.update(mainPanel.getGraphics());
                    setTimer(speed);

                }
                comparisons++;
            }
        }
        System.out.println("exchanges: "+exchanges+"-----"+"comparisons:"+comparisons);

    }

    /**
     * Insertion Sort
     */
    public void insertion() {
        int comparisons = 0;
        int exchanges = 0;
        for (int j = 1; j < mainPanel.gilmo.size(); j++) {
            int key = mainPanel.gilmo.get(j);
            int i = j - 1;
            while (i >= 0 && mainPanel.gilmo.get(i) > key) {
                exchanges++;
                comparisons++;
                mainPanel.gilmo.set(i + 1, mainPanel.gilmo.get(i));
                //mainPanel.gilmo[i + 1] = mainPanel.gilmo[i];
                i--;
                mainPanel.update(mainPanel.getGraphics());
                setTimer(speed);
                //mainPanel.gilmo[i + 1]->id = key;
            }
            mainPanel.gilmo.set(i + 1, key);
            exchanges++;


        }
    }

    /**
     * Selection Sort
     */
    public void selection() {
        int comparisons = 0;
        int exchanges = 0;
        for (int i = 0; i < mainPanel.gilmo.size() - 1; i++) {
            int min = mainPanel.gilmo.get(i);
            int minIndex = i;
            for (int j = i+1; j < mainPanel.gilmo.size(); j++) {
                comparisons++;
                if (mainPanel.gilmo.get(j)<min){
                    min = mainPanel.gilmo.get(j);
                    minIndex = j;
                }
            }
            exchanges++;
            Collections.swap(mainPanel.gilmo, minIndex, i);
            mainPanel.update(mainPanel.getGraphics());
            setTimer(speed);
        }
    }

    /**
     * Quick Sort
     * @param p
     * @param r
     */
    public void quickSort(int p, int r) {
        if (p < r) {
            mainPanel.update(mainPanel.getGraphics());
            setTimer(speed);
            int q = partition(p, r);
            quickSort(p, q - 1);
            quickSort(q + 1, r);
        }
    }
    public int partition(int p, int r) {

        int x = mainPanel.gilmo.get(r);
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (mainPanel.gilmo.get(j)<= x) {
                i++;
                Collections.swap(mainPanel.gilmo, j, i);

            }
        }
        Collections.swap(mainPanel.gilmo, i+1, r);
        return i + 1;
    }

    /**
     * Merge Sort
     * @param p
     * @param q
     * @param r
     */
    public void merge(int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = mainPanel.gilmo.get(p + i);
        }
        for (int j = 0; j < n2; j++) {
            R[j] = mainPanel.gilmo.get(q + j+1);
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                mainPanel.gilmo.set(k,L[i]);
                i++;
            } else {
		        mainPanel.gilmo.set(k,R[j]);
                j++;
            }
        }
    }

    public void merge_sort(int p, int r) {
        if (p < r) {
            mainPanel.update(mainPanel.getGraphics());
            setTimer(speed);
            int q = ((p + r) / 2);
            merge_sort(p, q);
            merge_sort(q + 1, r);
            merge(p, q, r);
        }
    }

    /**
     * Heap Sort
     * @param i
     */
    public void maxHeap(int i) {
        int l = 2*i+1;
        int r = 2 * (i + 1);
        int largest;
        if (l <= heapSize && mainPanel.gilmo.get(l)>mainPanel.gilmo.get(i)) {
            largest = l;
        }else {
            largest = i;
        }
        if (r<= heapSize && mainPanel.gilmo.get(r) > mainPanel.gilmo.get(largest)){
            largest = r;
        }
        if (largest!=i) {
            mainPanel.update(mainPanel.getGraphics());
            setTimer(speed);
            Collections.swap(mainPanel.gilmo, largest, i);

            maxHeap(largest);
        }
    }
    public void buildMaxHeap() {
        heapSize = mainPanel.gilmo.size()-1;
        for (int i = (mainPanel.gilmo.size()/2); i >= 0; i--) {
            maxHeap(i);

        }
    }
    //sorting
    public void heapSort() {
        buildMaxHeap();
        for (int i = mainPanel.gilmo.size()-1; i >= 1; i--) {
            Collections.swap(mainPanel.gilmo, 0, i);
            mainPanel.update(mainPanel.getGraphics());
            setTimer(speed);
            heapSize--;
            maxHeap(0);
        }

    }

    /**
     * Count Sort
     * @param size
     */
    public void countSort(int size) {
        int[] output = new int[size + 1];

        // Find the largest element of the array
        int max = mainPanel.gilmo.get(0);
        for (int i = 1; i < size; i++) {
            if (mainPanel.gilmo.get(i) > max)
                max = mainPanel.gilmo.get(i);
        }
        int[] count = new int[max + 1];

        // Initialize count array with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[mainPanel.gilmo.get(i)]++;
        }

        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {

            output[count[mainPanel.gilmo.get(i)] - 1] = mainPanel.gilmo.get(i);
            count[mainPanel.gilmo.get(i)]--;
            mainPanel.update(mainPanel.getGraphics());
            setTimer(speed);
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            mainPanel.gilmo.set(i, output[i]);
            mainPanel.update(mainPanel.getGraphics());
            setTimer(speed);

        }
    }

    /**
     * Shell Sort
     */
    public void shell()
    {
        int n = mainPanel.gilmo.size();

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = mainPanel.gilmo.get(i);

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && mainPanel.gilmo.get(j-gap)> temp; j -= gap)
                    mainPanel.gilmo.set(j,mainPanel.gilmo.get(j - gap));

                // put temp (the original a[i]) in its correct
                // location
                mainPanel.gilmo.set(j,temp);
                mainPanel.update(mainPanel.getGraphics());
                setTimer(speed);
            }
        }
    }

    /**
     * Stooge Sort
     * @param L
     * @param i
     * @param j
     */
    public void stoogeSort(ArrayList<Integer> L, int i, int j) {
        if (L.get(j) < L.get(i)) {
            Collections.swap(L, i, j);
            mainPanel.update(mainPanel.getGraphics());
            setTimer(speed);
        }
        if (j - i > 1) {
            int t = (j - i + 1) / 3;
            stoogeSort(L, i, j - t);
            stoogeSort(L, i + t, j);
            stoogeSort(L, i, j - t);
        }
    }

    /**
     * Cocktail Sort
     */
    public void cocktailSort() {
        boolean swapped = true;
        int start = 0;
        int end = mainPanel.gilmo.size();

        while (swapped == true) {
            swapped = false;

            for (int i = start; i < end - 1; ++i)
            {
                if (mainPanel.gilmo.get(i) > mainPanel.gilmo.get(i+1)) {
                    Collections.swap(mainPanel.gilmo,i,i+1);
                    swapped = true;
                    mainPanel.update(mainPanel.getGraphics());
                    setTimer(speed);
                }
            }


            if (swapped == false)
                break;
            swapped = false;
            end = end - 1;

            for (int i = end - 1; i >= start; i--) {
                if (mainPanel.gilmo.get(i) > mainPanel.gilmo.get(i+1)) {
                    Collections.swap(mainPanel.gilmo,i,i+1);
                    swapped = true;
                    mainPanel.update(mainPanel.getGraphics());
                    setTimer(speed);
                }
            }

            // increase the starting point, because
            // the last stage would have moved the next
            // smallest number to its rightful spot.
            start = start + 1;
        }
    }

    /**
     * Comb Sort
     */

    // Function to sort arr[] using Comb Sort
    public void combSort()
    {
        int n = mainPanel.gilmo.size();

        // initialize gap
        int gap = n;

        // Initialize swapped as true to make sure that
        // loop runs
        boolean swapped = true;

        // Keep running while gap is more than 1 and last
        // iteration caused a swap
        while (gap != 1 || swapped == true)
        {
            // Find next gap
            gap = getNextGap(gap);

            // Initialize swapped as false so that we can
            // check if swap happened or not
            swapped = false;

            // Compare all elements with current gap
            for (int i=0; i<n-gap; i++) {
                if (mainPanel.gilmo.get(i) > mainPanel.gilmo.get(i+gap)) {
                    // Swap arr[i] and arr[i+gap]
                    Collections.swap(mainPanel.gilmo,i,i+gap);
                    mainPanel.update(mainPanel.getGraphics());
                    setTimer(speed);
                    // Set swapped
                    swapped = true;
                }
            }
        }
    }
    int getNextGap(int gap) {
        // Shrink gap by Shrink factor
        gap = (gap*10)/13;
        if (gap < 1)
            return 1;
        return gap;
    }

    /**
     * Gnome Sort
     * @param arr
     * @param n
     */
    public void gnomeSort(ArrayList<Integer> arr, int n)
    {
        int index = 0;
        while (index < n) {
            if (index == 0)
                index++;
            if (arr.get(index) >= arr.get(index - 1))
                index++;
            else {
                int temp = 0;
                Collections.swap(arr,index,index-1);
                mainPanel.update(mainPanel.getGraphics());
                setTimer(speed);
                index--;
            }
        }
        return;
    }

    /**
     * Pancake Sort
     * @param arr
     * @param n
     * @return
     */
    public int pancakeSort(ArrayList<Integer> arr, int n) {
        for (int curr_size = n; curr_size > 1;
             --curr_size)
        {

            int mi = findMax(arr, curr_size);
            if (mi != curr_size-1)
            {

                flip(arr, mi);
                flip(arr, curr_size-1);
            }
        }
        return 0;
    }
    void flip(ArrayList<Integer> arr, int i)
    {
        int temp, start = 0;
        while (start < i)
        {
            Collections.swap(arr,start,i);
            mainPanel.update(mainPanel.getGraphics());
            setTimer(speed);
            start++;
            i--;
        }
    }

    int findMax(ArrayList<Integer> arr, int n) {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
            if (arr.get(i)> arr.get(mi))
                mi = i;
        return mi;
    }

    /**
     * Radix Sort
     * @param arr
     * @param n
     */
    public void radixsort(ArrayList<Integer> arr, int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            cSort(arr, n, exp);
            mainPanel.update(mainPanel.getGraphics());
            setTimer(speed);
    }

    int getMax(ArrayList<Integer> arr, int n)
    {
        int mx = arr.get(0);
        for (int i = 1; i < n; i++)
            if (arr.get(i) > mx)
                mx = arr.get(i);
        return mx;
    }

    void cSort(ArrayList<Integer> arr, int size, int place) {
        int[] output = new int[size + 1];
        int max = arr.get(0);
        for (int i = 1; i < size; i++) {
            if (arr.get(i) > max)
                max = arr.get(i);
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(arr.get(i)/ place) % 10]++;

        // Calculate cummulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            mainPanel.update(mainPanel.getGraphics());
            setTimer(speed);
            output[count[(arr.get(i) / place) % 10] - 1] = arr.get(i);
            count[(arr.get(i)/ place) % 10]--;
        }

        for (int i = 0; i < size; i++)
            arr.set(i,output[i]);
            mainPanel.update(mainPanel.getGraphics());
            setTimer(speed);

    }

    /**
     * Cycle Sort
     * @param arr
     * @param n
     */
    public void cycleSort(ArrayList<Integer> arr, int n)
    {
        // count number of memory writes
        int writes = 0;

        // traverse array elements and put it to on
        // the right place
        for (int cycle_start = 0; cycle_start <= n - 2; cycle_start++) {
            // initialize item as starting point
            int item = arr.get(cycle_start);

            // Find position where we put the item. We basically
            // count all smaller elements on right side of item.
            int pos = cycle_start;
            for (int i = cycle_start + 1; i < n; i++)
                if (arr.get(i) < item)
                    pos++;

            // If item is already in correct position
            if (pos == cycle_start)
                continue;

            // ignore all duplicate elements
            while (item == arr.get(pos))
                pos += 1;

            // put the item to it's right position
            if (pos != cycle_start) {
                int temp = item;
                item = arr.get(pos);
                arr.set(pos,temp);
                mainPanel.update(mainPanel.getGraphics());
                setTimer(speed);
                writes++;
            }

            // Rotate rest of the cycle
            while (pos != cycle_start) {
                pos = cycle_start;

                // Find position where we put the element
                for (int i = cycle_start + 1; i < n; i++)
                    if (arr.get(i) < item)
                        pos += 1;

                // ignore all duplicate elements
                while (item == arr.get(pos))
                    pos += 1;

                // put the item to it's right position
                if (item != arr.get(pos)) {
                    int temp = item;
                    item = arr.get(pos);
                    arr.set(pos,temp);
                    mainPanel.update(mainPanel.getGraphics());
                    setTimer(speed);
                    writes++;
                }
            }
        }
    }



    // The main function to that sorts arr[] of size n using
    // Radix Sort




    //    Collections.swap(mainPanel.gilmo, j - 1, j);
//    mainPanel.update(mainPanel.getGraphics());
//    setTimer(speed);
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}