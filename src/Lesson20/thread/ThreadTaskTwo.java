package Lesson20.thread;

public class ThreadTaskTwo implements Runnable{
    private int[] arrayOfNumber;
    private String type;

    public ThreadTaskTwo(int[] arrayOfNumber, String type) {
        this.arrayOfNumber = arrayOfNumber;
        this.type = type;
    }

    @Override
    public void run() {
        switch (type) {
            case "INSERTION" -> insertionSort(arrayOfNumber);
            case "SELECTION" -> selectionSort(arrayOfNumber);
            case "BUBBLE" -> bubbleSort(arrayOfNumber);
        }

        System.out.println(type + ": " + java.util.Arrays.toString(arrayOfNumber));
    }

    private void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
