package org.restful.project.resource;

import org.restful.project.model.Book;
import org.restful.project.service.BookService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
public class BookResource {

    BookService service = new BookService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks(){

        return service.getAllBooks();
    }

    @GET
    @Path("/{bookId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookById(@PathParam("bookId") long id){

        return service.getBookById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book insertBook(Book book){

        return service.insertBook(book);
    }

    @PUT
    @Path("/{bookId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book updateBook(@PathParam("bookId") long id, Book book){
        book.setId(id);

        return service.updateBook(book);
    }

    @DELETE
    @Path("/{bookId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteBook(@PathParam("bookId") long id){


        service.deleteBook(id);
    }
}
