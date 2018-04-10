package com.example.drodrigues.heroespoc.ui.list;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drodrigues.heroespoc.R;
import com.example.drodrigues.heroespoc.entity.Character;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private List<Character> characters;
    private OnItemClickListener listener;

    public CharacterAdapter(final List<Character> characters, final OnItemClickListener listener) {
        this.characters = characters;
        this.listener= listener;
    }

    /**
     * Interface for click item.
     */
    public interface OnItemClickListener {
        void onItemClick(final Character character);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_character, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CharacterAdapter.ViewHolder holder, final int position) {
        final Character character = characters.get(position);
        holder.bind(character, listener);
    }

    @Override
    public int getItemCount() {
        return this.characters.size();
    }

    public void refreshList(final List<Character> characters) {
        this.characters = characters;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.hero_name)
        TextView heroName;

        @BindView(R.id.hero_img)
        ImageView heroImg;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Character character, final OnItemClickListener listener) {
            heroName.setText(character.getName());
            if (!character.getPictureUrl().isEmpty()) {
                Picasso.with(itemView.getContext()).load(character.getPictureUrl()).into(heroImg);
            } else {
                final byte[] picture = character.getPicture();
                final Bitmap bmp = BitmapFactory.decodeByteArray(picture, 0, picture.length);
                heroImg.setImageBitmap(bmp);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(character);
                }
            });
        }

    }
}
