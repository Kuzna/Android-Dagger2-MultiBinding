package cz.kuzna.dagger2_multibinding.shared.inject;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import cz.kuzna.core.inject.HasComponentBuilder;
import cz.kuzna.core.mvp.MvpActivity;
import cz.kuzna.core.mvp.MvpPresenter;
import cz.kuzna.core.mvp.MvpView;
import cz.kuzna.dagger2_multibinding.MultibindingApplication;

/**
 * @author Radek Kuznik
 */
public abstract class D2MvpActivity<P extends MvpPresenter<V>, V extends MvpView> extends MvpActivity<P, V> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupComponent(MultibindingApplication.get(this));
    }

    @Inject
    public void setPresenter(P presenter) {
        super.setPresenter(presenter);
    }

    protected abstract void setupComponent(final HasComponentBuilder componentBuilder);
}
