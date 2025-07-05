import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JLabel balanceLabel;
    private JButton fatherButton;
    private JButton sonButton;
    private BankAccount account;

    public Main() {
        account = new BankAccount(0);

        setTitle("Data Inconsistency");
        setSize(800, 200);
        setLocationRelativeTo(null); // Center the window on screen
        setResizable(false); // Disable maximize button
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3, 10, 10));

        // Left Panel (Father)
        JPanel fatherPanel = new JPanel();
        fatherPanel.setBorder(BorderFactory.createTitledBorder("Father"));
        fatherPanel.setLayout(new BoxLayout(fatherPanel, BoxLayout.Y_AXIS));

        JLabel depositLabel = new JLabel("Deposit Amount:");
        JLabel depositAmount = new JLabel("1000000");
        fatherButton = new JButton("Deposit");

        depositLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        depositAmount.setAlignmentX(Component.CENTER_ALIGNMENT);
        fatherButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        fatherPanel.add(depositLabel);
        fatherPanel.add(depositAmount);
        fatherPanel.add(Box.createVerticalStrut(10));
        fatherPanel.add(fatherButton);

        // Center Panel (Balance)
        JPanel balancePanel = new JPanel();
        balancePanel.setLayout(new BorderLayout());
        balancePanel.setBorder(BorderFactory.createTitledBorder("Balance"));

        balanceLabel = new JLabel("" + account.getBalance(), SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 24));
        balancePanel.add(balanceLabel, BorderLayout.CENTER);

        // Right Panel (Son)
        JPanel sonPanel = new JPanel();
        sonPanel.setBorder(BorderFactory.createTitledBorder("Son"));
        sonPanel.setLayout(new BoxLayout(sonPanel, BoxLayout.Y_AXIS));

        JLabel withdrawLabel = new JLabel("Withdraw Amount:");
        JLabel withdrawAmount = new JLabel("1000000");
        sonButton = new JButton("Withdraw");

        withdrawLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        withdrawAmount.setAlignmentX(Component.CENTER_ALIGNMENT);
        sonButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        sonPanel.add(withdrawLabel);
        sonPanel.add(withdrawAmount);
        sonPanel.add(Box.createVerticalStrut(10));
        sonPanel.add(sonButton);

        // Add panels to frame
        add(fatherPanel);
        add(balancePanel);
        add(sonPanel);

        fatherButton.addActionListener(e -> new Father(account, balanceLabel).start());
        sonButton.addActionListener(e -> new Son(account, balanceLabel).start());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }
}
