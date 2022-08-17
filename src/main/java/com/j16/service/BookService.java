package com.j16.service;

import com.github.pagehelper.PageInfo;
import com.j16.pojo.Book;

public interface BookService {

    PageInfo<Book> selectBooks(int index, int page);

    int deleteBook(int id);

    int addBook(Book book);


    Book selectEditBook(int id);

    int updateBook(Book book);

}
