package cz.kuzna.dagger2_multibinding;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Radek Kuznik
 */
@Module
public class AppModule {

    private final MultibindingApplication application;
    private final Context context;

    public AppModule(final MultibindingApplication application) {
        this.application = application;
        this.context = application.getApplicationContext();
    }

    @Provides
    @Singleton
    Application provideApplication () {
        return this.application;
    }

    @Provides
    @Singleton
    Context provideContext () {
        return this.context;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return application.getResources();
    }
}
