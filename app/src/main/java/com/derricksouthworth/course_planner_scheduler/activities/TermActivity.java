package com.derricksouthworth.course_planner_scheduler.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.derricksouthworth.course_planner_scheduler.R;
import com.derricksouthworth.course_planner_scheduler.adapters.TermAdapter;
import com.derricksouthworth.course_planner_scheduler.entities.Term;
import com.derricksouthworth.course_planner_scheduler.viewmodels.TermViewModel;

import java.util.List;

public class TermActivity extends AppCompatActivity {
    private TermViewModel termViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_term);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final TermAdapter adapter = new TermAdapter(this);
        recyclerView.setAdapter(adapter);

        termViewModel = new ViewModelProvider(this).get(TermViewModel.class);
        termViewModel.getAllTerms().observe(this, new Observer<List<Term>>() {
            @Override
            public void onChanged(List<Term> terms) {
                adapter.setTerms(terms);
            }
        });
    }
}
