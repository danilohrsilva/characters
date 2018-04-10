package com.example.drodrigues.heroespoc.ui.newcharacter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.drodrigues.heroespoc.R;
import com.example.drodrigues.heroespoc.entity.Character;
import com.example.drodrigues.heroespoc.entity.CharacterType;
import com.example.drodrigues.heroespoc.infrastructure.Constants.Errors;
import com.example.drodrigues.heroespoc.infrastructure.OperationError;
import com.example.drodrigues.heroespoc.infrastructure.OperationListener;
import com.example.drodrigues.heroespoc.manager.CharacterManager;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;

public class NewCharacterActivity extends AppCompatActivity{

    public static final String EXTRA_CHARACTER_TYPE = "characterType";
    public static final int    NEW_CHARACTER_CODE = 1;
    public static final String EXTRA_CHARACTER = "character";

    private static final int HERO_PICTURE = 1000;

    @BindView(R.id.layout_character_name)
    protected TextInputLayout nameLayout;

    @BindView(R.id.character_name)
    protected TextInputEditText name;

    @BindView(R.id.layout_character_secret_name)
    protected TextInputLayout secretNameLayout;

    @BindView(R.id.character_secret_name)
    protected TextInputEditText secretName;

    @BindView(R.id.layout_character_description)
    protected TextInputLayout descriptionLayout;

    @BindView(R.id.character_description)
    protected TextInputEditText description;

    @BindView(R.id.layout_character_url)
    protected TextInputLayout pictureUrlLayout;

    @BindView(R.id.character_pic_url)
    protected TextInputEditText pictureUrl;

    @BindView(R.id.hero_img)
    protected ImageView heroImg;

    @BindView(R.id.camera_icon)
    protected ImageView cameraIcon;

    @BindView(R.id.delete_icon)
    protected ImageView deleteIcon;

    private CharacterManager mCharacterManager;

    private CharacterType type;

    private Character character = new Character();

    private byte[] picture = null;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_character);

        mCharacterManager = new CharacterManager(this);

        ButterKnife.bind(this);

        if (getIntent().hasExtra(EXTRA_CHARACTER_TYPE)) {
            type = (CharacterType) getIntent().getSerializableExtra(EXTRA_CHARACTER_TYPE);
        }
    }

    @OnClick(R.id.new_character_save)
    public void onSave() {
        setCharacter();

        mCharacterManager.newCharacter(character, new OperationListener<Boolean>() {
            @Override
            public void onSuccess(final Boolean result) {
                super.onSuccess(result);
                Toast.makeText(NewCharacterActivity.this, "Character saved", Toast.LENGTH_SHORT).show();
                final Intent returnIntent = new Intent();
                returnIntent.putExtra(NewCharacterActivity.EXTRA_CHARACTER, character);
                setResult(RESULT_OK, returnIntent);
                finish();
            }

            @Override
            public void onError(final List<OperationError> errors) {
                super.onError(errors);

                for (final OperationError error : errors) {
                    handleError(error);
                }

                Toast.makeText(NewCharacterActivity.this, "Errou!!!", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @OnFocusChange(R.id.character_pic_url)
    public void updatePicture() {
        final String url = pictureUrl.getText().toString();
        if (!url.isEmpty()){
            Picasso.with(NewCharacterActivity.this).load(url).into(heroImg);
        } else {
            heroImg.setImageURI(null);
        }

    }

    @OnClick(R.id.camera_icon)
    public void takePicture() {
        if (ContextCompat.checkSelfPermission(NewCharacterActivity.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(NewCharacterActivity.this, new String[] {Manifest.permission.CAMERA}, 1);
        } else {
            openCamera();
        }

    }

    @OnClick(R.id.delete_icon)
    public void deletePicture() {
        picture = null;
        deleteIcon.setVisibility(View.GONE);
        cameraIcon.setVisibility(View.VISIBLE);
        pictureUrl.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                } else {
                    Toast.makeText(this, "Permissão", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == HERO_PICTURE) {
            if (data.hasExtra("data")) {
                final Bitmap image = (Bitmap) data.getExtras().get("data");
                if (image != null) {
                    heroImg.setImageBitmap(image);
                    deleteIcon.setVisibility(View.VISIBLE);
                    cameraIcon.setVisibility(View.GONE);
                    pictureUrl.setVisibility(View.GONE);

                    final ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    image.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    picture = stream.toByteArray();
                }
            }

        }
    }

    private void openCamera() {
        final Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, HERO_PICTURE);
    }

    private void setCharacter() {
        character.setName(name.getText().toString());
        character.setSecretName(secretName.getText().toString());
        character.setDescription(description.getText().toString());
        if (picture != null) {
            character.setPicture(picture);
            character.setPictureUrl("");
        } else {
            character.setPictureUrl(pictureUrl.getText().toString());
        }
        character.setType(type);
    }

    private void handleError(final OperationError error) {
        switch (error.getErrorCode()) {
            case Errors.NEW_CHARACTER_EMPTY_NAME : nameLayout.setError(getString(R.string.new_character_name_empty));
                break;
            case Errors.NEW_CHARACTER_EMPTY_DESCRIPTION : descriptionLayout.setError(getString(R.string.new_character_description_empty));
                break;
            case Errors.NEW_CHARACTER_EMPTY_PICTURE : pictureUrlLayout.setError(getString(R.string.new_character_picture_empty));
                break;
        }
    }
}
