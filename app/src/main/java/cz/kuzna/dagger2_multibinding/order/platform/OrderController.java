package cz.kuzna.dagger2_multibinding.order.platform;

import javax.inject.Inject;

import cz.kuzna.dagger2_multibinding.order.dataaccess.OrderRestService;

/**
 * @author Radek Kuznik
 */

public class OrderController {

    private OrderRestService orderRestService;

    @Inject
    public OrderController(OrderRestService orderRestService) {
        this.orderRestService = orderRestService;
    }

    public boolean order(final int donutId) {
        return orderRestService.orderDonutNow(donutId);
    }
}
