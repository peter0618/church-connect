<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html>
    <head>
        <%@ include file="./include/head.jsp" %>
        <title>Home</title>
    </head>

    <body>
        <div class="body-wrapper">
            <%@ include file="./include/header.jsp" %>

            <div class="content">
                <!-- 컨텐츠 내용 입력 -->
                <div class="container" style="height: 100%;">
                    <div class="container">
                        <form action="/" class="mb-5">
                            <input class="form-control me-2 mt-5" name="name" type="search" value="${name}" placeholder="이름을 입력해주세요." aria-label="Search" style="height: 53px;">
                        </form>
                        <c:if test="${emptyList}">
                            <div class="ms-2">데이터가 없습니다.</div>
                        </c:if>

                        <c:forEach items="${list}" var="listVo">
                            <div class="mt-3">
                                <div class="card" onclick="onMemberCardClicked(${listVo.id});">
                                    <div class="row g-0">
                                        <div class="col-auto">
                                            <img src="${rootSrc}/image/poster_no_img.jpg" class="img-fluid rounded-start" style="width: 120px; height: 160px;">
                                        </div>
                                        <div class="col">
                                            <div class="card-body">
                                                <h5 class="card-title">${listVo.name} ${listVo.position}</h5>
                                                <p class="flex mb-1" style="font-size: small">
                                                    <span>${listVo.cellName}</span>
                                                    <span>|</span>
                                                    <span>${listVo.age()}세</span>
                                                    <span>|</span>
                                                    <span><fmt:formatDate value="${listVo.birthDate}" pattern="yyyy-MM-dd" /></span>
                                                </p>
                                                <p class="card-text" style="font-size: small">
                                                    ∙ 연락처 : ${listVo.phoneNumber}<br>
                                                    ∙ 가족 : ${listVo.familyInfo}<br>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                </div>

            </div>

            <%@ include file="./include/footer.jsp" %>
        </div>

        <%@ include file="./include/plugin_js.jsp" %>
        <script>
            function onMemberCardClicked() {
                // TODO: 사용자 카드 click 시 사용자 상세 화면으로 이동
            }
        </script>
    </body>
</html>