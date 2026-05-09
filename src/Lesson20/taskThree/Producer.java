package Lesson20.taskThree;

public class Producer extends Thread{
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            store.produce(i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
