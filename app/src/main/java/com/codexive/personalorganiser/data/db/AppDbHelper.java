package com.codexive.personalorganiser.data.db;

import com.codexive.personalorganiser.data.db.models.DaoMaster;
import com.codexive.personalorganiser.data.db.models.DaoSession;
import com.codexive.personalorganiser.data.db.models.EventModel;
import com.codexive.personalorganiser.data.db.models.FriendModel;
import com.codexive.personalorganiser.data.db.models.ToDoModel;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    //  TODO:- Event
    @Override
    public Observable<List<EventModel>> getAllEvent() {
        return Observable.fromCallable(new Callable<List<EventModel>>() {
            @Override
            public List<EventModel> call() throws Exception {
                return mDaoSession.getEventModelDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> saveEvent(EventModel eventModel) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getEventModelDao().insert(eventModel);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveEventList(List<EventModel> eventModelList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getEventModelDao().insertInTx(eventModelList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> updateEventList(List<EventModel> eventModelList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getEventModelDao().updateInTx(eventModelList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> updateEvent(EventModel eventModel) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getEventModelDao().update(eventModel);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> deleteAll() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getEventModelDao().deleteAll();
                return true;
            }
        });
    }

    //  TODO:- Friend
    @Override
    public Observable<List<FriendModel>> getAllFriend() {
        return Observable.fromCallable(new Callable<List<FriendModel>>() {
            @Override
            public List<FriendModel> call() throws Exception {
                return mDaoSession.getFriendModelDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> saveFriend(FriendModel friendModel) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getFriendModelDao().insert(friendModel);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveFriendList(List<FriendModel> friendModelList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getFriendModelDao().insertInTx(friendModelList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> updateFriendList(List<FriendModel> friendModelList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getFriendModelDao().updateInTx(friendModelList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> updateFriend(FriendModel friendModel) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getFriendModelDao().update(friendModel);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> deleteAllFriend() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getFriendModelDao().deleteAll();
                return true;
            }
        });
    }

    //  TODO:- TOdo Model
    @Override
    public Observable<List<ToDoModel>> getAllToDoModel() {
        return Observable.fromCallable(new Callable<List<ToDoModel>>() {
            @Override
            public List<ToDoModel> call() throws Exception {
                return mDaoSession.getToDoModelDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> saveToDoModel(ToDoModel toDoModel) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getToDoModelDao().save(toDoModel);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveToDoModelList(List<ToDoModel> toDoModelList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getToDoModelDao().saveInTx(toDoModelList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> updateToDoModelList(List<ToDoModel> toDoModelList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getToDoModelDao().updateInTx(toDoModelList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> updateToDoModel(ToDoModel toDoModel) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getToDoModelDao().update(toDoModel);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> deleteAllToDoModel() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getToDoModelDao().deleteAll();
                return true;
            }
        });
    }


}