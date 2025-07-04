DECLARE
  CURSOR cust_cursor IS 
    SELECT CustomerID, InterestRate FROM Loans;
  v_age NUMBER;
BEGIN
  FOR cust_rec IN cust_cursor LOOP
    SELECT FLOOR(MONTHS_BETWEEN(SYSDATE, DOB)/12) INTO v_age
    FROM Customers WHERE CustomerID = cust_rec.CustomerID;
    IF v_age > 60 THEN
      UPDATE Loans 
      SET InterestRate = InterestRate - 1 
      WHERE CustomerID = cust_rec.CustomerID;
      DBMS_OUTPUT.PUT_LINE('Applied 1% discount to customer ' || cust_rec.CustomerID);
    END IF;
  END LOOP;
  COMMIT;
END;
/