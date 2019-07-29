public class Order {

    static int id_count=0;

    int id;
    String reference;
    int quantity;

    public Order(int quan){
        id=id_count;
        reference = "reference"+id;
        id_count++;
        this.quantity=quan;
    }
}
