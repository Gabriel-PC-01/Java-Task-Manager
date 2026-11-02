package com.clovis.entity.task;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;




/**
 * TestTaskDate
 */
public class TestTaskDate {

    private BuildTaskDate buildTask; 

    @BeforeEach
    void setup(){

        buildTask = new BuildTaskDate();
        
    }


     


    @ParameterizedTest 
    @CsvSource(

        {
            "3000, 1, 1, 1, 1",
            "3000, 12, 31, 23, 59"
        }

    ) 
    @DisplayName("Test a valid TaskDate")
    void testMainCase(int year, int month,int day,int hour,int  minute) {

        assertDoesNotThrow(() -> 

            buildTask
                .setYear(year)
                .setMonth(month)
                .setDay(day)
                .setHour(hour)
                .setMinute(minute)
                .build()

        );

    }


    
    @ParameterizedTest 
    @CsvSource(

        {
            "2000, 1, 1, 1, 1",
        }

    )
    @DisplayName("Test date on the past")
    void testAlternativeCase1(int year, int month,int day,int hour,int  minute) throws Exception{

        assertThrows(IllegalArgumentException.class, () ->

         buildTask
            .setYear(year)
            .setMonth(month)
            .setDay(day)
            .setHour(hour)
            .setMinute(minute)
            .build()
        );

    }

   
    
    
    @ParameterizedTest 
    @CsvSource(

        {
            "-2000, 1, 1, 1, 1",
            "3000, 1, 1, -1, 1",
            "3000, 1, 1, 0, 1",
            "3000, 0, 1, 1, 0",
        }

    )
    @DisplayName("Test invalid values")
    void testAlternativeCase2(int year, int month,int day,int hour,int  minute) throws Exception{

        assertThrows(IllegalArgumentException.class, () ->

         buildTask
            .setYear(year)
            .setMonth(month)
            .setDay(day)
            .setHour(hour)
            .setMinute(minute)
            .build()
        );

    }

    
    @ParameterizedTest 
    @CsvSource(

        {
            "3000, 1, 1, 1, 1"
        }

    )
    @DisplayName("Test to print taskDate")
    void testPrintCase(int year, int month,int day,int hour,int  minute) throws Exception{

        System.out.println(
         buildTask
            .setYear(year)
            .setMonth(month)
            .setDay(day)
            .setHour(hour)
            .setMinute(minute)
            .build().getDate()
        );

    }

}
