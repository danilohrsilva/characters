package com.example.drodrigues.heroespoc.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.drodrigues.heroespoc.R;
import com.example.drodrigues.heroespoc.entity.Character;
import com.example.drodrigues.heroespoc.entity.CharacterType;
import com.example.drodrigues.heroespoc.infrastructure.OperationListener;
import com.example.drodrigues.heroespoc.manager.CharacterManager;
import com.example.drodrigues.heroespoc.ui.newcharacter.NewCharacterActivity;
import com.github.clans.fab.FloatingActionButton;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CharacterListActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemReselectedListener {

    @BindView(R.id.list_toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.progressBar)
    protected ProgressBar progressBar;

    @BindView(R.id.bottom_nav_view)
    protected BottomNavigationView bottomNavigationView;

    @BindView(R.id.characters_list_view_pager)
    protected ViewPager viewPage;

    @BindView(R.id.fab_add_hero)
    protected FloatingActionButton fabAddHero;

    @BindView(R.id.fab_add_villain)
    protected FloatingActionButton fabAddVillain;


    private Pair<List<Character>, List<Character>> characters;

    private CharacterManager mCharacterManager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mCharacterManager = new CharacterManager(this);

        ButterKnife.bind(this);

        initBottomNavigation();
        progressBar.setVisibility(View.VISIBLE);
        if (savedInstanceState!= null && (savedInstanceState.containsKey("heroes") &&
                savedInstanceState.containsKey("villains"))) {

            characters = new Pair<>((List<Character>) savedInstanceState.getSerializable("heroes"),
                    (List<Character>) savedInstanceState.getSerializable("villains"));
            viewPage.setAdapter(new CharacterPagerAdapter(getSupportFragmentManager(), characters));
            progressBar.setVisibility(View.GONE);

        } else {
            mCharacterManager.getAllCharacters(new OperationListener<Pair<List<Character>, List<Character>>>() {
                @Override
                public void onSuccess(Pair<List<Character>, List<Character>> result) {
                    super.onSuccess(result);
                    characters = result;
                    progressBar.setVisibility(View.GONE);
                    viewPage.setAdapter(new CharacterPagerAdapter(getSupportFragmentManager(), characters));
                }
            });

        }

        viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    bottomNavigationView.setSelectedItemId(R.id.nav_heroes);
                } else {
                    bottomNavigationView.setSelectedItemId(R.id.nav_villains);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onSaveInstanceState(final Bundle savedInstanceState) {
        if (!characters.first.isEmpty() || !characters.second.isEmpty()) {
            savedInstanceState.putSerializable("heroes", (Serializable) characters.first);
            savedInstanceState.putSerializable("villains", (Serializable) characters.second);
        }

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCharacterManager != null) {
            mCharacterManager.cancelOperations();
        }
    }

    private void initBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemReselectedListener(this);
        bottomNavigationView.setItemIconTintList(null);
    }

    @Override
    public void onNavigationItemReselected(@NonNull final MenuItem item) {
        final int a = 1;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        if (bottomNavigationView.getSelectedItemId() != item.getItemId()) {
            if (item.getItemId() == R.id.nav_heroes) {
                viewPage.setCurrentItem(0, true);
            } else {
                viewPage.setCurrentItem(1, true);
            }
        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @OnClick(R.id.fab_add_hero)
    void newHero() {
        openNewCharacter(CharacterType.HERO);
    }

    @OnClick(R.id.fab_add_villain)
    void newVillain() {
        openNewCharacter(CharacterType.VILLAIN);
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (NewCharacterActivity.NEW_CHARACTER_CODE == requestCode) {
            if (resultCode == RESULT_OK) {
                if (data.hasExtra(NewCharacterActivity.EXTRA_CHARACTER) &&
                    data.hasExtra(NewCharacterActivity.EXTRA_CHARACTER_TYPE)) {
                    addCharacter((Character) data.getSerializableExtra(NewCharacterActivity.EXTRA_CHARACTER),
                            (CharacterType) data.getSerializableExtra(NewCharacterActivity.EXTRA_CHARACTER_TYPE));
                }
            }
        }
    }

    private void openNewCharacter(final CharacterType type) {
        final Intent intent = new Intent(this, NewCharacterActivity.class);
        intent.putExtra(NewCharacterActivity.EXTRA_CHARACTER_TYPE, type);
        startActivityForResult(intent, NewCharacterActivity.NEW_CHARACTER_CODE);
    }

    private void addCharacter(final Character character, final CharacterType type) {
        final List<Character> heroes = characters.first;
        final List<Character> villains = characters.second;
        if (CharacterType.HERO.equals(type)) {
            heroes.add(character);
        } else {
            villains.add(character);
        }

        characters = new Pair<>(heroes, villains);
    }
}
