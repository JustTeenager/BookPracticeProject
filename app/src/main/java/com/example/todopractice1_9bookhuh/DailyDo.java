package com.example.todopractice1_9bookhuh;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DailyDo extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayAdapter<ToDoClass> adapter1;
    private static String wishes;
    private static String types;
    private TextView score;
    private TextView doesCount;
    private ListView doList1;
    private Intent intentIn;
    public static int count=0;
    public static int does=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doList1 = findViewById(R.id.doListDaily);
        score=findViewById(R.id.pCounterDaily);
        doesCount=findViewById(R.id.doesCountDaily);

        adapter1=new ArrayAdapter<ToDoClass>(this,android.R.layout.simple_list_item_1, ToDoClass.GetDoDaily());
        doList1.setAdapter(adapter1);
        doList1.setOnItemClickListener(this);

        score.setText("completed: "+count);
        doesCount.setText("Deals with yourself: "+does);

    }

    //public static void doAdderDaily(ToDoClass e){ буду мучать джависта
        //adapter.setNotifyOnChange(true);
        //adapter.add(e);
    //}

    public void onStart() {
        super.onStart();
        intentIn = getIntent();
        if (intentIn.getStringExtra(DoCreaterActivity.EXTRA_TYPE)!=null) {
            wishes = intentIn.getStringExtra(DoCreaterActivity.EXTRA_WISH);
            types = intentIn.getStringExtra(DoCreaterActivity.EXTRA_TYPE);
            adapter1.setNotifyOnChange(true);
            adapter1.add(new ToDoClass(wishes,types));
        }
    }

    public void suck(View view) {
        Intent intent=new Intent(this,DoCreaterActivity.class);
        startActivity(intent);
        does++;
        doesCount.setText("Deals with yourself: "+does);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        adapter1.setNotifyOnChange(true);
        adapter1.remove(adapter1.getItem(position));
        count++;
        score.setText("completed: "+count);
        does--;
        doesCount.setText("Deals with yourself: "+does);
    }
}
