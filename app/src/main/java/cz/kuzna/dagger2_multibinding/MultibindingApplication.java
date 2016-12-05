package cz.kuzna.dagger2_multibinding;

import android.app.Application;
import android.content.Context;

import java.util.Map;

import javax.inject.Inject;

import cz.kuzna.core.inject.ComponentBuilder;
import cz.kuzna.core.inject.ComponentBuilderContainer;
import timber.log.Timber;

/**
 * @author Radek Kuznik
 */
public class MultibindingApplication extends Application implements ComponentBuilderContainer {

    @Inject
    Map<Class<?>, ComponentBuilder> componentBuilders;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public static MultibindingApplication get(Context context) {
        return (MultibindingApplication) context.getApplicationContext();
    }

    @Override
    public ComponentBuilder getComponentBuilder(Class<?> clazz) {
        return componentBuilders.get(clazz);
    }
}
