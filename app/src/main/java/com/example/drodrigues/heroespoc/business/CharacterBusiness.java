package com.example.drodrigues.heroespoc.business;

import android.util.Pair;

import com.example.drodrigues.heroespoc.entity.Character;
import com.example.drodrigues.heroespoc.entity.CharacterType;
import com.example.drodrigues.heroespoc.gateway.database.dao.CharacterDao;
import com.example.drodrigues.heroespoc.infrastructure.OperationResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterBusiness extends BaseBusiness {

    private final CharacterDao characterDao;


    public CharacterBusiness(final CharacterDao characterDao) {
        super();
        this.characterDao = characterDao;
    }

    public OperationResult<Pair<List<Character>, List<Character>>> getAllCharacters() {
        final OperationResult<Pair<List<Character>, List<Character>>> result = new OperationResult<>();

        final List<Character> allCharacters = characterDao.getAll();

        final Pair<List<Character>, List<Character>> characters =
                new Pair<>(getAllHeroes(allCharacters), getAllVillains(allCharacters));

        result.setResult(characters);

        return result;
    }

    private List<Character> getAllHeroes(final List<Character> allCharacters) {
        final List<Character> result = new ArrayList<>();

        for (final Character character : allCharacters) {
            if (CharacterType.HERO.equals(character.getType())) {
                result.add(character);
            }
        }

        return result;
    }

    private List<Character> getAllVillains(final List<Character> allCharacters) {
        final List<Character> result = new ArrayList<>();

        for (final Character character : allCharacters) {
            if (CharacterType.VILLAIN.equals(character.getType())) {
                result.add(character);
            }
        }

        return result;
    }

}
