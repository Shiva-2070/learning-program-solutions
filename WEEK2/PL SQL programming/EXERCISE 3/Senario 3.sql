CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_acct IN NUMBER,
  p_to_acct IN NUMBER,
  p_amount IN NUMBER
) IS
  v_from_balance NUMBER;
BEGIN
  SELECT Balance INTO v_from_balance 
  FROM Accounts 
  WHERE AccountID = p_from_acct;
  
  IF v_from_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20004, 'Insufficient funds for transfer');
  END IF;

  UPDATE Accounts SET Balance = Balance - p_amount 
  WHERE AccountID = p_from_acct;
  
  UPDATE Accounts SET Balance = Balance + p_amount 
  WHERE AccountID = p_to_acct;
  
  INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
  VALUES (TransactionSeq.NEXTVAL, p_from_acct, SYSDATE, p_amount, 'Transfer');
  
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transfer completed successfully');
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
    ROLLBACK;
END;
/