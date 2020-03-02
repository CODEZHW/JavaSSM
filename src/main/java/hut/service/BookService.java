package hut.service;

import hut.domain.Books;

import java.util.List;

/**
 * @authoer : zhw
 * @Date: 2020/1/12
 * @Description: java_ssm
 * @version: 1.0
 */
public interface BookService {
    //增加一本书
    int addBook ( Books books );

    //删除一本书
    int deleteBookByID ( int id );

    //更新一本书
    int updateBook ( Books books );

    //查询一本书
    Books queryBookByID ( int id );

    //查询全部的书
    List <Books> queryAllBook ();

    Books queryBookByName ( String bookName );

}
