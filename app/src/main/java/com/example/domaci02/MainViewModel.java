package com.example.domaci02;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<User>> userLiveData;
    private List<User> users;

    public MainViewModel(){
        userLiveData = new MutableLiveData<>();
        users= new ArrayList<>();

        for (int i=0; i<=50; i++){
            users.add(new User(Util.generateId(), "Ime " + i));
        }
        userLiveData.setValue(users);
    }

    public LiveData<List<User>> getUsers(){
        return userLiveData;
    }

    public void setUsers(List<User> users){

        this.userLiveData.setValue(new ArrayList<>(users));
    }

    public void setFilter(String filter){
    filter = filter.toLowerCase();
    List<User> filterList = new ArrayList<>();
    for(User user: users){
        if(user.getmFname().toLowerCase().startsWith(filter)){
            filterList.add(user);
        }
    }
    userLiveData.setValue(filterList);

    }

}
