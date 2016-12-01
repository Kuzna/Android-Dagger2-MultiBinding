package cz.kuzna.dagger2_multibinding.detail.ui;

import cz.kuzna.core.mvp.MvpView;
import cz.kuzna.dagger2_multibinding.shared.donut.domain.Donut;

/**
 * @author Radek Kuznik
 */

public interface DonutDetailView extends MvpView {

    void showDetail(final Donut donut);
}
