package com.clovis.entity.task;

import java.util.Calendar;
import java.util.Objects;

import com.clovis.entity.EntityStatus;

/**
 * Date
 */
final public class TaskDate {

    private final Calendar timetoFinish = Calendar.getInstance();


    public EntityStatus setYear(final Integer year){

        // Calendar works with range from 0 to 11 for months
        // and for user is 1 to 12, cause this year - 1
        if( Objects.isNull(year)|| year <= 0 || year < Calendar.getInstance().get(Calendar.YEAR) ){
            return EntityStatus.INVALID_ENTRY;
        }


        timetoFinish.set(Calendar.YEAR, year);

        return EntityStatus.SUCCESS;
    }

    public EntityStatus setMonth(final Integer month){

    
        if( Objects.isNull(month)|| month <= 0 || month - 1 < Calendar.getInstance().get(Calendar.MONTH) || month > 12){
            return EntityStatus.INVALID_ENTRY;
        }


        timetoFinish.set(Calendar.MONTH, month - 1);

        return EntityStatus.SUCCESS;

    }

    public EntityStatus setDay(final Integer day){

    
        if( Objects.isNull(day)||  day <= 0|| day < Calendar.getInstance().get(Calendar.DAY_OF_MONTH) || day > 31){
            return EntityStatus.INVALID_ENTRY;
        }


        timetoFinish.set(Calendar.DAY_OF_MONTH, day);

        return EntityStatus.SUCCESS;

    }

    public EntityStatus setHour(final Integer hour){

        if( Objects.isNull(hour)|| hour <= 0|| hour < Calendar.getInstance().get(Calendar.HOUR_OF_DAY) || hour > 23){
            return EntityStatus.INVALID_ENTRY;
        }


        timetoFinish.set(Calendar.HOUR_OF_DAY, hour);

        return EntityStatus.SUCCESS;

    }

    public EntityStatus setMinute(final Integer minute){

        if( Objects.isNull(minute)|| minute <= 0|| minute < Calendar.getInstance().get(Calendar.MINUTE) || minute > 59){
            return EntityStatus.INVALID_ENTRY;
        }


        timetoFinish.set(Calendar.MINUTE, minute);

        return EntityStatus.SUCCESS;

    }

    public String getDate(){

        return 
            "year   : " + (timetoFinish.get(Calendar.YEAR) + 1) + "\n"    + 
            "month  : " + (timetoFinish.get(Calendar.MONTH) + 1) + "\n"   +
            "day    : " + timetoFinish.get(Calendar.DAY_OF_MONTH) + "\n"  +
            "hour   : " + timetoFinish.get(Calendar.HOUR_OF_DAY) + "\n"   +
            "minute : " + timetoFinish.get(Calendar.MINUTE)    + "\n"     ;


    }

}
