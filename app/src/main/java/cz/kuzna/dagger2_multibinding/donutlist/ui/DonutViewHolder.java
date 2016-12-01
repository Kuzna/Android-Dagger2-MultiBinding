package cz.kuzna.dagger2_multibinding.donutlist.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cz.kuzna.dagger2_multibinding.R;

/**
 * @author Radek Kuznik
 */
public class DonutViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public ImageView icon;
    public ImageView favoriteIcon;

    public DonutViewHolder(final View view, final DonutViewHolderListener listener) {
        super(view);
        name = (TextView) itemView.findViewById(R.id.textViewName);
        icon = (ImageView) itemView.findViewById(R.id.imageViewIcon);
        favoriteIcon = (ImageView) itemView.findViewById(R.id.imageViewFavorite);

        if(listener != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition(), v);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onItemLongClick(getAdapterPosition(), v);
                    return false;
                }
            });
        }
    }
}