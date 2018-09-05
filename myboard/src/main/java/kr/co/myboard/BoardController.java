package kr.co.myboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.myboard.domain.Board;
import kr.co.myboard.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="board/register", method=RequestMethod.GET)
	public String register(Model model) {
		return "board/register";
	}
	@RequestMapping(value="board/register", method=RequestMethod.POST)
	public String register(HttpServletRequest request, RedirectAttributes attr, Model model) {
		boardService.register(request);
		attr.addFlashAttribute("msg", "게시글 작성 성공");
		// 데이터베이스에 저장했으니까 리다이렉트
		return "redirect:list";
	}
	@RequestMapping(value="board/list", method=RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		List<Board> list = boardService.list();
		model.addAttribute("list", list);
		return "board/list";
	}
}
