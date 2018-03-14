package com.example.drodrigues.heroespoc.business;

import com.example.drodrigues.heroespoc.entity.Character;
import com.example.drodrigues.heroespoc.gateway.database.dao.CharacterDao;
import com.example.drodrigues.heroespoc.infrastructure.OperationResult;

import java.util.Collections;
import java.util.List;

public class CharacterBusiness extends BaseBusiness {

    private final CharacterDao characterDao;


    public CharacterBusiness(final CharacterDao characterDao) {
        super();
        this.characterDao = characterDao;
    }

    public OperationResult<List<Character>> getAllCharacters() {
        final OperationResult<List<Character>> result = new OperationResult<>();

        final List<Character> characters = characterDao.getAll();

        if (characters != null && !characters.isEmpty()) {
            result.setResult(characters);
        } else {
            result.setResult(Collections.<Character>emptyList());
        }

        return result;
    }

    public OperationResult<List<Character>> getAllHeroes() {
        final OperationResult<List<Character>> result = new OperationResult<>();

        final List<Character> characters = characterDao.getAllHeroes();

        if (characters != null && !characters.isEmpty()) {
            result.setResult(characters);
        } else {
            result.setResult(Collections.<Character>emptyList());
        }

        return result;
    }

    public OperationResult<List<Character>> getAllVillains() {
        final OperationResult<List<Character>> result = new OperationResult<>();

        final List<Character> characters = characterDao.getAllVillains();

        if (characters != null && !characters.isEmpty()) {
            result.setResult(characters);
        } else {
            result.setResult(Collections.<Character>emptyList());
        }

        return result;
    }

}
