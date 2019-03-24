// Сборка проекта
package app;

// Импорт
import java.util.concurrent.CyclicBarrier;
//import java.util.Scanner;

// Главный класс
public class App {
    private static thread_res tRes = new thread_res();
    //private static CyclicBarrier tBarrier = new CyclicBarrier(1, new thread_res());
    private static CyclicBarrier tBarrier = new CyclicBarrier(1, tRes);

    public static void main(String[] args) throws Exception {
        app.thread_test tTest = new app.thread_test();
        boolean tRepeater = true;
        
        while (tRepeater) {
            //tRepeater = tRes.getRepeate();
            tRepeater = tRes.repeate;

            tTest.run();    

            if (tRepeater) {
                tBarrier.await();
            }
        }    
    }
}


    /*
    private static final CyclicBarrier BARRIER = new CyclicBarrier(3, new FerryBoat());
    //Инициализируем барьер на три потока и таском, который будет выполняться, когда
    //у барьера соберется три потока. После этого, они будут освобождены.

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 9; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(400);
        }
    }

    //Таск, который будет выполняться при достижении сторонами барьера
    public static class FerryBoat implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("Паром переправил автомобили!");
            } catch (InterruptedException e) {
            }
        }
    }

    //Стороны, которые будут достигать барьера
    public static class Car implements Runnable {
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к паромной переправе.\n", carNumber);
                //Для указания потоку о том что он достиг барьера, нужно вызвать метод await()
                //После этого данный поток блокируется, и ждет пока остальные стороны достигнут барьера
                BARRIER.await();
                System.out.printf("Автомобиль №%d продолжил движение.\n", carNumber);
            } catch (Exception e) {
            }
        }
    }
    */

    /*
    static CyclicBarrier barrier = new CyclicBarrier(5, new thread_res());

    public static void main(String[] args) throws Exception {
        

        System.out.println("Потоки больше не проснутся!");
    }
    */


/*
for (int i = 0; i < 5; i ++) {
            app.thread_test testThread = new app.thread_test();
            app.thread_res res = new thread_res();
            res.sync = testThread.getSleep_time();
            
            synchronized(testThread) {
                while (true) {
                    testThread.start();
                    testThread.wait();
                    break;
                }

                testThread.notifyAll();
            }
        }
        
        System.out.println("Потоки больше не проснутся!");
*/


/*
// Отработка потоков
        for (int i = 0; i < 5; i ++) {
            app.thread_test testThread = new app.thread_test();
            testThread.start();
        }

        System.out.println("Потоки спят!");
*/


/*
// Отработка потоков      
        for (int i = 0; i < 5; i ++) {
            app.thread_test testThread = new app.thread_test();
            app.thread_res pivot = new app.thread_res();
            
            pivot.sync = testThread.getSleep_time();
            
            synchronized(pivot) {
                testThread.start();
                testThread.wait();
            }
            //System.out.println(pivot.sync);
        }      
*/


/*
private static final CyclicBarrier BARRIER = new CyclicBarrier(3, new FerryBoat());
    //Инициализируем барьер на три потока и таском, который будет выполняться, когда
    //у барьера соберется три потока. После этого, они будут освобождены.

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 9; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(400);
        }
    }

    //Таск, который будет выполняться при достижении сторонами барьера
    public static class FerryBoat implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("Паром переправил автомобили!");
            } catch (InterruptedException e) {
            }
        }
    }

    //Стороны, которые будут достигать барьера
    public static class Car implements Runnable {
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к паромной переправе.\n", carNumber);
                //Для указания потоку о том что он достиг барьера, нужно вызвать метод await()
                //После этого данный поток блокируется, и ждет пока остальные стороны достигнут барьера
                BARRIER.await();
                System.out.printf("Автомобиль №%d продолжил движение.\n", carNumber);
            } catch (Exception e) {
            }
        }
    }

*/