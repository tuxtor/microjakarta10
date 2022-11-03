package com.vorozco.microjakarta10.resources;

import com.vorozco.microjakarta10.model.Book;
import com.vorozco.microjakarta10.repository.BookRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("books")
@Produces("application/json")
@Consumes("application/json")
public class BookResource {

    @Inject
    BookRepository bookRepository;

    //List all
    @GET
    public List<Book> listAll() {
        return bookRepository.listAll();
    }

    //Get by id
    @GET
    @Path("{id}")
    public Book getBook(Long id) {
        return bookRepository.read(id);
    }

    //Create
    @POST
    public Book createBook(Book book) {
        bookRepository.create(book);
        return book;
    }

    //Update
    @PUT
    @Path("{id}")
    public Book updateBook(Long id, Book book) {
        bookRepository.update(book);
        return book;
    }

    //Delete
    @DELETE
    @Path("{id}")
    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }

}
