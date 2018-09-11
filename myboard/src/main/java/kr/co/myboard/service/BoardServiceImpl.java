package kr.co.myboard.service;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.myboard.dao.BoardDao;
import kr.co.myboard.domain.Board;
import kr.co.myboard.domain.Member;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;

	@Override
	public void register(HttpServletRequest request) {
		//insert into myboard(board_num, board_title, board_content, id, nickname)
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		String id = member.getId();
		String nickname = member.getNickname();
		String profile_img = member.getProfile_img();
				
		Board board = new Board();
		board.setId(id);
		board.setNickname(nickname);
		board.setBoard_content(board_content);
		board.setBoard_title(board_title);
		board.setProfile_img(profile_img);
		
		boardDao.register(board);
	}

	@Override
	public List<Board> list() {
		// 오늘 날짜에 작성된 게시글은 시간, 이전에 작성된 게시글은 날짜 출력
		List<Board> list = boardDao.list();
		// 오늘 날짜 만들기
		Calendar cal = Calendar.getInstance();
		Date today = new Date(cal.getTimeInMillis());
		// list의 데이터들을 확인해서 날짜와 시간을 저장
		for(Board board : list) {
			// 작성한 날짜 가져오기
			String regdate = board.getWrite_date().substring(0, 10);
			if(today.toString().equals(regdate)) {
				// 시간을 저장
				board.setDispDate(board.getWrite_date().substring(11, 16));
			}else {
				board.setDispDate(regdate);
			}
		}
		return list;
	}

	@Override
	public Board detail(HttpServletRequest request) {
		String board_num = request.getParameter("board_num");
		// 조회수 1 증가
		boardDao.updateCnt(Integer.parseInt(board_num));
		// 데이터 가져오는 메소드 호출해서 리턴
		return boardDao.detail(Integer.parseInt(board_num));
	}

	// 수정보기
	@Override
	public Board updateView(HttpServletRequest request) {
		String board_num = request.getParameter("board_num");
		return boardDao.detail(Integer.parseInt(board_num));
	}

	@Override
	public void update(HttpServletRequest request) {
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String board_num = request.getParameter("board_num");
		
		Board board = new Board();
		board.setBoard_title(board_title);
		board.setBoard_content(board_content);
		board.setBoard_num(Integer.parseInt(board_num));
		
		boardDao.update(board);
	}

	@Override
	public void delete(HttpServletRequest request) {
		String board_num = request.getParameter("board_num");
		boardDao.delete(Integer.parseInt(board_num));
	}
	
	@Override
	public List<Board> order_recommend() {
		List<Board> order_recommend = boardDao.order_recommend();
		return order_recommend;
	}	
}
