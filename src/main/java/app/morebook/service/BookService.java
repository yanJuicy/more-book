package app.morebook.service;

import app.morebook.dto.Data4LibraryBookDto;
import app.morebook.model.Book;
import app.morebook.repository.BookRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final RestTemplate restTemplate;

    public Book find(Integer id) {
        apiCall();
        return bookRepository.findById(id).orElse(null);
    }

    public void apiCall() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://data4library.kr")
                .path("/api/srchDtlList")
                .queryParam("authKey", "")
                .queryParam("isbn13", "9791191496680")
                .queryParam("format", "json")
                .encode()
                .build()
                .toUri();

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String json = result.getBody();
        int startIndex = json.indexOf("{\"no");
        int endIndex = json.indexOf("}}");
        String jsonObject = json.substring(startIndex, endIndex + 1);

        Gson gson = new Gson();
        Data4LibraryBookDto data4LibraryBookDto = gson.fromJson(jsonObject, Data4LibraryBookDto.class);
    }

}
