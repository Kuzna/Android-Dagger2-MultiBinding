package cz.kuzna.dagger2_multibinding.donutlist.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import cz.kuzna.core.inject.scope.ActivityScope;
import cz.kuzna.core.mvp.MvpPresenter;
import cz.kuzna.dagger2_multibinding.detail.ui.DonutDetailActivity;

/**
 * @author Radek Kuznik
 */
@ActivityScope
public class DonutListPresenter extends MvpPresenter<DonutListView> {


    public DonutListPresenter(Context context) {
        super(context);
    }

    public void goToDetail(final Activity activity, final int donutId) {
        final Intent intent = new Intent(getContext(), DonutDetailActivity.class);
        intent.putExtra(DonutDetailActivity.EXTRA_DONUT_ID, donutId);

        activity.startActivity(intent);
    }
}
