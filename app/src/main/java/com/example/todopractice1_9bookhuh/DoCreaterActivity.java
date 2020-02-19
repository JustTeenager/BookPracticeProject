package com.example.todopractice1_9bookhuh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DoCreaterActivity extends AppCompatActivity implements View.OnClickListener {
      EditText edit;
      Spinner spin;
      Button butt;
      ToDoClass doerDaily=new ToDoClass("w","t");
      ToDoClass doerWeekly=new ToDoClass("w","t");
      ToDoClass doerMonthly=new ToDoClass("w","t");
    public static final String EXTRA_WISH="extra_wish";
    public static final String EXTRA_TYPE="extra_type";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_creater);
        edit=findViewById(R.id.editDo);
        spin=findViewById(R.id.typeSpinner);
        butt=findViewById(R.id.sendButt);
        butt.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if (((String) spin.getSelectedItem()).equals("Daily one")){
                //ToDoClass a=new ToDoClass(edit.toString(),(String) spin.getSelectedItem());
                //DailyDo.doAdderDaily(edit.toString(),(String) spin.getSelectedItem());


                doerDaily.SetWish(edit.getText().toString());
                doerDaily.SetType((String) spin.getSelectedItem());


                Intent intent=new Intent(this,DailyDo.class);
                intent.putExtra(EXTRA_WISH,doerDaily.getWish());
                intent.putExtra(EXTRA_TYPE,doerDaily.getType());
                startActivity(intent);
            }
        else if (((String) spin.getSelectedItem()).equals("Weekly one")) {
                //WeeklyActivity.doAdderWeekly(new ToDoClass(edit.toString(),(String) spin.getSelectedItem()));

                doerWeekly.SetWish(edit.getText().toString());
                doerWeekly.SetType((String) spin.getSelectedItem());


                Intent intent=new Intent(this,WeeklyActivity.class);
                intent.putExtra(EXTRA_WISH,doerWeekly.getWish());
                intent.putExtra(EXTRA_TYPE,doerWeekly.getType());
                startActivity(intent);

            }
        else if (((String) spin.getSelectedItem()).equals("Monthly one")){
                //MonthlyActivity.doAdderMonthly(new ToDoClass(edit.toString(),(String) spin.getSelectedItem()));

                doerMonthly.SetWish(edit.getText().toString());
                doerMonthly.SetType((String) spin.getSelectedItem());


                Intent intent=new Intent(this,MonthlyActivity.class);
                intent.putExtra(EXTRA_WISH,doerMonthly.getWish());
                intent.putExtra(EXTRA_TYPE,doerMonthly.getType());
                startActivity(intent);
            }
        }
    }
