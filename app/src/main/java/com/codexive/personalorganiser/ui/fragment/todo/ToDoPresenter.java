package com.codexive.personalorganiser.ui.fragment.todo;



import android.util.Log;

import com.androidnetworking.error.ANError;
import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.data.DataManager;
import com.codexive.personalorganiser.data.db.models.ToDoModel;
import com.codexive.personalorganiser.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;


public class ToDoPresenter<V extends ToDoMvpView> extends BasePresenter<V> implements ToDoMvpPresenter<V> {
    @Inject
    public ToDoPresenter(DataManager mDataManager, CompositeDisposable mCompositeDisposable) {
        super(mDataManager, mCompositeDisposable);
    }


    @Override
    public void onAddData(String taskName, String location, String date, boolean status) {
        Log.e("by", "onGetData: "+taskName );
        getMvpView().showLoading(getMvpView().getContext().getString(R.string.loading));
        getCompositeDisposable().add(getDataManager().saveToDoModel(new ToDoModel(System.currentTimeMillis(),taskName,location,date,status)).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                getMvpView().hideLoading();
                if (aBoolean) {
                    getMvpView().sucessToAdmit(getMvpView().getContext().getString(R.string.stored));
                } else {
                    getMvpView().unSucessToAdmit(getMvpView().getContext().getString(R.string.error_stored));
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

    @Override
    public void onGetData() {
        getMvpView().showLoading(getMvpView().getContext().getString(R.string.loading));
        getCompositeDisposable().add(getDataManager().getAllToDoModel().subscribe(new Consumer<List<ToDoModel>>() {
            @Override
            public void accept(List<ToDoModel> toDoModels) throws Exception {
                getMvpView().hideLoading();
                if(!toDoModels.isEmpty()){
                    getMvpView().sucessToAdmitData(toDoModels);
                }else {
                    getMvpView().unSucessToAdmitData("No data Found!!");
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
