package system;

import system.fields.title.TaskTitle;
import system.fields.date.TaskDate;


public record Task(String title, String date){

    @Override
    public final String toString() {
        return title +System.lineSeparator()+ date;
    }

}
