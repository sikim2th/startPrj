<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
	<!-- main -->



      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> 리스트  페이지  </h3>
		  		<div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
                      <h4><i class="fa fa-angle-right"></i> 게시판 리스트 </h4>
                          <section id="unseen">
                          
                          <!-- findType -->
                          <form class="form-inline">
                          <select name="findType" class="form-control">
							  <option value="N"   <c:out value="${findCriteria.findType==null?'selected':''}"></c:out> >------</option>
							  <option value="S"   <c:out value="${findCriteria.findType=='S'?'selected':''}"></c:out>>제목</option>
							  <option value="C"   <c:out value="${findCriteria.findType=='C'?'selected' :''}"></c:out>>내용 </option>
							  <option value="W"   <c:out value="${findCriteria.findType=='W'?'selected':''}"></c:out>>작성자 </option>
							  <option value="SC"  <c:out value="${findCriteria.findType=='SC'?'selected':''}"></c:out>>제목+내용 </option>
							  <option value="CW"  <c:out value="${findCriteria.findType=='CW'?'selected':''}"></c:out>>내용+작성자 </option>
							  <option value="SCW" <c:out value="${findCriteria.findType=='SCW'?'selected':''}"></c:out>>제목+내용+작성자 </option>
						  </select>
						  <!-- keyword -->
						  <input type="text" name="keyword" id="findword" value="${findCriteria.keyword }">
						  </form>
						  <button id="findBtn">검색</button>
						  
                            <table class="table table-bordered table-striped table-condensed">
                              <thead>
                              <tr>
                                  <th>글번</th>
                                  <th>제목 </th>
                                  <th>작성자 </th>
                                  <th>작성일 </th>
                                  <th class="numeric">조회</th>
                               </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${list }" var="bvo">
                              <tr>
                                  <td>${bvo.bid }</td>
                                  <!-- <td><a href="/bbs/read?bid=${bvo.bid }">${bvo.subject }</a></td> -->
                                  <td><a href="/fbbs/readPage${pagingMaker.makeFind(pagingMaker.pageCriteria.page)}&bid=${bvo.bid} ">${bvo.subject }</a></td>
                                  <td >${bvo.writer }</td>
                                  <td><fmt:formatDate pattern="yy-MM-dd HH:mm" value="${bvo.regdate }"/></td>
                                  <td class="numeric">${bvo.hit }</td>
                              </tr>
                              </c:forEach>
                              
                              </tbody>
                          </table>
                          </section>
                  </div><!-- /content-panel -->
                  
                  	<div class="showback" align="center">
						<div class="btn-group">
						  <c:if test="${pagingMaker.prev }">
						  	<a href="list${pagingMaker.makeFid(pagingMaker.startPage - 1) }" ><button type="button" class="btn btn-theme03">PREV</button></a>
						  </c:if>
						  <c:forEach begin="${pagingMaker.startPage }" end="${pagingMaker.endPage }" var="pNum">
						  	<a href="list${pagingMaker.makeFind(pNum) }">
						  		<button type="button" class="<c:out value="${pagingMaker.pageCriteria.page == pNum?'btn btn-theme':'btn btn-default'}"></c:out>" >${pNum}</button>
						  	</a>
						  </c:forEach>
						  <c:if test="${pagingMaker.next && pagingMaker.endPage > 0 }">
						  	<a href="list${pagingMaker.makeFind(pagingMaker.endPage+1)}"><button type="button" class="btn btn-theme03"> NEXT</button></a>
						  </c:if>
						</div>
      				</div>
                  
               </div><!-- /col-lg-4 -->			
		  	</div><!-- /row -->
		  	
		  	<!-- /row -->

		</section><! --/wrapper -->
      </section> 
      <script type="text/javascript">
      var result = '${result}';
      if(result == "success"){
    	  alert("등록되었습니다.")
      }
      
      $(document).ready(function(){
    	  $('#findBtn').on("click", function(e){
    		  
    		  console.log("fidword >>> " + $("#findword").val());//xxxxx
    		  
    		  self.location = "list"+"${pagingMaker.makeUri(1)}"
    		  						+"&findType=" + $("select option:selected").val()
    		  						+"&keyword=" + $("#findword").val();
    	  });
      });
      </script>
      
      
<%@ include file="../include/footer.jsp" %>