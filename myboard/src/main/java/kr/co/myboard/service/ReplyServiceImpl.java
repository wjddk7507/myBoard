package kr.co.myboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.myboard.dao.ReplyDao;
import kr.co.myboard.domain.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDao replyDao;

	@Override
	public boolean register(HttpServletRequest request) {
		boolean result = false;
		
		String board_num = request.getParameter("board_num");
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String profile_img = request.getParameter("profile_img");
		String reply_content =request.getParameter("reply_content");
		String depth = request.getParameter("depth");
		
		Reply reply = new Reply();
		reply.setBoard_num(Integer.parseInt(board_num));
		reply.setId(id);
		reply.setNickname(nickname);
		reply.setProfile_img(profile_img);
		reply.setDepth(Integer.parseInt(depth));
		reply.setReply_content(reply_content);
		
		int r = replyDao.register(reply);
		
		if(r>0) result=true;
		return result;
	}

	@Override
	public List<Reply> list(HttpServletRequest request) {
		List<Reply> list = new ArrayList<Reply>();
		String board_num = request.getParameter("board_num");
		list = replyDao.list(Integer.parseInt(board_num));
		return list;
	}

	@Override
	public boolean delete(HttpServletRequest request) {
		boolean result = false;
		String reply_num = request.getParameter("reply_num");
		int r = replyDao.delete(Integer.parseInt(reply_num));
		if(r>0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean update(HttpServletRequest request) {
		boolean result = false;		
		String reply_num = request.getParameter("reply_num");
		String reply_content = request.getParameter("reply_content");
		
		Reply reply = new Reply();
		reply.setReply_num(Integer.parseInt(reply_num));
		reply.setReply_content(reply_content);
		
		int r = replyDao.update(reply);
		if(r>0) result = true;
		
		return result;
	}
	
}
