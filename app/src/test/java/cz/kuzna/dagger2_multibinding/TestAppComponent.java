package cz.kuzna.dagger2_multibinding;

import javax.inject.Singleton;

import cz.kuzna.dagger2_multibinding.shared.inject.BindingModule;
import cz.kuzna.dagger2_multibinding.shared.rest.inject.TestRestModule;
import dagger.Component;

/**
 * @author Radek Kuznik
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                TestRestModule.class,
                BindingModule.class
        }
)
public interface TestAppComponent {
        TestMultibindingApplication inject(TestMultibindingApplication application);
}