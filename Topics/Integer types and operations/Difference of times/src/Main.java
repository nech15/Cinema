import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hoursFirst = scanner.nextInt();
        int minutesFirst = scanner.nextInt();
        int secondsFirst = scanner.nextInt();
        int timeFirst = hoursFirst * 60 * 60 + minutesFirst * 60 + secondsFirst;
        int hoursSecond = scanner.nextInt();
        int minutesSecond = scanner.nextInt();
        int secondsSecond = scanner.nextInt();
        int timeSecond = hoursSecond * 60 * 60 + minutesSecond * 60 + secondsSecond;
        System.out.println(timeSecond - timeFirst);

    }
}
