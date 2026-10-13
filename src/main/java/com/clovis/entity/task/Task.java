package com.clovis.entity.task;


import java.util.Objects;

import com.clovis.entity.EntityStatus;


/**
 * Task
 */
public final class Task {

    private TaskDate date = new TaskDate(); 
    private Description description = new Description();
    private Title title = new Title();


    public EntityStatus setTitle(Title title) {

        if(Objects.isNull(title)){
            return EntityStatus.EMPTY_ENTRY;
        }

        this.title = title;
        return EntityStatus.SUCCESS;
    }

    public EntityStatus setDate(TaskDate date) {

        if(Objects.isNull(date)){
            return EntityStatus.EMPTY_ENTRY;
        }

        this.date = date;
        return EntityStatus.SUCCESS;

    }

    public EntityStatus setDescription(Description desciption) {

        if(Objects.isNull(description)){
            return EntityStatus.EMPTY_ENTRY;
        }

        this.description = desciption;

        return EntityStatus.SUCCESS;
    }

    
    public String getTask(){

        return date.getDate() + "\n\n"                  +
               title.getTitle() + "\n\n"                +
               description.getaDescription() + "\n\n"   ; 

    }

}
