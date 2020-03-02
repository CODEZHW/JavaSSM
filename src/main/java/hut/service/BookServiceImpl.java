package hut.service;

import hut.dao.BookMapper;
import hut.domain.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @authoer : zhw
 * @Date: 2020/1/12
 * @Description: java_ssm
 * @version: 1.0
 */

@Service("BookServiceImpl")
public class BookServiceImpl implements BookService {

    @Autowired
    @Qualifier("bookMapper")
    private BookMapper bookMapper;

    public void setBookMapper ( BookMapper bookMapper ) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook ( Books books ) {
        return bookMapper.addBook ( books );
    }

    @Override
    public int deleteBookByID ( int id ) {
        return bookMapper.deleteBookByID ( id );
    }

    @Override
    public int updateBook ( Books books ) {
        System.out.println ( "BookServiceImpl.updateBook" );
        System.out.println ( "books = " + books );
        return bookMapper.updateBook ( books );
    }

    @Override
    public Books queryBookByID ( int id ) {
        return bookMapper.queryBookByID ( id );
    }

    @Override
    public List <Books> queryAllBook () {
        return bookMapper.queryAllBook ( );
    }

    @Override
    public Books queryBookByName ( String bookName ) {
        return bookMapper.queryBookByName ( bookName );
    }
}
