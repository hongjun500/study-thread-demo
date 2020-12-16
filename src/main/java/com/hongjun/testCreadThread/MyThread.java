package com.hongjun.testCreadThread;

/**
 * @author hongjun500
 * @date 2020/12/16 17:07
 * @tool ThinkPadX1隐士
 * Created with 2019.3.2.IntelliJ IDEA
 * Description:
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        // 为线程搞一个名字
        Thread.currentThread().setName("MyThread");
        // 执行业务逻辑代码
        System.out.println("hello,Thread");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
