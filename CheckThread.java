package HW_01;

public class CheckThread extends Thread {

    private final int startRange;
    private final int endRange;

    //Constructor
    public CheckThread(int startRange, int endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }
    //Run
        @Override
        public void run() {

            //Liczby z zakresu od 1 do 2_000_000, które dzielą się przez 21 i zawierają cyfrę 3.
            //końcówka od dzielenia przez 21 musi równać się 0
            //przekształcić liczbę w string i sprawdzić czy w nim miesci sie 3. Contain zwróci true jesli jest 3
            for (int i = startRange; i <= endRange; i++) {
                if (i % 21 == 0 && String.valueOf(i).contains("3")) {
                    Homework.incrementCounter();
                }
            }
        }
    }