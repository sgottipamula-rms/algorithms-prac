package com.san.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncPrograming {

    public static void main(String[] args) throws Exception {

        CommandNoReturn commandNoReturn = new CommandNoReturn() {
            @Override
            public void action() {
                System.out.println("telling client I am done..");
            }
        };

        CallBackTask callBackTask = new CallBackTask(commandNoReturn);

        ExecutorService executorService  = Executors.newFixedThreadPool(1);
        executorService.submit(callBackTask);
        executorService.shutdown();

        Thread.sleep(1000);
    }
}
