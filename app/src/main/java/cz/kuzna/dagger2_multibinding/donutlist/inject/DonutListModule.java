package cz.kuzna.dagger2_multibinding.donutlist.inject;

import android.content.Context;

import cz.kuzna.core.inject.D2Module;
import cz.kuzna.core.inject.scope.ActivityScope;
import cz.kuzna.dagger2_multibinding.donutlist.ui.DonutListPresenter;
import cz.kuzna.dagger2_multibinding.donutlist.ui.DonutsAdapter;
import dagger.Module;
import dagger.Provides;

/**
 * @author Radek Kuznik
 */
@Module
public class DonutListModule implements D2Module {

    @Provides
    @ActivityScope
    DonutListPresenter presenter(final Context context) {
        return new DonutListPresenter(context);
    }

    @Provides
    @ActivityScope
    DonutsAdapter adapter() {
        return new DonutsAdapter();
    }
}
