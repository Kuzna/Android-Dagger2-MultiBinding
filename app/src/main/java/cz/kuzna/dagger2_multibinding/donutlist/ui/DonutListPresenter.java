package cz.kuzna.dagger2_multibinding.donutlist.ui;

import android.content.Context;

import cz.kuzna.core.inject.scope.ActivityScope;
import cz.kuzna.core.mvp.MvpPresenter;

/**
 * @author Radek Kuznik
 */
@ActivityScope
public class DonutListPresenter extends MvpPresenter<DonutListView> {


    public DonutListPresenter(Context context) {
        super(context);
    }

    public void goToDetail(final long donutId) {

    }
}
