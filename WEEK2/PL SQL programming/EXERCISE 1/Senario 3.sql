DECLARE
  CURSOR loan_cursor IS
    SELECT l.LoanID, c.Name, c.CustomerID
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
  FOR loan_rec IN loan_cursor LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || loan_rec.LoanID || ' for customer ' || loan_rec.Name || ' is due soon. Contact: ' || loan_rec.CustomerID);
  END LOOP;
END;
/