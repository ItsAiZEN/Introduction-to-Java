package Tests_questions;

public class A {
    private int _val;

    public A() {
        _val = 1;
    }

    public boolean equals(Object obj) {
        System.out.println("in A");
        return super.equals(obj);
    }
    public boolean equals(A obj) {
        System.out.println("in A");
        return true;
    }
}
