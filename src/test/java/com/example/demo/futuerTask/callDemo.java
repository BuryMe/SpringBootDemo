package com.example.demo.futuerTask;

import java.util.concurrent.Callable;

/**
 * Created by constanting on 2018/7/7.
 */
public class callDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int r = 0;
        for (int i = 0; i < 5; i++) {
            r = r+i;
            Thread.sleep(1000);
        }
        return new Integer(r);
    }

}
