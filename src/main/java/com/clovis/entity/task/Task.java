package com.clovis.entity.task;




/**
 * Task
 */
public final class Task {

    private final TaskDate dateToComplete; 
    private final TaskDescription taskDescription;
    private final TaskTitle taskTitle;
    private boolean isComplete = false;


    public Task(TaskTitle taskTitle, TaskDate dateToComplete, TaskDescription taskDescription){

        this.taskTitle = taskTitle;
        this.dateToComplete = dateToComplete;
        this.taskDescription = taskDescription;
    }


    public void completeTask(){
        isComplete = true;
    } 

    public boolean isComplete() {
        return isComplete;
    }



    
    public String getTask(){

        return "Title : " + taskTitle.getTitle() +
                "Date to complete : " + dateToComplete.getDate() +
                "task description : " + taskDescription.getDescription() +
                "Is complete ? : " + isComplete; 

    }

}
