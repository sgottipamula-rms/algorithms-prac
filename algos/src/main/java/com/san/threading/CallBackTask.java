package com.san.threading;

public class CallBackTask implements Runnable {

    CommandNoReturn commandNoReturn;

    public CallBackTask(CommandNoReturn commandNoReturn) {
        this.commandNoReturn = commandNoReturn;
    }

    @Override
    public void run() {
        System.out.println("Going to db and fetching value");
        commandNoReturn.action();
    }

}
