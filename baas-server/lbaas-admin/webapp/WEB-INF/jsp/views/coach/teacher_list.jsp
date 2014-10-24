<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/TagLib.jspf" %>

<ul class="breadcrumb breadcrumb-page">
  <div class="breadcrumb-label text-light-gray">
	You are here:
  </div>
  <li><a href="#">Home</a></li>
  <li class="active"><a href="/course/list">강사 관리</a></li>
</ul>

<div class="page-header">
  <div class="row">
	<h1 class="col-xs-12 col-sm-4 text-center text-left-sm">
	  <i class="fa fa-film page-header-icon"></i>
	  &nbsp;&nbsp;강사 관리</h1>
  </div>
</div>

<div class="row">
  <div class="col-md-8">
  </div>
</div>



<div class="panel">
	<div class="panel-heading">
		<span class="panel-title"></span>
	</div>
	<div class="panel-body">
		<table class="table table-striped">
		  <thead>
			<tr>
			  <th>UserID</th>
			  <th>Email</th>
			  <th>UserName</th>
			</tr>
		  </thead>
		  <tbody id="courselist">
		  </tbody>
		</table>
	</div>
</div>


<script type="text/javascript">

$(document).ready(function(){
	getData();
});

	
function getData(){
	$.ajax({
		type : 'get',
		async : false,
		url : 'http://auth.coursevil.org/api/usermanagement',
		cache : false,
		contentType : "application/json; charset=UTF-8",
		dataType : "json",
		success : function(data) {
			generate(data);
		},

		error : function(data, status, err) {
			alert('error');
		}
	});
	
}

function generate(data){
	// Success Hosts
	var cousreList = $("#courselist");
	cousreList.html("");

	var course = data.data;
	$.each(course, function(index){
		var obj=course[index];
		cousreList.append(getCourseList(obj.userId, obj.email, obj.userName));
	});	
}

function getCourseList(userId, email, userName){
	var innerDiv = '';
	innerDiv = innerDiv + '<tr>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + userId;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + email;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + userName;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '</tr>';
	return innerDiv
}

</script>

<!-- //http://119.81.162.219:8080/api/lecture/test2
 -->