package kr.co.myboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.myboard.domain.Reply;
import kr.co.myboard.service.ReplyService;

// 결과를 html이나 화면으로 만드는 것이 아니고 text나 json으로 만들어주는 어노테이션
@RestController
public class ReplyController {
	@Autowired
	ReplyService replyService;
	
	@RequestMapping(value="reply/register", method=RequestMethod.GET)
	public Map<String, Object> register(HttpServletRequest request){
		boolean result = replyService.register(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
	
	@RequestMapping(value="reply/list", method=RequestMethod.GET)
	public List<Reply> list(HttpServletRequest request){
		return replyService.list(request);
	}
}
