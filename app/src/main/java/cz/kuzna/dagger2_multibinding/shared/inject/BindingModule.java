package cz.kuzna.dagger2_multibinding.shared.inject;

import cz.kuzna.core.inject.ComponentBuilder;
import cz.kuzna.core.inject.InjectKey;
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
                DonutListComponent.class
        })
public abstract class BindingModule {

    @Binds
    @IntoMap
    @InjectKey(DonutListActivity.class)
    public abstract ComponentBuilder donutListActivityComponentBuilder(DonutListComponent.Builder builder);
}
