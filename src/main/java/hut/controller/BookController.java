package hut.controller;

import hut.domain.Books;
import hut.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @authoer : zhw
 * @Date: 2020/1/13
 * @Description: java_ssm
 * @version: 1.0
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;


    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list ( Model model ) {

        System.out.println ( "BookController.list" );
        List <Books> list = bookService.queryAllBook ( );
        model.addAttribute ( "list", list );
        return "allBook";
    }


    @RequestMapping("/toAddBook")
    public String toAddPaper () {
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook ( Books books ) {
        System.out.println ( "BookController.addBook" );
        System.out.println ( "books = " + books );
        bookService.addBook ( books );
        return "redirect:/book/allBook";
    }

    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper ( int id, Model model ) {
        System.out.println ( "BookController.toUpdatePaper" );
        Books books = bookService.queryBookByID ( id );
        model.addAttribute ( "Qbooks", books );
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook ( Books books, Model model ) {
        System.out.println ( "books = " + books );
        int i = bookService.updateBook ( books );
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook ( @PathVariable("bookId") int id ) {
        int i = bookService.deleteBookByID ( id );
        return "redirect:/book/allBook";
    }

    //查询一本书
    @RequestMapping(value = "/queryBook")
    public String queryBook ( Model model, String bookName ) {
        Books books = bookService.queryBookByName ( bookName );
        System.err.println ( "books = " + books );
        List <Books> list = new ArrayList <Books> ( );
        list.add ( books );

        if (books == null) {
            list = bookService.queryAllBook ( );
            model.addAttribute ( "error", "未查到" );
        }
        model.addAttribute ( "list", list );
        return "allBook";
    }

}
