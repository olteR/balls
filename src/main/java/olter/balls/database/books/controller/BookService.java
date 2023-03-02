package olter.balls.database.books.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import olter.balls.common.NameResponse;
import olter.balls.common.exception.ResourceNotFoundException;
import olter.balls.database.books.BookMapper;
import olter.balls.database.books.dto.BookListResponse;
import olter.balls.database.books.model.BookEntity;
import olter.balls.database.books.model.BookRepository;
import olter.balls.database.importer.dto.BookImport;
import olter.balls.database.importer.dto.ImportResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
  private final BookRepository bookRepository;
  private final BookMapper bookMapper;

  public BookListResponse getBook(Long id) {
    Optional<BookEntity> entity = bookRepository.findById(id);
    if (entity.isPresent()) {
      return bookMapper.entityToListResponse(entity.get());
    } else throw new ResourceNotFoundException("no book with such id");
  }

  public List<BookListResponse> getBooks() {
    return bookRepository.findAll().stream().map(bookMapper::entityToListResponse).toList();
  }

  public ImportResponse processImports(BookImport[] imports) {
    List<NameResponse> importedBooks = new ArrayList<>();
    List<NameResponse> updatedBooks = new ArrayList<>();
    for (BookImport book : imports) {
      Optional<BookEntity> oEntity = bookRepository.findByShortName(book.getShortName());
      log.info(
          oEntity.isPresent()
              ? "Updating " + book.getName() + "..."
              : "Importing " + book.getName() + "...");
      BookEntity entity = oEntity.orElseGet(BookEntity::new);
      bookMapper.map(book, entity);
      bookRepository.save(entity);
      if (oEntity.isPresent()) updatedBooks.add(bookMapper.entityToNameResponse(entity));
      else importedBooks.add(bookMapper.entityToNameResponse(entity));
    }
    log.info("Imported " + importedBooks.size() + " books");
    log.info("Updated " + updatedBooks.size() + " books");
    return new ImportResponse(importedBooks, updatedBooks);
  }
}
