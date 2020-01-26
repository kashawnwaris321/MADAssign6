package com.example.user.chaishack;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 14-Dec-19.
 */

public class RecyclerAdapater extends RecyclerView.Adapter<RecyclerAdapater.ImageViewHolder>
{

    private int [] images;

    public RecyclerAdapater (int [] images)
    {
        this.images= images;


    }
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate (R.layout.album_layout,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position)
    {
            int image_id = images[position];
            holder.Album.setImageResource(image_id);
            holder.AlbumTitle.setText("image :"+position);
    }

    @Override
    public int getItemCount()
    {

        return images.length;
    }
    public static class  ImageViewHolder extends RecyclerView.ViewHolder{

            ImageView Album;
            TextView AlbumTitle;

        public ImageViewHolder(View itemView) {
            super(itemView);

            Album =itemView.findViewById(R.id.album);
            AlbumTitle= itemView.findViewById(R.id.album_title);
        }
    }
}
