package cz.kuzna.dagger2_multibinding;

import javax.inject.Singleton;

import cz.kuzna.dagger2_multibinding.shared.inject.BindingModule;
import dagger.Component;

/**
 * @author Radek Kuznik
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                BindingModule.class
        }
)
public interface AppComponent {
    MultibindingApplication inject(MultibindingApplication application);
}
