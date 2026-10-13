package com.clovis.entity.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.clovis.entity.EntityStatus;

/**
 * TestTask
 */
public class TestTask {


    private Task task;
    private TaskDate taskDate;
    private Description description;
    private Title title;
    private EntityStatus status;


    @BeforeEach 
    void setup(){

        title= new Title();
        description= new Description();
        task = new Task();
          
    }


    //Title tests

    @Test 
    @DisplayName("Set valid title in task")
    void titleTestCase1(){

        status = title.setTitle("A valid title @ 123 ! {}");

        assertEquals(EntityStatus.SUCCESS, status, "Should be return Sucess but return " + status);

    }

    @ParameterizedTest
    @NullSource 
    @EmptySource
    @ValueSource(strings = {"", "   ", "\n", "\t"})
    @DisplayName("Set invalid titile in task")
    void titleTestCase2(String titleText){


        status = title.setTitle(titleText);
        assertEquals(EntityStatus.EMPTY_ENTRY, status, "Should be return Sucess but return " + status);

    }


    //Description tests

    @Test 
    @DisplayName("Set valid description in task")
    void descriptionTestCase1(){

        status = description.setDescription("A valid description @ 123 ! {} çlaksjddçlaskf");

        assertEquals(EntityStatus.SUCCESS, status, "Should be return Sucess but return " + status);

    }

    @ParameterizedTest 
    @NullSource 
    @EmptySource
    @ValueSource(strings = {"", "   ", "\n", "\t"})
    @DisplayName("Set invalid description in task")
    void descriptionTestCase2(String titleText){

        status = description.setDescription(titleText);
        assertEquals(EntityStatus.EMPTY_ENTRY, status, "Should be return Sucess but return " + status);

    }


    //Task tests
   
    @Test
    @DisplayName("Test valid entrys for task")
    void taskTestCase1(){

        title.setTitle("test task");

        taskDate = new TaskDate();
        taskDate.setYear(Calendar.getInstance().get(Calendar.YEAR));
        taskDate.setMonth(Calendar.getInstance().get(Calendar.MONTH));
        taskDate.setDay(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        taskDate.setHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        taskDate.setMinute(Calendar.getInstance().get(Calendar.MINUTE));

        description.setDescription("Descript of test task");


        status = task.setTitle(title);
        if(status.equals(EntityStatus.EMPTY_ENTRY)){ assertEquals(true, false, "title is null"); }
        status = task.setDate(taskDate);
        if(status.equals(EntityStatus.EMPTY_ENTRY)){ assertEquals(true, false, "date is null"); }
        status = task.setDescription(description);
        if(status.equals(EntityStatus.EMPTY_ENTRY)){ assertEquals(true, false, "description is null"); }


        System.out.println(task.getTask());
        

        assertEquals(EntityStatus.SUCCESS, status);
    }
}
