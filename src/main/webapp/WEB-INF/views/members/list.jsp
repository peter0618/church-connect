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


            <form role="form" action="/members" class="mb-5">
                <div class="container">
                    <div class="row">
                        <div class="col"><input class="form-control me-2 col-1" name="name" type="search" value="${param.name}" placeholder="이름을 입력해주세요." aria-label="Search" style="height: 53px;"></div>
                        <div class="col"><input class="form-control me-2 col-1" name="cellName" type="search" value="${param.cellName}" placeholder="셀 이름을 입력해주세요." aria-label="Search" style="height: 53px;"></div>
                    </div>
                    <div class="row mt-2">
                        <div class="col d-flex justify-content-end">
                            <button type="submit" class="btn btn-dark">검색</button>
                        </div>
                    </div>
                </div>
            </form>


            <table class="table table-hover">
                <thead>
                    <tr>
                        <th class="col-1 d-none d-md-table-cell" scope="col">#</th>
                        <th class="col-1" scope="col">이름</th>
                        <th class="col-1 d-none d-sm-table-cell" scope="col">직분</th> <!-- 이 열은 작은 화면(sm) 이상에서만 보임 -->
                        <th class="col-1 d-none d-md-table-cell" scope="col">셀</th>  <!-- 이 열은 중간 화면(md) 이상에서만 보임 -->
                        <th class="col-2" scope="col">전화번호</th>
                        <th class="col-2 d-none d-lg-table-cell" scope="col">생년월일</th> <!-- 이 열은 큰 화면(lg) 이상에서만 보임 -->
                        <th class="col-auto d-none d-xl-table-cell" scope="col">주소</th> <!-- 이 열은 매우 큰 화면(xl) 이상에서만 보임 -->
                        <th class="col-2 d-none d-lg-table-cell" scope="col">등록일</th>
                    </tr>
                </thead>
                <tbody>
                <c:set var="pageUncount"
                       value="${pageUtil.totalRowCount - ((pageUtil.pageNum - 1) *  pageUtil.pageListSize)}"/>
                <c:forEach items="${list}" var="listVo">
                    <tr>
                        <th class="col-1 d-none d-md-table-cell" scope="row">${pageUncount}</th>
                        <td class="col-1">${listVo.name}</td>
                        <td class="col-1 d-none d-sm-table-cell">${listVo.position}</td>
                        <td class="col-1 d-none d-md-table-cell">${listVo.cellName}</td>
                        <td class="col-2">${listVo.phoneNumber}</td>
                        <td class="col-2 d-none d-lg-table-cell"><fmt:formatDate value="${listVo.birthDate}" pattern="yyyy-MM-dd" /></td>
                        <td class="member-address col-auto d-none d-xl-table-cell" data-bs-toggle="tooltip" data-bs-title="${listVo.address}">${listVo.address}</td>
                        <td class="col-2 d-none d-lg-table-cell"><fmt:formatDate value="${listVo.registrationDate}" pattern="yyyy-MM-dd" /></td>
                    </tr>
                <c:set var="pageUncount" value="${pageUncount - 1}"/>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="container mt-5" style="height: 100%;">
            <%@ include file="../include/pagination.jsp" %>
        </div>

        <div class="container mt-5 d-flex" style="height: 100%;">
            <button type="button" class="btn btn-dark d-none d-xl-block me-2" onclick="window.print();">인쇄</button>
            <button type="button" class="btn btn-dark d-none d-xl-block me-2" onclick="excelDownload();">엑셀다운로드</button>
            <form action="/members/excel/downloadAll" method="get">
                <button type="submit" class="btn btn-dark d-none d-xl-block">전체 엑셀다운로드</button>
            </form>
        </div>

    </div>

    <%@ include file="../include/footer.jsp" %>
</div>

<%@ include file="../include/plugin_js.jsp" %>
<script src="${rootSrc}/js/pagination.js"></script>
<script>
  window.addEventListener('DOMContentLoaded', (event) => {
    initBootstrapTooltip();
  });

  function initBootstrapTooltip() {
    // tooltip init. (ref: https://getbootstrap.com/docs/5.3/components/tooltips/#enable-tooltips)
    const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]');
    const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl));
  }

    function excelDownload() {
        // 현재 페이지의 query string 가져오기
        const queryString = location.search;

        const url = '/members/excel/download?' + queryString; // 다운로드할 API의 URL

        fetch(url, {
            method: 'GET', // GET 방식으로 요청
            headers: {
                'Content-Type': 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
            }
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.blob(); // 응답을 Blob 형태로 변환
        })
        .then(blob => {
            // Blob으로부터 임시 URL 생성
            const url = window.URL.createObjectURL(blob);
            const a = document.createElement('a');
            a.href = url;
            a.download = 'downloaded_excel.xlsx'; // 다운로드할 파일의 이름
            document.body.appendChild(a);
            a.click(); // 다운로드를 시작하는 클릭 이벤트 트리거
            document.body.removeChild(a); // 트리거 후 a 요소 제거
            window.URL.revokeObjectURL(url); // 임시 URL 해제
        })
        .catch(error => {
            console.error('There has been a problem with your fetch operation:', error);
        });
    }
</script>
</body>
</html>