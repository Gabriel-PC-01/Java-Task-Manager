package com.clovis.entity.task;

import java.util.Objects;

import com.clovis.entity.EntityStatus;

/**
 * TaskTitle 
 */
final class TaskTitle{

    private final String title;
    static private final Integer maxSize = 50;


    public TaskTitle(String title) throws Exception{

        if(Objects.isNull(title)) {
            EntityStatus.EMPTY_ENTRY.throwException("Error, a null value");
        }

        if(title.isBlank() || title.isEmpty()) {
            EntityStatus.EMPTY_ENTRY.throwException("Error, text is blank");
        }

        if(title.length() > maxSize){
            EntityStatus.INVALID_ENTRY.throwException("Description too big. It can has 50 characters");
        }


        title.strip();
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public static int getMaxSize(){
        return maxSize;
    }

}
