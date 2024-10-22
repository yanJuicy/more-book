package app.morebook.service;

import app.morebook.dto.Data4LibraryBookDto;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class Data4LibraryService {

    private final RestTemplate restTemplate;

    @Value("${data4library.key}")
    private String apiKey;

    public Data4LibraryBookDto getBookDetail(String isbn) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://data4library.kr")
                .path("/api/srchDtlList")
                .queryParam("authKey", apiKey)
                .queryParam("isbn13", isbn)
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
        return gson.fromJson(jsonObject, Data4LibraryBookDto.class);
    }


}
