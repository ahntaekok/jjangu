    var id_check_yn = false;
    var nick_check_yn = false;
    var pw_check_yn = false;

function signup_submit() {
    if(id_check_yn == false){
        alert('아이디 중복확인 해주세요.');
        return false;
    }
    if(nick_check_yn == false){
        alert('닉네임 중복확인 해주세요.');
        return false;
    }
    if(pw_check_yn == false){
        alert('비밀번호 일치 시켜주세요.');
        return false;
    }
    $('#signup_form').submit();
}

document.addEventListener("DOMContentLoaded", function() {
  var pwdInput = document.getElementById("signup_password");
  var cPassInput = document.getElementById("cpass");
  var resultLabel = document.getElementById("passwordMatchLabel");

  pwdInput.addEventListener("keyup", function() {
    checkPasswordMatch();
  });

  cPassInput.addEventListener("keyup", function() {
    checkPasswordMatch();
  });

  function checkPasswordMatch() {
    var password = pwdInput.value;
    var confirmPassword = cPassInput.value;

    if(password === "" && confirmPassword === ""){
      resultLabel.textContent = "비밀번호 확인";
      resultLabel.style.color = "#555555";
      return false;
    }
    if (password === confirmPassword) {
      resultLabel.textContent = "비밀번호가 일치합니다.";
      resultLabel.style.color = "green";
      pw_check_yn = true;
    } else {
      resultLabel.textContent = "비밀번호가 일치하지 않습니다.";
      resultLabel.style.color = "red";
      pw_check_yn = false;
    }
  }
});

$(document).ready(function() {
  $('#check_button').click(function() {
    var resultLabel = $("#signup_ID_OK");
    var u_name = $('#signup_ID').val(); // 입력된 이름 값 가져오기
    if(u_name===""){
        resultLabel.text("아이디를 입력하세요");
        resultLabel.css("color", "red");
        return false;
    }
    // AJAX 요청 설정
    $.ajax({
      type: 'POST', // HTTP 요청 방식 설정 (GET 또는 POST)
      url: 'id_check', // 요청을 보낼 URL
      data: { u_name: u_name }, // 전송할 데이터 설정
      success: function(response) {
        if(response == 202){
          resultLabel.text("아이디 사용 가능합니다.");
          resultLabel.css("color", "green");
          id_check_yn = true;
        } else {
          resultLabel.text("아이디 중복입니다.");
          resultLabel.css("color", "red");
        }
      },error: function() {
                alert('에러가 발생했습니다.'); // 에러 시 처리
              }
    });
  });
});


document.addEventListener("DOMContentLoaded", function() {
  var idInput = document.getElementById("signup_ID");
  var resultLabel = $("#signup_ID_OK");

  idInput.addEventListener("keyup", function() {
    if(id_check_yn == true){
        id_check_yn = false;
        resultLabel.text("아이디 다시 검사하세요");
        resultLabel.css("color", "red");
    }
  });
});

$(document).ready(function() {
  $('#nick_check_button').click(function() {
    var resultLabel = $("#signup_nick_OK");
    var u_nickname = $('#signup_nick').val(); // 입력된 이름 값 가져오기
    if(u_nickname===""){
        resultLabel.text("닉네임을 입력하세요");
        resultLabel.css("color", "red");
        return false;
    }
    // AJAX 요청 설정
    $.ajax({
      type: 'POST', // HTTP 요청 방식 설정 (GET 또는 POST)
      url: 'nick_check', // 요청을 보낼 URL
      data: { u_nickname: u_nickname }, // 전송할 데이터 설정
      success: function(response) {
        if(response == 202){
          resultLabel.text("닉네임 사용 가능합니다.");
          resultLabel.css("color", "green");
          nick_check_yn = true;
        } else {
          resultLabel.text("닉네임 중복입니다.");
          resultLabel.css("color", "red");
        }
      },error: function() {
                alert('에러가 발생했습니다.'); // 에러 시 처리
              }
    });
  });
});

document.addEventListener("DOMContentLoaded", function() {
  var resultLabel = $("#signup_nick_OK");
  var idInput = document.getElementById("signup_nick");

  idInput.addEventListener("keyup", function() {
    if(nick_check_yn == true){
        nick_check_yn = false;
        resultLabel.text("닉네임 다시 검사하세요");
        resultLabel.css("color", "red");
    }
  });
});

    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;

                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
