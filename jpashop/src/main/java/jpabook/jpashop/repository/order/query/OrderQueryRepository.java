package jpabook.jpashop.repository.order.query;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {
    private final EntityManager em;

    public List<OrderQueryDto> findOrderQueryDtos() {
        List<OrderQueryDto> result = findOrders();

        result.forEach(o -> {
            List<OrderItemQueryDto> items = findOrderItems(o.getOrderId());
            o.setOrderItems(items);
        });
        return result;
    }

    private List<OrderItemQueryDto> findOrderItems(Long id) {
        return em.createQuery(
                        "select new jpabook.jpashop.repository.order.query.OrderItemQueryDto(oi.order.id, oi.item.name, oi.orderPrice, oi.count) from OrderItem oi" +
                                " join oi.item i" +
                                " where oi.order.id = :id", OrderItemQueryDto.class)
                .setParameter("id", id)
                .getResultList();
    }

    private List<OrderQueryDto> findOrders() {
        return em.createQuery(
                "select new jpabook.jpashop.repository.order.query.OrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address) from Order o" +
                        " join o.member m" +
                        " join o.delivery d", OrderQueryDto.class
        ).getResultList();
    }

    public List<OrderQueryDto> findAllByDto_optimization() {
        List<OrderQueryDto> result = findOrders();
        List<Long> ids = toOrderIds(result);
        Map<Long, List<OrderItemQueryDto>> orderItemMap = findOrderItemMap(ids);
        result.forEach(o -> o.setOrderItems(orderItemMap.get(o.getOrderId())));
        return result;
    }

    private static List<Long> toOrderIds(List<OrderQueryDto> result) {
        List<Long> ids = result.stream().map(OrderQueryDto::getOrderId).collect(Collectors.toList());
        return ids;
    }

    private Map<Long, List<OrderItemQueryDto>> findOrderItemMap(List<Long> ids) {
        List<OrderItemQueryDto> orderItems = em.createQuery(
                        "select new jpabook.jpashop.repository.order.query.OrderItemQueryDto(oi.order.id, oi.item.name, oi.orderPrice, oi.count) from OrderItem oi" +
                                " join oi.item i" +
                                " where oi.order.id in :ids", OrderItemQueryDto.class)
                .setParameter("ids", ids)
                .getResultList();
        Map<Long, List<OrderItemQueryDto>> orderItemMap
                = orderItems.stream().collect(Collectors.groupingBy(OrderItemQueryDto::getOrderId));
        return orderItemMap;
    }

    public List<OrderFlatDto> findAllByDto_flat() {
        return em.createQuery("select new jpabook.jpashop.repository.order.query.OrderFlatDto(o.id, m.name, o.orderDate, o.status, d.address, i.name, oi.orderPrice, oi.count)" +
                        " from Order o" +
                        " join o.member m" +
                        " join o.orderItems oi" +
                        " join o.delivery d" +
                        " join oi.item i", OrderFlatDto.class)
                .getResultList();
    }
}
