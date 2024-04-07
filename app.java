import java.util.Scanner;


public class app {
    public static void main(String[] args) {
        // 
        System.out.println("Welcome to Lock in Hub!\n");
        System.out.println("Pick the type of study technique you want to use: ");
        System.out.println("1. Pomodoro Technique"); // THIS IS DONE
        System.out.println("2. Pareto Analysis"); //Areej 
        System.out.println("3. Eat The Frog"); // Kentaro is doing
        System.out.println("4. Oliver Burkeman’s 3/3/3 Method"); //Areej 
        System.out.println("5. The Feymnan Technique");
        System.out.println("6. The calendar method");

        // Scanner object -- sc
        Scanner sc = new Scanner(System.in);
        System.out.println("Choice: ");
        int userChoice = sc.nextInt();

        // if statement to accomadate all the user choices 
        if(userChoice == 1){
            // calls the class
            Pomodoro p = new Pomodoro();
            new gui();
            p.start();  // DONE
            
        }

        if (userChoice == 2) {
          Pareto p = new Pareto();
          new gui();
          p.start();
            
        }

        if(userChoice == 3 ) {
            EatTheFrog e = new EatTheFrog();
            new gui();
            e.start(sc);


        }
        if(userChoice == 4 ) {
            Oliver o = new Oliver();
            new gui();
             o.startOliver();

        }
        if(userChoice == 5) {
            FeynmanTechnique f = new FeynmanTechnique();
            new gui();
            f.startFeynmanTechnique();

        }
        if (userChoice == 6){
            TimeBlock t = new TimeBlock();
            t.setupTasks();
        }

        
    }
} 
