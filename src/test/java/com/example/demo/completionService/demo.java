package com.example.demo.completionService;

import io.swagger.models.auth.In;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by constanting on 2018/7/7.
 */
public class demo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        try{
            int counTask = 10;
            List<Integer> list = new ArrayList<>();
            //定义completionService
            CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
            List<Future<Integer>> futureTasks = new ArrayList<>();
            //添加任务
            for (int i = 0; i < counTask; i++) {
                futureTasks.add(completionService.submit(new Task(i+1)));
            }
            for (int i = 0; i < counTask; i++) {
                Integer result = completionService.take().get();
                list.add(result);
                System.out.println("任务i=" + result + "完成" + new Date());
            }
            System.out.println("耗时：" + (System.currentTimeMillis()-start));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }

    /**
     * 模拟任务
     */
    static class Task implements Callable<Integer>{
        private Integer i;

        public Task(int i){
            super();
            this.i = new Integer(i);
        }

        @Override
        public Integer call() throws Exception {
            if(i == 5){
                Thread.sleep(5000);
            }else{
                Thread.sleep(1000);
            }
            System.out.println("线程："+Thread.currentThread().getName()+"执行完成，任务："+ i +"时间：" + new Date());
            return i;
        }
    }
}
