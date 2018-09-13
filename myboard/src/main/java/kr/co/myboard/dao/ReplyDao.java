package kr.co.myboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.myboard.domain.Reply;

@Repository
public class ReplyDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int register(Reply reply) {
		return sqlSession.insert("reply.register", reply);
	}
	
	public List<Reply> list(int board_num){
		return sqlSession.selectList("reply.list", board_num);
	}
}
