package system.cli;


import system.files.TaskFileManager;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

            TaskFileManager taskFileManager = new TaskFileManager();

            TaskCLI cli = new TaskCLI(taskFileManager);
            cli.start();

        
    }
}

