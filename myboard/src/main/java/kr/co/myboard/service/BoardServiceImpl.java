package kr.co.myboard.service;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.myboard.dao.BoardDao;
import kr.co.myboard.domain.Board;
import kr.co.myboard.domain.Criteria;
import kr.co.myboard.domain.Member;
import kr.co.myboard.domain.PageMaker;

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
	public Map<String, Object> list(Criteria criteria) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 데이터 가져오기
		List<Board> list = boardDao.list(criteria);
		// 마지막 페이지에 있는 데이터가 1개 밖에 없을 때
		// 그 데이터를 삭제하면 그 페이지의 데이터는 없다
		if(list.size()==0) {
			// 현재  페이지 번호를 1 감소시켜서 데이터를 다시 가져오기
			criteria.setPage(criteria.getPage()-1);
			list = boardDao.list(criteria);
		}
		// 오늘 날짜에 작성된 게시글은 시간, 이전에 작성된 게시글은 날짜 출력
		// 오늘 날짜 만들기
		Calendar cal = Calendar.getInstance();
		Date today = new Date(cal.getTimeInMillis());
		// list의 데이터들을 확인해서 날짜와 시간을 저장
		for(Board board : list) {
			// 작성한 날짜 가져오기
			String write_date = board.getWrite_date().substring(0, 10);
			if(today.toString().equals(write_date)) {
				// 시간을 저장
				board.setWrite_date(board.getWrite_date().substring(11, 16));
			}else {
				board.setWrite_date(write_date);
			}
		}
		// 게시물 목록을 Map에 저장
		map.put("list", list);
		
		// 페이지 번호 목록 만들기
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);		
		// 전체 데이터 개수 저장
		pageMaker.setTotalCount(boardDao.totalCount());
		// 페이지 번호 목록 Map에 저장
		map.put("pageMaker", pageMaker);
			
		return map;
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

	@Override
	public List<Board> order_date() {
		List<Board> order_date = boardDao.order_date();
		return order_date;
	}	
}
