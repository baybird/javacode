package Generics;


/**
 *
 * @author robert
 */
public class Generics {

    public static void main(String[] args) {
        // generics function
        test("hello");
        test(3);
        test(3.14);
        test(true);
        
        // generics class
        Test<Integer> objInt = new Test<>(3);
        System.out.println(objInt.getObj());
        
        Test<Double> objDou = new Test<>(3.14);
        System.out.println(objDou.getObj());
        
        Test<String> objStr = new Test<>("3.1415");
        System.out.println(objStr.getObj());
    }

    public static <T> void test(T input) {
        System.out.println(input + " is " + input.getClass().getName());
    }

}

class Test<T> {
    T obj;

    Test(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return this.obj;
    }
}
