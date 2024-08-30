package nested.test.ex1;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private Book[] books;
    private int index = 0;
    public Library(int size){
        books = new Book[size];
    }
    public void addBook(String title, String author) {
        if(index == books.length){
            System.out.println("도서관 저장 공간이 부족합니다.");
            return;
        }
        books[index] = this.new Book(title, author);
        index++;
    }

    public void showBooks() {
        System.out.println("== 책 목록 출력 ==");
        for (Book book : books) {
            System.out.println(book);
        }
    }
    private class Book{
        String title;
        String author;

        protected Book(String title, String author){
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "도서 제목: " + title +
                    ", 저자: " + author;
        }
    }
}
