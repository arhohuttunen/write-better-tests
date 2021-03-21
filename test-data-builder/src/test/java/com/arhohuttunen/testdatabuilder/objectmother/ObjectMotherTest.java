package com.arhohuttunen.testdatabuilder.objectmother;

import com.arhohuttunen.testdatabuilder.model.Address;
import com.arhohuttunen.testdatabuilder.model.Customer;
import com.arhohuttunen.testdatabuilder.model.Order;
import com.arhohuttunen.testdatabuilder.model.OrderItem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectMotherTest {
    @Test
    void constructOrderWithForeignAddress() {
        Address address = Addresses.createAddressWithCountry("United States");
        Customer customer = Customers.createCustomerWithAddress(address);
        Order order = Orders.createOrderWithCustomer(customer);
        order.addOrderItem(OrderItems.createOrderItem("Coffee mug"));

        // Safe default values
        assertThat(order.getOrderId()).isNotNull();
        assertThat(order.getCustomer().getCustomerId()).isNotNull();
        assertThat(order.getCustomer().getAddress().getCountry()).isNotNull();
    }

    @Test
    void constructSimilarOrders() {
        OrderItem coffeeMug = OrderItems.createOrderItem("Coffee Mug");
        OrderItem teaCup = OrderItems.createOrderItem("Tea cup");

        Order orderWithDiscount = Orders.createOrderWithDiscount(0.1);
        orderWithDiscount.addOrderItem(coffeeMug);
        orderWithDiscount.addOrderItem(teaCup);

        Order orderWithCouponCode = Orders.createOrderWithCouponCode("HALFOFF");
        orderWithCouponCode.addOrderItem(coffeeMug);
        orderWithCouponCode.addOrderItem(teaCup);

        assertThat(orderWithDiscount.getDiscountRate()).isEqualTo(0.1);
        assertThat(orderWithCouponCode.getDiscountRate()).isEqualTo(0.0);
    }
}
