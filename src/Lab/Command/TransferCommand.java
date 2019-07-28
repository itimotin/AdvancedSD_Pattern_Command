package Lab.Command;

import Lab.Service.*;
public class TransferCommand implements Command {
    private long fromAccountNumber;
    private long toAccountNumber;
    private double amount;
    private String description;
    private IAccountService accountService;

    public TransferCommand(long fromAccountNumber, long toAccountNumber, double amount, String description, IAccountService accountService) {
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.description = description;
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        accountService.transferFunds(fromAccountNumber,toAccountNumber,amount,description);
    }

    @Override
    public void undo() {
        accountService.transferFunds(toAccountNumber,fromAccountNumber,amount,description);
    }

    @Override
    public void redo() {
        execute();
    }
}

