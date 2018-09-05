package kr.co.myboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.myboard.domain.Board;

public interface BoardService {
	public void register(HttpServletRequest request);
	public List<Board> list();
}
