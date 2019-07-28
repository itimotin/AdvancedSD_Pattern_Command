package Lab.Main;

import Lab.Command.Command;
public class Invoker {
    private Command previousCommand;

    public void execute(Command command){
        previousCommand = command;
        command.execute();
    }

    public void undo(){
        previousCommand.undo();
    }

    public void redo(){
        previousCommand.redo();
    }
}

