//
//create table news(
//        id serial primary key,
//        title varchar(150) not null,
//        text varchar(250) not null,
//        time_pub timestamp not null unique);
public class News {
    private String title;
    private String text;
    private String time_pub;

    public News() {
    }

    public News(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime_pub() {
        return time_pub;
    }

    public void setTime_pub(String time_pub) {
        this.time_pub = time_pub;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", time_pub='" + time_pub + '\'' +
                '}';
    }
}

