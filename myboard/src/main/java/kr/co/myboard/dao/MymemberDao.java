package kr.co.myboard.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.myboard.domain.Mymember;

@Repository
public class MymemberDao {
	// XML Mapper를 이용하는 MyBatis 클래스의 객체를 주입
	@Autowired
	private SqlSession sqlSession;
	
	public String idCheck(String id) {
		return sqlSession.selectOne("mymember.idCheck",id);
	}
	// 회원 가입을 위한 메소드
	public void join(Mymember mymember) {
		sqlSession.insert("mymember.join", mymember);
	}
	// 로그인 처리를 위한 메소드
	public Mymember login(String id) {
		return sqlSession.selectOne("mymember.login", id);
	}
}
