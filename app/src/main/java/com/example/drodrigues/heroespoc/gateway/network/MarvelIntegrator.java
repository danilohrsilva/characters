package com.example.drodrigues.heroespoc.gateway.network;

import com.example.drodrigues.heroespoc.entity.Character;
import com.example.drodrigues.heroespoc.entity.CharacterType;
import com.example.drodrigues.heroespoc.entity.marvel.MarvelCharacter;
import com.example.drodrigues.heroespoc.entity.marvel.MarvelResult;
import com.example.drodrigues.heroespoc.gateway.network.services.MarvelService;
import com.example.drodrigues.heroespoc.infrastructure.Constants;
import com.example.drodrigues.heroespoc.infrastructure.OperationError;
import com.example.drodrigues.heroespoc.infrastructure.OperationResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MarvelIntegrator extends BackendIntegrator {

    private final MarvelService marvelService;


    public MarvelIntegrator() {
        super();
        marvelService = BackendIntegrator.createServiceMarvelAuthentication(MarvelService.class);
    }

    public OperationResult<List<Character>> getMarvelCharacters(final int limit, final int offset) {
        final Call<MarvelResult> call = marvelService.getMarvelCharacters(limit, offset);

        final OperationResult<List<Character>> result = new OperationResult<>();

        try {
            final Response<MarvelResult> response = call.execute();

            if (response.isSuccessful()) {
                final MarvelResult data = response.body();
                result.setResult(marvelToCharacter(data));
            } else {
                validateDefaultErrors(response.code(), result);
            }

        } catch (final IOException ex) {
            result.addError(new OperationError(Constants.Errors.INTERNET_NOT_AVAILABLE, "Internet not available."));
        }

        return result;
    }

    private List<Character> marvelToCharacter(final MarvelResult marvelData) {
        final List<Character> result = new ArrayList<>();

        if (marvelData != null) {
            for (MarvelCharacter marvel : marvelData.getData().getResults()) {
                final Character character =
                        new Character(marvel.getName(),
                                null,
                                marvel.getDescription(),
                                marvel.getThumbnail().getPath() + '.' + marvel.getThumbnail().getExtension(),
                                CharacterType.MARVEL
                        );
                result.add(character);
            }
        }

        return result;
    }

}
