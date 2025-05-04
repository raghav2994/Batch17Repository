package org.Anubhav_Roy_Package;

import java.util.ArrayList;
import java.util.List;

public class TestString { //String Reversal

    public static void main(String[] args) {
        String s="Hello World";
        stringRev(s);

    }

    private static void stringRev(String s) {

        StringBuilder res=new StringBuilder();
        res.append(s);
        res.reverse();
        System.out.println(res);

    }
}
