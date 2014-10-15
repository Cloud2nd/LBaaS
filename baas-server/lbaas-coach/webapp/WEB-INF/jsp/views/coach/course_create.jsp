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
	<div class="col-sm-12">

		<form id="lecture-regist-form" class="panel form-horizontal">
			<div class="panel-body">
				<div class="form-group">
					<label for="inputEmail2" class="col-sm-2 control-label">강좌명</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="lectureName" name="lectureName" placeholder="강좌명을 입력해주세요">
					</div>
				</div> <!-- / .form-group -->
				<div class="form-group">
					<label for="asdasdas" class="col-sm-2 control-label">강좌설명</label>
					<div class="col-sm-10">
						<textarea id="lectureDescription" name="lectureDescription" class="form-control"></textarea>
						<p class="help-block">강좌 설명을 적어주세요</p>
					</div>
				</div> <!-- / .form-group -->

				<!-- 강의 Type -->
				<div class="form-group">
					<label class="col-sm-2 control-label">강좌Type</label>
					<div class="col-sm-10">
						<div class="radio">
							<label>
								<input type="radio" name="lectureType" id="lectureTypeMovie" value="MOVIE" class="px" checked="">
								<span class="lbl">동영상강좌</span>
							</label>
						</div> <!-- / .radio -->
						<div class="radio">
							<label>
								<input type="radio" name="lectureType" id="lectureTypeText" value="TEXT" class="px">
								<span class="lbl">File</span>
							</label>
						</div> <!-- / .radio -->
					</div> <!-- / .col-sm-10 -->
				</div> <!-- / .form-group -->

				<!-- 언어 선택 -->
				<div class="form-group">
					<label class="col-sm-2 control-label">Language</label>
					<div class="col-sm-10">
						<div class="radio">
							<label>
								<input type="radio" name="lectureLanguage" id="languageKR" value="KR" class="px" checked="">
								<span class="lbl">Korean</span>
							</label>
						</div> <!-- / .radio -->
						<div class="radio">
							<label>
								<input type="radio" name="lectureLanguage" id="languageEN" value="EN" class="px">
								<span class="lbl">English</span>
							</label>
						</div> <!-- / .radio -->
					</div> <!-- / .col-sm-10 -->
				</div> <!-- / .form-group -->

				<div class="form-group" style="margin-bottom: 0;">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" id="lectureRegistBtn" class="btn btn-primary">강좌 등록</button>
					</div>
				</div> <!-- / .form-group -->
			</div>
		</form>
	<!-- /10. $FORM_EXAMPLE -->

	</div>
</div>



<script type="text/javascript">

$(document).ready(function() { 
	
	$("#lectureRegistBtn").click(function(e){

		  var json_val = JSON.stringify($("#lecture-regist-form").serializeObject());
		  
		  $.ajax({
			type : 'POST',
			async : false,
			url : 'http://dev.api.coursevil.org/api/lecture',
			cache : false,
			contentType : "application/json; charset=UTF-8",
			data : json_val,
			success: function(data, textStatus, jqXHR)
			{
			   alert("강좌 등록 요청되었습니다.");
			},
			error: function (jqXHR, textStatus, errorThrown)
			{
				alert("에러"+errorThrown);
			}
		});
	});
    
}); 

function onSuccess(json, status){alert($.trim(json));}

function onError(data, status){alert("error");}

/* form data to json */
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
 



</script>
