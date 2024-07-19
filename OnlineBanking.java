import java.util.*;

class Account {
    String accountHolder;
    String accountNumber;
    double balance;
    List<String> transactionHistory;

    public Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance+=amount;
        transactionHistory.add("Deposit:"+amount);

    }
    public boolean withdraw(double amount){
        if(amount<=balance){
            balance-=amount;
            transactionHistory.add("Withdraw Amount:"+ amount);
            return true;
        }
        else{
            System.out.println("Insufficient Balance");
            return false;
        }
    }
    public boolean transfer(Account beneficiary,double amount){
        if(withdraw(amount)){
            beneficiary.deposit(amount);
            transactionHistory.add("Transfer:"+amount+"to"+beneficiary.getAccountHolder());
            return true;
        }
        else{
            return false;
        }
    }
    public void viewTransactionHistory(){
        System.out.println("Transaction History for"+  accountHolder +" : ");
        for(String transaction:transactionHistory){
            System.out.println(transaction);
        }
    }
    public void display(){
        System.out.println("Account Holder Name:"+accountHolder);
        System.out.println("Account Number:"+accountNumber);
         System.out.println("Current Balance:"+balance);

    }

}


class  BankingSystem {
    Map <String,Account> accounts=new HashMap<>();
   
    public void createAccount(String accountHolder){
        String accountNumber="040203"+(accounts.size()+ 7634);
        Account newAccount= new Account(accountNumber, accountHolder);
        accounts.put(accountNumber, newAccount);
        System.out.println("Account created successfully!");
        System.out.println("Account Number:"+ accountNumber);


    }    
    public Account getAccount(String accountNumber){
        return accounts.get(accountNumber);

    }
    public void displayAccounts() {
        System.out.println("Available Accounts:");
        for (Account account : accounts.values()) {
            System.out.println("- " + account.getAccountHolder() + " (Account Number: " + account.getAccountNumber() + ")");
        }
    }
}
public class OnlineBanking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BankingSystem bankingSystem = new BankingSystem();

        while (true) {
            System.out.println("\n--- Online Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. View Transaction History");
            System.out.println("6. Manage Personal Information");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");
            int choice=scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name:");
                    String accountHolder=scan.nextLine();
                    bankingSystem.createAccount(accountHolder);
                    break;

                case 2:
                
                    System.out.print("Enter Account Number:");
                    String depositAccount=scan.nextLine();
                    Account depositAcc=bankingSystem.getAccount(depositAccount);
                    if(depositAcc!=null){
                        System.out.println("Enter Amount to Deposit Amount:");
                        double depositAmount=scan.nextDouble();
                        depositAcc.deposit(depositAmount);
                        System.out.println("Deposit Successfully1");
                    }
                    else{
                        System.out.println("Account not found");
                    }    
                    break;

                case 3:
                    System.out.println("Enter Account Number:");
                    String withdrawAccount=scan.nextLine();
                    Account withdrawAcc=bankingSystem.getAccount(withdrawAccount);
                    if(withdrawAcc!=null){
                        System.out.println("Enter withdraw amount:");
                        double withdrawAmount=scan.nextDouble();
                        withdrawAcc.withdraw(withdrawAmount);       
                         System.out.println("withdraw Successfully");
                        
                    }    
                    else{
                        System.out.println("Account not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter sender Account Number");
                    String senderAccount=scan.nextLine();
                    Account senderAcc=bankingSystem.getAccount(senderAccount);
                    if(senderAcc!=null){
                        System.out.println("Enter beneficiary Account Number ");
                        String beneficiaryAccount=scan.nextLine();
                        Account beneficiaryAcc=bankingSystem.getAccount(beneficiaryAccount);
                        if(beneficiaryAcc!=null){
                            System.out.println("Enter Amount to transfer:");
                            double transferAmount=scan.nextDouble();
                            senderAcc.transfer(beneficiaryAcc, transferAmount);
                            System.out.println("Money transfer Successfully");
                        }
                        else{
                            System.out.println(" beneficiaryAccount Not found");
                        }
                    } 
                    else{
                        System.out.println("Account not found");
                    }
                    break;

                case 5:
                    System.out.println("Enter Account Number");
                    String transcationAccount=scan.nextLine();
                    Account transcationAcc=bankingSystem.getAccount(transcationAccount);
                    if(transcationAcc!=null){
                        transcationAcc.viewTransactionHistory();
                    }    
                    else{
                        System.out.println("Account not found");
                    }
                    break;

                case 6:
                    System.out.println("Enter Account Number:");
                    String infAccount=scan.nextLine();
                    Account infAcc=bankingSystem.getAccount(infAccount);
                    if(infAcc!=null){
                        infAcc.display();
                    }    
                    else{
                        System.out.println("Account not found");
                    }
                    break;

                case 7:
                    System.out.println("Exiting the System.Goodbye!!");
                    
                    return;


                                    
                default:
                    System.out.println("You Entered Invalid option.Please Try Again.");
            }

        }
    }    
}