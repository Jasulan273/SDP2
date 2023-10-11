package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

//Define an abstract class Account that represents a bank account
abstract class Account {
  public abstract float getBalance();
}

//Create DepositAccount class that extends Account and represents a deposit account
class DepositAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public DepositAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

//Create SavingAccount class that extends Account and represents a savings account
class SavingAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public SavingAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

//Create CompositeAccount class that extends Account and represents a composite account
class CompositeAccount extends Account {
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  public float getBalance() {
    totalBalance = 0;
    for (Account account : accountList) {
      totalBalance += account.getBalance();
    }
    return totalBalance;
  }

  public void addAccount(Account account) {
    accountList.add(account);
  }

  public void removeAccount(Account account) {
    accountList.remove(account);
  }
}

//Main class to demonstrate the Composite Design Pattern
public class CompositePattern {
  public static void main(String[] args) {
    //Create CompositeAccount to hold various types of accounts
    CompositeAccount compositeAccount = new CompositeAccount();

    //Add deposit and savings accounts to the composite account
    compositeAccount.addAccount(new DepositAccount("DA001", 100));
    compositeAccount.addAccount(new DepositAccount("DA002", 150));
    compositeAccount.addAccount(new SavingAccount("SA001", 200));

    //Get the total balance of the composite account
    float totalBalance = compositeAccount.getBalance();
    System.out.println("Total Balance: " + totalBalance);
  }
}
