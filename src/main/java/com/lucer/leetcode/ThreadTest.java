package com.lucer.leetcode;

/**
 * @author: liuchuan
 */
public class ThreadTest {


    static Object lockObj = new Object();
    static volatile int printInt = 1;

    //声明一个对象，做为被锁的对象；
    // 由同步锁来对该对象上锁；
    // 在某一线程占有该对象时，判断是否可以打印（满足条件），不能打印则释放该对象（wait方法），同时通知需要该对象的其它线程（notifyAll-唤醒其它线程->进入就绪状态）
    public static void main(String[] args) {
        Thread threadFirst = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockObj) {
                    while (printInt <= 100) {
                        if (printInt % 3 == 1) {
                            System.out.println("threadName" + Thread.currentThread().getName() + ";i===" + printInt++);
                        }
                        lockObj.notifyAll();
                        if (printInt == 101) {//这里是个小坑;最后一次不执行wait()方法
                            return;
                        }
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread threadSecond = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockObj) {
                    while (printInt <= 100) {
                        if (printInt % 3 == 2) {
                            System.out.println("threadName" + Thread.currentThread().getName() + ";i===" + printInt++);
                        }
                        lockObj.notifyAll();
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread threadThird = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockObj) {
                    while (printInt <= 100) {
                        if (printInt % 3 == 0) {
                            System.out.println("threadName" + Thread.currentThread().getName() + ";i===" + printInt++);
                        }
                        lockObj.notifyAll();
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        threadFirst.start();
        threadSecond.start();
        threadThird.start();
    }


}
