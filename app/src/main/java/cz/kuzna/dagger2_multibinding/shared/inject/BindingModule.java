package cz.kuzna.dagger2_multibinding.shared.inject;

import cz.kuzna.core.inject.ComponentBuilder;
import cz.kuzna.core.inject.InjectKey;
import cz.kuzna.dagger2_multibinding.detail.inject.DonutDetailComponent;
import cz.kuzna.dagger2_multibinding.detail.ui.DonutDetailActivity;
import cz.kuzna.dagger2_multibinding.donutlist.inject.DonutListComponent;
import cz.kuzna.dagger2_multibinding.donutlist.ui.DonutListActivity;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author Radek Kuznik
 */
@Module(
        subcomponents = {
                DonutListComponent.class,
                DonutDetailComponent.class
        })
public abstract class BindingModule {

    @Binds
    @IntoMap
    @InjectKey(DonutListActivity.class)
    public abstract ComponentBuilder donutListActivityComponentBuilder(DonutListComponent.Builder builder);

    @Binds
    @IntoMap
    @InjectKey(DonutDetailActivity.class)
    public abstract ComponentBuilder donutDetailActivityComponentBuilder(DonutDetailComponent.Builder builder);
}
