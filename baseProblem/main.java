import java.util.*;
/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main
{

    private static String r = ""; 
    public static void main(String[] args)
    {
        Scanner in = new Scanner (System.in);
        System.out.print("Enter a positive decimal: ");
        int num = in.nextInt();

        System.out.print("\n\nBinary number: " + dec2bin(num));

    }

    /*
     * Method to find the binary number of a base ten number
     */
    public static String dec2bin(int num)
    {

        if (num == 0)
        {
            return r + 1;
        }
        else 
        {
            int ans = num/8;
            int remainder = num%8;
            System.out.println("Remainder: " + remainder);
            System.out.println("quotient: " + ans + "\n\n");
            dec2bin(ans);
            r = r + remainder;
            return r;
        }
    }
}
