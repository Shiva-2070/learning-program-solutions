CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_dept IN VARCHAR2,
  p_bonus_percent IN NUMBER
) IS
BEGIN
  UPDATE Employees 
  SET Salary = Salary * (1 + p_bonus_percent/100)
  WHERE Department = p_dept;
  
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Bonus applied to ' || SQL%ROWCOUNT || ' employees');
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error updating bonuses: ' || SQLERRM);
    ROLLBACK;
END;
/