-- Online PL/SQL solution for age-based loan discount
DECLARE
  -- Create temporary collections to simulate tables
  TYPE customer_type IS TABLE OF RECORD (
    CustomerID NUMBER,
    Name VARCHAR2(100),
    DOB DATE
  );
  
  TYPE loan_type IS TABLE OF RECORD (
    LoanID NUMBER,
    CustomerID NUMBER,
    InterestRate NUMBER
  );
  
  v_customers customer_type := customer_type();
  v_loans loan_type := loan_type();
  v_age NUMBER;
BEGIN
  -- Initialize sample data directly in collections
  v_customers.EXTEND(2);
  v_customers(1).CustomerID := 1;
  v_customers(1).Name := 'John Doe';
  v_customers(1).DOB := TO_DATE('1950-01-01', 'YYYY-MM-DD');
  
  v_customers(2).CustomerID := 2;
  v_customers(2).Name := 'Jane Smith';
  v_customers(2).DOB := TO_DATE('1985-06-15', 'YYYY-MM-DD');
  
  v_loans.EXTEND(2);
  v_loans(1).LoanID := 101;
  v_loans(1).CustomerID := 1;
  v_loans(1).InterestRate := 7.5;
  
  v_loans(2).LoanID := 102;
  v_loans(2).CustomerID := 2;
  v_loans(2).InterestRate := 6.5;
  
  -- Process loans and apply discounts
  DBMS_OUTPUT.PUT_LINE('Starting loan processing...');
  DBMS_OUTPUT.PUT_LINE('--------------------------');
  
  FOR i IN 1..v_loans.COUNT LOOP
    -- Calculate age
    FOR j IN 1..v_customers.COUNT LOOP
      IF v_customers(j).CustomerID = v_loans(i).CustomerID THEN
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, v_customers(j).DOB)/12);
        EXIT;
      END IF;
    END LOOP;
    
    -- Apply discount if eligible
    IF v_age > 60 THEN
      v_loans(i).InterestRate := v_loans(i).InterestRate - 1;
      DBMS_OUTPUT.PUT_LINE('Applied 1% discount to customer ' || 
                           v_loans(i).CustomerID || 
                           '. New rate: ' || v_loans(i).InterestRate || '%');
    ELSE
      DBMS_OUTPUT.PUT_LINE('No discount for customer ' || 
                           v_loans(i).CustomerID || 
                           ' (age ' || v_age || ')');
    END IF;
  END LOOP;
  
  DBMS_OUTPUT.PUT_LINE('--------------------------');
  DBMS_OUTPUT.PUT_LINE('Processing complete.');
  
  -- Display final loan rates
  DBMS_OUTPUT.PUT_LINE('Final loan rates:');
  FOR i IN 1..v_loans.COUNT LOOP
    DBMS_OUTPUT.PUT_LINE('Loan ' || v_loans(i).LoanID || 
                         ': Customer ' || v_loans(i).CustomerID || 
                         ' - ' || v_loans(i).InterestRate || '%');
  END LOOP;
END;
/