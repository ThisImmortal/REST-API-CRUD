package org.restful.project.service;

import org.restful.project.data.BookDB;
import org.restful.project.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookService {

    private Map<Long, Book> books = BookDB.getAllBooks();

    public BookService(){

    }

    public List<Book> getAllBooks(){

       List<Book> bookList = new ArrayList<>(books.values());
       return bookList;
    }

    public Book getBookById(long id){

        return books.get(id);
    }

    public Book insertBook(Book book){

        return BookDB.insertBook(book);
    }

    public Book updateBook(Book book){

        return BookDB.updateBook(book);
    }

    public void deleteBook(long id){

        BookDB.deleteBook(id);
    }
}
