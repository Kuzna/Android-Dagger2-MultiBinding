package cz.kuzna.dagger2_multibinding.donutlist.inject;

import cz.kuzna.core.inject.ComponentBuilder;
import cz.kuzna.core.inject.D2Component;
import cz.kuzna.core.inject.scope.ActivityScope;
import cz.kuzna.dagger2_multibinding.donutlist.ui.DonutListActivity;
import dagger.Subcomponent;

/**
 * @author Radek Kuznik
 */
@ActivityScope
@Subcomponent(
        modules = DonutListModule.class
)
public interface DonutListComponent extends D2Component<DonutListActivity> {

    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<DonutListModule, DonutListComponent> {
    }
}