package kr.co.myboard.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.myboard.dao.MemberDao;
import kr.co.myboard.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	@Override
	public String idCheck(HttpServletRequest request) {
			String id = request.getParameter("id");
			return memberDao.idCheck(id);
	}

	@Override
	public void join(MultipartHttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		// 파일
		MultipartFile profile_img = request.getFile("profile_img");
		
		// 파일을 저장할 경로 만들기 // 파일은 절대경로로만 저장이 가능
		// 프로젝트 내의 userimage 디렉토리의 절대 경로를 만들기
		String uploadPath = request.getRealPath("/profile");
		// 랜덤한 64자리의 문자열 만들기
		UUID uid = UUID.randomUUID();
		// 원본 파일이름 가져오기
		String filename = profile_img.getOriginalFilename();
		filename = uid+"_"+filename;
		// 업로드할 파일의 실제 경로 만들기
		String filepath = uploadPath+"\\"+filename;
		//System.out.println("실제 저장 경로 : "+filepath);
			
		// Dao의 파라미터로 사용할 객체
		Member mymember = new Member();
		// 업로드할 파일 객체 만들기
		File f = new File(filepath);
		try {
			// 파일 전송 - 파일 업로드
			profile_img.transferTo(f);
			mymember.setId(id);
			mymember.setPw(BCrypt.hashpw(pw, BCrypt.gensalt(10)));
			mymember.setNickname(nickname);
			// 데이터베이스에는 파일 이름만 저장
			mymember.setProfile_img(filename);
			memberDao.join(mymember);
		}catch(Exception e) {
			System.out.println("회원가입 실패 : "+e.getMessage());
		}

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
}
