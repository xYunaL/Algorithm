-- HR_DEPARTMENT와 HR_EMPLOYEES 테이블을 이용해 부서별 평균 연봉을 조회
-- 부서별로 부서 ID, 영문 부서명, 평균 연봉을 조회
-- 평균연봉은 소수점 첫째 자리에서 반올림하고 컬럼명은 AVG_SAL
-- 결과는 부서별 평균 연봉을 기준으로 내림차순 정렬

SELECT d.DEPT_ID, d.DEPT_NAME_EN, e.AVG_SAL
FROM HR_DEPARTMENT AS d 
    INNER JOIN (
        SELECT e.DEPT_ID, ROUND(AVG(e.SAL), 0) AS AVG_SAL
        FROM HR_EMPLOYEES e
        GROUP BY DEPT_ID
    ) e
    ON d.DEPT_ID = e.DEPT_ID
ORDER BY e.AVG_SAL DESC;