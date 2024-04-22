import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static int zn_a = 0;
    public static int zn_b = 0;
    public static int res = 0;
    public static int result = 0; // Ответ, который сохраняется для дальнейшей работы с программой
    public static void main(String[] args) {
        globalMenu();
    }
    public static void globalMenu(){
        System.out.println("1. Ввести пример");
        System.out.println("2. Продолжить работать с предыдущим ответом");
        System.out.println("3. Выход");
        System.out.println("Выберите пункт меню:");
        Scanner scr = new Scanner(System.in);
        int menu = scr.nextInt();
        mainMenu(menu);
    }

    public static void vvodDannih() {
        System.out.println("Ввод примера: ");
        Scanner scr = new Scanner(System.in);
        String str = scr.nextLine();
        String specsim;
        str = str.replaceAll("\\s+", " ");

        String str_2 = str.trim();
        //System.out.println("str_2: " + str_2);
       // String str_3 = str_2.replaceAll("[^-?0-9]+", " ");
       // System.out.println("str_3: " + str_3);
        String[] subst = str_2.split(" ");
//        for (int i = 0; i < subst.length; i++){
//            System.out.println("copystr: " + subst[i].trim());
//        }
        specsim = findSpecSymbol(subst);
        //System.out.println("спецсимвол: "+ specsim);

//        char[] stroka = str.toCharArray();
//        String[] symb = new String[str.length()];
//        for (int i = 0; i < str.length(); i++){
//            symb[i]= String.valueOf(stroka[i]);
//            //System.out.println(symb[i]);
//        }
//        specsim = findSpecSymbol(symb);

        if (specsim.length() > 1){
            System.out.println(specsim);
            globalMenu();
        }
        String[] words = str_2.split("[*+/^!?-]");
        //для вычисления факториала
        if (!specsim.equals("!")){
            zn_a = Integer.parseInt(words[0].trim());
            zn_b = Integer.parseInt(words[1].trim());
        }
        else
            zn_a = Integer.parseInt(words[0].trim());
        operationMenu(zn_a, zn_b, specsim);
    }

    public static String findSpecSymbol(String[] mas){
        String specialCharacters = "*+/^!?-";
        for (int i = 0; i < mas.length; i++)
            if (specialCharacters.contains(mas[i])){
                return (mas[i].trim());
            }
        return "Не введен символ операции!";
    }
    public static void mainMenu(int numb){
        switch (numb) {
            case 1:
                vvodDannih();
                break;
            case 2:
                if (result == 0){
                    System.out.println("Недоступно!");
                    globalMenu();
                    break;
                }
                else{
                System.out.println("1. Сложение");
                System.out.println("2. Вычитание");
                System.out.println("3. Умножение");
                System.out.println("4. Деление");
                System.out.println("5. Факториал");
                System.out.println("6. Возведение в степень");
                System.out.println("7. Сравнение");
                System.out.println("0. Назад");
                System.out.println("Выберите действие: ");
                Scanner scr = new Scanner(System.in);
                int operat = scr.nextInt();
                String oper = Integer.toString(operat);
                if (operat == 0) globalMenu();
                if (operat != 5){
                    System.out.println("Введите второе число: ");
                    Scanner sc = new Scanner(System.in);
                    zn_b = sc.nextInt();
                    operationMenu(result, zn_b, oper);
                }
                operationMenu(result, zn_b, oper);
                    }
                break;

            case 3:
                System.exit(0);
            default:
                System.out.println("Пункт отсутствует в меню");
                globalMenu();
        }
    }
    public static void operationMenu(int a, int b, String oper){
        switch (oper)
        {
            case "1":
            case "+":
                System.out.println("Сумма чисел = " + summation(a, b));
                result = summation(a, b);
                globalMenu();
                break;
            case "2":
            case "-":
                System.out.println("Разность чисел = " + difference(a, b));
                result = difference(a, b);
                globalMenu();
                break;
            case "3":
            case "*":
                System.out.println("Произведение чисел = " + multiplic(a, b));
                result = multiplic(a, b);
                globalMenu();
                break;
            case "4":
            case "/":
                if (b != 0){
                System.out.println("Частное чисел = " + division(a, b));
                result = (int)division(a, b);}
                else System.out.println("Делитель не должен быть равен 0!");
                globalMenu();
                break;
            case "5":
            case "!":
                System.out.println("Факториал числа = " + factorial(a));
                result = factorial(a);
                globalMenu();
                break;
            case "6":
            case "^":
                System.out.println("Число " + a + " в степени " + b + " = " + exponent(a, b));
                result = exponent(a, b);
                globalMenu();
                break;
            case "7":
            case "?":
                comparing(a, b);
                result = a;
                globalMenu();
                break;
            case "0":
                globalMenu();
            default:
                globalMenu();
        }
    }
    public static int summation(int a, int b){
        res = a + b;
        return res;
    }
    public static int difference(int a, int b){
        res = a - b;
        return res;
    }
    public static int multiplic(int a, int b){
        res = a*b;
        return res;
    }
    public static double division(int a, int b){
        double res_d;
        res_d = (double)a/b;
        return res_d;
    }
    public static int factorial(int a){
        if (a < 0)
            return 0;
        if (a == 0)
            return 1;
        else return a * factorial(a - 1);
    }
    public static int exponent(int a, int b){
        //res = (int)Math.pow(a,b);
        res = 1;
        for (int i = 1; i <= b; i++){
        res = res*a;
        }
        return res;
    }
    public static void comparing(int a, int b){
        if (a > b) {
            System.out.println(a + " > " + b);
        }
        else System.out.println(a + " < " + b);
    }
}