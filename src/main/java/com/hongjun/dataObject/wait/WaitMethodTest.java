package com.hongjun.dataObject.wait;

/**
 * @author hongjun500
 * @date 2021/1/14 22:55
 * @tool ThinkPadX1隐士
 * Created with 2019.3.2.IntelliJ IDEA
 * Description:
 */
public class WaitMethodTest {
    // 创建资源
    private volatile static Object resourceA = new Object();
    private volatile static Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 获取resourceA共享资源的监视器锁
                    synchronized (resourceA){
                        System.out.println("threadA get resourceA lock");

                        // 获取resourceA共享资源的监视器锁
                        synchronized (resourceB){
                            System.out.println("threadA get resourceB lock");

                            // 线程A阻塞，并释放获取到的resourceA的锁
                            System.out.println("threadA release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 休眠一秒
                    Thread.sleep(1000);

                    // 获取resourceA共享资源的监视器锁
                    synchronized (resourceA){
                        /**
                         * resourceA的锁被线程threadA释放了，这两句可以打印出
                         */
                        System.out.println("threadB get resourceA lock");

                        System.out.println("threadB try get resourceB lock.........");

                        // 获取resourceB共享资源监视器的锁
                        synchronized(resourceB){

                            /**
                             * 以下两句不会被打印，因为resourceB的锁并没有被线程threadA释放
                             */
                            System.out.println("threadB get resourceB lock");

                            // 线程B阻塞，并释放获取到的resourceA的锁
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动A、B线程
        threadA.start();
        threadB.start();

        // 等待线程结束
        threadA.join();
        threadB.join();
    }
}
