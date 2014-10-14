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
      <div class="col-md-12">
        <form class="form-horizontal" name="jq-validation-form" id="jq-validation-form" novalidate="novalidate">
          <div class="form-group">
            <label for="jq-validation-email" class="col-sm-2 control-label">강좌</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="lectureCode" name="lectureCode" placeholder="제목을 입력하세요.">
            </div>
          </div>

          <div class="form-group">
            <label for="jq-validation-text" class="col-sm-2 control-label">강좌 설명</label>
            <div class="col-sm-10">
              <textarea class="form-control" name="lectureName" id="lectureName" placeholder="본 강좌에 대한 설명을 간략히 적어주세요."></textarea>
            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <button  type="button" id="simplepost" class="btn btn-primary">강좌 등록</button>
            </div>
          </div>
        </form>
      </div>
    </div>


<script type="text/javascript">

$(document).ready(function() { 
            // bind 'myForm' and provide a simple callback function 
	
	$("#simplepost").click(function(e){

		 var json_val = JSON.stringify($("#jq-validation-form").serializeObject());


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
				alert("에러");
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
