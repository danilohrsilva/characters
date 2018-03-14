package com.example.drodrigues.heroespoc.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.drodrigues.heroespoc.R;
import com.example.drodrigues.heroespoc.entity.Character;
import com.example.drodrigues.heroespoc.infrastructure.OperationListener;
import com.example.drodrigues.heroespoc.manager.CharacterManager;
import com.example.drodrigues.heroespoc.ui.detail.CharacterDetailActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterListActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemReselectedListener {

    @BindView(R.id.list_toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.recycle_view_list_item)
    protected RecyclerView recyclerViewItems;

    @BindView(R.id.progressBar)
    protected ProgressBar progressBar;

    @BindView(R.id.bottom_nav_view)
    protected BottomNavigationView bottomNavigationView;

    private CharacterAdapter characterAdapter;

    private final List<Character> characters = new ArrayList<>();

    private CharacterManager mCharacterManager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        mCharacterManager = new CharacterManager(this);
        initBottomNavigation();
        bottomNavigationView.setItemIconTintList(null);

        progressBar.setVisibility(View.VISIBLE);
        loadCharacterAdapter();
        if (savedInstanceState!= null && savedInstanceState.containsKey("characters")) {
            characters.addAll((List<Character>) savedInstanceState.getSerializable("characters"));
            progressBar.setVisibility(View.GONE);
            recyclerViewItems.getAdapter().notifyDataSetChanged();
        } else {
            if(bottomNavigationView.getSelectedItemId() == R.id.nav_heroes) {
                getHeroes();
            } else {
                getVillains();
            }

        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle savedInstanceState) {
        if (!characters.isEmpty()) {
            savedInstanceState.putSerializable("characters", (Serializable) characters);
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

    private void getHeroes() {

        mCharacterManager.getAllHeroes(new OperationListener<List<Character>>() {
            @Override
            public void onSuccess(final List<Character> result) {
                super.onSuccess(result);
                characters.clear();
                characters.addAll(result);
                progressBar.setVisibility(View.GONE);
                bottomNavigationView.setVisibility(View.VISIBLE);
                recyclerViewItems.getAdapter().notifyDataSetChanged();
            }
        });
    }

    private void getVillains() {
        mCharacterManager.getAllVillains(new OperationListener<List<Character>>() {
            @Override
            public void onSuccess(final List<Character> result) {
                super.onSuccess(result);
                characters.clear();
                characters.addAll(result);
                progressBar.setVisibility(View.GONE);
                bottomNavigationView.setVisibility(View.VISIBLE);
                recyclerViewItems.getAdapter().notifyDataSetChanged();
            }
        });
    }

    private void loadCharacterAdapter() {
        characterAdapter = new CharacterAdapter(characters, new CharacterAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(final Character character) {
                startDetailActivity(character);
            }
        });

        recyclerViewItems.setAdapter(characterAdapter);

    }

    private void startDetailActivity(final Character character) {
        final Intent intent = new Intent(this, CharacterDetailActivity.class);
        intent.putExtra("character", character);
        startActivity(intent);
    }

    private void initBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemReselectedListener(this);
    }

    @Override
    public void onNavigationItemReselected(@NonNull final MenuItem item) {
        final int a = 1;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        if (bottomNavigationView.getSelectedItemId() != item.getItemId()) {
            characters.clear();
            progressBar.setVisibility(View.VISIBLE);
            if (item.getItemId() == R.id.nav_heroes) {
                getHeroes();
            } else {
                getVillains();
            }
        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
