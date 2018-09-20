package kr.co.myboard.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.myboard.domain.Bookmark;

@Repository
public class BookmarkDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int register(Bookmark bookmark) {
		return sqlSession.insert("bookmark.register", bookmark);
	}
	public int delete(Bookmark bookmark) {
		return sqlSession.delete("bookmark.delete", bookmark);
	}
	public List<String> bookmarkCheck(int board_num) {
		return sqlSession.selectList("bookmark.bookmarkCheck", board_num);
	}
	public void updateCnt(int board_num) {
		sqlSession.update("bookmark.updateCnt", board_num);
	}
	public void updateMCnt(int board_num) {
		sqlSession.update("bookmark.updateMCnt", board_num);
	}
}
