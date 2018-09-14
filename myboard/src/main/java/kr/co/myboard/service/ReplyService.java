package kr.co.myboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.myboard.domain.Reply;

public interface ReplyService {
	public boolean register(HttpServletRequest request);
	public List<Reply> list(HttpServletRequest request);
	public boolean delete(HttpServletRequest request);
	public boolean update(HttpServletRequest request);
}
