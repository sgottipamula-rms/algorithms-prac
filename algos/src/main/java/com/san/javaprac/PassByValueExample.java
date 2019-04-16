package com.san.javaprac;

public class PassByValueExample {

    class MyInteger {
        public Integer value;
    }

    public void modify(Integer i) {
        i=i*2;
        System.out.println("in modifyfn value:"+i); //20
    }

    public void modify(MyInteger i) {
        i.value=i.value*2;
        System.out.println("in modifyfn value:"+i.value); //20
    }


    public void go() {
        Integer i = 10;
        modify(i);
        System.out.println("after modification"+i); //10

        MyInteger j = new MyInteger();
        j.value=10;
        modify(j);
        System.out.println("after modification"+j.value);//20
    }

    public static void main(String[] args) {
        PassByValueExample passByValueExample = new PassByValueExample();
        passByValueExample.go();
    }
}
