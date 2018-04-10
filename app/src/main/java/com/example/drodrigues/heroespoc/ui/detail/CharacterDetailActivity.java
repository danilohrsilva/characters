package com.example.drodrigues.heroespoc.ui.detail;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drodrigues.heroespoc.R;
import com.example.drodrigues.heroespoc.entity.Character;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterDetailActivity extends AppCompatActivity {

    @BindView(R.id.hero_img)
    protected ImageView heroImg;

    @BindView(R.id.hero_name)
    protected TextView heroName;

    @BindView(R.id.hero_secret_name)
    protected TextView heroSecretName;

    @BindView(R.id.hero_description)
    protected TextView heroDescription;

    private Character character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
        ButterKnife.bind(this);

        getHeroExtra();
        startAnimation();
    }

    private void getHeroExtra() {
        if (getIntent().hasExtra("character")) {
            this.character = (Character) getIntent().getSerializableExtra("character");
            getHeroDetail();
        }
    }

    private void getHeroDetail() {

        if (!character.getPictureUrl().isEmpty()) {
            Picasso.with(this).load(character.getPictureUrl()).into(heroImg);
        } else {
            final byte[] picture = character.getPicture();
            final Bitmap bmp = BitmapFactory.decodeByteArray(picture, 0, picture.length);
            heroImg.setImageBitmap(bmp);
        }

        heroName.setText(character.getName());
        heroSecretName.setText(character.getSecretName());
        heroDescription.setText(character.getDescription());
    }

    private void startAnimation() {
        final ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                heroImg,
                PropertyValuesHolder.ofFloat("scaleX", 1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        scaleDown.setDuration(310);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown.setRepeatCount(5);

        scaleDown.start();
    }
}
