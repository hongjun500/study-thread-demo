package com.hongjun.domain;

/**
 * @author hongjun500
 * @date 2020/12/15 22:08
 * @tool ThinkPadX1隐士
 * Created with 2019.3.2.IntelliJ IDEA
 * Description: 测试中断线程
 */
public class TestInterruptThread {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        try {
            Thread.sleep(1); // 暂停1毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // t.interrupt(); // 中断t线程
        try {
            t.join(); // 等待t线程结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       /* HelloThread helloThread = new HelloThread();
        helloThread.start();
        helloThread.running = false;*/
        System.out.println("end");
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        System.out.println("gggggggg" + isInterrupted());
        while (! isInterrupted()){
            n ++;
            if (n == 10){
                // 当n为10的时候就中断此线程
                interrupt();
                try {
                    join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 线程中断之后在调用join会抛出异常
                    // 并清除中断状态，即isInterrupted() 会返回false，如果没有break的话，while会条件会一直返回true，就死循环了；
                    System.out.println("dd" + isInterrupted());
                    //手动再次中断
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("第" + n + "次" + "打印hello");
        }
    }
}
class HelloThread extends Thread {
    // 定义线程退出标志
    public volatile boolean running = true;
    @Override
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}