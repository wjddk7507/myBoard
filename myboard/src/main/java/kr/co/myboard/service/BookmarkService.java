package kr.co.myboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.myboard.domain.Bookmark;

public interface BookmarkService {
	public boolean register(HttpServletRequest request);
	public boolean delete(HttpServletRequest request);
	public List<String> bookmarkCheck(HttpServletRequest request);
}
