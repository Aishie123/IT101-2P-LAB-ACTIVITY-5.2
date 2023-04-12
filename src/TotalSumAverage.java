// Aisha Nicole L. Dones
// Section A122

import javax.swing.*;
import java.awt.*;

public class TotalSumAverage {

    private static JPanel panel;
    private static JTextField n1Field, n2Field;

    public static void main(String[] args) { script(); } // end of main

    private static void script(){
        double ave;
        int result, n1, n2, ctr, sum;
        int[] inputIntegers;

        createPanel();

        result = JOptionPane.showConfirmDialog(null, panel,
                "Input", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {

                n1 = Integer.parseInt(n1Field.getText());
                n2 = Integer.parseInt(n2Field.getText());

                if (n2 <= n1){
                    JOptionPane.showMessageDialog(null,
                            "Sorry! Second integer must be greater than " + n1, "ERROR", JOptionPane.ERROR_MESSAGE);
                    script();
                }
                else {
                    inputIntegers = new int[n2 - n1 + 1];
                    ctr = n1; // counter
                    while (ctr <= n2) {
                        inputIntegers[ctr - n1] = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Input integer " + (ctr - n1 + 1) + ": "));
                        ctr++;
                    }
                    sum = getSum(inputIntegers);
                    ave = getAverage(inputIntegers, sum);
                    showCount(sum, ave);
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "INVALID INPUT! Please try again.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                script();
            }
        }

    } // end of script

    private static int getSum(int[] arr){
        int sum = 0;
        for (int i : arr){
            sum += i;
        } return sum;
    } // end of getSum method

    private static double getAverage(int[] arr, int sum){ return (double) sum/arr.length; } // end of getAverage method

    private static void createPanel(){

        JPanel n1Panel, n2Panel;

        panel = new JPanel();

        n1Field = new JTextField();
        n2Field = new JTextField();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        n1Panel = new JPanel(new GridLayout(1, 2));
        n2Panel = new JPanel(new GridLayout(1, 2));

        createPanel(n1Panel, n1Field, "Type first integer: ");
        createPanel(n2Panel, n2Field, "Type second integer: ");

    } // end of createPanel method

    private static void createPanel(JPanel p, JTextField jt, String label){
        p.add(new JLabel(label));
        p.add(jt);
        panel.add(p);
        panel.add(Box.createVerticalStrut(5)); // a spacer
    } // end of createPanel method with 3 parameters

    private static void showCount(int sum, double ave){
        String strAve = String.format("%.2f", ave);
        String text = "Total Sum\t: " + sum + "\nAverage\t: " +
                (strAve.endsWith(".00") ? strAve.substring(0, strAve.length()-3) : strAve)
                + "\n\nCreated By: Aisha Nicole L. Dones";
        JOptionPane.showMessageDialog(null, new JTextArea(text));
    } // end of showCount method

} // end of class