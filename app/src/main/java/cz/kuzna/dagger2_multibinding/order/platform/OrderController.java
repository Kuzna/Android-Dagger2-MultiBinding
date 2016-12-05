package cz.kuzna.dagger2_multibinding.order.platform;

import javax.inject.Inject;

import cz.kuzna.dagger2_multibinding.order.dataaccess.OrderRestService;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Radek Kuznik
 */

public class OrderController {

    private OrderRestService orderRestService;

    @Inject
    public OrderController(OrderRestService orderRestService) {
        this.orderRestService = orderRestService;
    }

    public Observable<Boolean> order(final int donutId) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                final boolean result = orderRestService.orderDonutNow(donutId);

                subscriber.onNext(result);
                subscriber.onCompleted();
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
    }
}
