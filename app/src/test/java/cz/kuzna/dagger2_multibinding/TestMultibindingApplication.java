package cz.kuzna.dagger2_multibinding;

import android.content.Context;

/**
 * @author Radek Kuznik
 */
public class TestMultibindingApplication extends MultibindingApplication {


    @Override
    public void initComponents() {
//        appComponent = DaggerAppComponent
//                .builder()
//                .appModule(new AppModule(this))
//                .build();
//        appComponent.inject(this);
    }

    public static TestMultibindingApplication get(Context context) {
        return (TestMultibindingApplication) context.getApplicationContext();
    }
//
//    @Override public void onCreate() {
//        super.onCreate();
//        component = DaggerTestMyApplication_TestApplicationComponent.builder()
//                .testAndroidModule(new TestAndroidModule(this))
//                .commonModule(new CommonModule())
//                .build();
//    }
//
//    @Override public ApplicationComponent component() {
//        return component;
//    }
}