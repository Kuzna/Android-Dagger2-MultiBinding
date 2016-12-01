package cz.kuzna.core.mvp;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author Radek Kuznik
 */
public abstract class MvpActivity<P extends MvpPresenter<V>, V extends MvpView> extends AppCompatActivity {

    /** Local variables */
    private final String tag;
    protected P presenter;

    public MvpActivity() {
        this.tag = getClass().getSimpleName() + ": ";
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(getPresenterView());
    }

    @Override
    protected void onStop() {
        presenter.detachView();
        super.onStop();
    }

    protected V getPresenterView() {
        //noinspection unchecked
        return (V) this;
    }
    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public P getPresenter() {
        return presenter;
    }

    protected String log(final String message) {
        return tag + message;
    }
}