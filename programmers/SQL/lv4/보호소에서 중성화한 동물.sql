-- 보호소에 들어올 당시에는 중성화되지 않았지만, 
-- 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 
-- 아이디 순으로 조회
SELECT outs.ANIMAL_ID, outs.ANIMAL_TYPE, outs.NAME
FROM ANIMAL_INS ins 
    INNER JOIN ANIMAL_OUTS outs
    ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE ins.SEX_UPON_INTAKE LIKE 'Intact%'  
    AND outs.SEX_UPON_OUTCOME NOT LIKE 'Intact%'
ORDER BY ANIMAL_ID ASC;