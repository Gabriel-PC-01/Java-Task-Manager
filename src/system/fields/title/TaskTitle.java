package system.fields.title;


import system.fields.TaskField;
import system.fields.FieldStatus;
import system.fields.title.TitlePush;
/**
 * TaskTitle
 */
public class TaskTitle extends TaskField<TitlePush> {


    public TaskTitle(){
        this.fieldLength = 35;
    }

    @Override
    public FieldStatus set(TitlePush title){

        if (title.toString().length() > this.getLength()) {return FieldStatus.INPUT_TOO_LARGE;};

        this.fieldValue = title.toString();

        return FieldStatus.SUCESS;

    }

    @Override
    public int getLength() {
        return this.fieldLength;
    }

    @Override
    public String toString() {
        return fieldValue;
    }

}
