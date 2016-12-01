package cz.kuzna.dagger2_multibinding.detail.ui;

import android.content.Context;

import cz.kuzna.core.inject.scope.ActivityScope;
import cz.kuzna.core.mvp.MvpPresenter;
import cz.kuzna.dagger2_multibinding.R;
import cz.kuzna.dagger2_multibinding.shared.donut.domain.Donut;

/**
 * @author Radek Kuznik
 */
@ActivityScope
public class DonutDetailPresenter extends MvpPresenter<DonutDetailView> {


    public DonutDetailPresenter(Context context) {
        super(context);
    }

    public void loadData(final int donutId) {

        final Donut donut;

        switch (donutId) {
            case 0:
                donut = new Donut(R.drawable.ic_donut_blue_moon_sprinkle, R.string.blue_moon_sprinkle);
                break;
            case 1:
                donut = new Donut(R.drawable.ic_donut_butter_nut, R.string.butter_nut);
                break;
            case 2:
                donut = new Donut(R.drawable.ic_donut_caviar_strawberry, R.string.caviar_strawberry);
                break;
            case 3:
                donut = new Donut(R.drawable.ic_donut_dark_chocolate_sprinkle, R.string.dark_chocolate_sprinkle);
                break;
            case 4:
                donut = new Donut(R.drawable.ic_donut_green_tea_sprinkle, R.string.green_tea_sprinkle);
                break;
            case 5:
                donut = new Donut(R.drawable.ic_donut_lemon_sprinkle, R.string.lemon_sprinkle);
                break;
            case 6:
                donut = new Donut(R.drawable.ic_donut_maple_iced, R.string.maple_iced);
                break;
            case 7:
                donut = new Donut(R.drawable.ic_donut_raspberry, R.string.raspberry);
                break;
            case 8:
                donut = new Donut(R.drawable.ic_donut_strawberry_sprinkle, R.string.strawberry_sprinkle);
                break;
            case 9:
                donut = new Donut(R.drawable.ic_donut_sugar_pink, R.string.sugar_pink);
                break;
            case 10:
                donut = new Donut(R.drawable.ic_donut_vanilla_iced, R.string.vanilla_iced);
                break;
            case 11:
                donut = new Donut(R.drawable.ic_donut_vanilla_sprinkle, R.string.vanilla_sprinkle);
                break;
            default:
                donut = null;
                break;
        }

        getView().showDetail(donut);
    }
}
