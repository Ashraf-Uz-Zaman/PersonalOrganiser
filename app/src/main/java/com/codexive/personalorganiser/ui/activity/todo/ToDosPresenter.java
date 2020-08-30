package com.codexive.personalorganiser.ui.activity.todo;



import android.util.Log;

import com.androidnetworking.error.ANError;
import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.data.DataManager;
import com.codexive.personalorganiser.data.db.models.FriendModel;
import com.codexive.personalorganiser.data.db.models.ToDoModel;
import com.codexive.personalorganiser.ui.base.BasePresenter;
import com.codexive.personalorganiser.ui.fragment.todo.ToDoMvpPresenter;
import com.codexive.personalorganiser.ui.fragment.todo.ToDoMvpView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;


public class ToDosPresenter<V extends ToDosMvpView> extends BasePresenter<V> implements ToDosMvpPresenter<V> {
    @Inject
    public ToDosPresenter(DataManager mDataManager, CompositeDisposable mCompositeDisposable) {
        super(mDataManager, mCompositeDisposable);
    }


    @Override
    public void onUpdateData(Long Id, String taskName, String location, String date, boolean status) {
        getMvpView().showLoading(getMvpView().getContext().getString(R.string.updating));
        getCompositeDisposable().add(getDataManager().updateToDoModel(new ToDoModel(Id, taskName, location, date, status))
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        getMvpView().hideLoading();
                        if (aBoolean) {
                            getMvpView().sucessToAdmit(getMvpView().getContext().getString(R.string.updated));
                        } else {
                            getMvpView().unSucessToAdmit(getMvpView().getContext().getString(R.string.error_updated));
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("DATALINK", "error: " + throwable.getCause());
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        Log.e("DATALINK", "accept: " + throwable.getCause());

                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}
