package system.fields.date;


import system.fields.FieldStatus;
import system.fields.TaskField;
import system.fields.TestTaskField;
import system.fields.date.DatePush;
import system.fields.date.TaskDate;

public class TestTaskDate {

    public static void main(String[] args) {

        var taskDate= new TaskDate();

        var test = new TestDate();


        test.testValideInput(taskDate);
        test.testInvalideInput(taskDate);


    }

}


/**
 * InnerTestTaskTitle
 */
class TestDate extends TestTaskField<DatePush>{

    @Override
    public void testValideInput(TaskField<DatePush> field){

        System.out.println("Testando entradas validas para campo data");

        FieldStatus status;

        var db = new DateBuilder();

        status = field.set(

            db.setYear(26)
              .setMonth(06)
              .setDay(06)
              .build()

        );

        assert status == FieldStatus.SUCESS: "Saida esperada não retornada";
        System.out.println("Concluido");

    }

    @Override
    public void testInvalideInput(TaskField<DatePush> field){

        System.out.println("Testando entradas invalidas para campo data");


        boolean returnedException = false;

        var db = new DateBuilder();

        try{

            field.set(

                db.setYear(-26)
                .setMonth(-28)
                .setDay(-42)
                .build()

            );


        }catch(IllegalArgumentException e){
            returnedException = true;
        }


        assert returnedException : "Data negativa validada";

        returnedException = false;
        try{

            field.set(

                db.setYear(100)
                .setMonth(200)
                .setDay(300)
                .build()

            );


        }catch(IllegalArgumentException e){
            returnedException = true;
        }

        assert returnedException : "Data ano, mes data maior que 100 validada";


        System.out.println("Concluido");

    }

}
