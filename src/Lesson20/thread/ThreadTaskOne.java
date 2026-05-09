package Lesson20.thread;

public class ThreadTaskOne extends Thread {

    private int[] array;
    private boolean findMin;

    public ThreadTaskOne(int[] array, boolean findMin) {
        this.array = array;
        this.findMin = findMin;
    }

    @Override
    public void run() {

        int result = array[0];

        if (findMin) {
            for (int i = 1; i < array.length; i++) {
                if (array[i] < result) {
                    result = array[i];
                }
            }
            System.out.println("Минимум: " + result);
        } else {
            for (int i = 1; i < array.length; i++) {
                if (array[i] > result) {
                    result = array[i];
                }
            }
            System.out.println("Максимум: " + result);
        }
    }
}