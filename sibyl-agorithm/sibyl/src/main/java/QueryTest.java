import java.util.concurrent.*;

/**
 * @Classname ReturnNew
 * @Description TODO
 * @Date 2021/8/11 20:31
 * @Created by dyingleaf3213
 */
public class QueryTest {


    public static void main(String[] args) {
//        blockingMode();//阻塞 => 250+
        concurrentMode();//并发 => 150+

    }



    //并发
    public static void concurrentMode(){
        QueryTest test = new QueryTest();
        Long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer[]> futureA = executorService.submit(test::queryA);
        Future<Integer[]> futureB = executorService.submit(test::queryB);

        try {
            futureA.get();//阻塞
            futureB.get();//阻塞
        } catch (Exception e) {
        }


        Long cost = System.currentTimeMillis() - startTime;

        executorService.shutdown();
        System.err.println("cost => " + cost);
    }

    //阻塞
    public static void blockingMode() {
        QueryTest test = new QueryTest();
        Long startTime = System.currentTimeMillis();
        Integer[] a = test.queryA();
        Integer[] b = test.queryB();
        Long cost = System.currentTimeMillis() - startTime;
        System.err.println("cost => " + cost);
    }

    public Integer[] queryA(){
        sleep(100L);
        return of(1,2,3,4,5);
    }

    public Integer[] queryB(){
        sleep(150L);
        return of(6,7,8,9,10);
    }
    public static void sleep(Long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static <T> T[] of(T... value){
        return value;
    }
}
