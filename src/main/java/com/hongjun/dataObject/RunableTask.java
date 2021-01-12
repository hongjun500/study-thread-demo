package com.hongjun.dataObject;

/**
 * @author hongjun500
 * @date 2021/1/12 22:58
 * @tool ThinkPadX1隐士
 * Created with 2019.3.2.IntelliJ IDEA
 * Description:
 */
public class RunableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("这是实现Runable接口的线程");
    }

    public static void main(String[] args) {
        RunableTask runableTask = new RunableTask();
        // 启动
        Thread thread = new Thread(runableTask);
        // 线程命名
        thread.setName("RunableTask");
        thread.start();
        System.out.println(thread.getName());

        // 会打印出main
        System.out.println(Thread.currentThread().getName());
        // new Thread(runableTask).start();
    }
}
