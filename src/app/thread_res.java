// Сборка проект
package app;

// Импорт
import java.util.Scanner;

// Ресурсы синхронизации
class thread_res implements Runnable {
    static Scanner scanner = new Scanner(System.in);
    
    private String answer = "Y";
    public boolean repeate = true;

    private void setRepeate() {
        if(answer == "N") {
            repeate = false;
        }
    }

    private void setAnswer() {
        System.out.print("Ответ: "); answer = scanner.nextLine();
        setRepeate();
    }

    public boolean getRepeate() {
        return repeate;
    }

    @Override
    public void run() {
        System.out.println("Разбудить потоки? (Y/N)");
        setAnswer();
    }
}
