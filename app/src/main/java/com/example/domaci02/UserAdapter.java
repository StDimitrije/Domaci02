package com.example.domaci02;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private List<User> mDataSet;

    public UserAdapter(){
        mDataSet=new ArrayList<>();
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);

        return new UserHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User user = mDataSet.get(position);
        holder.fName.setText(user.getmFname());
        Picasso.get().load(user.getmImgUrl()).into(holder.image);
//        holder.lName.setText(user.getmLname());
//        holder.phone.setText(user.getmPhone());
//        holder.email.setText(user.getmEmail());
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setData(List<User> users) {
        UserDiffCallBack callBack = new UserDiffCallBack(mDataSet,users);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callBack);
        mDataSet.clear();
        mDataSet.addAll(users);
        result.dispatchUpdatesTo(this);
    }


    public class UserHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView fName;
        TextView lName;
        TextView phone;
        TextView email;


        public UserHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.list_image);
            fName = itemView.findViewById(R.id.tv_fname);
            lName = itemView.findViewById(R.id.tv_lname);
            phone = itemView.findViewById(R.id.tv_phone);
            email = itemView.findViewById(R.id.tv_mail);
        }
    }
}
