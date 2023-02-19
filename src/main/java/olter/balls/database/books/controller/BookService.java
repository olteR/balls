package olter.balls.database.books.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.database.books.BookMapper;
import olter.balls.database.books.dto.BookListResponse;
import olter.balls.database.books.model.BookEntity;
import olter.balls.database.books.model.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
  private final BookRepository bookRepository;
  private final BookMapper bookMapper;

  public BookListResponse getBook(Integer id) {
    Optional<BookEntity> entity = bookRepository.findById(id);
    if (entity.isPresent()) {
      return bookMapper.entityToListResponse(entity.get());
    } else throw new ResourceNotFoundException("no book with such id");
  }

  public List<BookListResponse> getBooks() {
    return bookRepository.findAll().stream().map(bookMapper::entityToListResponse).toList();
  }
}
