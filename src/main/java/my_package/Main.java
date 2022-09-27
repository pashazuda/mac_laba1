package my_package;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CalcException {
        while (true){
            Scanner console = new Scanner(System.in);
            String input = console.nextLine();
            System.out.println(Calculator.calc(input));
        }
    }
}
