//package com.company.project;
//
//import java.util.ArrayList;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//public class TestThreadMethod {
//
//
//
//    public void threadMethod() {
//
//        List<T> updateList = new ArrayList();
//        // 初始化线程池, 参数一定要一定要一定要调好！！！！
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(20, 50,
//                4, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new ThreadPoolExecutor.AbortPolicy());
//        // 大集合拆分成N个小集合, 这里集合的size可以稍微小一些（这里我用100刚刚好）, 以保证多线程异步执行, 过大容易回到单线程
//        List<T> splitNList = SplitListUtils.split(totalList, 100);
//        // 记录单个任务的执行次数
//        CountDownLatch countDownLatch = new CountDownLatch(splitNList.size());
//        // 对拆分的集合进行批量处理, 先拆分的集合, 再多线程执行
//        for (List<T> singleList : splitNList) {
//            // 线程池执行
//            threadPool.execute(new Thread(new Runnable(){
//                @Override
//                public void run() {
//                    for (Entity yangshiwen : singleList) {
//                        // 将每一个对象进行数据封装, 并添加到一个用于存储更新数据的list
//                        // ......
//
//                        // 任务个数 - 1, 直至为0时唤醒await()
//                        countDownLatch.countDown();
//                    }
//                }
//            }));
//        }
//        try {
//            // 让当前线程处于阻塞状态，直到锁存器计数为零
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            throw new BusinessLogException(ResponseEnum.FAIL);
//        }
//        // 通过mybatis的批量插入的方式来进行数据的插入, 这一步还是要做判空
//        if (GeneralUtil.listNotNull(updateList)) {
//            batchUpdateEntity(updateList);
//            LogUtil.info("xxxxxxxxxxxxxxx");
//        }
//    }
//}
