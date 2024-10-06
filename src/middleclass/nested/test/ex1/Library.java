package middleclass.nested.test.ex1;

import java.util.HashMap;

public class Library {
    private Integer booksCnt;

    private Book[] books;
    private int idx = 0;

    private static class Book {
        String name;
        String author;

        public Book(String name, String author) {
            this.name = name;
            this.author = author;
        }
    }

    public Library(Integer booksCnt) {
        this.booksCnt = booksCnt;
        this.books = new Book[booksCnt];
    }

    public void addBook(String name, String author) {
        Book book = new Book(name, author);
        books[idx++] = book;
    }

    public void showBooks() {
        System.out.println("==== 책 목록 출력 ====");
        for (int i = 0; i < idx; i++) {
            System.out.println("도서제목 : " + books[i].name + ", 저자 : " + books[i].author);
        }
    }
}
