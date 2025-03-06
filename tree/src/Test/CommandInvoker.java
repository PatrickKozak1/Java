package Test;

class CommandInvoker {
    private CommandPattern command;

    public void setCommand(CommandPattern command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
