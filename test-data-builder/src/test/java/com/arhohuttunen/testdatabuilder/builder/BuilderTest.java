package com.arhohuttunen.testdatabuilder.builder;

import com.arhohuttunen.testdatabuilder.model.Order;
import org.junit.jupiter.api.Test;

import static com.arhohuttunen.testdatabuilder.builder.AddressBuilder.anAddress;
import static com.arhohuttunen.testdatabuilder.builder.CustomerBuilder.aCustomer;
import static com.arhohuttunen.testdatabuilder.builder.OrderBuilder.anOrder;
import static com.arhohuttunen.testdatabuilder.builder.OrderItemBuilder.anOrderItem;
import static org.assertj.core.api.Assertions.assertThat;

class BuilderTest {
    @Test
    void buildOrderWithForeignAddress() {
        Order order = anOrder()
                .with(aCustomer().with(anAddress().withCountry("United States")))
                .with(anOrderItem().withName("Coffee mug").withQuantity(1))
                .build();

        // Safe default values
        assertThat(order.getOrderId()).isNotNull();
        assertThat(order.getCustomer().getCustomerId()).isNotNull();
        assertThat(order.getCustomer().getAddress().getCountry()).isNotNull();
    }

    @Test
    void buildSimilarOrders() {
        OrderBuilder coffeeMugAndTeaCup = anOrder()
                .with(anOrderItem().withName("Coffee mug").withQuantity(1))
                .with(anOrderItem().withName("Tea cup").withQuantity(1));

        Order orderWithDiscount = coffeeMugAndTeaCup.but().withDiscountRate(0.1).build();
        Order orderWithCouponCode = coffeeMugAndTeaCup.but().withCouponCode("HALFOFF").build();

        assertThat(orderWithDiscount.getDiscountRate()).isEqualTo(0.1);
        assertThat(orderWithCouponCode.getDiscountRate()).isEqualTo(0.0);
    }
}
