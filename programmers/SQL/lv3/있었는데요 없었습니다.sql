-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문
-- 결과는 보호 시작일이 빠른 순으로 조회해야합니다.

SELECT ins.ANIMAL_ID, ins.NAME
FROM ANIMAL_INS ins 
    JOIN ANIMAL_OUTS outs 
    ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE  ins.DATETIME > outs.DATETIME
ORDER BY ins.DATETIME ASC;