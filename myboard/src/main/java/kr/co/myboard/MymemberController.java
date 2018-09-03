package kr.co.myboard;

import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.myboard.service.MymemberService;

@Controller
public class MymemberController {
	@Autowired
	MymemberService memberservice;
	@RequestMapping(value = "mymember/join", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "mymember/join";
	}

	@RequestMapping(value = "mymember/join", method = RequestMethod.POST)
	public String join(MultipartHttpServletRequest request, RedirectAttributes attr) {
		memberservice.join(request);
		attr.addFlashAttribute("msg","회원가입");
		// 삽입, 삭제, 갱신 다음에는 리다이렉트로 이동
		return "redirect:/";
	}
}
