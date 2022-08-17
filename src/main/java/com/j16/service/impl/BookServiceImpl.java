package com.j16.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j16.dao.BookDao;
import com.j16.pojo.Book;
import com.j16.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao dao;

    public PageInfo<Book> selectBooks(int index, int page) {
        PageHelper.startPage(index, page);
        return new PageInfo<com.j16.pojo.Book>(dao.selectBooks());
    }

    public int deleteBook(int id) {
        return dao.deleteBook(id);
    }

    public int addBook(Book book) {
        return dao.addBook(book);
    }

    public Book selectEditBook(int id) {
        return dao.selectEditBook(id);
    }

    public int updateBook(Book book) {
        return dao.updateBook(book);
    }
}
