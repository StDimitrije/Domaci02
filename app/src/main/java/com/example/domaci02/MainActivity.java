package com.example.domaci02;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private EditText et_input;
    private Button btn_add;
    private RecyclerView recyclerView;
    private MainViewModel mainViewModel;
    private List<User> mUsers;
    private UserAdapter userAdapter;
    private Button btn_remove;
    private EditText et_filter;
    private String filter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mUsers = new ArrayList<>();
        initViews();
        initRecycler();
        initViewModels();
        initFilter();
    }

    private void initFilter() {

         et_filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter = s.toString();
                mainViewModel.setFilter(filter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void initViewModels() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                mUsers= new ArrayList<>(users);
                userAdapter.setData(mUsers);

            }
        });
    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        userAdapter = new UserAdapter();
        recyclerView.setAdapter(userAdapter);
    }


    private void initViews() {
        et_input=findViewById(R.id.et_input);
        btn_add = findViewById(R.id.btn_add);
        btn_remove= findViewById(R.id.btn_remove);
        et_filter = findViewById(R.id.et_filter);
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mUsers.remove(0);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et_input.getText().toString();
//                mUsers.add(0, new User(Util.generateId(),s));
                User user = new User(Util.generateId(),s);
                mainViewModel.addUsers(user);

                et_input.getText().clear();
            }
        });




    }


}
