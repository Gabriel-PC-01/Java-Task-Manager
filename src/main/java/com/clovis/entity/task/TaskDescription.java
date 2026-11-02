package com.clovis.entity.task;

import java.util.Objects;

import com.clovis.entity.EntityStatus;

/**
 * Description
 */
final class TaskDescription{

    private final String description;
    static private final Integer maxSize = 200;


    TaskDescription(String description) throws Exception{

        if(Objects.isNull(description)) {
            EntityStatus.EMPTY_ENTRY.throwException("Error, a null value");
        }

        if(description.isBlank() || description.isEmpty()){
            EntityStatus.EMPTY_ENTRY.throwException("Error, blank text passed");
        }


        if(description.length() > maxSize){
            EntityStatus.INVALID_ENTRY.throwException("Description too big. It can has 200 characters");
        }


        description.strip();
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public static int getMaxSize(){
        return maxSize;
    }
}
