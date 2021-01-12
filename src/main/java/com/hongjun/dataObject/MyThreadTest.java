package com.hongjun.dataObject;

/**
 * @author hongjun500
 * @date 2021/1/12 22:52
 * @tool ThinkPadX1隐士
 * Created with 2019.3.2.IntelliJ IDEA
 * Description:
 */
public class MyThreadTest {
    // 继承Thread类并重写其run方法
    public static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("这是继承Thread类的线程！！！");
        }
    }

    public static void main(String[] args) {
        // 创建线程
        MyThread myThread = new MyThread();
        // 启动线程
        myThread.start();
    }
}
