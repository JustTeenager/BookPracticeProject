package com.example.todopractice1_9bookhuh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class WeeklyActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayAdapter<ToDoClass> adapter2;
    private TextView score;
    private TextView doesCount;
    private ListView doList2;
    private Intent intentIn;
    private static String wishes="a";
    private static String types="a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);
        doList2 = findViewById(R.id.doListWeekly);
        score=findViewById(R.id.pCounterWeekly);
        doesCount=findViewById(R.id.doesCountWeekly);

        adapter2=new ArrayAdapter<ToDoClass>(this,android.R.layout.simple_list_item_1, ToDoClass.getDoWeekly());
        doList2.setAdapter(adapter2);
        doList2.setOnItemClickListener(this);

        score.setText("completed: "+DailyDo.count);
        doesCount.setText("Deals with yourself: "+DailyDo.does);
    }

    //public static void doAdderWeekly(ToDoClass e){
        //adapter.setNotifyOnChange(true);
        //adapter.add(e);
    //}

    public void onStart() {
        super.onStart();
        intentIn = getIntent();
        if (intentIn.getStringExtra(DoCreaterActivity.EXTRA_TYPE)!=null) {
            wishes = intentIn.getStringExtra(DoCreaterActivity.EXTRA_WISH);
            types = intentIn.getStringExtra(DoCreaterActivity.EXTRA_TYPE);
            adapter2.setNotifyOnChange(true);
            adapter2.add(new ToDoClass(wishes,types));
        }
    }

    public void suck(View view) {
        Intent intent =new Intent(this,DoCreaterActivity.class);
        startActivity(intent);

        DailyDo.does++;
        doesCount.setText("Deals with yourself: "+DailyDo.does);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        adapter2.setNotifyOnChange(true);
        adapter2.remove(adapter2.getItem(position));
        DailyDo.count++;
        score.setText("completed: "+DailyDo.count);
        DailyDo.does--;
        doesCount.setText("Deals with yourself: "+DailyDo.does);
    }
}
