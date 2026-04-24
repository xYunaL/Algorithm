-- FOOD_PRODUCT와 FOOD_ORDER 테이블에서 
-- 생산일자가 2022년 5월인 식품들의 
-- 식품 ID, 식품 이름, 총매출을 조회 
-- 이때 총매출을 기준으로 내림차순 정렬, 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬

-- # MySQL
SELECT p.product_id, 
       p.product_name, 
       (a.TOTAL_AMOUNT * p.PRICE) AS TOTAL_SALES
FROM FOOD_PRODUCT AS p
    INNER JOIN (
        SELECT o.PRODUCT_ID, SUM(o.AMOUNT) AS TOTAL_AMOUNT, o.produce_date
        FROM FOOD_ORDER o
        WHERE o.produce_date >= '2022-05-01' 
            AND o.produce_date < '2022-06-01'
        GROUP BY o.PRODUCT_ID
    ) a
    ON p.product_id = a.product_id
ORDER BY TOTAL_SALES DESC, p.PRODUCT_ID ASC;

-- # Oracle
-- ## 1. 선 집계 후 조인
SELECT p.product_id, 
       p.product_name, 
       (a.TOTAL_AMOUNT * p.price) AS TOTAL_SALES
FROM FOOD_PRODUCT p
INNER JOIN (
    SELECT product_id, SUM(amount) AS TOTAL_AMOUNT
    FROM FOOD_ORDER
    WHERE produce_date >= TO_DATE('2022-05-01', 'YYYY-MM-DD') 
      AND produce_date < TO_DATE('2022-06-01', 'YYYY-MM-DD')
    GROUP BY product_id
) a
ON p.product_id = a.product_id
ORDER BY TOTAL_SALES DESC, p.product_id ASC;

-- ## 2. 선 조인 후 집계
SELECT p.product_id, 
       p.product_name, 
       SUM(p.price * o.amount) AS TOTAL_SALES
FROM FOOD_PRODUCT p
INNER JOIN FOOD_ORDER o 
        ON p.product_id = o.product_id
WHERE o.produce_date >= TO_DATE('2022-05-01', 'YYYY-MM-DD') 
  AND o.produce_date < TO_DATE('2022-06-01', 'YYYY-MM-DD')
GROUP BY p.product_id, p.product_name
ORDER BY TOTAL_SALES DESC, p.product_id ASC;

-- 가독성을 높이기 위해 아래와 같이 '먼저 조인하고 나중에 집계하는' 표준적인 방식이 가장 많이 사용됨.
-- 오라클 옵티마이저(Optimizer)는 위처럼 작성해도 내부적으로 최적의 실행 계획을 찾아 연산함.