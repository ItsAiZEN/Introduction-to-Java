package Tests_questions;

public class C extends A {
    private int _cVal;

    public C() {
        _cVal = 3;
    }

//    public boolean equals(Object obj) {
//        System.out.println("in C");
//        return super.equals(obj);
//    }

    public boolean equals(C obj) {
        System.out.println("in C");
        return true;
    }
}
