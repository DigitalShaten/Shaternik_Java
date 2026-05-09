package Lesson20.taskThree;

public class Consumer extends Thread{
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for(int i = 1; i <=5; i ++) {
            store.consume();

            try {
                Thread.sleep(300);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
