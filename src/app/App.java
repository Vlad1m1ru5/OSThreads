// Сборка проекта
package app;

// Импорт
import java.util.Scanner;

// Главный класс
public class App {

    static Scanner scanner = new Scanner(System.in);
    static String input;

    public static void main(String[] args) throws Exception {
        
        for (int i = 0; i < 5; i ++) {
            app.thread_test testThread = new app.thread_test();
            testThread.start();
        }
    
    }
}