package cz.kuzna.dagger2_multibinding.detail.inject;

import cz.kuzna.core.inject.ComponentBuilder;
import cz.kuzna.core.inject.D2Component;
import cz.kuzna.core.inject.scope.ActivityScope;
import cz.kuzna.dagger2_multibinding.detail.ui.DonutDetailActivity;
import cz.kuzna.dagger2_multibinding.order.inject.OrderModule;
import dagger.Subcomponent;

/**
 * @author Radek Kuznik
 */
@ActivityScope
@Subcomponent(
        modules = { DonutDetailModule.class, OrderModule.class }
)
public interface DonutDetailComponent extends D2Component<DonutDetailActivity> {

    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<DonutDetailModule, DonutDetailComponent> {
    }
}