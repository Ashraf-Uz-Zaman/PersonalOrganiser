package com.codexive.personalorganiser.ui.activity.friend;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.data.DataManager;
import com.codexive.personalorganiser.data.db.models.FriendModel;
import com.codexive.personalorganiser.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;


public class FriendPresenter <V extends FriendMvpView> extends BasePresenter<V> implements FriendMvpPresenter<V> {
    @Inject
    public FriendPresenter(DataManager mDataManager, CompositeDisposable mCompositeDisposable) {
        super(mDataManager, mCompositeDisposable);
    }

    @Override
    public void onStoreData(String firstName, String lastName, String gender, String Age, String Address) {
        getMvpView().showLoading(getMvpView().getContext().getString(R.string.saving));
        getCompositeDisposable().add(getDataManager().saveFriend(new FriendModel(System.currentTimeMillis(),firstName,lastName,gender,Age,Address))
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        getMvpView().hideLoading();
                        if (aBoolean) {
                           getMvpView().sucessToStore(getMvpView().getContext().getString(R.string.stored));
                        } else {
                            getMvpView().unSucessToStore(getMvpView().getContext().getString(R.string.error_stored));
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
