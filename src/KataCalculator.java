import java.util.Scanner;

public class KataCalculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(calc(input));
    }

    static String calc(String input) throws Exception {
        input = input.trim();
        input = input.replaceAll(" ", "");
        int index = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || (input.charAt(i) == '-' || input.charAt(i) == '*') || input.charAt(i) == '/') {
                index = i;
            }
        }
        if (index == -1) {
            throw new Exception("строка не является математической операцией");
        }
        String first, second, third;
        first = input.substring(0, index);
        second = input.substring(index, index + 1);
        third = input.substring(index + 1);
        boolean flag1 = false;
        boolean flag2 = false;
        Rome[] rome = Rome.values();
        for (Object o : rome) {
            if (first.equals(String.valueOf(o))) {
                flag1 = true;
            }
            if (third.equals(String.valueOf(o))) {
                flag2 = true;
            }
        }
        try {
            // если не спарсятся , то 1 или оба римские , либо строки
            // и отправляем в блок кетч на проверку , что оба римские
            int i = Integer.parseInt(first);
            int iii = Integer.parseInt(third);
            if ((i > 0 && i <= 10) && (iii > 0 && iii <= 10)) {
                switch (second) {
                    case ("+"):
                        return String.valueOf(i + iii);
                    case ("-"):
                        return String.valueOf(i - iii);
                    case ("*"):
                        return String.valueOf(i * iii);
                    case ("/"):
                        return String.valueOf(i / iii);
                }
            }
        } catch (Exception e) {
            if (flag1 && flag2) {
                try {
                    int res = 0;
                    switch (second) {
                        case ("+"):
                            res = Rome.valueOf(first).i + Rome.valueOf(third).i;
                            break;
                        case ("-"):
                            res = Rome.valueOf(first).i - Rome.valueOf(third).i;
                            break;
                        case ("*"):
                            res = Rome.valueOf(first).i * Rome.valueOf(third).i;
                            break;
                        case ("/"):
                            res = Rome.valueOf(first).i / Rome.valueOf(third).i;
                            break;
                    }
                    if (res < 1) {
                        throw new Exception();
                    } else if (res > 1 && res <= 10) {
                        return String.valueOf(Rome.values()[res - 1]);
                    } else {
                        int f = res / 10;
                        int s = res % 10;
                        String desyatki = "";
                        switch (f) {
                            case 1:
                                desyatki = "X";
                                break;
                            case 2:
                                desyatki = "XX";
                                break;
                            case 3:
                                desyatki = "XXX";
                                break;
                            case 4:
                                desyatki = "XL";
                                break;
                            case 5:
                                desyatki = "L";
                                break;
                            case 6:
                                desyatki = "LX";
                                break;
                            case 7:
                                desyatki = "LXX";
                                break;
                            case 8:
                                desyatki = "LXXX";
                                break;
                            case 9:
                                desyatki = "XC";
                                break;
                            case 10:
                                desyatki = "C";
                                break;
                        }
                        if (s != 0) {
                            return desyatki + Rome.values()[s - 1];
                        } else
                            return desyatki;
                    }
                } catch (Exception ex) {
                    throw new Exception("в римской системе нет отрицательных чисел");
                }
            } else
                throw new Exception("используются одновременно разные системы счисления");

        }
        throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно");
    }
}
