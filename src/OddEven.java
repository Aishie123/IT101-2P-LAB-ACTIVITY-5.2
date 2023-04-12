// Aisha Nicole L. Dones
// Section A122

import javax.swing.*;
import java.util.ArrayList;

public class OddEven {

    public static void main(String[] args) { script(); } // end of main

    private static void script(){
        int sentinel = 0;
        int n, i;

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        try {
            i = 0;
            do {
                n = Integer.parseInt(JOptionPane.showInputDialog(null, "Integer " + (i+1) + ": "));
                numbers.add(n);
                if (n == 0){ continue; }
                else if (n % 2 == 0){ even.add(n); }
                else { odd.add(n); }
                i++;
            } while ( n != sentinel );

            JTextArea textArea = new JTextArea(resultToString(numbers, odd, even));
            JScrollPane scrollArea = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(null, scrollArea);

        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "INVALID INPUT! Please try again.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            script();
        }
    } // end of script

    private static String resultToString(ArrayList<Integer> numbers, ArrayList<Integer> odd, ArrayList<Integer> even){
        StringBuilder strInput, strNum, strOddN, strEvenN;
        String strOdd, strEven;

        strInput = new StringBuilder("If the inputs are: ");
        for (Integer number : numbers) { strInput.append(number).append(" "); }

        strNum = new StringBuilder("\n\nNumbers\t: ");
        for (int j = 0; j < numbers.size() - 1; j++){ strNum.append(numbers.get(j)).append(" "); }

        strOddN = new StringBuilder("\nOdd Numbers\t: ");
        for (Integer integer : odd) { strOddN.append(integer).append(" "); }

        strEvenN = new StringBuilder("\nEven Numbers\t: ");
        for (Integer integer : even) { strEvenN.append(integer).append(" "); }

        strEven = "\nEven\t: " + even.size();
        strOdd = "\nOdd\t: " + odd.size();

        return strInput.toString() + strNum + strOddN + strEvenN + strOdd + strEven
                + "\n\nCreated By: Aisha Nicole L. Dones";

    } // end of resultToString method

} // end of class
