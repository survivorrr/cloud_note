package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.BookService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")
public class AddBookController {
	@Resource private BookService bookService;
	
	@RequestMapping("/addBook.do")
	@ResponseBody
	public NoteResult<Object> execute(String userId,String name){
		NoteResult<Object> result = bookService.addNoteBook(userId, name);
		return result;
	}
}
