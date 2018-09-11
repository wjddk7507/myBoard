package kr.co.myboard.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.myboard.dao.MemberDao;
import kr.co.myboard.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	// 메일을 보내는 객체 주입
	@Autowired
	private MailSender mailSender;

	@Override
	public String idCheck(HttpServletRequest request) {
			String id = request.getParameter("id");
			return memberDao.idCheck(id);
	}

	@Override
	public void join(MultipartHttpServletRequest request) {
		Member mymember = new Member();
		String filename="";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		// 파일/
		MultipartFile profile_img = request.getFile("profile_img");

		
		// 파일을 저장할 경로 만들기 // 파일은 절대경로로만 저장이 가능
		// 프로젝트 내의 profile 디렉토리의 절대 경로를 만들기
		String uploadPath = request.getRealPath("/profile");
		// 랜덤한 64자리의 문자열 만들기
		UUID uid = UUID.randomUUID();
		// 원본 파일이름 가져오기
		filename = profile_img.getOriginalFilename();
		if(filename.length()==0) {
			filename="default.jpg";
		}else {
			filename = uid+"_"+filename;
			// 업로드할 파일의 실제 경로 만들기
			String filepath = uploadPath+"\\"+filename;
				
			// 업로드할 파일 객체 만들기
			File f = new File(filepath);
			try {
				// 파일 전송 - 파일 업로드
				profile_img.transferTo(f);
			}catch(Exception e) {
				System.out.println("이미지 업로드 실패 : "+e.getMessage());
			}
		}
		mymember.setId(id);
		mymember.setPw(BCrypt.hashpw(pw, BCrypt.gensalt(10)));
		mymember.setNickname(nickname);
		// 데이터베이스에는 파일 이름만 저장
		mymember.setProfile_img(filename);
		memberDao.join(mymember);
	}

	@Override
	public Member login(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Member member= memberDao.login(id);
		if(member != null) {
			// 비밀번호가 일치하면
			if(BCrypt.checkpw(pw, member.getPw()) == true) {
				// 비밀번호만 초기화
				member.setPw("");
			} else {
				// 비밀번호가 일치하지 않으면 전부 초기화
				member = null;
			}
		}		
		return member;
	}

	@Override
	public void sendmail(HttpServletRequest request) {
		// sendmail.jsp에서 전송온 파라미터 읽기
		String receiver = request.getParameter("receiver");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		try {
			//메일 보내기 객체 만들기
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("wjddk7507@naver.com");
			//받는 사람 설정
			message.setTo(receiver);
			//메일 제목 설정
			message.setSubject(title);
			//메일 내용 설정
			message.setText(contents);
			//메일 보내기
			mailSender.send(message);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
