package system.fields.title;


public class TitleBuilder{

    private String title;

    public TitleBuilder setTitle(String title){

        this.title = title;

        return this;
    }

    public TitlePush build(){ return new TitlePush(title); }

}
