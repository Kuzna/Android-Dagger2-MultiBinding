package cz.kuzna.dagger2_multibinding;

import android.content.Context;

import cz.kuzna.dagger2_multibinding.shared.rest.inject.TestRestModule;

/**
 * @author Radek Kuznik
 */
public class TestMultibindingApplication extends MultibindingApplication {


    TestAppComponent component;

    @Override
    public void initComponents() {
        component = DaggerTestAppComponent
                .builder()
                .appModule(new AppModule(this))
                .testRestModule(new TestRestModule())
                .build();
        component.inject(this);
    }

    public static TestMultibindingApplication get(Context context) {
        return (TestMultibindingApplication) context.getApplicationContext();
    }

    public TestAppComponent component() {
        return component;
    }
}