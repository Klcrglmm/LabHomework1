public class RunnerSort {
    private final String[] names;
    private final int[] minutes;

    public RunnerSort(String[] names, int[] minutes) {
        this.names = names;
        this.minutes = minutes;
    }

    private String firstPerson;
    private String secondPerson;
    private String thirdPerson;

    private int lowestMinute() {
        int lowestMin = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length; i++) {
            if (lowestMin > minutes[i]) {
                lowestMin = minutes[i];
                firstPerson = names[i];
            }
        }
        return lowestMin;
    }

    private int secondMinute() {
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length; i++) {
            if (minutes[i] > lowestMinute() && secondMin > minutes[i]) {
                secondMin = minutes[i];
                secondPerson = names[i];
            }
        }
        return secondMin;
    }

    private int thirdMinute() {
        int thirdMin = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length; i++) {
            if (thirdMin > minutes[i] && minutes[i] != lowestMinute() && minutes[i] != secondMinute()) {
                thirdMin = minutes[i];
                thirdPerson = names[i];
            }
        }
        return thirdMin;
    }

    public void outputRating() {
        thirdMinute();// ı used to the method to assign value to firstPerson, secondPerson, thirdPerson
        // if ı didn't use this, they would be written first(they would be appear 'null') and then assigned values
        System.out.println("Birinci: " + firstPerson + " " + lowestMinute() + "'");
        System.out.println("İkinci: " + secondPerson + " " + secondMinute() + "'");
        System.out.println("Üçüncü: " + thirdPerson + " " + thirdMinute() + "'");
    }

    public void outputBarChart() {
        int[] frequency = new int[3];
        for (int minute : minutes) {
            frequency[(minute / 100) - 2]++;
        }
        System.out.println("A -> " + frequency[0]);
        System.out.println("B -> " + frequency[1]);
        System.out.println("C -> " + frequency[2]);
    }
}