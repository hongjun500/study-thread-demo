package com.hongjun.testCreadThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author hongjun500
 * @date 2020/12/16 17:17
 * @tool ThinkPadX1隐士
 * Created with 2019.3.2.IntelliJ IDEA
 * Description: 使用实现Callable接口的方式创建线程
 */
public class MyThreadByCallable implements Callable{
    @Override
    public Object call() throws Exception {
        // call方法可以指定返回的值
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 这一块的内容不太明白，根据多数文章建议，用线程池创建线程最好
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThreadByCallable());
        Thread thread = new Thread(futureTask);
        thread.start();
        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}
