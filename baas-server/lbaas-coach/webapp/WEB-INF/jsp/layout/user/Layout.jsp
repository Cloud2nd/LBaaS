<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/TagLib.jspf" %>

<!DOCTYPE html>
<html class="gt-ie8 gt-ie9 not-ie">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Coursevil Admin</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">

  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,600,700,300&subset=latin" rel="stylesheet" type="text/css">

  <link href="/assets/stylesheets/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="/assets/stylesheets/pixel-admin.min.css" rel="stylesheet" type="text/css">
  <link href="/assets/stylesheets/widgets.min.css" rel="stylesheet" type="text/css">
  <link href="/assets/stylesheets/rtl.min.css" rel="stylesheet" type="text/css">
  <link href="/assets/stylesheets/themes.min.css" rel="stylesheet" type="text/css">
  
	 <script type="text/javascript"> window.jQuery || document.write('<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js">'+"<"+"/script>"); </script>
	
	<script src="/assets/javascripts/bootstrap.min.js"></script>
	<script src="/assets/javascripts/pixel-admin.min.js"></script>

</head>


<body class="theme-default main-menu-animated">

<script>var init = [];</script>

<div id="main-wrapper">
	
	<tiles:insertAttribute name="header" />
	
	<div id="content-wrapper">
		<tiles:insertAttribute name="body" />
	</div>
	
	<div id="main-menu-bg">
  	</div>
  	
</div>

</body>

<script type="text/javascript">
 window.PixelAdmin.start(init);
</script>
	  

</html>