package kr.co.myboard;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.myboard.service.BookmarkService;

@RestController
public class BookmarkController {
	@Autowired
	private BookmarkService bookmarkService;

	@RequestMapping(value="bookmark/register", method=RequestMethod.GET)
	public boolean register(HttpServletRequest request){
		System.out.println(request.getParameter("board_title"));
		System.out.println(request.getParameter("board_num"));
		boolean result = bookmarkService.register(request);
		return result;
	}
	@RequestMapping(value="bookmark/delete", method=RequestMethod.GET)
	public boolean delete(HttpServletRequest request){
		boolean result = bookmarkService.delete(request);
		return result;
	}
}
