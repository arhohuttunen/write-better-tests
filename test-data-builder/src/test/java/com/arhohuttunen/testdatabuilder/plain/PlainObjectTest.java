package com.arhohuttunen.testdatabuilder.plain;

import com.arhohuttunen.testdatabuilder.model.Address;
import com.arhohuttunen.testdatabuilder.model.Customer;
import com.arhohuttunen.testdatabuilder.model.Order;
import com.arhohuttunen.testdatabuilder.model.OrderItem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlainObjectTest {
    @Test
    void constructOrderWithForeignAddress() {
        Address address = new Address("1216 Clinton Street", "Philadelphia", "19108", "United States");
        Customer customer = new Customer(1L, "Terry Tew", address);
        Order order = new Order(1L, customer, 0.0, null);
        order.addOrderItem(new OrderItem("Coffee mug", 1));

        assertThat(order.getCustomer().getAddress().getCountry()).isEqualTo("United States");
    }

    @Test
    void constructSimilarOrders() {
        Address address = new Address("1216  Clinton Street", "Philadelphia", "19108", "United States");
        Customer customer = new Customer(1L, "Unimportant", address);
        OrderItem coffeeMug = new OrderItem("Coffee mug", 1);
        OrderItem teaCup = new OrderItem("Tea cup", 1);

        Order orderWithDiscount = new Order(1L, customer, 0.1, null);
        orderWithDiscount.addOrderItem(coffeeMug);
        orderWithDiscount.addOrderItem(teaCup);

        Order orderWithCouponCode = new Order(2L, customer, 0.0, "HALFOFF");
        orderWithCouponCode.addOrderItem(coffeeMug);
        orderWithCouponCode.addOrderItem(teaCup);

        assertThat(orderWithDiscount.getDiscountRate()).isEqualTo(0.1);
        assertThat(orderWithCouponCode.getCouponCode()).isEqualTo("HALFOFF");
    }
}
