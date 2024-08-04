<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                            <input class="form-control me-2 mt-5" name="name" type="search" placeholder="이름을 입력해주세요." aria-label="Search" style="height: 53px;">
                        </form>
                        <div class="mt-3">
                            <div class="card" onclick="onMemberCardClicked();">
                                <div class="row g-0">
                                    <div class="col-auto">
                                        <img src="${rootSrc}/image/poster_no_img.jpg" class="img-fluid rounded-start" style="width: 120px; height: 160px;">
                                    </div>
                                    <div class="col">
                                        <div class="card-body">
                                            <h5 class="card-title">최병준 집사</h5>
                                            <p class="flex mb-1" style="font-size: small">
                                                <span>하람셀</span>
                                                <span>|</span>
                                                <span>39세</span>
                                                <span>|</span>
                                                <span>1985-06-18</span>
                                            </p>
                                            <p class="card-text" style="font-size: small">
                                                ∙ 연락처 : 01075790618<br>
<%--                                                ∙ 등록일 : 2023년 이전등록자<br>--%>
                                                ∙ 가족 : 김예은(아내), 최은성(아들), 최성은(딸)<br>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="mt-3">
                            <div class="card">
                                <div class="row g-0">
                                    <div class="col-auto">
                                        <img src="${rootSrc}/image/poster_no_img.jpg" class="img-fluid rounded-start" style="width: 120px; height: 160px;">
                                    </div>
                                    <div class="col">
                                        <div class="card-body">
                                            <h5 class="card-title">최병준 집사</h5>
                                            <p class="flex mb-1" style="font-size: small">
                                                <span>하람셀</span>
                                                <span>|</span>
                                                <span>39세</span>
                                                <span>|</span>
                                                <span>1985-06-18</span>
                                            </p>
                                            <p class="card-text" style="font-size: small">
                                                ∙ 연락처 : 01075790618<br>
<%--                                                ∙ 등록일 : 2023년 이전등록자<br>--%>
                                                ∙ 가족 : 김예은(아내), 최은성(아들)<br>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <%@ include file="./include/footer.jsp" %>
        </div>

        <%@ include file="./include/plugin_js.jsp" %>
        <script>
            function onMemberCardClicked() {
                // alert("onMemberCardClicked!!!");
                // TODO: 사용자 카드 click 시 사용자 상세 화면으로 이동
            }
        </script>
    </body>
</html>