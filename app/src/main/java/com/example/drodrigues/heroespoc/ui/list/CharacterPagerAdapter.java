package com.example.drodrigues.heroespoc.ui.list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Pair;

import com.example.drodrigues.heroespoc.entity.Character;

import java.util.List;

public class CharacterPagerAdapter extends FragmentPagerAdapter {

    private static int QT_ITEMS = 2;

    private static Pair<List<Character>, List<Character>> characters;

    public CharacterPagerAdapter(final FragmentManager fragmentManager,
                                 final Pair<List<Character>, List<Character>> characters) {
        super(fragmentManager);
        this.characters = characters;
    }

    @Override
    public Fragment getItem(final int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return CharactersFragment.newInstance(characters.first);
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return CharactersFragment.newInstance(characters.second);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return QT_ITEMS;
    }
}
