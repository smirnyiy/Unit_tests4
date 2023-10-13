package hw04;
/*
    У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных.
    Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
 */

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    public void init() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testFindBookById() {
        String id = "1";
        Book book = new Book(id, "Book1", "Author1");
        when(bookRepository.findById(id)).thenReturn(book);
        Book result = bookService.findBookById(id);
        verify(bookRepository).findById(id);
        assertEquals(book, result);
    }

    @Test
    public void testFindAllBooks() {
        List<Book> books = Arrays.asList(
                new Book("1", "Book1", "Author1"),
                new Book("2", "Book2", "Author2")
        );
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> result = bookService.findAllBooks();
        verify(bookRepository).findAll();
        assertEquals(books, result);
    }
}
