package com.example.gradecalculator2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    EditText quarter1;
    EditText quarter2;
    EditText exam;
    EditText level;

    TextView semester;
    TextView semesterExam;
    TextView minimum;
    TextView maximum;
    TextView passing;
    TextView gradepa;

    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        quarter1 = findViewById(R.id.quarter1Grade);
        quarter2 = findViewById(R.id.quarter2Grade);
        exam = findViewById(R.id.examGrade);
        level = findViewById(R.id.classLevel);

        semester = findViewById(R.id.quarter2Grade);
        semesterExam = findViewById(R.id.quarter2Grade);
        minimum = findViewById(R.id.quarter2Grade);
        maximum = findViewById(R.id.quarter2Grade);
        passing = findViewById(R.id.quarter2Grade);
        gradepa = findViewById(R.id.quarter2Grade);

        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double q1 = Double.parseDouble(quarter1.getText().toString());
                double q2 = Double.parseDouble(quarter2.getText().toString());
                double e = Double.parseDouble(exam.getText().toString());
                double lvl = Double.parseDouble(level.getText().toString());

                double s1 = ( q1 + q2 ) / 2;
                double s1e = ( q1 * 3 + q2 * 3 + e ) / 7;
                double min = ( 6 * s1 ) / 7;
                double max = ( 6 * s1 + 100 ) / 7;
                double pass = -6 * s1 + 490;
                double gpa = lvl + ( 6 * s1 + e - 490 ) / 70;

                semester.setText(Double.toString(s1));
                semesterExam.setText(Double.toString(s1e));
                minimum.setText(Double.toString(min));
                maximum.setText(Double.toString(max));
                passing.setText(Double.toString(pass));
                gradepa.setText(Double.toString(gpa));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
