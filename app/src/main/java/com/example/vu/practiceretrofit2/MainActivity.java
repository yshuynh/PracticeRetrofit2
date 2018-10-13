package com.example.vu.practiceretrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vu.practiceretrofit2.retrofit2.APIUtils;
import com.example.vu.practiceretrofit2.retrofit2.DataClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> objects = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Retrofit
        GetDataUsingRetrofit2();

    }

    private void GetDataUsingRetrofit2() {
        DataClient dataClient = APIUtils.getData();
        Call<List<User>> callback = dataClient.GetUserList();
        callback.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                List<User> listUser = response.body();
                for (User item: listUser) {
                    objects.add(item.getLogin());
                }
                updateListView(objects);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void updateListView(List<String> objects) {
        listView = findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, objects);
        listView.setAdapter(arrayAdapter);
    }
}
