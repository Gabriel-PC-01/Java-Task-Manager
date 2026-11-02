package com.clovis.entity.task;


import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import com.clovis.entity.EntityStatus;


/**
 * Date
 */
final class TaskDate{

    private final  Integer[] timeFields;
    private final Integer leapDay = 29;
    private final LocalDateTime currentDate = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);


    public TaskDate(Integer[] timeFields) throws Exception{

        this.timeFields = timeFields.clone(); 

        //check null values
        for(var dateTimeField :  this.timeFields){
            if (Objects.isNull(dateTimeField)) {
               EntityStatus.EMPTY_ENTRY.throwException("A date field is empty"); 
            }
        }


            //check valid values for leap years
        if(  !Year.isLeap(this.timeFields[IndexValue.YEAR.value()] ) ){

            if( this.timeFields[IndexValue.MONTH.value()] == Month.FEBRUARY.getValue()
                || this.timeFields[IndexValue.DAY.value()] == leapDay){
                EntityStatus.INVALID_ENTRY.throwException("The current year is not leap.");

            }

        }

        //check negative numbers 
        for (var dateTimeField : this.timeFields) {

            if(dateTimeField <= 0){ EntityStatus.INVALID_ENTRY.throwException("Invalid value. Put numbers bigger than 0"); }
        }

        //check if in past
        LocalDateTime dueDate = LocalDateTime.of(
            timeFields[IndexValue.YEAR.value()],
            timeFields[IndexValue.MONTH.value()],
            timeFields[IndexValue.DAY.value()],
            timeFields[IndexValue.HOUR.value()],
            timeFields[IndexValue.MINUTE.value()]
        );

        if (dueDate.isBefore(currentDate)) {
            EntityStatus.INVALID_ENTRY.throwException(
                "The date cannot be in the past."
            );
        }

    }

    public  LocalDateTime getDate(){

       return LocalDateTime.of(
            timeFields[IndexValue.YEAR.value()],
            timeFields[IndexValue.MONTH.value()],
            timeFields[IndexValue.DAY.value()],
            timeFields[IndexValue.HOUR.value()],
            timeFields[IndexValue.MINUTE.value()]
        );

    }



    private enum IndexValue{

    // Each value represents a index position
    // thar TaskDate user to read Date fields
    // fro an Integer[]

      YEAR{

         @Override
          public int value() {
              return 0;
          } 

      },
      MONTH{

         @Override
          public int value() {
              return 1;
          } 

      },
      DAY{

         @Override
          public int value() {
              return 2;
          } 

      },
      HOUR{

         @Override
          public int value() {
              return 3;
          } 

      },
      MINUTE{

         @Override
          public int value() {
              return 4;
          } 

      };


      abstract public int value();

    }
}
