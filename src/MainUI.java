import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("OS Scheduler Visualizer");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel title = new JLabel("Smart OS Process Scheduler", SwingConstants.CENTER);
        title.setBounds(150, 20, 300, 30);
        frame.add(title);

        // Input label
        JLabel label = new JLabel("Enter Burst Times (comma separated):");
        label.setBounds(50, 80, 250, 30);
        frame.add(label);

        // Text field
        JTextField inputField = new JTextField();
        inputField.setBounds(50, 110, 500, 30);
        frame.add(inputField);

        //  Button
        JButton runButton = new JButton("Run FCFS");
        runButton.setBounds(220, 170, 150, 40);

        // Button action
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String input = inputField.getText();
                String[] parts = input.split(",");

                int n = parts.length;
                int[] bt = new int[n];
                int[] wt = new int[n];
                int[] tat = new int[n];

                // Convert string to integers
                for (int i = 0; i < n; i++) {
                    bt[i] = Integer.parseInt(parts[i].trim());
                }

                // FCFS Waiting Time
                wt[0] = 0;
                for (int i = 1; i < n; i++) {
                    wt[i] = wt[i - 1] + bt[i - 1];
                }

                // Turnaround Time
                for (int i = 0; i < n; i++) {
                    tat[i] = wt[i] + bt[i];
                }
                // 123
                GanttChartPanel chart = new GanttChartPanel(bt);
                JOptionPane.showMessageDialog(frame, chart, "Gantt Chart", JOptionPane.PLAIN_MESSAGE);

                // Build result string
                StringBuilder result = new StringBuilder();
                result.append("Process\tBT\tWT\tTAT\n");

                for (int i = 0; i < n; i++) {
                    result.append("P").append(i + 1)
                            .append("\t")
                            .append(bt[i]).append("\t")
                            .append(wt[i]).append("\t")
                            .append(tat[i]).append("\n");
                }

                JTextArea textArea = new JTextArea(result.toString());
                textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
                textArea.setEditable(false);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(350, 200));

                JOptionPane.showMessageDialog(frame, scrollPane, "FCFS Result", JOptionPane.INFORMATION_MESSAGE);

            }
        });


        frame.add(runButton);
        frame.setVisible(true);
    }
}



