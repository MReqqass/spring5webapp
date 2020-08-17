package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author a = new Author("mohammed", "reqqass");
        Book b = new Book("OCA 8", "123456789");
        a.getBooks().add(b);
        b.getAuthors().add(a);
        authorRepository.save(a);
        bookRepository.save(b);
        System.out.println(bookRepository.count());

        Publisher publisherRabat = new Publisher("Library Rabat","street 42, zone 113, morocco","RA","59000");
        Publisher publisherOujda = new Publisher("Library Oujda","street 79, zone 512, morocco","OU","60000");
        publisherRepository.save(publisherRabat);
        publisherRepository.save(publisherOujda);
        System.out.println(publisherRepository.count());
    }
}
