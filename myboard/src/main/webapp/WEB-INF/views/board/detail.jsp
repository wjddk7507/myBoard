<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<section class="content">
	<div class="container">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">상세보기</h3>
			</div>

			<div class="box-body">
				<div class="form-group">
					<label>제목</label> <input type="text" name="board_title"
						class="form-control" value="${board.board_title}" readonly="readonly" />
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea name="board_content" rows="5" readonly="readonly"
						class="form-control">${board.board_content}</textarea>
				</div>

				<div class="form-group">
					<label>작성자</label> 
					<img src="${pageContext.request.contextPath}/profile/${board.profile_img}" id="profile-img">
					<input type="text" class="form-control" value="${board.nickname}" readonly="readonly" />
				</div>
			</div>
			<div class="box-footer">
				<button class="btn btn-success" id="mainBtn">메인</button>
				<c:if test="${member.id == board.id}">
					<button class="btn btn-warning" id="updateBtn">수정</button>								
					<button class="btn btn-danger" id="deleteBtn">삭제</button>
				</c:if>
				<button class="btn btn-primary" id="listBtn">목록</button>
			</div>
		</div>
	</div>
	</section>
	<script>
		//메인 버튼을 눌렀을 때 처리
		document.getElementById("mainBtn").addEventListener("click",function() {
				location.href = "../";
		});
		//목록 버튼을 눌렀을 때 처리
		document.getElementById("listBtn").addEventListener("click",function() {			
			location.href = "list?page=${criteria.page}&perPageNum=${criteria.perPageNum}";
		});
		<c:if test = "${member.id == board.id}">
		//삭제 버튼을 눌렀을 때 처리 // 다이얼로그 이용
		document.getElementById("deleteBtn").addEventListener("click", function(){
			location.href = "delete?board_num=" + ${board.board_num}+"&page=${criteria.page}&perPageNum=${criteria.perPageNum}";		
		});
		//수정 버튼을 눌렀을 때 처리
		document.getElementById("updateBtn").addEventListener("click",function() {
					location.href = "update?board_num=" + ${board.board_num};
				});
		</c:if>
		
		
	</script>
	
	<c:if test="${user.email == vo.email}">
	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<div id="dialog-confirm" title="정말로 삭제?" style="display: none">
		<p>삭제하시면 복구할 수 없습니다. 그래도 삭제하실 건가요?</p>
	</div>
	<script>
		document.getElementById("deleteBtn").addEventListener("click", function(){
			$("#dialog-confirm").dialog({
			      resizable: false,
			      height: "auto",
			      width: 400,
			      modal: true,
			      buttons: {
			        "삭제": function() {
			          $(this).dialog("close");
			          location.href="delete?board_num=${board.board_num}";
			        },
			        "취소": function() {
			          $(this).dialog("close");
			        }
			      }
			    });
		})
	</script>
	
</c:if>
</body>
</html>