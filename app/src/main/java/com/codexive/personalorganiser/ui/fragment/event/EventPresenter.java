package com.codexive.personalorganiser.ui.fragment.event;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.data.DataManager;
import com.codexive.personalorganiser.data.db.models.EventModel;
import com.codexive.personalorganiser.data.db.models.ToDoModel;
import com.codexive.personalorganiser.ui.base.BasePresenter;
import com.codexive.personalorganiser.ui.fragment.todo.ToDoMvpView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class EventPresenter<V extends EventMvpView> extends BasePresenter<V> implements EventMvpPresenter<V> {

    @Inject
    public EventPresenter(DataManager mDataManager, CompositeDisposable mCompositeDisposable) {
        super(mDataManager, mCompositeDisposable);
    }


    @Override
    public void onAddData(String name, String location, String date, String time) {
        getMvpView().showLoading(getMvpView().getContext().getString(R.string.loading));
        getCompositeDisposable().add(getDataManager().saveEvent(new EventModel(System.currentTimeMillis(), name, date, time, location)).subscribe(new Consumer<Boolean>() {
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
        getCompositeDisposable().add(getDataManager().getAllEvent().subscribe(new Consumer<List<EventModel>>() {
            @Override
            public void accept(List<EventModel> eventModelList) throws Exception {
                getMvpView().hideLoading();
                if (eventModelList != null) {
                    getMvpView().sucessToAdmitData(eventModelList);
                } else {
                    getMvpView().unSucessToAdmit("No data Found!!");
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
    public void onDeleteData(EventModel eventModel) {
        getMvpView().showLoading(getMvpView().getContext().getString(R.string.loading));
        getCompositeDisposable().add(getDataManager().delete(eventModel).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                getMvpView().hideLoading();
                if (aBoolean) {
                    getMvpView().sucessToAdmit(getMvpView().getContext().getString(R.string.delete));
                } else {
                    getMvpView().unSucessToAdmit(getMvpView().getContext().getString(R.string.error_deleted));
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
