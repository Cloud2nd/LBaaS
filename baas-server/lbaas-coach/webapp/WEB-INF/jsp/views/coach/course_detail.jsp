<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/TagLib.jspf" %>

<script>
	init.push(function(){
		$( "#ui-menu-demo" ).menu();
	});
</script>

<ul class="breadcrumb breadcrumb-page">
  <div class="breadcrumb-label text-light-gray">
	You are here:
  </div>
  <li><a href="/">Home</a></li>
  <li><a href="/course/list">강좌 관리</a></li>
  <li class="active"><a href="#">MySQL 입문</a></li>
</ul>


<div class="page-header">
  <div class="row">
	<h1 class="col-xs-12 col-sm-4 text-center text-left-sm" id="LectureCodeHead">
	  <i class="fa fa-file-text page-header-icon"></i>
	  test</h1>
  </div>
</div>


<div class="row">
  <div class="col-md-8">
  </div>
</div>

<div class="panel-heading">
	<span class="panel-title">Course Infomation</span>
</div>

<div class="panel-body form-horizontal">
	<div class="form-group">
		<label for="lectureCode" class="col-sm-2 control-label">Lecture Code</label>
		<div class="col-sm-10">
			<input id="lectureCodeValue" type="text" class="form-control" id="inputEmail2" placeholder="Lecture Code" disabled>
		</div>
	</div> <!-- / .form-group -->

	<div class="form-group">
		<label for="lectureName" class="col-sm-2 control-label">Lecture Name</label>
		<div class="col-sm-10">
			<input id="lectureNameValue" type="text" class="form-control" id="inputEmail2" placeholder="Lecture Name" disabled>
		</div>
	</div> <!-- / .form-group -->

	<div class="form-group">
		<label for="lectureName" class="col-sm-2 control-label">Lecture Description</label>
		<div class="col-sm-10">
			<textarea id="lectureDescValue" class="form-control" name="jq-validation-text" id="jq-validation-text" placeholder="본 강좌에 대한 설명을 간략히 적어주세요." disabled></textarea>
		</div>
	</div> <!-- / .form-group -->

	<div style="margin-bottom: 0;">
		<div class="col-sm-offset-2 col-sm-10">
			<button id="edit" class="btn btn-primary" onclick="edit();">Edit</button>
			<button id="cancel" class="btn btn-primary" onclick="cancel();">Cancel</button>
			<button id="update" class="btn btn-primary" onclick="update();">Update</button>
		</div>
	</div> <!-- / .form-group -->

</div>






<script type="text/javascript">

$(document).ready(function(){

	$("#cancel").hide();
	$("#update").hide();
	
	getData();
});

	
function getData(){
	$.ajax({
		type : 'get',
		async : false,
		url : 'http://dev.api.coursevil.org/api/lecture/test1',
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
	
	var courseData = data.data;
	$("#LectureCodeHead").html("<i class=\"fa fa-file-text page-header-icon\"></i>&nbsp;&nbsp;"+courseData.lectureName);
	$("#lectureCodeValue").val(courseData.lectureCode);
	$("#lectureNameValue").val(courseData.lectureName);
	$("#lectureDescValue").val(courseData.lectureName);
}

function edit(){

	var editBtn = $("#courselist");

	$("#lectureNameValue").attr('disabled', false);
	$("#lectureDescValue").attr('disabled', false);

	$("#cancel").show();
	$("#update").show();
	$("#edit").hide();
}

function cancel(){
	
	$("#lectureNameValue").attr('disabled', true);
	$("#lectureDescValue").attr('disabled', true);

	$("#cancel").hide();
	$("#update").hide();
	$("#edit").show();

}

function update(){
	alert("업데이트 요청되었습니다.");
}
</script>
