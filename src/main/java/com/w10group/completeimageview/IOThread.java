package com.w10group.completeimageview;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qiaoyuang on 2017/4/26.
 * 耗时逻辑处理线程
 */

class IOThread {

    private static ExecutorService singleThread;

    static Executor getSingleThread() {
        if (singleThread == null) {
            singleThread = Executors.newSingleThreadExecutor();
        }
        return singleThread;
    }

}