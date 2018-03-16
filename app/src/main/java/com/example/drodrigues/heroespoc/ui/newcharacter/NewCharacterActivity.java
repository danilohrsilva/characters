package com.example.drodrigues.heroespoc.ui.newcharacter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;

import com.example.drodrigues.heroespoc.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewCharacterActivity extends AppCompatActivity{

    public static final String EXTRA_CHARACTER_TYPE = "characterType";

    @BindView(R.id.character_name)
    protected TextInputEditText inputName;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_character);
        ButterKnife.bind(this);
    }
}
