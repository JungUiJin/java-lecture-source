package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component 의 세분화 어노테이션으로 Service 계층에서 사용.
@Service("bookService")
public class BookService {

    /* BookDAO 타입의 빈 객체를 이 프로퍼티에 자동으로 주입해준다. */
    @Autowired
    private BookDAO bookDAO;

    public List<BookDTO> selectAllBooks(){
        return bookDAO.selectBookList();
    }
    public BookDTO searchBookMySequence(int sequence){
        return bookDAO.selectOneBook(sequence);
    }
}
