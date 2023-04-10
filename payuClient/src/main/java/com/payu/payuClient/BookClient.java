package com.payu.payuClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class BookClient {
    private final String BASE_URI = "http://localhost:8081/books";
    private Client client = ClientBuilder.newClient();

    public List<Book> getAllBooks() {
        WebTarget target = client.target(BASE_URI);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        return response.readEntity(new GenericType<List<Book>>(){});
    }

    public Book getBookById(int id) {
        WebTarget target = client.target(BASE_URI).path(String.valueOf(id));
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        return response.readEntity(Book.class);
    }

    public void addBook(Book book) {
        WebTarget target = client.target(BASE_URI);
        Entity<Book> entity = Entity.entity(book, MediaType.APPLICATION_JSON);
        Response response = target.request().post(entity);
        response.close();
    }

    public void updateBook(Book book) {
        WebTarget target = client.target(BASE_URI).path(String.valueOf(book.getId()));
        Entity<Book> entity = Entity.entity(book, MediaType.APPLICATION_JSON);
        Response response = target.request().put(entity);
        response.close();
    }

    public void deleteBook(int id) {
        WebTarget target = client.target(BASE_URI).path(String.valueOf(id));
        Response response = target.request().delete();
        response.close();
    }
}
