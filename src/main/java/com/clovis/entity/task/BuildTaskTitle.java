package com.clovis.entity.task;




/**
 * BuildTaskTitle
 */
public class BuildTaskTitle {

    private String title;


    public BuildTaskTitle setTitle(String title){
        this.title = title;
        return this;
    }

    public TaskTitle build()throws Exception{
        return new TaskTitle(title);
    }
    
}
