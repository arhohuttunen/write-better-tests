package com.arhohuttunen.testdatabuilder.lombok;

import org.junit.jupiter.api.Test;

import static com.arhohuttunen.testdatabuilder.lombok.Address.anAddress;
import static com.arhohuttunen.testdatabuilder.lombok.Customer.aCustomer;
import static com.arhohuttunen.testdatabuilder.lombok.Order.anOrder;
import static com.arhohuttunen.testdatabuilder.lombok.OrderItem.anOrderItem;
import static org.assertj.core.api.Assertions.assertThat;

public class LombokBuilderTest {
    @Test
    void buildOrderWithForeignAddress() {
        Order order = anOrder()
                .withOrderId(1L) // No safe default value
                .withCustomer(aCustomer()
                        .withCustomerId(1L) // No safe default value
                        .withName("Terry Tew") // No safe default value
                        .withAddress(anAddress()
                                .withStreet("1216  Clinton Street") // No safe default value
                                .withCity("Philadelphia") // No safe default value
                                .withPostalCode("19108") // No safe default value
                                .withCountry("United States")
                                .build()
                        )
                        .build()
                )
                .withOrderItem(anOrderItem().withName("Coffee mug").withQuantity(1).build())
                .build();

        assertThat(order.getOrderId()).isNotNull();
        assertThat(order.getCustomer().getCustomerId()).isNotNull();
        assertThat(order.getCustomer().getAddress().getCountry()).isNotNull();
    }

    @Test
    void buildSimilarOrders() {
        Order coffeeMugAndTeaCup = anOrder()
                .withOrderId(1L)
                .withCustomer(aCustomer()
                        .withCustomerId(1L)
                        .withName("Terry Tew")
                        .withAddress(anAddress()
                                .withStreet("1216  Clinton Street")
                                .withCity("Philadelphia")
                                .withPostalCode("19108")
                                .withCountry("United States")
                                .build()
                        )
                        .build()
                )
                .withOrderItem(anOrderItem().withName("Coffee mug").withQuantity(1).build())
                .withOrderItem(anOrderItem().withName("Tea cup").withQuantity(1).build())
                .build();

        Order orderWithDiscount = coffeeMugAndTeaCup.toBuilder().withDiscountRate(0.1).build();
        Order orderWithCouponCode = coffeeMugAndTeaCup.toBuilder().withCouponCode("HALFOFF").build();

        assertThat(orderWithDiscount.getDiscountRate()).isEqualTo(0.1);
        assertThat(orderWithCouponCode.getDiscountRate()).isNull();
    }
}
