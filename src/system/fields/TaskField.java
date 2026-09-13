package system.fields;


import system.fields.FieldStatus;

public abstract class TaskField<T> {

    protected String fieldValue;
    protected int fieldLength;

    public abstract FieldStatus set(T input);

    public abstract int getLength();


}
