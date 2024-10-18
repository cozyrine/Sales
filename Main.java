import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        // Ask agent to choose their name
        System.out.println("Please enter your name: ");
        String agentName = myObj.nextLine();

        // Create an Agent object with the chosen name
        Agent agent = new Agent(agentName);

        int x;
        System.out.println("How many sales you want to submit?");
        x = myObj.nextInt();

        // Arrays to store the plan names and TPD values
        String[] planNames = new String[x];
        int[] tpdValues = new int[x];


        // Loop to collect input for each sale
        for (int i = 0; i < x; i++) {
            myObj.nextLine();  // Consume the leftover newline character
            String planname;
            int tpd;

            System.out.println("Plan name: ");
            planname = myObj.nextLine();  // Read the plan name

            System.out.println("TPD: ");
            tpd = myObj.nextInt();  // Read the TPD value

            // Store the values in arrays
            planNames[i] = planname;
            tpdValues[i] = tpd;

        }

        // Print all stored plan names and TPD values at the end
        System.out.print(agent.getName() + ":");
        for (int i = 0; i < x; i++) {
            System.out.println(planNames[i] + tpdValues[i]);
        }
    }
}