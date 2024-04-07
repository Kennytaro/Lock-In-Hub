import java.util.TimerTask;
import java.util.Timer;
import java.util.Scanner;

/**
 * WILL RUN INFINITELY UNLESS STOPPED BY USER
 **/ 
public class Pomodoro {
    // counter to count if it run 4 times :)
    private int counter = 0;

    // Pomodoro timer
    private static final int POMODORO_DURATION = 25 * 60; // 25 minutes in seconds (25 * 60)
    private static int remainingTimeP = POMODORO_DURATION;

    // Break timer 
    private static final int BREAK_DURATION = 5 * 60; // 5 minutes in seconds (5 * 60)
    private static int remainingTimeB = BREAK_DURATION;

    // Long break timer
    private static final int LONG_BREAK_DURATION = 15 * 60; // 15 minutes in seconds (15 * 60)
    private static int remainingTimeL = LONG_BREAK_DURATION;

    public int getCounter(){
        return counter;
    }

    public void addCounter(int x){
        this.counter += x;
    }

    public void setCounter(int x){
        this.counter = x;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to start your Pomodoro timer? (y/n)");
        char userChoice = sc.next().charAt(0);

        if (Character.toLowerCase(userChoice) == 'y') {
            startTimer();
        }
        else{
            System.out.println("ok bye");
        }
        
    }

    public static void main(String[] args) {
        Pomodoro p = new Pomodoro();
        p.start();
    }


    public void startTimer() {
        System.out.println("\nTimer has started!");
        remainingTimeP = POMODORO_DURATION;
        addCounter(1);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                remainingTimeP--;
                if (remainingTimeP >= 0) {
                    int minutes = remainingTimeP / 60;
                    int seconds = remainingTimeP % 60;
                    System.out.printf("\rTime Remaining: %02d:%02d", minutes, seconds);
                } else {
                    System.out.println("\nPomodoro Completed!");
                    timer.cancel();
                    startBreak(); // go take a break
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); // Update every second
    }

    public void startBreak() {
        System.out.println("\nBreak Time!");
        remainingTimeB = BREAK_DURATION;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                remainingTimeB--;
                if (remainingTimeB >= 0) {
                    int minutes = remainingTimeB / 60;
                    int seconds = remainingTimeB % 60;
                    System.out.printf("\rBreak Time Remaining: %02d:%02d", minutes, seconds);
                } else {
                    System.out.println("\nBreak Completed!\n");
                    timer.cancel();
                    if(getCounter() == 4){
                        System.out.println("Congrats! You have completed 4 Pomodoros. Take a longer break!\n");
                        longBreak();
                    }
                    else{
                        startTimer(); // start another Pomodoro
                    }
                    //startTimer(); // start another Pomodoro
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); // Update every second
    }

    public void longBreak(){
        System.out.println("\nTime for your long break!");
        remainingTimeL = LONG_BREAK_DURATION;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                remainingTimeL--;
                if (remainingTimeL >= 0) {
                    int minutes = remainingTimeL / 60;
                    int seconds = remainingTimeL % 60;
                    System.out.printf("\rTime Remaining: %02d:%02d", minutes, seconds);
                } else {
                    System.out.println("\nLong Break Completed!\n");
                    timer.cancel();
                    setCounter(0);
                    startTimer(); // restart timer 
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); // Update every second 
    }
}
