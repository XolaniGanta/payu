
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% out.println(request.getContextPath()); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Catalogue</title>
</head>
<body>
<h1>Book Catalogue</h1>

<h2>All Books</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>ISBN Number</th>
        <th>Date</th>
        <th>Price</th>
        <th>Type</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.isbnNumber}</td>
            <td><fmt:formatDate value="${book.date}" pattern="MM/dd/yyyy"/></td>
            <td>${book.price}</td>
            <td>${book.bookType}</td>
            <td>
                <form action="${pageContext.request.contextPath}/books?action=edit" method="post">
                    <input type="hidden" name="id" value="${book.id}">
                    <input type="submit" value="Edit">
                </form>
                <form action="${pageContext.request.contextPath}/books?action=delete" method="post">
                    <input type="hidden" name="id" value="${book.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Add Book</h2>
<form action="${pageContext.request.contextPath}/books" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="isbnNumber">ISBN Number:</label>
    <input type="text" id="isbnNumber" name="isbnNumber" required>
    <br>
    <label for="date">Date:</label>
    <input type="date" id="date" name="date" required>
    <br>
    <label for="price">Price:</label>
    <input type="number" step="0.01" id="price" name="price" required>
    <br>
    <label for="bookType">Type:</label>
    <select id="bookType" name="bookType" required>
        <option value="Hard cover">Hard cover</option>
        <option value="eBook">eBook</option>
    </select>
    <br>
    <input type="submit" value="Add">
</form>
