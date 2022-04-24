import java.util.Scanner;

public class question1 {
    private static String add(String num1, String num2)
    {
        String [] num1_p = num1.split(".");
        String [] num2_p = num2.split(".");
        
        System.out.println(num1+" "+num2);
        System.out.println(num1_p.length );
        System.out.println(num1_p[0]+"="+num1_p[1]);
        
        
        return "ff";
    }

    
    
    // please don't modify any code below.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        String sum = add(num1, num2);
        System.out.println(sum);
    }
}