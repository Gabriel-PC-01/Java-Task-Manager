package system.fields.date;


import system.fields.TaskField;
import system.fields.FieldStatus;

/**
 * TaskTitle
 */
public class TaskDate extends TaskField<DatePush> {

    public TaskDate(){
        this.fieldLength = 9;
    }

    @Override
    public FieldStatus set(DatePush date){

        if (date.toString().length() > this.getLength()) {return FieldStatus.INPUT_TOO_LARGE;};

        this.fieldValue = date.toString();

        return FieldStatus.SUCESS;

    }

    @Override
    public int getLength() {
        return this.fieldLength;
    }

    @Override
    public String toString() {

        if(fieldValue == null){
            return "kdkdkdkdd";
        }

        return  fieldValue;
    }

}
