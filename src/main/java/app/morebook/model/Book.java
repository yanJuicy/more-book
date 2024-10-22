package app.morebook.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_test")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String bookname;

    private String author;

    private String publisher;

    private String publicationYear;

    private String bookImageUrl;

    @Column(name = "isbn13")
    private String isbn;

    private String description;

    public Book(String bookname, String author, String publisher, String publicationYear,
                String bookImageUrl, String isbn, String description) {
        this.bookname = bookname;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.bookImageUrl = bookImageUrl;
        this.isbn = isbn;
        this.description = description;
    }

    public void updateImageAndDesc(String imageUrl, String description) {
        this.bookImageUrl = imageUrl;
        this.description = description;
    }
}
