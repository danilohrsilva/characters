package com.example.drodrigues.heroespoc.manager;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.drodrigues.heroespoc.business.CharacterBusiness;
import com.example.drodrigues.heroespoc.entity.Character;
import com.example.drodrigues.heroespoc.infrastructure.OperationListener;
import com.example.drodrigues.heroespoc.infrastructure.OperationResult;
import com.example.drodrigues.heroespoc.infrastructure.factory.DaoFactory;
import com.example.drodrigues.heroespoc.infrastructure.factory.IntegratorFactory;

import java.util.List;

public class CharacterManager extends BaseManager {

    private final CharacterBusiness characterBusiness;

    public CharacterManager(final Context context) {
        super(context);
        characterBusiness = new CharacterBusiness(DaoFactory.getInstance().createHeroDao(context),
                IntegratorFactory.getInstance().marvelIntegrator());
    }


    public void getAllCharacters(final OperationListener<Pair<List<Character>, List<Character>>> listener) {
        cancelOperations();
        AsyncTask<Void, Void, OperationResult<Pair<List<Character>, List<Character>>>> task =
                new AsyncTask<Void, Void, OperationResult<Pair<List<Character>, List<Character>>>>() {

                    @Override
                    protected OperationResult<Pair<List<Character>, List<Character>>> doInBackground(Void... voids) {
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return characterBusiness.getAllCharacters();
                    }

                    @Override
                    protected void onPostExecute(final OperationResult<Pair<List<Character>, List<Character>>> operationResult) {
                        removeFromTaskList(this);
                        if (listener != null) {
                            if (operationResult.isOperationSuccessful()) {
                                listener.onSuccess(operationResult.getResult());
                            } else {
                                listener.onError(operationResult.getErrors());
                            }
                        }
                    }

                    @Override
                    protected void onCancelled() {
                        removeFromTaskList(this);
                        if (listener != null) {
                            listener.onCancel();
                        }
                    }
                };

        addToTaskList(task);
        task.execute();
    }

    public void newCharacter(final Character character, final OperationListener<Boolean> listener) {
        AsyncTask<Void, Void, OperationResult<Boolean>> task =
                new AsyncTask<Void, Void, OperationResult<Boolean>>() {
                    @Override
                    protected OperationResult<Boolean> doInBackground(Void... voids) {
                        return characterBusiness.saveCharacter(character);
                    }

                    @Override
                    protected void onPostExecute(final OperationResult<Boolean> operationResult) {
                        removeFromTaskList(this);
                        if (listener != null) {
                            if (operationResult.isOperationSuccessful()) {
                                listener.onSuccess(operationResult.getResult());
                            } else {
                                listener.onError(operationResult.getErrors());
                            }
                        }
                    }

                    @Override
                    protected void onCancelled() {
                        removeFromTaskList(this);
                        if (listener != null) {
                            listener.onCancel();
                        }
                    }
                };
        addToTaskList(task);
        task.execute();
    }

    public void getMarvelCharacters(final OperationListener<List<Character>> listener,
                                    final int offset) {
        cancelOperations();
        AsyncTask<Void, Void, OperationResult<List<Character>>> task =
                new AsyncTask<Void, Void, OperationResult<List<Character>>>() {

                    @Override
                    protected OperationResult<List<Character>> doInBackground(Void... voids) {
                        return characterBusiness.getMarvelCharacters(offset);
                    }

                    @Override
                    protected void onPostExecute(final OperationResult<List<Character>> operationResult) {
                        removeFromTaskList(this);
                        if (listener != null) {
                            if (operationResult.isOperationSuccessful()) {
                                listener.onSuccess(operationResult.getResult());
                            } else {
                                listener.onError(operationResult.getErrors());
                            }
                        }
                    }

                    @Override
                    protected void onCancelled() {
                        removeFromTaskList(this);
                        if (listener != null) {
                            listener.onCancel();
                        }
                    }

                };

        addToTaskList(task);
        task.execute();
    }

}
