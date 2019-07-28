package Lab.Command;

import Lab.Service.*;
public class WithdrawCommand implements Command {
    private IAccountService accountService;
    private long accNo;
    private double withdrawAmount;

    public WithdrawCommand(IAccountService accountService, long accNo, double withdrawAmount) {
        this.accountService = accountService;
        this.accNo = accNo;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void execute() {
        accountService.withdraw(accNo,withdrawAmount);
    }

    @Override
    public void undo() {
        accountService.deposit(accNo,withdrawAmount);
    }

    @Override
    public void redo() {
        execute();
    }
}
