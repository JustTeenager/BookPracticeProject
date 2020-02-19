package com.example.todopractice1_9bookhuh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MonthlyActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static ArrayAdapter<ToDoClass> adapter3;
    private TextView score;
    private TextView doesCount;
    private ListView doList;
    private Intent intentIn;
    private static String wishes;
    private static String types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly);
        doList = findViewById(R.id.doListMonthly);
        score=findViewById(R.id.pCounterMonthly);
        doesCount=findViewById(R.id.doesCountMonthly);

        adapter3=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,ToDoClass.getDoMonthly());
        doList.setAdapter(adapter3);
        doList.setOnItemClickListener(this);

        score.setText("completed: "+DailyDo.count);
        doesCount.setText("Deals with yourself: "+DailyDo.does);
    }

    //public static void doAdderMonthly(ToDoClass e){
        //adapter.setNotifyOnChange(true);
        //adapter.add(e);
    //}

    public void onStart() {
        super.onStart();
        intentIn = getIntent();
        if (intentIn.getStringExtra(DoCreaterActivity.EXTRA_TYPE)!=null) {
            wishes = intentIn.getStringExtra(DoCreaterActivity.EXTRA_WISH);
            types = intentIn.getStringExtra(DoCreaterActivity.EXTRA_TYPE);
            adapter3.setNotifyOnChange(true);
            adapter3.add(new ToDoClass(wishes,types));
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
        adapter3.setNotifyOnChange(true);
        adapter3.remove(adapter3.getItem(position));
        DailyDo.count++;
        score.setText("completed: "+DailyDo.count);
        DailyDo.does--;
        doesCount.setText("Deals with yourself: "+DailyDo.does);
    }
}
