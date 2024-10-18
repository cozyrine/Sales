import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Sales extends JFrame {
    private JTextField agentNameField, planNameField, tpdField;
    private JTextArea displayArea;
    private ArrayList<String> planNames = new ArrayList<>();
    private ArrayList<Integer> tpdValues = new ArrayList<>();
    private int totalTPD = 0;

    public Sales() {
        // Set up the main window
        setTitle("Agent Sales App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Agent's name input
        add(new JLabel("Enter Agent Name:"));
        agentNameField = new JTextField(20);
        add(agentNameField);

        // Plan name input
        add(new JLabel("Plan Name:"));
        planNameField = new JTextField(20);
        add(planNameField);

        // TPD input
        add(new JLabel("TPD:"));
        tpdField = new JTextField(20);
        add(tpdField);

        // Submit button
        JButton submitButton = new JButton("Submit Sale");
        add(submitButton);

        // Display area for results
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea));

        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String planName = planNameField.getText();
                int tpd;

                try {
                    tpd = Integer.parseInt(tpdField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for TPD.");
                    return;
                }

                // Add the sales data to the list
                planNames.add(planName);
                tpdValues.add(tpd);
                totalTPD += tpd;

                // Clear the input fields after submission
                planNameField.setText("");
                tpdField.setText("");

                // Update the display area with submitted sales
                displaySales();
            }
        });
    }

    // Method to display all submitted sales and total TPD
    private void displaySales() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agent Name: ").append(agentNameField.getText()).append("\n\nSubmitted Sales:\n");

        for (int i = 0; i < planNames.size(); i++) {
            // Just show plan name followed by TPD, without labels
            sb.append(planNames.get(i)).append(" ").append(tpdValues.get(i)).append("\n");
        }

        sb.append("\nTotal TPD: ").append(totalTPD);

        // Set the text in the display area
        displayArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        // Create and display the app window
        Sales app = new Sales();
        app.setVisible(true);
    }
}
