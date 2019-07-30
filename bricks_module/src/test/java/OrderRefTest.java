import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class OrderRefTest {

    Customer c;
    Order ord;
    List<Order> orders;
    DataContainerClass dcc=new DataContainerClass();

    @Given("A customer wants to buy any number of bricks")
    public void getCustomer(){
        c=new Customer();
    }


    @When("A Create Order request for a number of bricks is submitted")
    public void createOrder(){
       ord = c.submitOrder(50);
    }


    @Then("An Order reference is returned")
    public void checkReference(){
           assertTrue(ord!=null);
           assertTrue(ord.reference!=null);
           assertTrue(ord.reference instanceof String);
           assertTrue(ord.reference.contains("reference"));
    }


   @ Given("A customer has submitted an order for some bricks")
   public void customerSubmittedOrder(){
        // this has already been done in previous methods
   }


  @When("A Get Order request is submitted with a valid Order reference")
  public void getOrderRequest(){
       ord=c.getOrder("reference0");
  }


  @Then ("The order details are returned")
  public void checkOrderRequest(){
      assertTrue(ord!=null);

  }


   @And("The order details contains the Order reference and the number of bricks ordered")
   public void checkOrderRequestDetails(){
       assertTrue(ord.reference.equals("reference0"));
       assertTrue(ord.quantity==50);
   }


    @When("A Get Order request is submitted with an invalid Order reference")
    public void checkBadOrder(){
       ord=c.getOrder("bleh");
    }

    @Then ("No order details are returned")
    public void checkNullOrder(){
        assertTrue(ord==null);
    }


    @Given ("Many customers have submitted orders for bricks")
    public void createManyCustomersAndOrders(){

        int n=99;

        for (int i=0;i<n;i++){
         c = dcc.addCustomer(null);
         for (int j=0;j<20;j++){
             c.submitOrder(i+j+1);
         }
        }
    }


    @When("A Get Orders request is submitted")
    public void getAllOrders(){
        orders = dcc.getAllOrders();
    }


    @Then ("All the orders details are returned")
    public void checkAllOrders(){

        assertEquals(orders.size(),dcc.getAllOrders().size());

    }


    @And("The order details contains the Order reference and the number of bricks ordered")
    public void checkAllOrderDetails(){

        boolean ok=true;

        for (Order x:orders){
            if (x.reference==null) {ok=false;break;}
            if (x.quantity==0)        {ok=false;break;}
        }

        assertEquals("order found without reference or quantity ",true,ok);
    }


    public static void main(String[] args){
      OrderRefTest ort=new OrderRefTest();
      ort.getCustomer();
      ort.createOrder();
      ort.checkReference();
      ort.createManyCustomersAndOrders();
      ort.getAllOrders();
    }
}