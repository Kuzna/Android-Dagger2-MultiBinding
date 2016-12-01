package cz.kuzna.dagger2_multibinding.detail.inject;

import android.content.Context;

import cz.kuzna.core.inject.D2Module;
import cz.kuzna.core.inject.scope.ActivityScope;
import cz.kuzna.dagger2_multibinding.detail.ui.DonutDetailPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * @author Radek Kuznik
 */
@Module
public class DonutDetailModule implements D2Module {

    @Provides
    @ActivityScope
    DonutDetailPresenter presenter(final Context context) {
        return new DonutDetailPresenter(context);
    }
}
