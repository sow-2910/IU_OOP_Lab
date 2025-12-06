import java.util.ArrayList;
import java.util.List;

abstract class Account {
    public double balance;

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

interface WithDrawAble {
    void withdraw(double amount);
}

class StandardAccount extends Account implements WithDrawAble {
    @Override
    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive");
        if (amount > balance)
            throw new IllegalArgumentException("Not enough money in your account");
        balance -= amount;
    }
}

class FixedTermAccount extends Account {

}

public class Main {
    public static void main(String[] args) {
        List<Account> bankAccounts = new ArrayList<>();

        StandardAccount acc1 = new StandardAccount();
        FixedTermAccount acc2 = new FixedTermAccount();

        bankAccounts.add(acc1);
        bankAccounts.add(acc2);

        System.out.println("deposit for all account");
        for (Account acc : bankAccounts) {
            acc.deposit(1000);
            System.out.println("Balance: " + acc.getBalance());
        }

        System.out.println("Withdraw");
        acc1.withdraw(500);
        System.out.println("Account 1 after withdrawing: " + acc1.getBalance());

    }
}
