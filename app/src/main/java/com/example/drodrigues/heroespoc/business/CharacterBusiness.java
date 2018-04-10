package com.example.drodrigues.heroespoc.business;

import android.util.Pair;

import com.example.drodrigues.heroespoc.entity.Character;
import com.example.drodrigues.heroespoc.entity.CharacterType;
import com.example.drodrigues.heroespoc.gateway.database.dao.CharacterDao;
import com.example.drodrigues.heroespoc.gateway.network.MarvelIntegrator;
import com.example.drodrigues.heroespoc.infrastructure.OperationError;
import com.example.drodrigues.heroespoc.infrastructure.OperationResult;

import java.util.ArrayList;
import java.util.List;

import static com.example.drodrigues.heroespoc.infrastructure.Constants.Errors.NEW_CHARACTER_EMPTY_DESCRIPTION;
import static com.example.drodrigues.heroespoc.infrastructure.Constants.Errors.NEW_CHARACTER_EMPTY_NAME;
import static com.example.drodrigues.heroespoc.infrastructure.Constants.Errors.NEW_CHARACTER_EMPTY_PICTURE;
import static com.example.drodrigues.heroespoc.infrastructure.Constants.Errors.NEW_CHARACTER_TYPE;

public class CharacterBusiness extends BaseBusiness {

    private final CharacterDao characterDao;
    private final MarvelIntegrator marvelIntegrator;

    private static final int marvelLimit = 10;


    public CharacterBusiness(final CharacterDao characterDao,
                             final MarvelIntegrator marvelIntegrator) {
        super();
        this.characterDao = characterDao;
        this.marvelIntegrator = marvelIntegrator;
    }

    public OperationResult<Pair<List<Character>, List<Character>>> getAllCharacters() {
        final OperationResult<Pair<List<Character>, List<Character>>> result = new OperationResult<>();

        final List<Character> allCharacters = characterDao.getAll();

        final Pair<List<Character>, List<Character>> characters =
                new Pair<>(getAllHeroes(allCharacters), getAllVillains(allCharacters));

        result.setResult(characters);

        return result;
    }

    public OperationResult<Boolean> saveCharacter(final Character character) {
        final OperationResult<Boolean> result = new OperationResult<>();

        final List<OperationError> errors = validateCharacter(character);

        if (errors.isEmpty()) {
            result.setResult(characterDao.add(character));
        } else {
            result.addAllErrors(errors);
        }

        return result;
    }

    public OperationResult<List<Character>> getMarvelCharacters(final int offset) {
        return marvelIntegrator.getMarvelCharacters(marvelLimit, offset);
    }

    private List<OperationError> validateCharacter(final Character character) {
        final List<OperationError> errors = new ArrayList<>();

        if (character.getName().isEmpty()) {
            errors.add(new OperationError(NEW_CHARACTER_EMPTY_NAME, "Name can not be empty"));
        }

        if (character.getType() == null) {
            errors.add(new OperationError(NEW_CHARACTER_TYPE, "The character must have a type"));
        }

        if (character.getDescription().isEmpty()) {
            errors.add(new OperationError(NEW_CHARACTER_EMPTY_DESCRIPTION, "The character must have a description"));
        }

        if (character.getPictureUrl().isEmpty() && character.getPicture() == null) {
            errors.add(new OperationError(NEW_CHARACTER_EMPTY_PICTURE, "The character must have a picture"));
        }

        return errors;
    }

    private List<Character> getAllHeroes(final List<Character> allCharacters) {
        final List<Character> result = new ArrayList<>();

        for (final Character character : allCharacters) {
            if (CharacterType.DC_HERO.equals(character.getType())) {
                result.add(character);
            }
        }

        return result;
    }

    private List<Character> getAllVillains(final List<Character> allCharacters) {
        final List<Character> result = new ArrayList<>();

        for (final Character character : allCharacters) {
            if (CharacterType.DC_VILLAIN.equals(character.getType())) {
                result.add(character);
            }
        }

        return result;
    }

}
