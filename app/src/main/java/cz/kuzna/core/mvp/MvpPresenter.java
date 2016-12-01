package cz.kuzna.core.mvp;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * @author Radek Kuznik
 */
public abstract class MvpPresenter<T extends MvpView> {

    private Context context;
    private final String tag;
    private WeakReference<T> mvpView;

    public MvpPresenter(Context context) {
        this.context = context;
        this.tag = getClass().getSimpleName() + ": ";
    }

    public void attachView(T mvpView) {
        this.mvpView = new WeakReference<>(mvpView);
    }

    public void detachView() {
        mvpView = null;
    }

    public T getView() {
        return mvpView.get();
    }

    public Context getContext() {
        return context;
    }

    public String getTag() {
        return tag;
    }

    public void onDestroyed() {

    }

    protected boolean isViewAttached() {
        return mvpView != null;
    }
}
