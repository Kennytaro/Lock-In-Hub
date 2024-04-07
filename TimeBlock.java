import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TimeBlock {
    private Timer timer;
    private int seconds;
    private String[] tasks;
    private Scanner scanner;

    public TimeBlock() {
        System.out.println("Nice that you chose this method");
        setupTasks();
    }

    public void setupTasks() {
        scanner = new Scanner(System.in);
        System.out.println("How many tasks do you have to complete today?");
        int numberTasks = Integer.parseInt(scanner.nextLine());
        if (numberTasks <= 0) {
            System.out.println("No tasks to complete. Good job!");
            return;
        }

        tasks = new String[numberTasks];

        // Input task names
        for (int i = 0; i < numberTasks; i++) {
            System.out.print("Enter task " + (i + 1) + ": ");
            tasks[i] = scanner.nextLine();
        }

        // Print tasks
        System.out.println("Here are your tasks:");
        for (int i = 0; i < numberTasks; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }

        chooseTask();
    }

    public void chooseTask() {
        System.out.print("Enter the number of the task you want to start: ");
        int chosenTaskNumber = Integer.parseInt(scanner.nextLine());
        if (chosenTaskNumber < 1 || chosenTaskNumber > tasks.length) {
            System.out.println("Invalid task number. Please enter a number between 1 and " + tasks.length + ".");
            chooseTask();
            return;
        }

        System.out.println("You chose Task " + chosenTaskNumber + ": " + tasks[chosenTaskNumber - 1]);
        System.out.println("Press 'Enter' to start the task.");
        scanner.nextLine(); // Wait for the user to press Enter

        startTimer(chosenTaskNumber);
    }

    public void startTimer(int taskNumber) {
        System.out.println("\nTimer has started. Press 'p' to stop the timer.");

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seconds++;
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                System.out.printf("\r%02d:%02d:%02d", hours, minutes, secs);
            }
        }, 0, 1000); // Update every second

        // Listen for 'p' to stop the timer
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("p")) {
                stopTimer(taskNumber);
                break;
            } else {
                System.out.println("Invalid input. Press 'p' to stop the timer.");
            }
        }
    }

    public void stopTimer(int taskNumber) {
        if (timer != null) {
            timer.cancel();
            System.out.println("\nTimer stopped for Task " + taskNumber + ": " + tasks[taskNumber - 1]);

            // Check if there are more tasks
            if (taskNumber < tasks.length) {
                System.out.println("What task do you want to do next?");
                chooseTask();
            } else {
                System.out.println("Good job! All tasks completed.");
            }
        }
    }

    public static void main(String[] args) {
        TimeBlock t = new TimeBlock();
    }
}
