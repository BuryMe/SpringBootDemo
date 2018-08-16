package com.example.demo.futuer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * FutuerDemo
 * Created by constanting on 2018/7/7.
 */
public class FutuerTest3 {

    static class task implements Callable<Integer>{
        private Integer integer;
        public task(Integer i){
            super();
            this.integer = i;
        }
        @Override
        public Integer call() throws Exception {
            if(integer == 3){
                Thread.sleep(3000);
            }else if(integer == 5){
                Thread.sleep(5000);
            }else if(integer == 1){
                Thread.sleep(1000);
            }
            System.out.println("线程"+Thread.currentThread().getName()+"，任务"+integer+",完成！"+ new Date());
            return integer;
        }
    }

    public static void main(String[] args) throws InterruptedException,ExecutionException{
        Long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try{
            List<Integer> integers = new ArrayList<>();
            List<Future<String>> futures = new ArrayList<>();
            for (Integer i = 0; i < 10; i++) {
               // futures.add(executorService.submit(new task(i + 1)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }



}
