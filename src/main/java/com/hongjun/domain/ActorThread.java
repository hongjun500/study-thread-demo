package com.hongjun.domain;

/**
 * @author hongjun500
 * @date 2020/12/13 15:03
 * @tool ThinkPadX1隐士
 * Created with 2019.3.2.IntelliJ IDEA
 * Description:
 */
public class ActorThread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println(getName() + "是一个演员!");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning){
            System.out.println(getName() + "登台演出:" + (++count));
            if (count >= 100){
                keepRunning = false;
            }
            if (count % 10 == 0){
                try {
                    // 线程休眠1秒
                    // System.out.println(getName() + "休息一秒!");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName() + "演出结束!");
    }
}