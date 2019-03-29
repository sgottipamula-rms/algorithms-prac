package com.san;

import sun.java2d.xr.MutableInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Hello world!
 *
 */
public class App 
{

    private void modifyx(int x) {
        x=100;
        System.out.println("in proc:"+x); //100
    }

    private void modifyy(MutableInteger y) {
        y.setValue(100);
        System.out.println("in proc:"+y.getValue());//100
    }

    public static void main( String[] args )
    {

        App app = new App();

        int x=10;
        app.modifyx(x);
        System.out.println("outproc:"+x); //10..primitives are immutable

        //Integer class is immutable apparently so user MutableInteger
        MutableInteger y=new MutableInteger(10);
        app.modifyy(y);
        System.out.println("outproc:"+y.getValue()); //100

    }
}
