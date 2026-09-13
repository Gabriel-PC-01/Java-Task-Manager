package system.fields;

import system.fields.TaskField;

/**
 * TestTaskField
 */
public abstract class TestTaskField <T> {

    public abstract void testValideInput(TaskField<T> field);
    public abstract void testInvalideInput(TaskField<T> field);

}
