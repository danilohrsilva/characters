package com.example.drodrigues.heroespoc.ui.detail;

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
    }

    private void getHeroExtra() {
        if (getIntent().hasExtra("character")) {
            this.character = (Character) getIntent().getSerializableExtra("character");
            getHeroDetail();
        }
    }

    private void getHeroDetail() {
        Picasso.with(this).load(character.getPicture()).into(heroImg);
        heroName.setText(character.getName());
        heroSecretName.setText(character.getSecretName());
        heroDescription.setText(character.getDescription());
    }
}
