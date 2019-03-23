// Сборка проект 
package app;

// Мой тестовый поток
public class thread_test extends Thread {
    private long sleep_time = 0;

    private void randSleep_time() {  
        this.sleep_time = 1 + (long)(Math.random() * (1000 - 1));
    }

    public long getSleep_time() {
        return this.sleep_time;
    }

    @Override
    public synchronized void run() {
        try {
            this.randSleep_time();
            Thread.sleep(this.sleep_time);
        } catch (InterruptedException e) {
            System.out.println("Поток " + getId() + " устал и отказывается работать!");
        } finally {
            System.out.println("Привет! Мой номер потока " + getId() + ". Я спал " + this.sleep_time + " мс.");
        }
    }
}
