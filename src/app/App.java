package app;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class App {
    private final int threadsCount;
    private final int maxPauseMs;

    private final CyclicBarrier barrier;

    public App (int threadsCount, int maxPauseMs){
        this.threadsCount = threadsCount;
        this.maxPauseMs = maxPauseMs;
        barrier = new CyclicBarrier(threadsCount + 1);

        for (int i = 0; i < threadsCount; i++) {
            new TimerThread().start();
        }
    }

    public static void main(String[] args) {
        App experiment = new App(5, 500);

        Scanner sc = new Scanner(System.in);
        String s = "y";

        while(true) { 
            if ("y".equalsIgnoreCase(s)) {
                experiment.go();
            }
            else {
                experiment.go();
                break;
            }

            System.out.println("Для продолжения введите \"y\"");
            System.out.println("Для окончания введите любое другое сообщения");
            s = sc.nextLine();
        }

        sc.close();
    }

    private void go(){
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(maxPauseMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    class TimerThread extends Thread{

        TimerThread(){
            super();
            setDaemon(true);
        }

        @Override
        public void run() {
            super.run();

            while(true){
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                doit();
            }
        }

        void doit(){

            Long time1 = (new Date()).getTime();
            
            try {
                Thread.sleep(new Random().nextInt(maxPauseMs));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Long time2 = (new Date()).getTime();

            System.out.println("Поток " + this.getName() + " спал \"" + (time2 - time1) + "\" мс");
        }
    }
}