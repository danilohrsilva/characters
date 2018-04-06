package com.example.drodrigues.heroespoc.ui.list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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

    private OnLastItemVisible mCallback;


    public static CharactersFragment newInstance(final List<Character> characters) {
        final CharactersFragment charactersFragment = new CharactersFragment();
        final Bundle args = new Bundle();
        args.putSerializable("characters", (Serializable) characters);
        charactersFragment.setArguments(args);
        return charactersFragment;
    }

    // Container Activity must implement this interface
    public interface OnLastItemVisible {
        public void onLastItemVisible();
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

        recyclerViewItems.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    final GridLayoutManager grid = (GridLayoutManager) recyclerView.getLayoutManager();
                    if (grid.findLastCompletelyVisibleItemPosition() == grid.getItemCount() - 1) {
                        mCallback.onLastItemVisible();
                    }
                }

            }
        });

    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            try {
                mCallback = (OnLastItemVisible) context;
            } catch (ClassCastException e) {
                throw new ClassCastException(context.toString()
                    + " must implement OnLastItemVisible");
            }
        }
    }

    public void addMoreCharacters(final List<Character> characters) {
        this.characters.addAll(characters);
        characterAdapter.notifyDataSetChanged();
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
