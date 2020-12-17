package com.hongjun.testCreadThread;

/**
 * @author hongjun500
 * @date 2020/12/16 17:09
 * @tool ThinkPadX1隐士
 * Created with 2019.3.2.IntelliJ IDEA
 * Description:
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 执行业务逻辑代码
        System.out.println("hello, Runnable-------" + Thread.currentThread());
    }

    public static void main(String[] args) throws InterruptedException {
        // 这种方法是不建议使用的
        Thread thread = new Thread(new MyRunnable());
        // 为线程搞一个名字
        thread.setName("oneThread");
        thread.start();
        Thread thread1 = new Thread(new MyRunnable());
        thread1.setName("twoThread");
        thread1.start();
        System.out.println("end");
    }
}
