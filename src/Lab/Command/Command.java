package Lab.Command;

public interface Command {
    void execute();
    void undo();
    void redo();
}
