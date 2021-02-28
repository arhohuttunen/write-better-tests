package com.arhohuttunen.testdatabuilder.objectmother;

import com.arhohuttunen.testdatabuilder.model.Address;
import com.arhohuttunen.testdatabuilder.model.Customer;
import com.arhohuttunen.testdatabuilder.model.Order;
import com.arhohuttunen.testdatabuilder.model.OrderItem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectMotherTest {
    @Test
    void constructOrder() {
        Address address = Addresses.createAddress("1216  Clinton Street", "Philadelphia", "19108");
        Customer customer = Customers.createCustomerWithAddress("Terry Tew", address);
        Order order = Orders.createOrderWithCustomer(customer);
        order.addOrderItem(OrderItems.createOrderItem("Coffee mug"));
        order.addOrderItem(OrderItems.createOrderItem("Tea cup"));

        assertThat(order.getCustomer().getName()).isEqualTo("Terry Tew");
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

        // We have safe default values:
        assertThat(orderWithCouponCode.getCustomer().getAddress().getCountry()).isEqualTo("Some country");
        assertThat(orderWithCouponCode.getCustomer().getName()).isEqualTo("Unimportant");
        assertThat(orderWithCouponCode.getDiscountRate()).isEqualTo(0.0);
    }
}
