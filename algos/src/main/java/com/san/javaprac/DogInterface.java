package com.san.javaprac;

public interface DogInterface {
    void bark();

    default void boo() {
        System.out.println("boo");
    }

}
