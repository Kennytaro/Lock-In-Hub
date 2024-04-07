import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Oliver {
    private Scanner scanner;

    public Oliver() {
        System.out.println("Nice job you chose this method!!");
    }

    public void startOliver() {
        System.out.println("Let's input the number of tasks you have to do (up to 3):");
        scanner = new Scanner(System.in);
        int numTasks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (numTasks <= 0) {
            System.out.println("No tasks to complete. Good job!");
            return;
        } else if (numTasks > 3) {
            System.out.println("Sorry, you can only input up to 3 tasks at a time.");
            return;
        }

        System.out.println("Enter the tasks:");

        String[] tasks = new String[numTasks];
        for (int i = 0; i < numTasks; i++) {
            System.out.print("Task " + (i + 1) + ": ");
            tasks[i] = scanner.nextLine();
        }

        for (int i = 0; i < numTasks; i++) {
            System.out.println("\nStarting Task " + (i + 1) + ": " + tasks[i]);
            System.out.println("Press 'Enter' to start the task.");
            scanner.nextLine(); // Wait for the user to press Enter

            ThreeHourTimer threeHourTimer = new ThreeHourTimer();
            threeHourTimer.startTimer();

            System.out.println("Press 'p' to stop the timer.");

            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("p")) {
                    threeHourTimer.stopTimer();
                    System.out.println("Timer stopped!");
                    System.out.println("Good job on Task " + (i + 1) + "!");
                    break;
                }
            }

            if (i < numTasks - 1) {
                System.out.println("\nWhat task do you want to do next?");
            }
        }

        System.out.println("\nAll tasks completed!");
    }

    public static void main(String[] args) {
        Oliver o = new Oliver();
        o.startOliver();
    }
}

class ThreeHourTimer {
    private static final int THREE_HOURS_IN_SECONDS = 3 * 60 * 60; // 3 hours in seconds
    private int remainingTimeP;

    public void startTimer() {
        System.out.println("\nTimer has started for 3 hours!");
        remainingTimeP = THREE_HOURS_IN_SECONDS;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                remainingTimeP--;
                if (remainingTimeP >= 0) {
                    int hours = remainingTimeP / 3600;
                    int minutes = (remainingTimeP % 3600) / 60;
                    int seconds = remainingTimeP % 60;
                    System.out.printf("\rTime Remaining: %02d:%02d:%02d", hours, minutes, seconds);
                } else {
                    timer.cancel(); // Stop the timer
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); // Update every second
    }

    public void stopTimer() {
        remainingTimeP = 0;
    }
}
