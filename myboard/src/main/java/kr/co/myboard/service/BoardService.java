package kr.co.myboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.myboard.domain.Board;

public interface BoardService {
	public void register(HttpServletRequest request);
	public List<Board> list();
	public Board detail(HttpServletRequest request);
	// 수정보기
	public Board updateView(HttpServletRequest request);
	// 수정
	public void update(HttpServletRequest request);
	public void delete(HttpServletRequest request);

	public List<Board> order_recommend();
}
