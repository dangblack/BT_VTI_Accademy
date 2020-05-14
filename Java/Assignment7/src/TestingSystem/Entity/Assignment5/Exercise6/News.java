package TestingSystem.Entity.Assignment5.Exercise6;


public class News implements INews{
    private int ID;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }


    @Override
    public void display() {
        News news = new News();
        System.out.println(news.toString());
    }

    @Override
    public float calculate() {
        float argRates = 0;
        int[] rates = {6,9,10};
        argRates = ((float)(rates[0] + rates[1] + rates[2])/3);
        return argRates;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", averageRate=" + averageRate +
                '}';
    }
}
