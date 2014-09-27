<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/TagLib.jspf" %>

<ul class="breadcrumb breadcrumb-page">
  <div class="breadcrumb-label text-light-gray">
	You are here:
  </div>
  <li><a href="#">Home</a></li>
  <li>강좌 관리</a></li>
  <li class="active"><a href="#">강좌 등록</a></li>
</ul>

<div class="page-header">
  <div class="row">
	<h1 class="col-xs-12 col-sm-4 text-center text-left-sm">
	  <i class="fa fa-suitcase page-header-icon"></i>
	  &nbsp;&nbsp;강좌 등록</h1>
  </div>
</div>

<div class="row">
  <div class="col-md-8">
  </div>
</div>

<div class="row">
  <div class="col-md-12 form-horizontal">
	  <div class="form-group ">
		<label for="jq-validation-email" class="col-sm-2 control-label">강좌코드</label>
		<div class="col-sm-10">
		  <input type="text" class="form-control" id="jq-validation-email" name="jq-validation-email" placeholder="제목을 입력하세요.">
		</div>
	  </div>
	  <div class="form-group">
		<label for="jq-validation-email" class="col-sm-2 control-label">강좌</label>
		<div class="col-sm-10">
		  <input type="text" class="form-control" id="jq-validation-email" name="jq-validation-email" placeholder="제목을 입력하세요.">
		</div>
	  </div>

	  <div class="form-group">
		<label for="jq-validation-text" class="col-sm-2 control-label">강좌 설명</label>
		<div class="col-sm-10">
		  <textarea class="form-control" name="jq-validation-text" id="jq-validation-text" placeholder="본 강좌에 대한 설명을 간략히 적어주세요."></textarea>
		</div>
	  </div>

	  <div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
		  <button class="btn btn-primary" onclick="create();">강좌 등록</button>
		</div>
	  </div>
  </div>
</div>


<script type="text/javascript">

function create(){
	  
	  var  formData = "{\"lectureCode\":\"ravi\",\"lectureName\":\"31\",\"lectureLanguage\":\"KR\",\"lectureType\":\"MOVIE\",\"lectureThumbnail\":\"1\"}";  

//    var formData = {lectureCode:"ravi",lectureName:"31",lectureLanguage:"KR",lectureType:"MOVIE",lectureThumbnail:"1"}; //Array 
 
 alert(formData);

	$.ajax({
		type : 'POST',
		async : false,
		url : 'http://119.81.162.219:8080/api/lecture',
		cache : false,
		contentType : "application/json; charset=UTF-8",
	    data : formData,
	    success: function(data, textStatus, jqXHR)
	    {
	       alert("강좌 등록 요청되었습니다.");
	    },
	    error: function (jqXHR, textStatus, errorThrown)
	    {
	 
		}
	});

}

</script>
