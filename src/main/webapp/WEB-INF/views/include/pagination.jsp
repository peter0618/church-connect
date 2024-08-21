<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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