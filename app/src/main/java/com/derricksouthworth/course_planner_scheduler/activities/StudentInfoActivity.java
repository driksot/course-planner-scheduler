package com.derricksouthworth.course_planner_scheduler.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.derricksouthworth.course_planner_scheduler.R;

public class StudentInfoActivity extends AppCompatActivity {
    public static final String EXTRA_ENTER =
            "com.derricksouthworth.course-planner-scheduler.activies.ENTER";

    private Button buttonEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        final Button button = findViewById(R.id.button_enter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enterIntent = new Intent(StudentInfoActivity.this, TermActivity.class);
                startActivityForResult(enterIntent, 1);
            }
        });
    }
}