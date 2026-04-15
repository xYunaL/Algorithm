-- FOOD_PRODUCT 테이블에서 
-- 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회하는 SQL문
-- 이때 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력
-- 식품 가격을 기준으로 내림차순 정렬해주세요.

SELECT f.CATEGORY, f.PRICE, f.PRODUCT_NAME
FROM FOOD_PRODUCT f
    INNER JOIN (
        SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
        FROM FOOD_PRODUCT
        WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
        GROUP BY CATEGORY
    ) m
    ON f.CATEGORY = m.CATEGORY AND f.PRICE = m.MAX_PRICE
ORDER BY f.PRICE DESC;