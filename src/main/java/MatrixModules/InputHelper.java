package MatrixModules;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHelper {
    static protected Scanner in = new Scanner(System.in);

    public int parserLength() {
        int n = 0;
        while (n <= 0) {
            n = parserInt("Введено не число или отрицательное число, попробуйте ещё раз \n");
        }

        return n;
    }

    public String input() {
        return in.nextLine();
    }

    public int parserInt(String Message) {
        Pattern pattern = Pattern.compile("^(-|\\+)?[0-9]+?$");
        Matcher matcher;
        int n = 0;
        boolean flag = false;
        String str;
        while (!flag) {
            str = input();//input();
            matcher = pattern.matcher(str);
            if (matcher.matches()) {
                n = Integer.valueOf(str);
                flag = true;
            } else {
                System.out.print(Message);//
            }
        }
        return n;
    }

    public static boolean isLong(String input){
        Pattern pattern = Pattern.compile("^(-|\\+)?[0-9]+$");
        Matcher matcher;
        matcher = pattern.matcher(input);
        if (matcher.matches()) {
           return true;
        } else {
           return false;
        }
    }

    public String parserLongArithm(String Message) {
        Pattern pattern = Pattern.compile("^(-|\\+)?[0-9]+$");
        Matcher matcher;
        String n = "a";
        String str;
        while (n.equals("a")) {
            str = input();//input();
            matcher = pattern.matcher(str);
            if (matcher.matches()) {
                n =str;
            } else {
                System.out.print(Message);//
            }
        }
        return n;
    }
    public double parserDouble(String Message) {
        Pattern pattern = Pattern.compile("^(-|\\+)?[0-9]+(\\.[0-9]+)?$");
        Matcher matcher;
        double n = 0;
        boolean flag = false;
        String str;
        while (!flag) {
            str = input();//input();
            matcher = pattern.matcher(str);
            if (matcher.matches()) {
                n = Double.valueOf(str);
                flag = true;
            } else {
                System.out.print(Message);//
            }
        }
        return n;
    }


}
