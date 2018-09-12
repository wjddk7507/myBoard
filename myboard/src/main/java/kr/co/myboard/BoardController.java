package kr.co.myboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.myboard.domain.Board;
import kr.co.myboard.domain.Criteria;
import kr.co.myboard.domain.SearchCriteria;
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
	public String list(SearchCriteria criteria, Model model) {
		Map<String, Object> map = boardService.list(criteria);
		model.addAttribute("map", map);
		return "board/list";
	}
	@RequestMapping(value="board/detail", method=RequestMethod.GET)
	public String detail(Criteria criteria, HttpServletRequest request, Model model) {
		Board board = boardService.detail(request);
		model.addAttribute("board", board);
		return "board/detail";
	}
	@RequestMapping(value="board/update", method=RequestMethod.GET)
	public String updateView(Criteria criteria, HttpServletRequest request, Model model) {
		Board board = boardService.updateView(request);
		model.addAttribute("board", board);
		return "board/update";
	}
	@RequestMapping(value="board/update", method=RequestMethod.POST)
	public String update(Criteria criteria, HttpServletRequest request, Model model, RedirectAttributes attr) {
		boardService.update(request);
		attr.addFlashAttribute("msg", "수정 성공");
		return "redirect:list?page="+criteria.getPage()+"&perPageNum="+criteria.getPerPageNum();
	}
	@RequestMapping(value="board/delete", method=RequestMethod.GET)
	public String delete(Criteria criteria, HttpServletRequest request, Model model, RedirectAttributes attr) {
		boardService.delete(request);
		attr.addFlashAttribute("msg", "게시글 삭제 성공");
		return "redirect:list?page="+criteria.getPage()+"&perPageNum="+criteria.getPerPageNum();
	}
}
