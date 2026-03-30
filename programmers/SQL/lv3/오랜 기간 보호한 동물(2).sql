-- 입양을 간 동물 중, 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회
-- 보호 기간이 긴 순으로 조회
SELECT outs.ANIMAL_ID, outs.NAME
FROM ANIMAL_OUTS outs INNER JOIN ANIMAL_INS ins
    ON ins.ANIMAL_ID = outs.ANIMAL_ID
ORDER BY DATEDIFF(outs.DATETIME, ins.DATETIME) DESC
LIMIT 2;