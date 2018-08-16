package com.example.demo.futuerTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by constanting on 2018/7/7.
 */
public class main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FutureTask<String> futureTask = new FutureTask<String>(new RealData("request"));
        ExecutorService executorService = Executors.newCachedThreadPool();
        try{
            executorService.submit(futureTask);
            System.out.println("-----"+futureTask.get());
            long end = System.currentTimeMillis();
            System.out.println("use time"+(end-start));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
