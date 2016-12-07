package cz.kuzna.dagger2_multibinding.donutlist.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import javax.inject.Inject;

import cz.kuzna.core.inject.ComponentBuilderContainer;
import cz.kuzna.core.widget.DividerItemDecoration;
import cz.kuzna.dagger2_multibinding.R;
import cz.kuzna.dagger2_multibinding.donutlist.inject.DonutListComponent;
import cz.kuzna.dagger2_multibinding.donutlist.inject.DonutListModule;
import cz.kuzna.dagger2_multibinding.shared.inject.D2MvpActivity;

/**
 * @author Radek Kuznik
 */
public class DonutListActivity extends D2MvpActivity<DonutListPresenter, DonutListView> implements DonutListView, DonutViewHolderListener {

    @Inject
    DonutsAdapter donutsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut_list);

        donutsAdapter.setListener(this);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(donutsAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, final int swipeDir) {
                donutsAdapter.remove(viewHolder.getAdapterPosition());
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    protected void setupComponent(ComponentBuilderContainer componentBuilder) {
        ((DonutListComponent.Builder) componentBuilder.getComponentBuilder(this.getClass()))
                .module(new DonutListModule())
                .build()
                .injectMembers(this);
    }

    @Override
    public void onItemClick(int position, View view) {
        getPresenter().goToDetail(this, position);
    }

    @Override
    public void onItemLongClick(int position, View view) {
        donutsAdapter.remove(position);
    }
}
