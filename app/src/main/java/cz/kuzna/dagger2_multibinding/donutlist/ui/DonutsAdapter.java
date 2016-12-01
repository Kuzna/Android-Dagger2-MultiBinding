package cz.kuzna.dagger2_multibinding.donutlist.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cz.kuzna.dagger2_multibinding.R;
import cz.kuzna.dagger2_multibinding.shared.donut.domain.Donut;

/**
 * @author Radek Kuznik
 */
public class DonutsAdapter extends RecyclerView.Adapter<DonutViewHolder> {

    private DonutViewHolderListener listener;
    private ArrayList<Donut> items;

    public DonutsAdapter() {
        items = new ArrayList<>();

        items.add(new Donut(R.drawable.ic_donut_blue_moon_sprinkle, R.string.blue_moon_sprinkle, false));
        items.add(new Donut(R.drawable.ic_donut_butter_nut, R.string.butter_nut, false));
        items.add(new Donut(R.drawable.ic_donut_caviar_strawberry, R.string.caviar_strawberry, false));
        items.add(new Donut(R.drawable.ic_donut_dark_chocolate_sprinkle, R.string.dark_chocolate_sprinkle, true));

        items.add(new Donut(R.drawable.ic_donut_green_tea_sprinkle, R.string.green_tea_sprinkle, true));
        items.add(new Donut(R.drawable.ic_donut_lemon_sprinkle, R.string.lemon_sprinkle, false));
        items.add(new Donut(R.drawable.ic_donut_maple_iced, R.string.maple_iced, false));
        items.add(new Donut(R.drawable.ic_donut_raspberry, R.string.raspberry, true));

        items.add(new Donut(R.drawable.ic_donut_strawberry_sprinkle, R.string.strawberry_sprinkle, false));
        items.add(new Donut(R.drawable.ic_donut_sugar_pink, R.string.sugar_pink, false));
        items.add(new Donut(R.drawable.ic_donut_vanilla_iced, R.string.vanilla_iced, true));
        items.add(new Donut(R.drawable.ic_donut_vanilla_sprinkle, R.string.vanilla_sprinkle, true));
    }

    @Override
    public DonutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_donut, parent, false);
        return new DonutViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(final DonutViewHolder holder, final int position) {
        final Donut donut = items.get(position);
        holder.name.setText(donut.nameResId);
        holder.icon.setImageResource(donut.iconResId);
//        holder.favoriteIcon.setImageResource(donut.favorite ? R.drawable.ic_star_yellow_500_24dp : R.drawable.ic_star_border_grey_500_24dp);
    }

    public void setListener(DonutViewHolderListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public Donut getItem(int position) {
        return items.get(position);
    }

    public void remove(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }
}