package cz.kuzna.dagger2_multibinding.order.dataaccess;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author Radek Kuznik
 */

public interface OrderRestApi {

    @POST("/donut/order")
    Call<OrderResultDto> doOrderDonut(@Body OrderDto request);
}