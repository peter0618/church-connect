<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="${rootSrc}/bootstrap/js/bootstrap.bundle.js"></script>
<script>
  window.addEventListener('DOMContentLoaded', (event) => {
    updateActiveMenuItem();
  });

  function updateActiveMenuItem() {
    // 현재 페이지의 pathname을 가져옵니다.
    const currentPath = location.pathname;

    // nav-item-list(ul 태그) 하위에 있는 모든 a 태그를 가져옵니다.
    const menuLinks = document.querySelectorAll('#nav-item-list a');

    // 각 a 태그에 대해 루프를 돌면서 href가 현재 pathname과 일치하는지 검사합니다.
    menuLinks.forEach(function(menuLink) {
      // a 태그의 href 속성에서 pathname을 추출합니다.
      const linkPath = new URL(menuLink.href).pathname;

      // 현재 페이지의 pathname과 비교하여 일치하면 active 클래스를 추가합니다.
      if (linkPath === currentPath) {
        menuLink.classList.add('active');
      }
    });
  }
</script>