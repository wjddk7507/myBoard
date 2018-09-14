<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<div class="form-group">
	<!-- 회원가입 -->
	<!-- method와 enctype은 파일을 업로드하기 위해서 설정 
	파일이 업로드되는 폼은 반드시l method는 post로 enctype은 multipart/form-data로 설정
	onsubmit에 함수를 연결한 것은 폼의 데이터를 전송할 때 유효성 검사를 하기 위해서이다 -->

<h2 style="text-align:center">회원가입</h2>
<form  id="registerform" enctype="multipart/form-data" method="post" onsubmit="return check()" style="width:600px; margin:0 auto;">
  <div class="form-row">
  
    <div class="form-group col-md-6">
      <label for="id">이메일</label>
      <input type="email" class="form-control" name="id" id="id" maxlength=50 onblur="confirmId()" required="required" placeholder="Email">
    </div>
    
    <div class="form-group col-md-6">
    	<!-- html5의 pattern 속성을 이용해서 정규식 검사 수행 (알파벳, 한글, 2자 이상) -->
      	<label for="nickname">이름</label>
      	<input type="text" class="form-control" id="nickname" name="nickname" placeholder="nickname" pattern="([a-z, A-Z, 가-힣]){2,}" required="required" title="닉네임은 문자 2자 이상입니다.">
    	</div>
 	</div>
 	
 	<div class="form-group">
    	<label for="pw">비밀번호</label>
    	<input type="password" class="form-control" name="pw" id="pw" required="required" placeholder="password">
 	</div>
 	
 	<div class="form-group">
    <label for="pwconfirm">비밀번호 확인</label>
    <input type="password" id="pwconfirm" required="required" class="form-control" placeholder="confirm password">
	</div>
	
	<div class="form-group" style="text-align:center; margin-top:20px;">
		<img id="img" width="150px" height="150px" border="1"  class="rounded mx-auto d-block">
	 	<div class="input-group mb-3" style="margin-top:20px">
			<div class="custom-file">
		    	<input type="file" class="custom-file-input" id="profile_img" name="profile_img" />
		    	<label class="custom-file-label" for="profile_img" aria-describedby="profile_img" id="img_label">Choose file</label>
		 	</div>
		</div>
 	</div>
 	
 	
 	
  <div class="form-group" style="text-align:center">
 	<button type="submit" class="btn btn-primary">회원가입</button>
  	<button type="submit" class="btn btn-success" onclick="javascript:window.location='../'">메인으로</button>
  </div>
  
</form>


	<br />
	<br />
	
</div>

<script>
// 이메일 중복 검사 통과 여부를 저장할 변수
// 전송버튼을 눌렀을 때 이 값이 false 이면 전송하지 않는다
var idcheck = false;

// email 중복 체크를 위한 함수
function confirmId(){
	// email에 입력된 값 가져오기
	val = document.getElementById("id").value;
	idDiv = document.getElementById("idDiv");
	
	$.ajax({
		// member/join 위치에서 요청을 하기때문에
		url:'idCheck',
		// ? 뒤에 오는 값!!
		data:{'id':val},
		dataType:'json',
		success:function(data){
			if(data.result==true){
				// 이메일이 중복되지 않은 경우
				idDiv.innerHTML = "사용 가능한 이메일입니다"
				idDiv.style.color = "blue";
				idcheck = true;
			}else{
				idDiv.innerHTML = "사용 불가능한 이메일입니다"
				idDiv.style.color = "red";
				idcheck = false;
			}
		}			
	});
}

// 이미지 출력
var img = document.getElementById("img");
var profile_img = document.getElementById("profile_img");
	
// 선택한 파일 이름을 저장할 변수
var filename = "";

// image에서 선택이 변경되었을 때 호출되는 함수
profile_img.addEventListener("change", function(){
	readURL(this);
});

function readURL(input){
	// 선택한 파일명 가져오기
	filename = input.files[0].name;
	// 그림 파일인지 확인
	var ext = filename.substr(filename.length-3, filename.length);
	if(ext.toLowerCase() != 'gif' && ext.toLowerCase() != 'jpg' && ext.toLowerCase() != 'png'){
		alert("그림 파일을 선택하세요!");
		return;
	}
	// 그림 파일의 내용 읽기
	var reader = new FileReader();
	reader.readAsDataURL(input.files[0]);
	// 그림 파일의 내용을 전부 읽으면 img 에 출력
	reader.onload = function(e){
		img.src = e.target.result;
	}
	
}

// 회원가입 눌렀을 때 유효성 검사
// form에서 submit 했을 때 호출되는 함수 / false를 리턴하면 서버로 전송되지 않는다
function check(){
	// emailcheck의 값이 false이면 서버로 전송하지 않도록 
	if(idcheck == false){
		document.getElementById("idDiv").innerHTML = "이메일 중복 검사를 통과하지 못했습니다";
		document.getElementById("idDiv").style.color="red";
		document.getElementById("idDiv").focus();
		return false;
	}
	// 비밀번호에 입력한 값과 비밀번호 확인에 입력한 값이 일치하지 않으면 서버로 전송하지 않도록
	var pw = document.getElementById("pw");
	var pwconfirm = document.getElementById("pwconfirm");
	if(pw.value != pwconfirm.value){
		alert("두 개의 비밀번호는 일치해야 합니다");
		pw.focus();
		return false;
	}
	// 비밀번호는 숫자, 영문자, 특수문자 1개 이상으로 8자 이상 만들어졌는지 검사
	// 정규식 이용
	var p1 = /[0-9]/;
	var p2 = /[a-zA-Z]/;
	var p3 = /[~!@#$%^&*()]/;
	if( !p1.test(pw.value) || !pw.test(pw.value) || !p3.test(pw.value) || pw.value.length<8 ){
		alert("비밀번호는 8자 이상의 숫자, 영문자, 특수문자를 입력해주세요");
		pw.focus;
		return false;
	}
}
</script>
