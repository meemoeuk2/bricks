import java.util.*;

public class Customer {

    static int id_count;

    int id;
    String name="";
    List<Order> orders = new ArrayList<Order>();

    public Customer(){ new Customer("none");}

    public Customer(String nam){
        id=id_count;
        id_count++;
        if (nam==null) { nam="none";}
        name=nam;
    }

    public Order getOrder(String ref){
        for (Order x:orders){
            if (x.reference.equals(ref) )     { return x; }
        }

        return null;
    }

    public Order submitOrder(int quan){
        Order ord=new Order(quan);
        orders.add(ord);
        return ord;                                 // assuming in the spec 'reference'  is an number, not an object
    }

}
