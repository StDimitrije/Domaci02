package com.example.domaci02;

import java.util.List;

import androidx.recyclerview.widget.DiffUtil;

public class UserDiffCallBack extends DiffUtil.Callback {
    private List<User> oldList;
    private List<User> newList;


    public UserDiffCallBack(List<User> oldList, List<User> newList){
        oldList=oldList;
        newList=newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        User oldUser= oldList.get(oldItemPosition);
        User newUser = newList.get(newItemPosition);

        return oldUser.getmId() == newUser.getmId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        User oldUser= oldList.get(oldItemPosition);
        User newUser = newList.get(newItemPosition);

        return oldUser.getmFname().equals(newUser.getmFname());

    }
}
