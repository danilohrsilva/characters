package com.example.drodrigues.heroespoc.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drodrigues.heroespoc.R;
import com.example.drodrigues.heroespoc.entity.Character;
import com.example.drodrigues.heroespoc.ui.detail.CharacterDetailActivity;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharactersFragment extends Fragment {

    @BindView(R.id.recycle_view_list_item)
    protected RecyclerView recyclerViewItems;

    private List<Character> characters;

    private CharacterAdapter characterAdapter;



    public static CharactersFragment newInstance(final List<Character> characters) {
        final CharactersFragment charactersFragment = new CharactersFragment();
        final Bundle args = new Bundle();
        args.putSerializable("characters", (Serializable) characters);
        charactersFragment.setArguments(args);
        return charactersFragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.heroes_list, container, false);
        ButterKnife.bind(this, view);
        characters = (List<Character>) getArguments().getSerializable("characters");
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadCharacterAdapter();
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
        final Intent intent = new Intent(this.getActivity(), CharacterDetailActivity.class);
        intent.putExtra("character", character);
        startActivity(intent);
    }

}
