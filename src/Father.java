import javax.swing.*;

public class Father extends Thread {
    private BankAccount account;
    private JLabel balanceLabel;

    public Father(BankAccount account, JLabel balanceLabel) {
        this.account = account;
        this.balanceLabel = balanceLabel;
    }

    @Override
    public void run() {
        Peterson.flag[0] = true;
        Peterson.turn = 1;
        while (Peterson.flag[1] && Peterson.turn == 1) {
            // Busy wait
        }

        account.deposit(1000000);
        updateBalance();

        Peterson.flag[0] = false;
    }

    private void updateBalance() {
        SwingUtilities.invokeLater(() -> balanceLabel.setText("Balance: " + account.getBalance()));
    }
}
