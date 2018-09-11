package kr.co.myboard.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.co.myboard.domain.Board;
import kr.co.myboard.domain.Criteria;

public interface BoardService {
	public void register(HttpServletRequest request);
	// 게시물 전체를 가져오는 메소드 // 게시물 목록과 현재 페이지 번호를 같이 넘겨줌
	// 게시물 상세보기를 하거나 수정 및 삭제를 했을 때 현제 페이지 번호를 같이 넘겨서
	// 목록보기를 작업하거나 작업이 완료되면 현재 페이지로 이동하게끔 하기 위해서
	// 출력할 페이지 번호 관련 데이터도 같이 넘겨줘야 한다
	public Map<String, Object> list(Criteria criteria);
	public Board detail(HttpServletRequest request);
	public Board updateView(HttpServletRequest request);
	public void update(HttpServletRequest request);
	public void delete(HttpServletRequest request);
	public List<Board> order_recommend();	
	public List<Board> order_date();	
}
