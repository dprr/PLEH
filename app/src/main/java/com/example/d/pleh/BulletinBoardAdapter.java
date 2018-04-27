package com.example.d.pleh;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BulletinBoardAdapter extends RecyclerView.Adapter<BulletinBoardAdapter.ViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(Wish item);
    }

    private List<Wish> bulletinBoardDataset;
    private final OnItemClickListener listener;

    public BulletinBoardAdapter(List<Wish> bulletinBoardDataset, OnItemClickListener listener) {
        this.bulletinBoardDataset = bulletinBoardDataset;
        this.listener = listener;
    }

    @Override
    public BulletinBoardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wish_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(bulletinBoardDataset.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return bulletinBoardDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView wishImageView;
        TextView wishDescriptionTextView;
        ImageView offerImageView;
        TextView offerDescriptionTextView;

        public ViewHolder(View view) {
            super(view);
            wishImageView = view.findViewById(R.id.wish_image);
            wishDescriptionTextView = view.findViewById(R.id.wish_description);
            offerImageView = view.findViewById(R.id.offer_image);
            offerDescriptionTextView = view.findViewById(R.id.offer_description);
        }

        public void bind(final Wish item, final OnItemClickListener listener) {
            wishImageView.setImageResource(Wish.getWishImage(item.getWishCategoryType()));
            wishDescriptionTextView.setText(item.getWishTitle());
            offerImageView.setImageResource(Wish.getRewardImage(item.getRewardCategoryType()));
            offerDescriptionTextView.setText(item.getRewardTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
