package br.com.luciano.popularmovies.screen;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import br.com.luciano.popularmovies.R;
import br.com.luciano.popularmovies.util.OnItemClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieVideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.movie_video_thumbnail)
    ImageView movieVideoThumbnail;

    @Nullable
    private OnItemClickListener onItemClickListener;

    public MovieVideoViewHolder(View itemView, @Nullable OnItemClickListener onItemClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.onItemClickListener = onItemClickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
