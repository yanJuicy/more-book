package app.morebook.service;

import app.morebook.dto.Data4LibraryBookDto;
import app.morebook.model.Book;
import app.morebook.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final Data4LibraryService data4LibraryService;

    public Book find(Integer id) {
        Book book = bookRepository.findById(id).orElse(null);

        Data4LibraryBookDto bookDetail = null;

        if (book.getBookImageUrl() == null) {
            bookDetail = data4LibraryService.getBookDetail(book.getIsbn());
            book.updateImageUrl(bookDetail.getBookImageURL());
        }

        if (book.getDescription() == null) {
            bookDetail = data4LibraryService.getBookDetail(book.getIsbn());
            book.updateDescription(bookDetail.getDescription());
        }

        return book;
    }


}
