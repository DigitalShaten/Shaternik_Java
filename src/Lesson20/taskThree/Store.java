package Lesson20.taskThree;

import java.util.LinkedList;
import java.util.Queue;

public class Store {
    private final Queue<Integer> products = new LinkedList<>();
    private final static int MAZ_SIZE = 3;

    public synchronized void produce(int product) {
        try {
            while (products.size() == MAZ_SIZE) {
                wait();
            }
            products.add(product);
            System.out.println("Произведено: " + product);

            notify();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public synchronized void consume() {
        try {
            while (products.isEmpty()) {
                wait();
            }
            int product = products.poll();
            System.out.println("Куплено: " + product);

            notify();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
