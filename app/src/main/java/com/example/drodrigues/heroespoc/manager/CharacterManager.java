package com.example.drodrigues.heroespoc.manager;

import android.content.Context;
import android.os.AsyncTask;

import com.example.drodrigues.heroespoc.business.CharacterBusiness;
import com.example.drodrigues.heroespoc.entity.Character;
import com.example.drodrigues.heroespoc.infrastructure.OperationListener;
import com.example.drodrigues.heroespoc.infrastructure.OperationResult;
import com.example.drodrigues.heroespoc.infrastructure.factory.DaoFactory;

import java.util.List;

public class CharacterManager extends BaseManager {

    private final CharacterBusiness characterBusiness;

    public CharacterManager(final Context context) {
        super(context);
        characterBusiness = new CharacterBusiness(DaoFactory.getInstance().createHeroDao(context));
    }


    public void getAllHeroes(final OperationListener<List<Character>> listener) {
        AsyncTask<Void, Void, OperationResult<List<Character>>> task =
                new AsyncTask<Void, Void, OperationResult<List<Character>>>() {

                    @Override
                    protected OperationResult<List<Character>> doInBackground(Void... voids) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return characterBusiness.getAllHeroes();
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

        addTask(task);
    }

    public void getAllVillains(final OperationListener<List<Character>> listener) {
        AsyncTask<Void, Void, OperationResult<List<Character>>> task =
                new AsyncTask<Void, Void, OperationResult<List<Character>>>() {

                    @Override
                    protected OperationResult<List<Character>> doInBackground(Void... voids) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return characterBusiness.getAllVillains();
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

        addTask(task);
    }


    private void addTask(final AsyncTask<Void, Void, OperationResult<List<Character>>> task) {
        // Task execution
        addToTaskList(task);
        task.execute();
    }


}
