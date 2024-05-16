import java.util.Arrays;
import java.util.Scanner;

public class KataCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(calc(input));
    }
    static String calc(String input){
        input=input.trim();
        input=input.replaceAll(" ","");
        int index = -1;
        for (int i=0;i<input.length();i++){
            if(input.charAt(i)=='+' || (input.charAt(i)=='-' || input.charAt(i)=='*') || input.charAt(i)=='/'){
                index=i;
            }
        }
        String first,second,third;
        first=input.substring(0,index);
        second = input.substring(index,index+1);
        third = input.substring(index+1);
        //System.out.println(first + " " + second + " " + third);
        boolean flag1 = false;
        boolean flag2= false;
        Rome[] rome = Rome.values();
        for (Object o : rome) {
            if (first==o){
                flag1=true;
            }if (third==o){
                flag2=true;
            }
        }
        return input;
    }
}
