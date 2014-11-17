package framework.factory;

public class AbstractFactory {

    public ICustomerFactory getICustomerFactory(){
    
        return new CustomerFactory();
    }
    
    public IAccountFactory getAccountFactory(){
    
        return new CompanyAccFactory();
    }
}
