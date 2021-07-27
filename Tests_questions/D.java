package Tests_questions;

public class D extends C {
    private int _dVal;

    public D() {
        _dVal = 3;

    }

//    public boolean equals(Object obj) {
//        System.out.println("in D");
//        return super.equals(obj);
//    }

    public boolean equals(A obj) {
        System.out.println("in D");
        return true;
    }
}
