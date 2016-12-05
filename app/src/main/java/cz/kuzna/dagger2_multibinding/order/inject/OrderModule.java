package cz.kuzna.dagger2_multibinding.order.inject;

import cz.kuzna.core.inject.scope.ActivityScope;
import cz.kuzna.dagger2_multibinding.order.dataaccess.OrderRestApi;
import cz.kuzna.dagger2_multibinding.order.dataaccess.OrderRestService;
import cz.kuzna.dagger2_multibinding.order.platform.OrderController;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Radek Kuznik
 */
@Module
public class OrderModule {

    @Provides
    @ActivityScope
    public OrderController provideController(final OrderRestService restService) {
        return new OrderController(restService);
    }

    @Provides
    @ActivityScope
    public OrderRestApi provideRestApi(final Retrofit retrofit) {
        return retrofit.create(OrderRestApi.class);
    }

    @Provides
    @ActivityScope
    public OrderRestService provideRestService(final OrderRestApi restApi) {
        return new OrderRestService(restApi);
    }
}
