package ru.myst.spring.Project2Boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.myst.spring.Project2Boot.models.Book;
import ru.myst.spring.Project2Boot.models.Person;
import ru.myst.spring.Project2Boot.repositories.BooksRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BooksRepository booksRepository;

    @Autowired
    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> index(boolean sortByName) {
        List<Book> books;
        if (sortByName) {
            books = booksRepository.findAll(Sort.by("name"));
        } else {
            books = booksRepository.findAll();
        }
        return books;
    }

    public List<Book> findWithPagination(int page, int booksPerPage, boolean sortByName) {
        List<Book> books;
        if (sortByName) {
            books = booksRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("name"))).getContent();
        } else {
            books = booksRepository.findAll(PageRequest.of(page, booksPerPage)).getContent();
        }
        return books;
    }

    public Book show(int id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        Book bookToBeUpdated = booksRepository.findById(id).get();
        updatedBook.setBook_id(id);
        updatedBook.setOwner(bookToBeUpdated.getOwner());
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    public Person getBookOwner(int id) {
        return booksRepository.findById(id).get().getOwner();
    }

    public List<Book> searchByTitle(String title) {
        return booksRepository.findByNameStartingWith(title);
    }

    @Transactional
    public void assign(int id, Person person) {
        booksRepository.findById(id).ifPresent(book -> {
            book.setOwner(person);
            book.setTakenAt(new Date());
        });

    }

    @Transactional
    public void release(int id) {
        booksRepository.findById(id).ifPresent(book -> {
            book.setOwner(null);
            book.setTakenAt(null);
        });
    }
}
