package com.clovis.entity.task;

/**
 * BuildTaskDescription
 */
public class BuildTaskDescription {

    String description;


    public BuildTaskDescription setDescription(String description){

        this.description = description;

        return this;
    } 

    public TaskDescription build() throws Exception{

        return new TaskDescription(description);

    }
}
