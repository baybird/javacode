package Recursion;

/**
 *
 * @author robert
 */
public class RecursionTracing {

    public static void main(String[] args) {
//        System.out.println(mystery5(-23, -48));
        mystery9(3842);
    }

    public static void mystery2(int n) {
        if (n <= 1) {
            System.out.print(n);
        } else {
            mystery2(n / 2);
            System.out.print(", " + n);
        }
    }

    public static int mystery5(int x, int y) {
        if (x < 0) {
            return -mystery5(-x, y);
        } else if (y < 0) {
            return -mystery5(x, -y);
        } else if (x == 0 && y == 0) {
            return 0;
        } else {
            return 100 * mystery5(x / 10, y / 10) + 10 * (x % 10) + y % 10;
        }
    }

    public static void mystery8(int n) {
        if (n > 100) {
            System.out.print(n);
        } else {
            mystery8(2 * n);
            System.out.print(", " + n);
        }
    }

    public static void mystery9(int x) {
        if (x < 10) {
            System.out.print(x);
        } else {
            int y = x % 10;
            System.out.print(y);
            mystery9(x / 10);
            System.out.print(y);
        }
    }
}
