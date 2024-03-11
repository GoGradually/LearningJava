package construct.ex;

public class Book {
    String title; //제목
    String author; //저자
    int page; //페이지 수

    // 코드를 완성하세요.
    Book(String title, String author, int page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }

    Book(String title, String author) {
        this(title, author, 0);
    }

    Book(String title) {
        this(title, "", 0);
    }

    Book() {
        this("", "", 0);
    }

    void displayInfo() {
        System.out.println("제목: " + title + ", 작가: " + author + ", 페이지 수: " + page);
    }
}