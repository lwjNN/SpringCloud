package atguigu.com;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lwj
 * @date 2020/8/17 18:21
 */
public class Test1 {

    public volatile int sum = 0;
    public  void addOne(){
        sum++;
    }
    AtomicInteger atomicInteger = new AtomicInteger(0);
    public  void addAtomic(){
        atomicInteger.getAndIncrement();
    }
    public static void main(String[] args) {
//        AtomicInteger atomicInteger = new AtomicInteger(0);
//        System.out.println(atomicInteger.compareAndSet(5, 2019));
//        System.out.println(atomicInteger.compareAndSet(5, 2020));
        Test1 t1 = new Test1();
        for (int i = 1; i<=20; i++){
            new Thread(() ->{
                for (int j = 0; j < 1000; j++) {
                    t1.addOne();
                    t1.addAtomic();
                }
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println("使用volatile修饰的sum求和：" + t1.sum);
        System.out.println("使用JUC中原子类递增结果：" + t1.atomicInteger);

//        Test1 t1 = new Test1();
//        new Thread(() ->{
//            System.out.println(Thread.currentThread().getName() + "come in ");
//            try{
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            t1.addOne();
//            System.out.println(Thread.currentThread().getName() + "update number:" + t1.sum);
//        },"input thread name").start();
//
//        while (t1.sum == 0){
//
//        }
//        System.out.println("over");
    }
}
