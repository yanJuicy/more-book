package app.morebook.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Data4LibraryBookDto {

    private int no;
    private String bookname;
    private String publication_date;
    private String authors;
    private String publisher;
    private String class_no;
    private String class_nm;
    private String publication_year;
    private String bookImageURL;
    private String isbn;
    private String isbn13;
    private String description;

}
