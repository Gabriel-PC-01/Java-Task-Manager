package com.clovis.entity.task;


public class BuildTaskDate{

        private int year;
        private int month;
        private int day;
        private int hour;
        private int minute;


        public BuildTaskDate setYear(int year){

            this.year = year;
            return this;
        }

        public BuildTaskDate setMonth(int month){

            this.month = month;
            return this;
        }

        public BuildTaskDate setDay(int day){

            this.day = day;
            return this;
        }

        public BuildTaskDate setHour(int hour){

            this.hour = hour;
            return this;
        }

        public BuildTaskDate setMinute(int minute){

            this.minute = minute;
            return this;
        }

        public TaskDate build() throws Exception{

            //do not alter the element sequecence
            // the TaskDate consider this to read date time fields
            Integer[] arrayToReturn = {year, month, day, hour, minute};
           


            return new TaskDate(arrayToReturn); 

        }
    }
