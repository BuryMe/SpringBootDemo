package com.example.demo.futuerTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by constanting on 2018/7/7.
 */
public class callDemoMain {



    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new callDemo());
        ExecutorService executorService = Executors.newCachedThreadPool();
        try{
            executorService.submit(futureTask);
            System.out.println(futureTask.get());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }


}
