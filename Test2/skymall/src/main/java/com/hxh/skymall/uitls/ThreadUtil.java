package com.hxh.skymall.uitls;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ThreadUtil {
    static ExecutorService pool;
    static {
        pool = Executors.newFixedThreadPool(5);
    };
    public static void execute(Runnable runnable) {
        pool.execute(runnable);
    }

}
