package ibf2024.assessment.paf.batch4.models;

import java.util.List;

public class OrderCreation {
  List<Order> orders;

  public OrderCreation(List<Order> orders) {
    this.orders = orders;
  }

  public void addOrder(Order order){
    this.orders.add(order);
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
  
}
