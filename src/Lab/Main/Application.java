package Lab.Main;

import Lab.Command.Command;
import Lab.Command.DepositCommand;
import Lab.Command.WithdrawCommand;
import Lab.Command.TransferCommand;
import Lab.Service.AccountService;
import Lab.Domain.AccountEntry;
import Lab.Domain.Customer;
import Lab.Service.IAccountService;
import Lab.Domain.Account;
import java.util.Collection;

public class Application {
	public static void main(String[] args) {
		Invoker invoker = new Invoker();

		IAccountService accountService = new AccountService();
		// create 2 accounts;
		accountService.createAccount(1231123, "I. Timotin");
		accountService.createAccount(1231233, "I. Constantin");

		//use account 1;
		Command depositCommand1 = new DepositCommand(accountService,1231123, 1000.0);
		Command depositCommand2 = new DepositCommand(accountService,1231233, 2000.0);

		invoker.execute(depositCommand1);
		invoker.execute(depositCommand2);

		accountService.createAccount(1263862, "C. Tereburke");
		
		Command withdrawCommand = new WithdrawCommand(accountService,1263862, 230);
		invoker.execute(withdrawCommand);
		invoker.undo();
		invoker.redo();

		accountService.createAccount(4253892, "B. Alex");
		//use account 2;
		Command depositCommand = new DepositCommand(accountService,4253892, 12450);
		invoker.execute(depositCommand);

		Command transferCommand = new TransferCommand(4253892, 1263862, 100, "payment of invoice 10232",accountService);
		invoker.execute(transferCommand);
		invoker.undo();

		// show balances
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------" + "-Description------------------" + "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%20s%20s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}



