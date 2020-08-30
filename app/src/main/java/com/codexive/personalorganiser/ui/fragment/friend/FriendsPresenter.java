package com.codexive.personalorganiser.ui.fragment.friend;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.codexive.personalorganiser.R;
import com.codexive.personalorganiser.data.DataManager;
import com.codexive.personalorganiser.data.db.models.FriendModel;
import com.codexive.personalorganiser.ui.activity.friend.FriendMvpPresenter;
import com.codexive.personalorganiser.ui.activity.friend.FriendMvpView;
import com.codexive.personalorganiser.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;


public class FriendsPresenter<V extends FriendsMvpView> extends BasePresenter<V> implements FriendsMvpPresenter<V> {
    @Inject
    public FriendsPresenter(DataManager mDataManager, CompositeDisposable mCompositeDisposable) {
        super(mDataManager, mCompositeDisposable);
    }

    @Override
    public void onGetData() {
        getMvpView().showLoading(getMvpView().getContext().getString(R.string.loading));
        getCompositeDisposable().add(getDataManager().getAllFriend().subscribe(new Consumer<List<FriendModel>>() {
            @Override
            public void accept(List<FriendModel> friendModels) throws Exception {
                getMvpView().hideLoading();
                if(!friendModels.isEmpty()){
                    getMvpView().sucessToAdmit(friendModels);
                }else {
                    getMvpView().unSucessToAdmit("No data Found!!");
                }

            }
        },  new Consumer<Throwable>() {
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
