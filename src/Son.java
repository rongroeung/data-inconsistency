import javax.swing.*;

public class Son extends Thread {
    private BankAccount account;
    private JLabel balanceLabel;

    public Son(BankAccount account, JLabel balanceLabel) {
        this.account = account;
        this.balanceLabel = balanceLabel;
    }

    @Override
    public void run() {
        Peterson.flag[1] = true;
        Peterson.turn = 0;
        while (Peterson.flag[0] && Peterson.turn == 0) {
            // Busy wait
        }

        account.withdraw(100000);
        updateBalance();

        Peterson.flag[1] = false;
    }

    private void updateBalance() {
        SwingUtilities.invokeLater(() -> balanceLabel.setText("Balance: " + account.getBalance()));
    }
}
