package com.arhohuttunen.testdatabuilder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.arhohuttunen.testdatabuilder.AddressBuilder.anAddress;
import static com.arhohuttunen.testdatabuilder.CustomerBuilder.aCustomer;
import static com.arhohuttunen.testdatabuilder.OrderBuilder.anOrder;
import static com.arhohuttunen.testdatabuilder.OrderItemBuilder.anOrderItem;
import static org.assertj.core.api.Assertions.assertThat;

class BuilderTest {
    @Test
    void handBuiltOrder() {
        Address address = new Address("1216  Clinton Street", "Philadelphia", "19108", null);
        Customer customer = new Customer(1L, "Terry Tew", address);
        OrderItem coffeeMug = new OrderItem("Coffee mug", 1);
        OrderItem teaCup = new OrderItem("Tea cup", 1);
        Order order = new Order(1L, customer, Arrays.asList(coffeeMug, teaCup), 0.0, null);

        assertThat(order.getCustomer().getName()).isEqualTo("Terry Tew");
    }

    @Test
    void createOrder() {
        Order order = anOrder()
                .with(aCustomer()
                        .withName("Terry Tew")
                        .with(anAddress()
                                .withStreet("1216  Clinton Street")
                                .withCity("Philadelphia")
                                .withPostalCode("19108")
                        )
                )
                .with(anOrderItem().withName("Coffee mug").withQuantity(1))
                .with(anOrderItem().withName("Tea cup").withQuantity(1))
                .build();

        assertThat(order.getCustomer().getName()).isEqualTo("Terry Tew");
    }

    @Test
    void createSimilarOrders() {
        OrderBuilder coffeeMugAndTeaCup = anOrder()
                .with(anOrderItem().withName("Coffee mug").withQuantity(1))
                .with(anOrderItem().withName("Tea cup").withQuantity(1));

        Order orderWithDiscount = coffeeMugAndTeaCup.withDiscountRate(0.1).build();
        Order orderWithCouponCode = coffeeMugAndTeaCup.withCouponCode("HALFOFF").build();

        assertThat(orderWithDiscount.getDiscountRate()).isEqualTo(0.1);
        assertThat(orderWithCouponCode.getDiscountRate()).isEqualTo(0.0);
    }
}
