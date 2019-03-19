
// Проект 
package app;


// Мой тестовый поток
public class thread_test extends Thread {

    private long sleep_time = 0;
 
    private void setSleep_time(long timer) {
        this.sleep_time = 1 + (long)(Math.random() * (1000 - 1));
    }

    @Override
    public void run() {
        
        try {
            this.setSleep_time(this.sleep_time);
            Thread.sleep(this.sleep_time);
            System.out.println("Привет! Мой номер потока " + getId() % 10 + ". Я спал " + this.sleep_time + " мс.");
        } 
        catch (InterruptedException e) {
            // Следующая строка генерируется автоматически
            //e.printStackTrace();
            System.out.println("Поток устал и отказывается работать!");
        }
        finally {
            ///
        }
           
    }
}