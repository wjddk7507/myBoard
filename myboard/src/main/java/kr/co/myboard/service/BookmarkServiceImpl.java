package kr.co.myboard.service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.myboard.dao.BookmarkDao;
import kr.co.myboard.domain.Bookmark;

@Service
public class BookmarkServiceImpl implements BookmarkService {
	@Autowired
	private BookmarkDao bookmarkDao;
	
	@Override
	public boolean register(HttpServletRequest request) {
		boolean result = false;
		
		String board_num = request.getParameter("board_num");
		String board_title = request.getParameter("board_title");
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		
		Bookmark bookmark = new Bookmark();
		bookmark.setBoard_num(Integer.parseInt(board_num));
		bookmark.setBoard_title(board_title);
		bookmark.setId(id);
		bookmark.setNickname(nickname);
		
		int r = bookmarkDao.register(bookmark);
		
		if(r>0) {
			result = true;		
			bookmarkDao.updateCnt(Integer.parseInt(board_num));
		}
		return result;
	}

	@Override
	public boolean delete(HttpServletRequest request) {
		boolean result = false;
		
		String board_num = request.getParameter("board_num");
		String id = request.getParameter("id");

		Bookmark bookmark = new Bookmark();
		bookmark.setBoard_num(Integer.parseInt(board_num));
		bookmark.setId(id);

		int r = bookmarkDao.delete(bookmark);
		
		if(r>0) {
			result = true;	
			bookmarkDao.updateMCnt(Integer.parseInt(board_num));
		}
		return result;
	}

	@Override
	public List<String> bookmarkCheck(HttpServletRequest request) {
		String board_num = request.getParameter("board_num");
		List<String> list = new ArrayList<String>();
		list = bookmarkDao.bookmarkCheck(Integer.parseInt(board_num));
		
		return list;
	}

	@Override
	public List<Bookmark> bookmarkList(String id) {
		List<Bookmark> list = new ArrayList<Bookmark>();
		list = bookmarkDao.bookmarkList(id);
		return list;
	}
	
}
