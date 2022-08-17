package com.j16.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.j16.pojo.Book;
import com.j16.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "book", produces = "application/json;charset=utf-8")
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping(value = "selectBooks")
    @ResponseBody
    public String selectStudent(@RequestParam("index") Integer index) {
        return JSON.toJSONString(bookService.selectBooks(index, 5), SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 删除单个
     *
     * @param id
     * @return
     */
    @GetMapping(value = "deleteBook")
    @ResponseBody
    public String deleteStudent(@RequestParam("id") Integer id) {
        if (bookService.deleteBook(id) > 0) {
            return "true";
        } else {
            return "false";
        }

    }


    @PostMapping(value = "addBook")
    public ModelAndView addBook(Book book) {
        if (bookService.addBook(book) > 0) {
            return  new ModelAndView("index");
        } else {
            return  new ModelAndView("addBook");
        }

    }


    @GetMapping("editBooks/{id}")
    public ModelAndView editStudent(@PathVariable("id") Integer id, HttpServletRequest request) {
        request.getSession().setAttribute("id", id);
        return new ModelAndView("editBook");
    }


    @GetMapping("selectEditBook")
    @ResponseBody
    public String selectEditStudent(HttpServletRequest request) {
        Integer id = (Integer) request.getSession().getAttribute("id");
        System.out.println(JSON.toJSONString(bookService.selectEditBook(id)));
        return JSON.toJSONString(bookService.selectEditBook(id));
    }


    @PostMapping(value = "updateBook")
    public ModelAndView updateBook(Book book) {
        if (bookService.addBook(book) > 0) {
            return  new ModelAndView("index");
        } else {
            return  new ModelAndView("addBook");
        }

    }

}
