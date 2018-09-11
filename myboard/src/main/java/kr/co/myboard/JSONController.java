package kr.co.myboard;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.myboard.service.MemberService;

@RestController
public class JSONController {
	@Autowired
	private MemberService memberService;
	
	// 아이디 중복 체크 요청을 처리
	@RequestMapping(value="member/idCheck", method=RequestMethod.GET)
	public Map<String, Object> idCheck(HttpServletRequest request){
		String id = memberService.idCheck(request);
		// 리턴할 Map을 생성
		Map<String, Object> map = new HashMap<String, Object>();
		// result 라는 키에서 id가 null인지 여부 저장
		// 존재하는 아이디이면 false 존재하지 않는 아이디이면 true
		// http://localhost:8080/pk/mymember/idCheck?id=wjddk
		map.put("result", id==null);
		return map;
	}
}

/*
 * Controller가 jsp 파일을 이용해서 출력하지 않고 데이터를 출력하도록 만들기
  -> 클라이언트 쪽에서 ajax 요청을 하는 경우 : 클라이언트 화면 전체 갱신 없이 서버로부터 데이터를 받아오고자 하는 경우
  -> 클라이언트 프로그램을 클라이언트가 원하는대로 제작하도록 하기 위해서

클라이언트 요청 -> 서버에게 전달 -> 서버가 처리 -> 서버가 데이터 전송 -> 클라이언트가 데이터를 받아서 용도에 맞게 편집해서 화면에 출력

스프링에서는 RestController라는 어노테이션이 붙은 클래스가요청을 처리해서 리턴하면 일반 문자열이나 JSON 문자열을 만들어서 리턴해준다
JSON은 자바스크립트 객체 표현법인데 자바스크립트는 [] 과 {} 밖에 없어서 문자열만 리턴하면 표현할 방법이 없어서 하나짜리 데이터를 리턴하면 문자열로 넘겨주고 배열이나 맵을 리턴하면 JSON으로 변경해서 넘겨준다
 * */
