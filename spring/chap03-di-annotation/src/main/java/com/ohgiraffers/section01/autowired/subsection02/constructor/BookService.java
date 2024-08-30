package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component 의 세분화 어노테이션으로 Service 계층에서 사용.
@Service("bookServiceConstructor")
public class BookService {


    private BookDAO bookDAO;

    // 생성자 주입
    // Spring 4.3 버전 이후 부터 생성자가 1개 뿐이라면 어노테이션을 생략해도 자동으로 생성자 주입이 동작한다.
    // 단, 생성자가 1개 이상인 경우에는 명시적으로 작성해주어야 한다.
    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks(){
        return bookDAO.selectBookList();
    }
    public BookDTO searchBookMySequence(int sequence){
        return bookDAO.selectOneBook(sequence);
    }
}
