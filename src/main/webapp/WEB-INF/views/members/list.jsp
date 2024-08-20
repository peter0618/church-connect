<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html>
<head>
    <%@ include file="../include/head.jsp" %>
    <style>
        .member-address {
          white-space: nowrap;
          text-overflow:ellipsis;
          overflow: hidden;
          max-width:1px;
        }
    </style>
    <title>Home</title>
</head>

<body>
<div class="body-wrapper">
    <%@ include file="../include/header.jsp" %>

    <div class="content">
        <!-- 컨텐츠 내용 입력 -->
        <div class="container mt-5" style="height: 100%;">

            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="col-1" scope="col">#</th>
                    <th class="col-1" scope="col">이름</th>
                    <th class="col-1" scope="col">직분</th>
                    <th class="col-1" scope="col">셀</th>
                    <th class="col-2" scope="col">전화번호</th>
                    <th class="col-2" scope="col">생년월일</th>
                    <th class="col-auto" scope="col">주소</th>
                    <th class="col-2" scope="col">등록일</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="pageUncount"
                       value="${pageUtil.totalRowCount - ((pageUtil.pageNum - 1) *  pageUtil.pageListSize)}"/>
                <c:forEach items="${list}" var="listVo">
                    <tr>
                        <th scope="row">${pageUncount}</th>
                        <td>${listVo.name}</td>
                        <td>${listVo.position}</td>
                        <td>${listVo.cellName}</td>
                        <td>${listVo.phoneNumber}</td>
                        <td><fmt:formatDate value="${listVo.birthDate}" pattern="yyyy-MM-dd" /></td>
                        <td class="member-address" data-bs-toggle="tooltip" data-bs-title="${listVo.address}">${listVo.address}</td>
                        <td><fmt:formatDate value="${listVo.registrationDate}" pattern="yyyy-MM-dd" /></td>
                    </tr>
                <c:set var="pageUncount" value="${pageUncount - 1}"/>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="container mt-5" style="height: 100%;">
            <!-- pagination start -->
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <c:if test="${pageUtil.blockStartNum > 1 }">
                    <li class="page-item">
                        <a class="page-link" href="javascript:goPage(${pageUtil.blockStartNum - 1 });" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    </c:if>
                    <c:forEach var="pnum" begin="${pageUtil.blockStartNum}" end="${pageUtil.blockEndNum }">
                        <c:choose>
                            <c:when test="${pnum == pageUtil.pageNum }">
                                <li class="page-item active"><a class="page-link" href="#">${pnum}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link" href="javascript:goPage(${pnum});">${pnum}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pageUtil.blockEndNum < pageUtil.pageTotalCount }">
                    <li class="page-item">
                        <a class="page-link" href="javascript:goPage(${pageUtil.blockEndNum + 1 });" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    </c:if>
                </ul>
            </nav>
            <!-- pagination end -->
        </div>

    </div>

    <%@ include file="../include/footer.jsp" %>
</div>

<%@ include file="../include/plugin_js.jsp" %>
<script>
  // tooltip init. (ref: https://getbootstrap.com/docs/5.3/components/tooltips/#enable-tooltips)
  const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
  const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))


  // pagination util logic start
  /**
   * 다른 쿼리 파라미터는 유지한 상태로 페이지를 이동합니다.
   */
  function goPage(page) {
    // 현재 page 의 path 가져오기 (호스트 뒤에 나오는 경로)
    const path = location.pathname;
    // 현재 페이지의 query string 가져오기
    const queryString = location.search;

    const newPageUrl = getNewPageUrl(page, path, queryString);
    location.href = newPageUrl;
  }

  /**
   * 현재 페이지 url 에서 page 쿼리 파라미터만 변경한 url 을 반환합니다.
   */
  function getNewPageUrl(page, path, queryString) {
    const searchParams = new URLSearchParams(queryString);
    searchParams.set("page", page);
    return path + '?' + searchParams.toString();
  }
  // pagination util logic end
</script>
</body>
</html>