package com.example.testingforrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalpage);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_view_recycler_list);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<QuestionAndAnswer> list = databaseAccess.getQuestion("Elementary");
        databaseAccess.close();
        System.err.println("list: "+list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewDataAdapter dataAdapter = new RecyclerViewDataAdapter(list);
        // Set data adapter.
        recyclerView.setAdapter(dataAdapter);
    }
}
