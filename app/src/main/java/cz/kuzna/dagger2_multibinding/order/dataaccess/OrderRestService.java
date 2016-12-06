package cz.kuzna.dagger2_multibinding.order.dataaccess;

import android.support.annotation.WorkerThread;

import javax.inject.Inject;

import cz.kuzna.core.rest.RestException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * @author Radek Kuznik
 */

public class OrderRestService {

    private OrderRestApi restApi;

    @Inject
    public OrderRestService(final OrderRestApi restApi) {
        this.restApi = restApi;
    }

    @WorkerThread
    public boolean orderDonutNow(final int donutId) {

        final OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(donutId);

        try {
            final Response<OrderResultDto> response = restApi.doOrderDonut(orderDto).execute();

            if (response.isSuccessful() && response.body() != null) {
                if(response.body().isStatus()) {
                    Timber.d("Ok");
                    return true;
                } else {
                    Timber.d("Donut order failed: %s", response.body().getMsg());
                    return false;
                }
            } else {
                Timber.d("Donut order failed: %s", response.errorBody().toString());
                return false;
            }
        } catch (Throwable e) {
            Timber.d(e, "Donut order failed");
            return false;
        }
    }
}
