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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最后end");
    }
}