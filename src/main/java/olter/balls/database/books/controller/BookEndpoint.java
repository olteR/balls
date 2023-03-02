package olter.balls.database.books.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import olter.balls.database.books.dto.BookListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/database")
@RequiredArgsConstructor
public class BookEndpoint {
  private final BookService bookService;

  @GetMapping("/book/{id}")
  public ResponseEntity<BookListResponse> getBook(@PathVariable Long id) {
    return ResponseEntity.ok().body(bookService.getBook(id));
  }

  @GetMapping("/books")
  public ResponseEntity<List<BookListResponse>> getBook() {
    return ResponseEntity.ok().body(bookService.getBooks());
  }
}
