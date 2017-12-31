<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
	<!-- main -->
	<section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> 게시글 조회  </h3>
          	
          	<form role="form" method="post">
          				<input type="hidden" name="bid" value="${bbsVO.bid }"/>
          				<input type="hidden" name="page" value="${findCriteria.page }"/>
          				<input type="hidden" name="numPerPage" value="${findCriteria.numPerPage }"/>
          				<input type="hidden" name="findType" value="${findCriteria.findType }"/>
          				<input type="hidden" name="keyword" value="${findCriteria.keyword }"/>
          	</form>
          	
          	<!-- BASIC FORM ELELEMNTS -->
          	<div class="row mt">
          		<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> 조회사항 </h4>
                      <form class="form-horizontal style-form" method="post">
                      
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">제목</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="subject" value="${bbsVO.subject }" readonly="readonly">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"> 내용 </label>
                              <div class="col-sm-10">
                                  <!-- <input type="text" class="form-control"> -->
                                  <textarea class="form-control"  rows="4" cols="" name="content" readonly="readonly">${bbsVO.content }</textarea>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">작성자 </label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control round-form" name="writer" value="${bbsVO.writer }" readonly="readonly">
                              </div>
                          </div>
                          
                          
                          
                      
          			</form>
                  </div>
                  
					<div class="form-group">
						<div class="col-sm-12" align="center">
			          		<button type="button" id="btn_modify" class="btn btn-primary">수정하</button>&nbsp;
			          		<button type="button" class="btn btn-danger">삭제하기 </button>&nbsp;
			          		<button type="button" class="btn btn-info">목록으</button>
		          		</div>
		          	</div> 
		          	
		          	<script>
		          		$(document).ready(function() {
		          			var frmObj = $("form[role='form']");
		          			
		          			console.log("폼태그 입니다. ");
		          			
		          			$("#btn_modify").on("click", function(){
		          				frmObj.attr("action","/fbbs/modifyPage");
		          				frmObj.attr("method","get");
		          				frmObj.submit();
		          			});
		          			
		          			$(".btn-danger").on("click", function(){
		          				frmObj.attr("method", "get");
		          				
		          				frmObj.attr("action","/fbbs/delPage");
		          				frmObj.submit();
		          			});
		          			
		          			$(".btn-info").on("click", function(){
		          				//self.location = "/bbs/list";
		          				frmObj.attr("method","get");
		          				frmObj.attr("action", "/fbbs/list");
		          				frmObj.submit(); 
		          			});
		          		});
		          	</script>
		          	                         
          		</div><!-- col-lg-12-->      	
          	</div><!-- /row -->
          	
          	
          	
          	<!-- INLINE FORM ELELEMNTS -->
          	<!-- /row -->
          	
          	<!-- INPUT MESSAGES -->
          	<!-- /row -->
          	
          	<!-- INPUT MESSAGES -->
          	<!-- /row -->
          	
          	
		</section><! --/wrapper -->
      </section>

<%@ include file="../include/footer.jsp" %>
