package system.fields.date;

import java.sql.Date;


/**
 * DateBuilder
 */
public class DateBuilder {

    private int year;
    private int month;
    private int day;


    public DateBuilder setYear(int year){

        if(year < 0){
            throw new IllegalArgumentException();
        }

        if(year > 100){
            throw new IllegalArgumentException();
        }

        this.year = year;

        return this;
    }

    public DateBuilder setMonth(int month){

        if(year < 0){
            throw new IllegalArgumentException();
        }

        if(month> 100){
            throw new IllegalArgumentException();
        }

        this.month = month;

        return this;
    }

    public DateBuilder setDay(int day) {

        if(year < 0){
            throw new IllegalArgumentException();
        }

        if(day > 100){
            throw new IllegalArgumentException();
        }

        this.day = day;

        return this;
    }

    public DatePush build(){
    return new DatePush(year, month, day);
    }
}
