package system.cli;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import system.Task;
import system.fields.date.DateBuilder;
import system.fields.date.TaskDate;
import system.fields.title.TaskTitle;
import system.fields.title.TitleBuilder;
import system.files.TaskFileManager;

public class TaskCLI {

    private final TaskFileManager taskFileManager;
    private final Scanner scanner;

    public TaskCLI(TaskFileManager taskFileManager) {
        this.taskFileManager = taskFileManager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        boolean running = true;

        while (running) {

            printMenu();

            int option = readOption();

            switch (option) {

                case 1:
                    createTask();
                    break;

                case 2:
                    listTasks();
                    break;

                case 3:
                    completeTask();
                    break;

                case 4:
                    running = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private void printMenu() {

        System.out.println("========== TAREFAS ==========");
        System.out.println("1 - Criar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Concluir tarefa");
        System.out.println("4 - Sair");
        System.out.println("==============================");
        System.out.print("Escolha uma opção: ");
    }

    private int readOption() {

        while (true) {

            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {
                System.out.print("Digite uma opção válida: ");
            }
        }
    }

    private void createTask() {

        System.out.println();
        System.out.println("========== CRIAR TAREFA ==========");

        System.out.print("Título: ");
        String title = scanner.nextLine();

        System.out.println("Data: ");

        System.out.print("ano: ");
        int dateYear = scanner.nextInt();
        System.out.print("mes: ");
        int dateMonth = scanner.nextInt();
        System.out.print("dia: ");
        int dateDay = scanner.nextInt();



        var tb = new TitleBuilder();
        var taskTitle = new TaskTitle();

        var db = new DateBuilder();
        var taskDate = new TaskDate();


        taskDate.set(
            db
            .setYear(dateYear)
            .setMonth(dateMonth)
            .setDay(dateDay)
            .build()
        );
        taskTitle.set(tb.setTitle(title).build());

        taskFileManager.addTaskField(taskTitle);
        taskFileManager.addTaskField(taskDate);

        System.out.println("Tarefa criada com sucesso.");

    }

    private void listTasks() {

        System.out.println();
        System.out.println("========== TAREFAS ==========");


            for (var task  : taskFileManager.read()) {
            System.out.println(task.toString());
            System.out.println(System.lineSeparator());
            }


    }

    private void completeTask() {

        System.out.println();
        System.out.println("========== CONCLUIR TAREFA ==========");

        String title;
        System.out.print("Informe o nome da tarefa");
        title = scanner.nextLine();

        var tb = new TitleBuilder();
        var taskTitle = new TaskTitle();

        taskTitle.set(tb.setTitle(title).build());

        taskFileManager.removeTask(taskTitle);
        System.out.println("========== TAREFA CONCLUIDA ==========");

    }
}
