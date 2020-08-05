package com.derricksouthworth.course_planner_scheduler.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.derricksouthworth.course_planner_scheduler.R;
import com.derricksouthworth.course_planner_scheduler.entities.Term;

import java.util.ArrayList;
import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermHolder> {
    private LayoutInflater inflater;
    private List<Term> terms = new ArrayList<>();

    public TermAdapter(Context context) { inflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public TermHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.term_item, parent, false);
        return new TermHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermHolder holder, int position) {
        Term currentTerm = terms.get(position);
        holder.textViewTermName.setText(currentTerm.getTerm_name());
        holder.textViewTermStart.setText((CharSequence) currentTerm.getTerm_start());
        holder.textViewTermEnd.setText((CharSequence) currentTerm.getTerm_end());
    }

    @Override
    public int getItemCount() {
        return terms.size();
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
        notifyDataSetChanged();
    }

    class TermHolder extends RecyclerView.ViewHolder {
        private TextView textViewTermName;
        private TextView textViewTermStart;
        private TextView textViewTermEnd;

        private TermHolder(@NonNull View itemView) {
            super(itemView);
            textViewTermName = itemView.findViewById(R.id.text_view_term_name);
            textViewTermStart = itemView.findViewById(R.id.text_view_term_start);
            textViewTermEnd = itemView.findViewById(R.id.text_view_term_end);
        }
    }
}
