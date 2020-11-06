package Pro02;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;


public class Main {
    public static void main(String[] args) {
        long[] ans = new long[100];
        long a=0;
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        CountDownLatch latch = new CountDownLatch(100);
        Thread[] threads = new Thread[100];
        long before = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            int finalJ = j;
            threads[j] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (long i = finalJ * 10000000 + 1; i <= (finalJ + 1) * 10000000; i++) {
                        if (contain(i, x)) {
                            ans[finalJ] += i;
                        }
                    }
                    latch.countDown();
                }
            });
        }
        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
        try {
            latch.await();
            for(int i=0;i<100;i++){
                a+=ans[i];
            }
            long after = System.currentTimeMillis();
            System.out.println(a);
            System.out.println((after - before) / 1000+"秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
}
