package com.example.rentit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.example.rentit.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId ={R.drawable.cars,R.drawable.chinangwa,R.drawable.spoons,R.drawable.njinga,R.drawable.ngombe,R.drawable.mbaula,R.drawable.fan};

        String[] name ={"cars","cassava farm","spoons","bicycles","male cattle","charcoal burners","fans"};
        String[] lastMessage = {"contact 0995442220","40pin per season","12pin per event","pin per day","20pin after mating","3pin per night","2pin per night"};
        String[] phoneNo = {"0995442220","0884675792","0999005680","0881234428","0992113348","0881345567","0881234428","0992113348"};
        String[] country = {"monday","Wednesday","friday","friday","monday","Wednesday","friday","friday"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for (int i = 0; i<imageId.length;i++){
            User user = new User(name[i],lastMessage[i],phoneNo[i],country[i],imageId[i]);

            userArrayList.add(user);
        }
        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phoneNo[position]);
                i.putExtra("country",country[position]);
                i.putExtra("imageId",imageId[position]);
                startActivity(i);
            }
        });


    }
}