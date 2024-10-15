package app.morebook.controller;

import app.morebook.model.Book;
import app.morebook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookApiController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id) {
        return bookService.find(id);
    }

}
