// Сборка проекта
package app;

// Импорт
import java.util.Scanner;

// Главный класс
public class App {

    static Scanner scanner = new Scanner(System.in);
 
    private synchronized void massage(){
        
    }

    public static void main(String[] args) throws Exception {
        // Отработка потоков
        for (int i = 0; i < 5; i ++) {
            app.thread_test testThread = new app.thread_test();
            app.thread_res pivot = new app.thread_res();
            
            testThread.start();
            pivot.sync = testThread.getSleep_time();

            synchronized(pivot) {
                while (true) {
                    testThread.wait();
                    break;
                }

                testThread.notifyAll();
            }

        }
    } // Конец main()
}

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
            
            synchronized(testThread) {
                while (true) {
                    testThread.start();
                    testThread.wait();
                    break;
                }

                testThread.notifyAll();
            }
        }
        
        System.out.println("Потоки спят!");
*/