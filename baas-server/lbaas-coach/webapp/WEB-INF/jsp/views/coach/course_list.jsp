<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/TagLib.jspf" %>

<ul class="breadcrumb breadcrumb-page">
  <div class="breadcrumb-label text-light-gray">
	You are here:
  </div>
  <li><a href="#">Home</a></li>
  <li class="active"><a href="/course/list">강좌 관리</a></li>
</ul>

<div class="page-header">
  <div class="row">
	<h1 class="col-xs-12 col-sm-4 text-center text-left-sm">
	  <i class="fa fa-film page-header-icon"></i>
	  &nbsp;&nbsp;강좌 관리</h1>
  </div>
</div>

<div class="row">
  <div class="col-md-8">
  </div>
</div>

<form action="" class="col-md-4">
  <div class="input-group input-group-sm">
	<input type="text" class="form-control" placeholder="Search..." name="s">
	  <span class="input-group-btn">
		<button class="btn" type="submit">
		  <span class="fa fa-search"></span>
		</button>
	  </span>
  </div>
</form>

<a href="/course/create" class="btn btn-md btn-primary col-md-2"  role="button">강좌 등록</a>
<br><br>

<div class="panel">
	<div class="panel-heading">
		<span class="panel-title"></span>
	</div>
	<div class="panel-body">
		<table class="table table-striped">
		  <thead>
			<tr>
			  <th>강좌코드</th>
			  <th>강좌명</th>
			  <th>언어</th>
			  <th>강좌유형</th>
			  <th>대기인원</th>
			  <th>상태</th>
			  <th>Detail</th>
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
		url : 'http://dev.api.coursevil.org/api/lecture',
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
		cousreList.append(getCourseList(obj.lectureCode, obj.lectureName, obj.lectureLanguage, obj.lectureType, obj.lectureThumbnail, obj.needApprove));
	});	
}

function getCourseList(code, name, language, type, thumbnail, notapprove){
	var innerDiv = '';
	innerDiv = innerDiv + '<tr>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + code;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + name;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + language;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + type;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + notapprove;
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + '시작';
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '<td>';
	innerDiv = innerDiv + '<a href="/course/detail/'+code+'">'+"강좌상세"+'</a>';
	innerDiv = innerDiv + '</td>';
	innerDiv = innerDiv + '</tr>';
	return innerDiv
}

</script>

<!-- //http://119.81.162.219:8080/api/lecture/test2
 -->