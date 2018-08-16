package com.example.demo.futuer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by constanting on 2018/7/7.
 */
public class FutuerTest2{

    private static class Task implements Callable<String>{
        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "call return";
        }
    }

    public static void main(String[] args) throws InterruptedException,ExecutionException{
        List<Future<String>> futureList = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            futureList.add(executorService.submit(new Task()));
        }
        for (Future<String> res: futureList) {
            System.out.println(res.get());
        }

    }
}
