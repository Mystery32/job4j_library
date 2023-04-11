package ru.myst.spring.Project2Boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.myst.spring.Project2Boot.models.Book;
import ru.myst.spring.Project2Boot.models.Person;
import ru.myst.spring.Project2Boot.repositories.PeopleRepository;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> index() {
        return peopleRepository.findAll();
    }

    public Person show(int id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setPerson_id(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    public Optional<Person> getPersonByName(String name) {
        return peopleRepository.findByName(name);
    }

    public List<Book> getBooksByPerson(int id) {
        Optional<Person> person = peopleRepository.findById(id);
        List<Book> books = new ArrayList<>(Collections.emptyList());
        if (person.isPresent()) {
//            Hibernate.initialize(person.get().getBooks());
            person.get().getBooks().forEach(book -> {
                long diffInMillis = Math.abs(book.getTakenAt().getTime() - new Date().getTime());
                if (diffInMillis > 300000) {
                    book.setExpired(true);
                }
            });
            books.addAll(person.get().getBooks());
        }
        return books;
    }
}
