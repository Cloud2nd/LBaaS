<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/TagLib.jspf" %>

<div id="main-navbar" class="navbar navbar-inverse" role="navigation">
<button type="button" id="main-menu-toggle">
  <i class="navbar-icon fa fa-bars icon"></i>
  <span class="hide-menu-text">HIDE MENU</span>
</button>

<div class="navbar-inner">
  <div class="navbar-header">
	<a href="/" class="navbar-brand">
	  <div><img alt="CourseVil Admin" src="/assets/images/pixel-admin/main-navbar-logo.png"></div>
	  CourseVil Admin
	</a>
	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-navbar-collapse">
	  <i class="navbar-icon fa fa-bars"></i>
	</button>
  </div>
</div>
</div>

<div id="main-menu" role="navigation">
<div id="main-menu-inner">
  <div class="menu-content top">
	<a href="/course/create" class="btn btn-primary btn-labeled" style="width: 100%;">
	<span class="btn-label icon fa fa-plus"></span>강좌 등록</a>
  </div>

  <ul class="navigation">
	<li>
	  <a href="/"><i class="menu-icon fa fa-dashboard"></i>
		<span class="mm-text">Dashboard</span></a>
	</li>

	<li class="">
	  <a href="/course/list"><i class="menu-icon fa fa-film"></i>
		<span class="mm-text">강좌 관리</span></a>
	</li>
  </ul>
</div>
</div>