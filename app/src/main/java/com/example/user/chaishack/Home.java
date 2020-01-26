package com.example.user.chaishack;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    SearchView mySearchView;
    ListView myList;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    private TextView mTextMessage;
    private RecyclerView recyclerView;

    private int [] images ={R.drawable.download, R.drawable.c,R.drawable.g,R.drawable.p,R.drawable.images1,};
    private RecyclerAdapater adapater;



    private RecyclerView.LayoutManager layoutManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_favourite:
                    mTextMessage.setText("favourite");
                    return true;
                case R.id.navigation_order:
                    mTextMessage.setText("order");
                    return true;

                case R.id.navigation_search:
                    mTextMessage.setText("Search");
                    return true;

            }


            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapater = new RecyclerAdapater( images );
        recyclerView.setAdapter(adapater );


        //mySearchView=(SearchView) findViewById(abc.id.searchView);
       // myList=(ListView)findViewById(abc.id.myList);
       // list=new ArrayList<String>();

        //list.add("Chai");
       // list.add("Parhta");
      //  list.add("Biryani");
       // list.add("Rait & Salad");
        //list.add("Beverages");


        adapter= new ArrayAdapter<String>(this,R.layout.simple_list_item_1,list);
        myList.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText){
                adapter.getFilter().filter( newText);
                return false;
            }
        });
    }

}
