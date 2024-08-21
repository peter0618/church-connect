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