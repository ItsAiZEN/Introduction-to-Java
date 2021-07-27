package Tests_questions;

public class B extends A {
    private int _bVal;

    public B() {
        _bVal = 2;
    }

    public boolean equals(Object obj) {
        System.out.println("in B");
        return true;

    }
}
