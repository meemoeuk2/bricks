import java.util.ArrayList;
import java.util.List;

public class DataContainerClass {

    List<Customer> customers = new ArrayList<Customer>();

    public Customer addCustomer(){ return addCustomer("none");}

    public Customer addCustomer(String name){
        if (name==null) {name="none";}
        Customer c= new Customer(name);
        customers.add(c);
        return c;
    }


    public ArrayList<Order> getAllOrders(){
        List<Order> allOrders= new ArrayList<Order>();
        for (Customer c:customers) {
            allOrders.addAll(c.orders);
        }

        return (ArrayList) allOrders;
    }
}
