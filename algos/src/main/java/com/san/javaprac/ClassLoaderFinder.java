package com.san.javaprac;

import sun.net.spi.nameservice.dns.DNSNameService;

import java.util.HashMap;

public class ClassLoaderFinder {

    public static void main(String[] args) {
        System.out.println(HashMap.class.getClassLoader());//null=bootstrapCL
        System.out.println(DNSNameService.class.getClassLoader());//sun.misc.Launcher$ExtClassLoader@66d3c617
        System.out.println(ClassLoaderFinder.class.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
