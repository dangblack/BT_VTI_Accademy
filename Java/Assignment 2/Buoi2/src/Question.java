import java.time.LocalDateTime;

public class Question {
    int questionID;
    String content;
    CategoryQuestion categoryID;
    TypeQuestion typeID;
    Account creatorID;
    LocalDateTime createDate;
    Exam[] exams;
}
