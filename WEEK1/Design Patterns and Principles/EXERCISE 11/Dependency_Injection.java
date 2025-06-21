
interface CustomerRepo {
    String find(int id);
}
class CustomerRepoImpl implements CustomerRepo {
    public String find(int id) {
        return "Customer " + id;
    }
}

class CustomerService {
    CustomerRepo repo;
    
    CustomerService(CustomerRepo r) {
        this.repo = r;
    }
    
    String getCustomer(int id) {
        return repo.find(id);
    }
}

class TestDI {
    public static void main(String[] a) {
        CustomerRepo repo = new CustomerRepoImpl();
        CustomerService service = new CustomerService(repo);
        
        System.out.println(service.getCustomer(1001));
    }
}