package app.morebook.service;

import app.morebook.model.Book;
import app.morebook.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book find(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

}
