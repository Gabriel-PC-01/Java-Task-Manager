package system.fields.date;



/**
 * DateDTO
 */
public record DatePush(int year, int month, int day) {

    @Override
    public final String toString() {

        String year = String.valueOf(this.year);
        String month = String.valueOf(this.month);
        String day = String.valueOf(this.day);

        if(this.month < 10){month = "0" + month;}
        if(this.day < 10){day = "0" + day;}

        return year + "/" + month + "/" + day + System.lineSeparator();
    }
}
