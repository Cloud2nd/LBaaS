<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/TagLib.jspf" %>

<h1 class="form-header">Sign in to your Account</h1>

<script>var init = [];</script>

<script>
	init.push(function () {

		// Setup validation
		$("#signin-form_id").validate({
			ignore: '.ignore, .select2-input',
			focusInvalid: false,
			rules: {
				'email': {
				  required: true,
				  email: true,
				  minlength: 2
				},

				'passwd':{
				  required: true,
				  minlength: 2
				}
			}
		});
	});
</script>

<!-- Form -->
<form action="/login/process" id="signin-form_id" class="panel" method="post">
	<div class="form-group">
		<input type="text" name="email" id="email" class="form-control input-lg" placeholder="Username or email">
	</div> <!-- / Username -->

	<div class="form-group signin-password">
		<input type="password" name="passwd" id="password_id" class="form-control input-lg" placeholder="Password">
	</div> <!-- / Password -->

	<div class="form-actions">
		<input type="submit" value="Sign In" class="btn btn-primary btn-block btn-lg">
	</div> <!-- / .form-actions -->
</form>
<!-- / Form -->

<!-- Get jQuery from Google CDN -->
<!--[if !IE]> -->
	<script type="text/javascript"> window.jQuery || document.write('<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js">'+"<"+"/script>"); </script>
<!-- <![endif]-->
<!--[if lte IE 9]>
	<script type="text/javascript"> window.jQuery || document.write('<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js">'+"<"+"/script>"); </script>
<![endif]-->


<!-- Pixel Admin's javascripts -->
<script src="assets/javascripts/bootstrap.min.js"></script>
<script src="assets/javascripts/pixel-admin.min.js"></script>

<script type="text/javascript">
	init.push(function () {
		// Javascript code here
	})
	window.PixelAdmin.start(init);
</script>

