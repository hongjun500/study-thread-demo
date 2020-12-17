package com.hongjun.domain;

/**
 * @author hongjun500
 * @date 2020/12/17 11:31
 * @tool ThinkPadX1隐士
 * Created with 2019.3.2.IntelliJ IDEA
 * Description:
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        /*Thread.currentThread().setName("MyThread方法名");
        System.out.println("方法名" + getName());*/
        while (!isInterrupted()) {
            System.out.println("执行业务逻辑代码的run方法");
        }
    }
}
