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
	public void updateCnt(int board_num) {
		sqlSession.update("board.updateCnt", board_num);
	}
	public Board detail(int board_num) {
		return sqlSession.selectOne("board.detail", board_num);
	}
	public void update(Board board) {
		sqlSession.update("board.update", board);
	}
	public void delete(int board_num) {
		sqlSession.delete("board.delete", board_num);
	}
}
