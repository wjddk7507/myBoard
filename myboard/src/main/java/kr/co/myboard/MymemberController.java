package kr.co.myboard;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.myboard.domain.Mymember;
import kr.co.myboard.service.MymemberService;

@Controller
public class MymemberController {
	@Autowired
	MymemberService memberservice;
	
	@RequestMapping(value = "mymember/join", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {		
		return "mymember/join";
	}

	@RequestMapping(value = "mymember/join", method = RequestMethod.POST)
	public String join(MultipartHttpServletRequest request, RedirectAttributes attr) {
		memberservice.join(request);
		attr.addFlashAttribute("msg","회원가입");
		// 삽입, 삭제, 갱신 다음에는 리다이렉트로 이동
		return "redirect:/";
	}
	
	@RequestMapping(value = "mymember/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {		
		return "mymember/login";
	}
	@RequestMapping(value = "mymember/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, RedirectAttributes attr, HttpSession session) {	
		Mymember member = memberservice.login(request);
		//로그인에 실패한 경우
		if(member == null) {
			attr.addFlashAttribute("msg", "없는 이메일이거나 잘못된 비밀번호 입니다.");
			return "redirect:login";
		}
		//로그인에 성공한 경우
		else {
			session.setAttribute("member", member);
			//이전 요청을 가져오기
			Object dest = session.getAttribute("dest");
			//이전 요청이 없으면 시작 페이지로 이동
			if(dest == null) {
				return "redirect:/";
			}
			//이전 요청이 있으면 그 페이지로 이동
			else {
				return "redirect:/" + dest.toString();
			}
		}
	}
	
	@RequestMapping(value="mymember/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		// 세션 초기화
		session.invalidate();
		// 메인 페이지로 리다이렉트(연속 2번하면 안되는 경우 리다이렉트..!!)
		return "redirect:/";
	}
}
