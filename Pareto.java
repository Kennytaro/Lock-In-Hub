import java.util.Scanner;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

public class Pareto {
    static ArrayList<Task> tasks = new ArrayList<>(); // Moved outside of main method
    // Break timer
    private static final int FIVE_DURATION = 5 * 60; // 5 minutes in seconds (5 * 60)
    private static int remainingTime = FIVE_DURATION;

    public static void main(String[] args) {
      Pareto p = new Pareto();
      p.start();
    }

    public void start(){
        System.out.println("\nThank you for choosing the Pareto technique! This will ensure 80% of your outcome. Good luck studying!");

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("*** 80/20% Rule ***");
            System.out.println("1. Start a timed Reflection Process");
            System.out.println("2. Create Tasks");
            System.out.println("3. Pace yourself in completion of tasks based on importance");
            System.out.println("3. Exit");
            System.out.println("Enter 1 to start: ");

            int userChoice = scan.nextInt();
            scan.nextLine();

            switch (userChoice) {
                case 1:
                    listStart(scan);
                    break;
                case 2:
                    viewObjectives(); // Removed unnecessary parameter
                    break;
                case 3:
                    System.out.println("Exiting the Pareto program...");
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }
    public static void listStart(Scanner scan) { // Added Scanner as a parameter
        System.out.println("\nReflect on the following: \nWhat are the main things that distract you while studying?\nWhat help you stay locked in?\nWhat tasks do I need to focus on during this study session? \nA timer for 5 minutes will start as you jot down the root of the issue and techniques that might help");
        // Start the 5-minute timer (this wont work) thankssss!!!!
        // yeah gimme a sec i'll fix it for u
        remainingTime = FIVE_DURATION;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                remainingTime--;
                if (remainingTime >= 0) {
                    int minutes = remainingTime / 60;
                    int seconds = remainingTime % 60;
                    System.out.printf("\rTime left: %02d:%02d", minutes, seconds);
                } else {
                    timer.cancel(); // timer completed
                    System.out.println("\nReflection time is up!");
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); // Update every second

        // Get user's notes within the 5-minute timeframe
        String notes = scan.nextLine();

        System.out.println("\nDefine up to 3 tasks for today's session: ");
        ArrayList<String> objectives = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter task " + (i + 1) + " (or leave blank to skip): ");
            String objective = scan.nextLine();
            if (!objective.isEmpty()) {
                objectives.add(objective);
            }
        }

        for (String objective : objectives) {
            int importance;
            do {
                System.out.print("\nEnter the importance of \"" + objective + "\" (0-10): ");
                importance = scan.nextInt();
                scan.nextLine(); // Consume newline
            } while (importance < 0 || importance > 10);

            Task t = new Task(objective, importance);
            tasks.add(t);
        }

        System.out.println("\nSummary of your Task Reflection:\n");
        System.out.println("Notes: " + notes);
        System.out.println("Tasks in accordance to most important:");
        for (Task t : tasks) {
            System.out.println("- " + t.objective + " (# of Importance: " + t.importance + ")");
        }
    }

    private static void viewObjectives() {
        System.out.println("\n*** Your Tasks ***");
        if (tasks.isEmpty()) {
            System.out.println("No tasks have been entered yet.");
        } else {
            for (Task task : tasks) {
                System.out.println("- " + task.objective + " (Importance: " + task.importance + ")");
            }
        }
    }

    static class Task {
        String objective;
        int importance;

        public Task(String objective, int importance) {
            this.objective = objective;
            this.importance = importance;
        }
    }
}

