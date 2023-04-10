package com.payu.payuClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = { "/books/*" })
public class BookServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookClient client = new BookClient();

        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("add")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String isbnNumber = request.getParameter("isbnNumber");
                LocalDate date = LocalDate.parse(request.getParameter("date"));
                double price = Double.parseDouble(request.getParameter("price"));
                String bookType = request.getParameter("bookType");

                Book book = new Book(id,name, isbnNumber, date, price, bookType);
                client.addBook(book);
            } else if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String isbnNumber = request.getParameter("isbnNumber");
                LocalDate date = LocalDate.parse(request.getParameter("date"));
                double price = Double.parseDouble(request.getParameter("price"));
                String bookType = request.getParameter("bookType");

                Book book = new Book(id, name, isbnNumber, date, price, bookType);
                client.updateBook(book);
            } else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                client.deleteBook(id);
            }

        }

        List<Book> books = client.getAllBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
    }

}
