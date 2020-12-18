<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="<c:url value="/resources/login.css" />" rel="stylesheet">
<link href="<c:url value="/resources/util.css" />" rel="stylesheet">
<link href="<c:url value="https://use.fontawesome.com/releases/v5.15.1/css/all.css" />" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous"  rel="stylesheet">
<link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/animate.css" />" rel="stylesheet">
<link href="<c:url value="/resources/hamburgers.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/select2.min.css" />" rel="stylesheet">




<meta charset="utf-8">

<head>
<title>Page de Connexion</title>
</head>
<body>



<div class="limiter">
	<div class="container-login100">
		<div class="wrap-login100">
			<div class="login100-pic js-tilt" data-tilt>
				<img src='<c:url value="/resources/hiclipart.png"></c:url>' />
			</div>

			<form class="login100-form validate-form">
					<span class="login100-form-title">
						Se connecter
					</span>

				<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
					<label for="mail">Email:</label>
					<input class="input100" name="mail" size="30" />
					<span class="focus-input100"></span>
					<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Password is required">
					<label for="mdp">Mot de passe:</label>
					<input class="input100" type="password" name="mdp" size="30" /> ${erreurMessage}
					<span class="focus-input100"></span>
					<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
				</div>

				<div class="container-login100-form-btn">
					<button class="login100-form-btn">
						Login
					</button>
				</div>

				<div class="text-center p-t-136">
					<a class="txt2" href="civil">
						S'enregistrer
						<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
					</a>
				</div>
			</form>
		</div>
	</div>
</div>

</body>
</html>