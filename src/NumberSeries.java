// Aisha Nicole L. Dones
// Section A122

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberSeries {

    private static final String[][] rowData = new String[5][10];
    private static final String[] columnNames = {"", "", "", "", "", "", "", "", "", ""};

    private static final int[][] nums = new int[5][10];

    private static final ArrayList<Integer> odd = new ArrayList<>();
    private static final ArrayList<Integer> even = new ArrayList<>();

    private static final StringBuilder strOdd = new StringBuilder();
    private static final StringBuilder strEven = new StringBuilder();
    private static final StringBuilder strDiv5 = new StringBuilder();
    private static final StringBuilder strNegative = new StringBuilder();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Numbers.txt"));

        for (byte i = 0; i < nums.length; i++){
            for (byte j = 0; j < nums[i].length; j++){
                nums[i][j] = scanner.nextInt();
                rowData[i][j] = String.valueOf(nums[i][j]);
            }
        }
        displayNumbers(numberTable());
    } // end of main

    private static void displayNumbers(JScrollPane scrollPane){
        String[] strRow = {"R1", "R2", "R3", "R4", "R5"};

        JPanel panel = new JPanel();

        JPanel topPanel = new JPanel(new GridLayout(2, 1, 0, 2));
        JPanel centerPanel = new JPanel(new GridLayout(1, 1, 0, 2));
        JPanel bottomPanel1 = new JPanel(new GridLayout(2, 1, 0, 2));
        JPanel bottomPanel2 = new JPanel(new GridLayout(4, 1, 0, 2));
        JPanel bottomPanel3 = new JPanel(new GridLayout(10, 1, 0, 2));
        JPanel bottomPanel4 = new JPanel(new GridLayout(5, 1, 0, 2));
        JPanel bottomPanel5 = new JPanel(new GridLayout(2, 1, 0, 2));
        JPanel bottomPanel6 = new JPanel(new GridLayout(1, 1, 0, 2));
        JPanel bottomPanel7 = new JPanel(new GridLayout(1, 1, 0, 2));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        topPanel.add(new JLabel("******** NUMBER SERIES ********\n"));
        topPanel.add(new JLabel("Created by: Aisha Nicole L. Dones\n"));

        centerPanel.add(scrollPane);

        bottomPanel1.add(new JLabel("\nSum      : " + sumAll()));
        bottomPanel1.add(new JLabel("\nAverage: " + aveAll()));
        // 2 rows in panel

        findOddEven();
        bottomPanel2.add(new JLabel("\nOdd Numbers: " + strOdd));
        bottomPanel2.add(new JLabel("\nSum of Odd Numbers: " + sumOddEven(odd)));
        bottomPanel2.add(new JLabel("\nEven Numbers: " + strEven));
        bottomPanel2.add(new JLabel("\nSum of Even Numbers: " + sumOddEven(even)));
        // 4 rows in panel

        for (int i = 0; i < strRow.length; i++){
            bottomPanel3.add(new JLabel("\nSum of " + strRow[i] + "      : " + sumRow(i)));
            bottomPanel3.add(new JLabel("\nAverage of " + strRow[i] + ": " + aveRow(i)));
        } // 10 rows in panel

        for (int i = 0; i < strRow.length; i++){
            bottomPanel4.add(new JLabel("\nLowest No. of " + strRow[i] + ": " + lowestInR(i)));
        } // 5 rows in panel

        bottomPanel5.add(new JLabel("\nLowest No. of All: " + lowestAll()));
        bottomPanel5.add(new JLabel("\nHighest No. of All: " + highestAll()));
        // 2 rows in panel

        divBy5();
        bottomPanel6.add(new JLabel("\nNumbers divisible by 5: " + strDiv5));
        findNegative();
        bottomPanel7.add(new JLabel("\nNegative numbers: " + strNegative));

        addPanel(panel, topPanel, 10);
        addPanel(panel, centerPanel, 10);
        addPanel(panel, bottomPanel1, 8);
        addPanel(panel, bottomPanel2, 8);
        addPanel(panel, bottomPanel3, 8);
        addPanel(panel, bottomPanel4, 8);
        addPanel(panel, bottomPanel5, 8);
        addPanel(panel, bottomPanel6, 8);
        addPanel(panel, bottomPanel7, 8);

        JOptionPane.showMessageDialog(null, panel, "Number Series", JOptionPane.PLAIN_MESSAGE);

    } // end of displayNumbers method

    private static int sumAll(){
        int sum = 0;
        for (int[] numRow : nums){ for (int num : numRow){ sum += num; } }
        return sum;
    } // end of sumAll method

    private static int aveAll(){ return sumAll()/((nums.length)*nums[0].length); } // end of aveAll method

    private static void findOddEven(){
        for (int[] numRow : nums){
            for (int num : numRow){
                if (num%2 != 0){ odd.add(num); strOdd.append(num).append(" "); }
                else{ even.add(num); strEven.append(num).append(" "); }
            }
        }
    } // end of findOddEven method

    private static int sumOddEven(ArrayList<Integer> list){
        int sum = 0;
        for (Integer n : list){ sum += n; }
        return sum;
    } // end of sumOddEven method

    private static int sumRow(int row){
        int sum = 0;
        for (int num : nums[row]){ sum += num; }
        return sum;
    } // end of sumRow method

    private static int aveRow(int row){ return sumRow(row)/nums[row].length; } // end of aveRow method

    private static int lowestInR(int row){
        int low = nums[row][0];
        for (int i = 0; i < nums[row].length; i++){
            if (nums[row][i] < low){ low = nums[row][i]; }
        } return low;
    } // end of lowestInR method

    private static int lowestAll(){
        int low = nums[0][0];
        for (int[] row : nums){
            for (int i = 0; i < row.length; i++){
                if (row[i] < low){ low = row[i]; }
            }
        } return low;
    } // end of lowestAll method

    private static int highestAll(){
        int high = nums[0][0];
        for (int[] row : nums){
            for (int i = 0; i < row.length; i++){
                if (row[i] > high){ high = row[i]; }
            }
        } return high;
    } // end of highestAll method

    private static void divBy5(){
        for (int[] numRow : nums){
            for (int num : numRow){
                if (num%5 == 0){ strDiv5.append(num).append(" "); }
            }
        }
    } // end of divBy5 method

    private static void findNegative(){
        for (int[] numRow : nums){
            for (int num : numRow){
                if (num < 0){ strNegative.append(num).append(" "); }
            }
        }
    } // end of findNegative method

    private static void addPanel(JPanel panel, JPanel p, int space){
        panel.add(p);
        panel.add(Box.createVerticalStrut(space)); // vertical space
    } // end of addPanel method

    private static JScrollPane numberTable(){

        JTable table = new JTable(rowData, columnNames);
        table.setPreferredScrollableViewportSize(
                new Dimension(
                        table.getPreferredSize().width,
                        table.getRowHeight() * rowData.length));
        final JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    } // end of numberTable method

} // end of class
