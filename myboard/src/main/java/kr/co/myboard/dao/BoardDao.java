package kr.co.myboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.myboard.domain.Board;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;

	public void register(Board board) {
		sqlSession.insert("board.register", board);
	}
	public List<Board> list(){
		return sqlSession.selectList("board.list");
	}
}
