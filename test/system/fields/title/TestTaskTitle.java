package system.fields.title;

import system.fields.FieldStatus;
import system.fields.TaskField;
import system.fields.TestTaskField;
import system.fields.title.TaskTitle;
import system.fields.title.TitleBuilder;
import system.fields.title.TitlePush;

/**
 * TestTaskTitle
 */
public class TestTaskTitle {

    public static void main(String[] args) {

        var taskTitle = new TaskTitle();

        var test = new TestTitle();


        test.testValideInput(taskTitle);
        test.testInvalideInput(taskTitle);


    }

}


/**
 * InnerTestTaskTitle
 */
class TestTitle extends TestTaskField<TitlePush>{

    @Override
    public void testValideInput(TaskField<TitlePush> field){

        System.out.println("Testando entradas validas para campo titulo");

        String inputString = "";
        var tb = new TitleBuilder();

        while (inputString.length() < 30 ) {
            inputString = inputString + "+";
        }

        

        assert field.set(tb.setTitle(inputString).build()) == FieldStatus.SUCESS: "Entrada esperada não retornada";
        System.out.println("Concluido");

    }

    @Override
    public void testInvalideInput(TaskField<TitlePush> field){

        System.out.println("Testando entradas invalidas para campo titulo");

        String inputString = "";
        var tb = new TitleBuilder();

        while (inputString.length() <= 30) {
            inputString = inputString + "+";
        }


        assert field.set(tb.setTitle(inputString).build()) == FieldStatus.INPUT_TOO_LARGE : "Entrada esperada não retornada";
        System.out.println("Concluido");

    }

}
