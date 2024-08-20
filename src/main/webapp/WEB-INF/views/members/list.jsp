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
                <tr>
                    <th scope="row">3</th>
                    <td>Peter</td>
                    <td>집사</td>
                    <td>성령셀</td>
                    <td>010-1111-1111</td>
                    <td>1985-01-01</td>
                    <td class="member-address" data-bs-toggle="tooltip" data-bs-title="광진구 중랑구 겸재로 50길 6 대성쉐르빌 302호">광진구 중랑구 겸재로 50길 6 대성쉐르빌 302호</td>
                    <td></td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Grace</td>
                    <td>간사</td>
                    <td>사랑셀</td>
                    <td>010-2222-2222</td>
                    <td>1987-02-02</td>
                    <td class="member-address" data-bs-toggle="tooltip" data-bs-title="광진구 군자동">광진구 군자동</td>
                    <td>2016-02-17</td>
                </tr>
                <tr>
                    <th scope="row">1</th>
                    <td>John</td>
                    <td>성도</td>
                    <td>소망셀</td>
                    <td>010-3333-3333</td>
                    <td>1989-03-03</td>
                    <td class="member-address" data-bs-toggle="tooltip" data-bs-title="강원도 철원군 동송읍 이평로 131번길 23 우림빌리지 3동 302호">강원도 철원군 동송읍 이평로 131번길 23 우림빌리지 3동 302호</td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>

    </div>

    <%@ include file="../include/footer.jsp" %>
</div>

<%@ include file="../include/plugin_js.jsp" %>
<script>
  const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
  const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
</script>
</body>
</html>