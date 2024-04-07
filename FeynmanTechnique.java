import java.util.Scanner;

public class FeynmanTechnique  {
   
    public FeynmanTechnique () { 
        System.out.println("Great! You chose this method");
        startFeynmanTechnique();
    }

    public void startFeynmanTechnique() {
        Scanner scanner = new Scanner(System.in); // declaring scanner

        System.out.println("Put in the name of your topic");
        String topicName = scanner.nextLine();

        System.out.println("Please put your notes here and we will give the next step");
        String userNotes = scanner.nextLine();
        System.out.println("Your notes: " + userNotes);

        System.out.println("Thank you for the notes, so what do we do now? COMPILE IT <3");
        System.out.println("so type here what other notes you have");
        String compileNotes = ""; // Initialize compileNotes

        String decision;
        while (true) {
            compileNotes += scanner.nextLine() + "\n"; // Append each input followed by a new line
            System.out.println("Do you want to compile the notes now? (YES/NO)");
            decision = scanner.nextLine();
            if (decision.equalsIgnoreCase("YES")) {
                break;
            } else if (decision.equalsIgnoreCase("NO")) {
                System.out.println("Continue adding notes:");
            } else {
                System.out.println("Invalid input. Please enter YES or NO.");
            }
        }

        System.out.println("Here is what we gathered : \n" + compileNotes);
    }

    public static void main(String[] args) {
        FeynmanTechnique f = new FeynmanTechnique();
        f.startFeynmanTechnique();
    }
}
