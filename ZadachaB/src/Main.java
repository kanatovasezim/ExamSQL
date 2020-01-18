//В SQL Создать таблицу "Новости" (id, заголовок новости, текст новости, время публикации)
//
//        В Java сделать методы для
//
//        создания новой новости.
//        отображения новости (заголовок и текст)
//        удаления новости
//        изменения текста и заголовка новости
public class Main {

    public static void main(String[] args) {
        DB db = new DB();
        News news1 = new News("Title", "Here should be a text");
        db.insertNews(news1);
        db.deleteNews(5);
        db.updateNews("The title","Here should be the text", 6);

    }
}
