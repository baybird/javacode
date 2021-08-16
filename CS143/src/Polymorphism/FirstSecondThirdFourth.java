package Polymorphism;

/**
 *
 * @author robert
 */
public class FirstSecondThirdFourth {

    public static void main(String[] args) {
        First var1_2 = new Second();
        First var1_3 = new Third();
        First var1_4 = new Fourth();
        Second var2_3 = new Third();
        Object var2 = new Second();

        var1_2.method2();
        var1_3.method2();
        var1_4.method2();
        var2_3.method2();
        //var4.method2();

        System.out.println("*************");
        ((First) var1_2).method2();
        ((Second) var1_2).method2();
        ((Second) var2_3).method2();
        ((Third) var2_3).method2();
        //((Fourth) var1_2).method2();

    }
}

class First {

    public void method2() {
        System.out.println("First2");
    }

    public void method3() {
        method2();
    }
}

class Second extends First {

    public void method2() {
        System.out.println("Second2");
    }
}

class Third extends Second {

    public void method1() {
        System.out.println("Third1");
        super.method2();
    }

    public void method2() {
        System.out.println("Third2");
    }
}

class Fourth extends First {

    public void method1() {
        System.out.println("Fourth1");
    }

    public void method2() {
        System.out.println("Fourth2");
    }
}
