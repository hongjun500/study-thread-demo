package com.hongjun.domain;

import com.hongjun.StudyThreadDemoApplication;
import org.springframework.boot.SpringApplication;

/**
 * @author hongjun500
 * @date 2020/12/15 21:41
 * @tool ThinkPadX1隐士
 * Created with 2019.3.2.IntelliJ IDEA
 * Description:
 */
public class TestJoinThread {
    public static void main(String[] args) {
        System.out.println("先start");
        Thread t = new Thread(() -> { System.out.println("再hello"); });
        t.start();
        try {
            // main线程通过join方法等待t线程结束后再继续执行打印 最后end，那么最终打印结果将是这个 1先start 2再hello 3最后end
            // 这个join方法被注释后最后的打印结果将是 1 先start,2 最后end,3 再hello
            t.join();
            // join方法源码:如下
            /**
             * public final void join() throws InterruptedException {
             *                 join(0);
             *             }
             */
            // 如上可以看出还有一个重载方法，入参表示毫秒数，代表这个等待线程结束的时间（和sleep方法有出入），超过了等待时间就不再继续等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最后end");
    }
}