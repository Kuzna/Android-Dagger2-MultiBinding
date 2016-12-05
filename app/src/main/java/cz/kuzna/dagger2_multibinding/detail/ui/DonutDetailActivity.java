package cz.kuzna.dagger2_multibinding.detail.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cz.kuzna.core.inject.ComponentBuilderContainer;
import cz.kuzna.dagger2_multibinding.R;
import cz.kuzna.dagger2_multibinding.detail.inject.DonutDetailComponent;
import cz.kuzna.dagger2_multibinding.detail.inject.DonutDetailModule;
import cz.kuzna.dagger2_multibinding.shared.donut.domain.Donut;
import cz.kuzna.dagger2_multibinding.shared.inject.D2MvpActivity;

/**
 * @author Radek Kuznik
 */
public class DonutDetailActivity extends D2MvpActivity<DonutDetailPresenter, DonutDetailView> implements DonutDetailView {

    public static final String EXTRA_DONUT_ID = "ext_donut_id";

    private int donutId;

    @BindView(R.id.iv_image) ImageView ivImage;
    @BindView(R.id.tv_text) TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut_detail);

        if(getIntent() != null && getIntent().hasExtra(EXTRA_DONUT_ID)) {
            donutId = getIntent().getIntExtra(EXTRA_DONUT_ID, -1);
        }
    }

    @Override
    protected void setupComponent(ComponentBuilderContainer componentBuilder) {
        ((DonutDetailComponent.Builder) componentBuilder.getComponentBuilder(this.getClass()))
                .module(new DonutDetailModule())
                .build()
                .injectMembers(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().loadData(donutId);
    }

    @Override
    public void showDetail(Donut donut) {
        if(donut.iconResId != -1) {
            ivImage.setImageResource(donut.iconResId);
        }

        if(donut.nameResId != -1) {
            tvText.setText(donut.nameResId);
        }
    }

    @OnClick(R.id.btn_order_now)
    public void onClickOrderNow(final View view) {
        getPresenter().orderNow(donutId);
    }

    @Override
    public void showOrderProgress() {

    }

    @Override
    public void hideOrderProgress() {

    }
}
