CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE Accounts 
  SET Balance = Balance * 1.01 
  WHERE AccountType = 'Savings';
  
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Monthly interest processed for all savings accounts');
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error processing interest: ' || SQLERRM);
    ROLLBACK;
END;
/