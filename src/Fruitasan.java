// Aisha Nicole L. Dones
// Section A122

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fruitasan {

    private static final int[] fruitPcs = new int[3];
    private static final int[][] monthlyPcs = new int[5][3];
    private static final int[] totalMonthlyPcs = new int[5];
    private static final double[] fruitSales = new double[3];
    private static final double[] totalMonthlySales = new double[5];

    private static final String[] months = {"January", "February", "March", "April", "May"};
    private static final String[] fruits = {"Apple", "Mango", "Banana"};
    private static final double[] price = {16.78, 14.50, 7.89}; // apple, mango, and banana prices respectively

    private static int totalPcs = 0;
    private static int totalSales = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("fruits.txt"));

        while (file.hasNextLine()) {
            String line = file.nextLine();
            Scanner scanner = new Scanner(line);
            String fruit = scanner.next();
            for (int i = 0; i < monthlyPcs.length; i++) {
                if (scanner.hasNextInt()) {
                    monthlyPcs[i][getFruitIndex(fruit)] = scanner.nextInt();
                } else {
                    // skips the line if there are no integers
                    break;
                }
            } // end of for
            scanner.close();
        } // end of while
        findTotal();
        displayFruitasan();
    } // end of main

    private static int getFruitIndex(String fruitName) {
        int index = -1;
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i].equalsIgnoreCase(fruitName)) { index = i; break; }
        } return index;
    } // end of getFruitIndex method

    private static String strMostSold(){
        int mostSold = 0;

        for (int i = 1; i < totalMonthlyPcs.length; i++){
            if (totalMonthlyPcs[i] > totalMonthlyPcs[mostSold]){ mostSold = i; }
        }
        return months[mostSold];
    } // end of findMostSold method

    private static void displayFruitasan(){
        StringBuilder text1 = new StringBuilder("\n\nTotal number of sold per fruit from January to May: ");
        for (int i = 0; i < fruitPcs.length; i++){
            text1.append("\n").append(fruits[i]).append("\t: ").append(fruitPcs[i]).append(" pcs. (").
                    append(String.format("%.2f",fruitSales[i])).append(" pesos)");
        }
        StringBuilder text2 = new StringBuilder("\n\nTotal number of sold per month: ");
        for (int i = 0; i < months.length; i++){
            text2.append("\n").append(months[i]).append("\t: ").append(totalMonthlyPcs[i]).append(" pcs. (").
                    append(String.format("%.2f", totalMonthlySales[i])).append(" pesos)");
        }
        text2.append("\n\nMonth with the most sold Apples, Mangoes, and Bananas: ").append(strMostSold());
        String text3 = "\n\nTotal sales of fruits: " + totalSales + " pesos (" + totalPcs + " pcs.)";

        String text = "-- FRUITASAN --" + "\nCreated by: Aisha Nicole L. Dones" + text1 + text2 + text3;

        JTextArea textArea = new JTextArea(text);
        JScrollPane scrollArea = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollArea);
    } // end of displaySales method

    private static void findTotal() {
        for (int i = 0; i < monthlyPcs.length; i++){
            totalMonthlyPcs[i] += monthlyPcs[i][0] + monthlyPcs[i][1] + monthlyPcs[i][2]; }

        for (int i = 0; i < monthlyPcs.length; i++){
            totalMonthlySales[i] += (monthlyPcs[i][0] * 16.78) + (monthlyPcs[i][1] * 14.50) + (monthlyPcs[i][2] * 7.89); }

        for (int i = 0; i < fruits.length; i++) {
            fruitPcs[i] = monthlyPcs[0][i] + monthlyPcs[1][i] + monthlyPcs[2][i] + monthlyPcs[3][i] + monthlyPcs[4][i];
            fruitSales[i] = fruitPcs[i] * price[i]; }

        for (int piece : fruitPcs) { totalPcs += piece; }
        for (double sale : fruitSales) { totalSales += sale; }
    } // end of findTotal method

} // end of class
