package kr.co.myboard;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.myboard.domain.Board;
import kr.co.myboard.domain.SearchCriteria;
import kr.co.myboard.service.BoardService;
import kr.co.myboard.service.BoardServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(SearchCriteria criteria, Locale locale, Model model) {
		System.out.println(sqlSession);
		
		List<Board> order_recommend = boardService.order_recommend();
		model.addAttribute("recommend", order_recommend);
		List<Board> order_date = boardService.order_date();
		model.addAttribute("order_date", order_date);
		
		return "home";
	}
}
