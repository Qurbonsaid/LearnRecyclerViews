package com.example.android.learnrecyclerviews;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CaptionedImagesAdapter extends
        RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{

    private ArrayList<ItsCode> itsCodes;
    private Listener listener;

    interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CaptionedImagesAdapter(ArrayList<ItsCode> itsCodes){
        this.itsCodes = itsCodes;
    }

    @Override
    public int getItemCount(){
        return itsCodes.toArray().length;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_caption_image, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.code_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(),
                itsCodes.get(position).getImageResourceId());
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(itsCodes.get(position).getName());
        TextView textView = (TextView) cardView.findViewById(R.id.file_name);
        textView.setText(itsCodes.get(position).getName());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }
}
