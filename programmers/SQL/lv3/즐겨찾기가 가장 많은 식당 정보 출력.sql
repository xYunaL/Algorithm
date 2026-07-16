-- REST_INFO 테이블에서 음식종류별로 즐겨찾기수가 가장 많은 식당의 
-- 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회
-- 음식 종류를 기준으로 내림차순 정렬

SELECT r.FOOD_TYPE, r.REST_ID, r.REST_NAME, m.MAX_FAV
FROM REST_INFO r 
    INNER JOIN (
        SELECT FOOD_TYPE, MAX(FAVORITES) AS MAX_FAV
        FROM REST_INFO
        GROUP BY FOOD_TYPE
    ) m
    ON m.REST_ID = r.REST_ID
ORDER BY r.FOOD_TYPE DESC;