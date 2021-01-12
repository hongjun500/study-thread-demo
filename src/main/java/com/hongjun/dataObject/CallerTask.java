package com.hongjun.dataObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author hongjun500
 * @date 2021/1/12 23:08
 * @tool ThinkPadX1隐士
 * Created with 2019.3.2.IntelliJ IDEA
 * Description:
 */
public class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello,Callable";
    }

    public static class CallerTask2 implements Callable<List<CallerTask>> {

        @Override
        public List<CallerTask> call() throws Exception {
            CallerTask callerTask = new CallerTask();
            List<CallerTask> list = new ArrayList<>();
            list.add(callerTask);
            list.add(callerTask);
            return list;
        }
    }

    public static void main(String[] args) {
        CallerTask callerTask = new CallerTask();
        CallerTask2 callerTask2 = new CallerTask2();
        // 创建异步任务
        FutureTask futureTask = new FutureTask<>(callerTask);
        FutureTask<List<CallerTask>> futureTask2 = new FutureTask<>(callerTask2);
        // 启动
        new Thread(futureTask).start();
        new Thread(futureTask2).start();
        try {
            Object o = futureTask.get();
            List<CallerTask> list = futureTask2.get();
            System.out.println("-----" + o.toString());
            System.out.println("-----" + list.size());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CallerTask";
    }
}
