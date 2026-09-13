package system.files;

import system.fields.date.DateBuilder;
import system.fields.date.TaskDate;
import system.fields.title.TaskTitle;
import system.fields.title.TitleBuilder;
import system.files.TaskFileManager;

/**
 * TestTaskFileManager
 */
public class TestTaskFileManager {

    public static void main(String[] args) {

        System.out.println("Iniciando Teste de TestTaskFileManager");

        var taskFileManager = new TaskFileManager();


        System.out.println("Inserindo task");
        TaskTitle title = new TaskTitle();
        var tb = new TitleBuilder();
        title.set(tb.setTitle("minha tarefa").build());

        var date = new TaskDate();
        var db = new DateBuilder();

        date.set(

            db
            .setYear(26)
            .setMonth(8)
            .setDay(29)
            .build()


        );


        taskFileManager.addTaskField(title);
        taskFileManager.addTaskField(date);



        System.out.println("Lendo tasks");
        for (var task  : taskFileManager.read()) {
            System.out.println(task.toString());
        }

        System.out.println("Removendo tarefa:");

        title.set(tb.setTitle("tarefa teste").build());

        date.set(

            db
            .setYear(26)
            .setMonth(8)
            .setDay(29)
            .build()


        );

        taskFileManager.addTaskField(title);
        taskFileManager.addTaskField(date);
        taskFileManager.addTaskField(title);
        taskFileManager.addTaskField(date);

        taskFileManager.removeTask(title);


        System.out.println("Concluido");
    }

}
