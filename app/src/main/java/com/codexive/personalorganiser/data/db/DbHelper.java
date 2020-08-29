package com.codexive.personalorganiser.data.db;

import com.codexive.personalorganiser.data.db.models.EventModel;
import com.codexive.personalorganiser.data.db.models.FriendModel;
import com.codexive.personalorganiser.data.db.models.ToDoModel;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    Observable<List<EventModel>> getAllEvent();

    Observable<Boolean> saveEvent(EventModel eventModel);

    Observable<Boolean> saveEventList(List<EventModel> eventModelList);

    Observable<Boolean> updateEventList(List<EventModel> eventModelList);

    Observable<Boolean> updateEvent(EventModel eventModel);

    Observable<Boolean> deleteList(List<EventModel> eventModelList);

    Observable<Boolean> delete(EventModel eventModel);

    Observable<Boolean> deleteAll();

    //  TODO:- Friend
    Observable<List<FriendModel>> getAllFriend();

    Observable<Boolean> saveFriend(FriendModel friendModel);

    Observable<Boolean> saveFriendList(List<FriendModel> friendModelList);

    Observable<Boolean> updateFriendList(List<FriendModel> friendModelList);

    Observable<Boolean> updateFriend(FriendModel friendModel);

    Observable<Boolean> deleteFriendList(List<FriendModel> friendModelList);

    Observable<Boolean> deleteFriend(FriendModel friendModel);

    Observable<Boolean> deleteAllFriend();

//  TODO:- TOdo model

    Observable<List<ToDoModel>> getAllToDoModel();

    Observable<Boolean> saveToDoModel(ToDoModel toDoModel);

    Observable<Boolean> saveToDoModelList(List<ToDoModel> toDoModelList);

    Observable<Boolean> updateToDoModelList(List<ToDoModel> toDoModelList);

    Observable<Boolean> updateToDoModel(ToDoModel toDoModel);

    Observable<Boolean> deleteTOdoList(List<ToDoModel> toDoModelList);

    Observable<Boolean> deleteTOdo(ToDoModel toDoModel);

    Observable<Boolean> deleteAllToDoModel();
}
