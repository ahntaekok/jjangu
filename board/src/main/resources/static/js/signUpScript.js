        function goBack() {
            window.location.href="login";
        }
        function validateForm() {
            var password = document.getElementById("u_pw").value;
            var confirmPassword = document.getElementById("u_pw_confirm").value;

            if ((password !== confirmPassword) && password!="") {
                alert("비밀번호가 일치하지 않습니다.");
                return false;
            }
        }