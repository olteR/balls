package olter.balls.database.importer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import olter.balls.database.books.BookEntity;
import olter.balls.database.books.BookMapper;
import olter.balls.database.books.dto.BookRepository;
import olter.balls.database.books.dto.BookResponse;
import olter.balls.database.importer.dto.BookImport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ImporterService {

    @Value("${import.url}")
    private String IMPORT_URL;

    private final ImportMapper importMapper;
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public List<BookResponse> importBooks() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        ObjectMapper mapper = new ObjectMapper();

        headers.add("user-agent", "Application");
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseJson = restTemplate.exchange(IMPORT_URL.concat("books.json"), HttpMethod.GET, httpEntity, String.class);
        BookImport[] imports = mapper.readValue(Objects.requireNonNull(responseJson.getBody()).substring(responseJson.getBody().indexOf('['), responseJson.getBody().lastIndexOf(']') + 1), BookImport[].class);
        ArrayList<BookEntity> importedBooks = new ArrayList<>();
        for (BookImport book : imports) {
            importedBooks.add(importMapper.toBookEntity(book));
        }
        bookRepository.saveAll(importedBooks);
        return bookMapper.entityToResponseList(importedBooks);
    }
}
