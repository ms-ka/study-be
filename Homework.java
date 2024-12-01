package HW_01;

//!! ==== Multi-threading======

//Дан диапазон чисел: от 1 до 2_000_000 включительно.
//Задача: найти, сколько чисел из этого диапазона делятся нацело на 21 и при этом содержат цифру 3.
//Решить данную задачу в один поток.
//Решить данную задачу в два потока, разделив между потоками заданный диапазон чисел пополам.
//Сравнить результаты двух решений - они должны совпадать.


public class Homework {
    private static int counter;

    // synchronized zabezpiecza, ze tylko jeden potok działa, inne czekają
    public static synchronized void incrementCounter() {
        counter++;
    }

    //pole jest statyczne aby móc zmieniać w nim zmienne
    public static void main(String[] args) {
        int counter1 = withOneThread();
        counter = 0;
        int counter2 = withTwoThread();
        System.out.println((counter1 == counter2) ? "are the same" : "are different");
    }

    public static int withTwoThread() {
        CheckThread myThread2 = new CheckThread(1, 1_000_000);
        CheckThread myThread3 = new CheckThread(1_000_000, 2_000_000);

        myThread2.start();
        myThread3.start();

        try {
            myThread2.join();
            myThread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter two: " + counter);
        return counter;
    }
        public static int withOneThread() {
            CheckThread myThread1 = new CheckThread(1, 2_000_000);
            myThread1.start();

            try {
                myThread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Counter value: " + counter);
            return counter;
        }
}
