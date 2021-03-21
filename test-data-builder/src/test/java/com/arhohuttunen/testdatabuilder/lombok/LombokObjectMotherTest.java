package com.arhohuttunen.testdatabuilder.lombok;

import org.junit.jupiter.api.Test;

import static com.arhohuttunen.testdatabuilder.lombok.Addresses.anAddress;
import static com.arhohuttunen.testdatabuilder.lombok.Customers.aCustomer;
import static com.arhohuttunen.testdatabuilder.lombok.OrderItem.anOrderItem;
import static com.arhohuttunen.testdatabuilder.lombok.Orders.anOrder;
import static org.assertj.core.api.Assertions.assertThat;

public class LombokObjectMotherTest {
    @Test
    void buildOrder() {
        Order order = anOrder()
                .withCustomer(aCustomer()
                        .withAddress(anAddress().withCountry("United States").build())
                        .build()
                )
                .withOrderItem(anOrderItem().withName("Coffee mug").withQuantity(1).build())
                .build();

        // Safe default values
        assertThat(order.getOrderId()).isNotNull();
        assertThat(order.getCustomer().getCustomerId()).isNotNull();
        assertThat(order.getCustomer().getAddress().getCountry()).isNotNull();
    }

    @Test
    void buildSimilarOrders() {
        Order coffeeMugAndTeaCup = anOrder()
                .withOrderItem(anOrderItem().withName("Coffee mug").withQuantity(1).build())
                .withOrderItem(anOrderItem().withName("Tea cup").withQuantity(1).build())
                .build();

        Order orderWithDiscount = coffeeMugAndTeaCup.toBuilder().withDiscountRate(0.1).build();
        Order orderWithCouponCode = coffeeMugAndTeaCup.toBuilder().withCouponCode("HALFOFF").build();

        assertThat(orderWithDiscount.getDiscountRate()).isEqualTo(0.1);
        assertThat(orderWithCouponCode.getDiscountRate()).isEqualTo(0.0);
    }
}
