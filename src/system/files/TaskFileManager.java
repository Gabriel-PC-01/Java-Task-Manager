package system.files;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

import system.fields.TaskField;
import system.fields.title.TaskTitle;
import system.Task;


public class TaskFileManager{


    private final Path taskFile = Paths.get("tasks.tsk");



    public void addTaskField(TaskField<?> field) {

        createFile();

        ByteBuffer buffer = ByteBuffer.allocate(field.getLength());
        buffer.order(ByteOrder.BIG_ENDIAN);


            byte[] byteField = field.toString().getBytes(StandardCharsets.UTF_8);


        buffer.put(byteField, 0, byteField.length);

        buffer.flip();


        try (
                FileChannel channel = FileChannel.open(taskFile, StandardOpenOption.APPEND);
        ){

            channel.write(buffer);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void removeTask(TaskTitle title){

        List<String> lines;

        try {

            lines = Files.readAllLines(taskFile);

            for(int i = 0; i < lines.size(); i++){

                if ( title.toString().contains(lines.get(i)) ) {

                    lines.remove(i);
                    lines.remove(i);

                    break;
                }

            }

            cleanFile();
            Files.write(taskFile, lines, StandardOpenOption.APPEND);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public ArrayList<Task> read(){

        ArrayList<Task> taskList = new ArrayList<Task>();


        try {

        List<String> lines = Files.readAllLines(taskFile);


        for (int i = 0; i < lines.size(); i += 2) {

            taskList.add(new Task(
                lines.get(i),
                lines.get(i + 1)
            ));
        }

        } catch (Exception  e) {

            System.out.println(e.getMessage());
        }

        return taskList;
    }


    public void cleanFile(){

        try {

            FileChannel channel = FileChannel.open(
            taskFile,
            StandardOpenOption.WRITE,
            StandardOpenOption.TRUNCATE_EXISTING);

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }


    }


    private void createFile(){

        if (!Files.exists(taskFile)) {
            try {
                Files.createFile(taskFile);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
