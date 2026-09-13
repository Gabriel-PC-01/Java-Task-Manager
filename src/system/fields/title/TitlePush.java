package system.fields.title;


public record TitlePush(String title) {

    @Override
    public final String toString() {

        String tab = "    ";

        return tab + title + System.lineSeparator();
    }
}
