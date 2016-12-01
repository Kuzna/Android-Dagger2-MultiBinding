package cz.kuzna.dagger2_multibinding.shared.donut.domain;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * @author Radek Kuznik
 */
public class Donut {
    public @DrawableRes int iconResId;
    public @StringRes int nameResId;
    public boolean favorite;

    public Donut(@DrawableRes int iconResId, @StringRes int nameResId, boolean favorite) {
        this.iconResId = iconResId;
        this.nameResId = nameResId;
        this.favorite = favorite;
    }
}