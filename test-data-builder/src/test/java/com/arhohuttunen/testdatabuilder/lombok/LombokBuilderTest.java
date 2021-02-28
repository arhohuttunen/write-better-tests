package com.arhohuttunen.testdatabuilder.lombok;

import org.junit.jupiter.api.Test;
import static com.arhohuttunen.testdatabuilder.lombok.Address.anAddress;
import static com.arhohuttunen.testdatabuilder.lombok.Customer.aCustomer;
import static com.arhohuttunen.testdatabuilder.lombok.Order.anOrder;
import static com.arhohuttunen.testdatabuilder.lombok.OrderItem.anOrderItem;

import static org.assertj.core.api.Assertions.assertThat;

public class LombokBuilderTest {
    @Test
    void buildOrder() {
        Order order = anOrder()
                .withCustomer(aCustomer()
                        .withName("Terry Tew")
                        .withAddress(anAddress()
                                .withStreet("1216  Clinton Street")
                                .withCity("Philadelphia")
                                .withPostalCode("19108")
                                .build()
                        )
                        .build()
                )
                .withOrderItem(anOrderItem().withName("Coffee mug").withQuantity(1).build())
                .withOrderItem(anOrderItem().withName("Tea cup").withQuantity(1).build())
                .build();

        assertThat(order.getCustomer().getName()).isEqualTo("Terry Tew");
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
