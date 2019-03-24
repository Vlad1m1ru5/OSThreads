// Сборка проект 
package app;

// Мой тестовый поток
public class thread_test extends Thread {    
    // Конструктор
    thread_test() {
        //randSleep_time();
    }

    private long sleep_time = 0;

    // Генерация времениы сна потока
    private void randSleep_time() {  
        this.sleep_time = 1 + (long)(Math.random() * (1000 - 1));
    }

    // Вернуть время сна потока
    public long getSleep_time() {
        return this.sleep_time;
    }

    // Выполнение потока
    @Override
    public synchronized void run() {
        try {
            randSleep_time();
            Thread.sleep(this.sleep_time);
        } catch (InterruptedException e) {
            System.out.println("Поток " + getId() + " устал и отказывается работать!");
        } finally {
            System.out.println("Привет! Я поток номер " + getId() + ". Я спал " + this.sleep_time + " мс.");
        }
    }
}
