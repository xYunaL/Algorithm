-- 자동차 종류가 '세단'인 자동차들 중 
-- 10월에 대여를 시작한 기록이 있는 자동차 ID 리스트를 출력
-- 자동차 ID 리스트는 중복이 없어야 하며, 자동차 ID를 기준으로 내림차순 정렬

SELECT history.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR car RIGHT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY history
    ON car.car_id = history.car_id
WHERE 
    car.CAR_TYPE = '세단' 
    AND history.start_date BETWEEN '2022-10-01' AND '2022-10-31'
GROUP BY history.car_id
ORDER BY history.car_id DESC;