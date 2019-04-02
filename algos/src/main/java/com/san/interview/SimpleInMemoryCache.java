package com.san.interview;

import java.util.*;

public class SimpleInMemoryCache {

    public final Map<String,Integer> cache = new HashMap<>();
    public final Map<Integer,Set<String>> reverseCache = new TreeMap<>();


    public void set(String key, Integer val) {
        Integer prev = cache.getOrDefault(key,0);

        Set keys = reverseCache.getOrDefault(prev,new HashSet<>());
        keys.remove(key);

        cache.put(key,val);
        keys = reverseCache.getOrDefault(val,new HashSet<>());
        keys.add(key);
        reverseCache.put(val,keys);
    }

    public void increment(String key) {
        Integer prev = cache.getOrDefault(key,0);
        set(key,prev+1);
    }

    public int get(String key) {
        return cache.getOrDefault(key,Integer.MIN_VALUE);
    }

    public void del(String key) {
        Integer val = cache.get(key);
        cache.remove(key);

        Set<String> keys = reverseCache.getOrDefault(val,new HashSet<>());
        keys.remove(key);
        reverseCache.put(val,keys);
    }

    public void delvalue(Integer val) {
        Set<String> keys = reverseCache.getOrDefault(val, new HashSet<>());

        for(String key : keys) {
            cache.remove(key);
        }

        reverseCache.remove(val);
    }


    public static void main(String[] args) {

        SimpleInMemoryCache simpleInMemoryCache = new SimpleInMemoryCache();
        LinkedList<String> commandQueue = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to SimpleInMemoryCache shell(case-sensitive)...type QUIT to exit..");

        while(true) {
            if(commandQueue.isEmpty()) {
                System.out.println(">");
                commandQueue.add(scanner.nextLine());
            }

            String command = commandQueue.remove();

            if(command.contains("SET")) {
                String[] split = command.split(" ");
                simpleInMemoryCache.set(split[1],Integer.parseInt(split[2]));
                System.out.println("processed set command");
                continue;
            }

            if(command.contains("INCR")) {
                String[] split = command.split(" ");
                simpleInMemoryCache.increment(split[1]);
                System.out.println("processed increment command");
                continue;
            }

            if(command.contains("GET")) {
                String[] split = command.split(" ");
                Integer val = simpleInMemoryCache.get(split[1]);
                String retval = val==Integer.MIN_VALUE?"<nil>":val.toString();
                System.out.println("processed get command, result:"+retval);
                continue;
            }

            if(command.contains("DEL ")) {
                String[] split = command.split(" ");
                simpleInMemoryCache.del(split[1]);
                System.out.println("processed del command");
                continue;
            }

            if(command.contains("DELVALUE ")) {
                String[] split = command.split(" ");
                simpleInMemoryCache.delvalue(Integer.parseInt(split[1]));
                System.out.println("processed delvalue command");
                continue;
            }

            if(command.contains("MULTI")) {
                System.out.println("multi mode..type EXEC to execute or DISCARD to discard given commands");
                Queue<String> multiQueue = new LinkedList<>();

                while(true) {
                    System.out.println(">");
                    String multicommand = scanner.nextLine();

                    if(multicommand.equals("EXEC")) {
                        commandQueue.addAll(multiQueue);
                        System.out.println("executing multi commands");
                        break;
                    }

                    if(multicommand.equals("DISCARD")) {
                        System.out.println("discarding above multi commands");
                        break;
                    }

                    multiQueue.add(multicommand);
                }
                continue;
            }

            if(command.contains("QUIT")) {
                break;
            }
        }

        System.out.println("Exiting..");
    }
}
