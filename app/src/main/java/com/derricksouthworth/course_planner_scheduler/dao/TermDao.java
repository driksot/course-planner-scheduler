package com.derricksouthworth.course_planner_scheduler.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.derricksouthworth.course_planner_scheduler.entities.Term;

import java.util.List;

@Dao
public interface TermDao {

    @Insert
    void insert(Term term);

    @Update
    void update(Term term);

    @Delete
    void delete(Term term);

    @Query("DELETE FROM term_table")
    void deleteAllTerms();

    @Query("SELECT * FROM term_table ORDER BY term_id")
    LiveData<List<Term>> getAllTerms();

    @Query("SELECT * FROM term_table WHERE term_id = :termId ORDER BY term_id")
    Term getTerm(int termId);
}
