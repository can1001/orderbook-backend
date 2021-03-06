package io.logostory.orderbook.backend.domain.entity.order;


import io.logostory.orderbook.backend.domain.code.OrderStatus;
import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import io.logostory.orderbook.backend.domain.entity.account.Account;
import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@EqualsAndHashCode(of = "orderId")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`order`")
public class Order extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long orderId;

    String seatNumber;
    int totalPrice;

    @Enumerated(EnumType.STRING)
    OrderStatus status = OrderStatus.SAVED;

    @ManyToOne
    @JoinColumn(name = "shopId")
    Shop shop;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="order")
    List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "accountId")
    Account account;

    public void addItem(Item i) {
        items.add(i);
        i.setOrder(this);
    }
}
