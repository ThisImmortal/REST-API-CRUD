package org.restful.project.data;

import org.restful.project.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDB {

    public static Map<Long, Book> getAllBooks(){

        Map<Long, Book> books;

        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        String jpql = "SELECT b FROM Book b";
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);

        List<Book> bookList;
        try {

            bookList = query.getResultList();
            books = convertListToMap(bookList);
        }
        finally {

            em.close();
        }

        return books;
    }

    public static Book insertBook(Book book){

        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
           em.persist(book);
           transaction.commit();
           return book;
        }
        catch (Exception e){
            System.out.println(e);
            transaction.rollback();
            return null;
        }
        finally {
            em.close();
        }


    }

    public static Book updateBook(Book book){
        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
           em.merge(book);
           transaction.commit();
           return book;
        }
        catch (Exception e){
            System.out.println(e);
            transaction.rollback();
            return null;
        }
        finally {
            em.close();
        }

    }

    public static void deleteBook(long id){

        EntityManager em = DBUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            Book book = em.find(Book.class, id);
            em.remove(em.merge(book));
            transaction.commit();
        }
        catch (Exception e){
            System.out.println(e);
            transaction.rollback();

        }
        finally {
            em.close();

        }
    }




    //helper method
    public static Map<Long, Book> convertListToMap(List<Book>bookList){

        Map<Long, Book> bookMap = new HashMap<>();
        for (Book book:bookList) {

            bookMap.put(book.getId(), book);
        }

        return bookMap;
    }


}
