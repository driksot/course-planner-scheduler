package com.derricksouthworth.course_planner_scheduler.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.derricksouthworth.course_planner_scheduler.models.Course;

import java.util.List;

@Dao
public interface CourseDao {

    @Insert
    void insert(Course course);

    @Update
    void update(Course course);

    @Delete
    void delete(Course course);

    @Query("DELETE FROM course_table")
    void deleteAllCourses();

    @Query("SELECT * FROM course_table")
    LiveData<List<Course>> getAllCourses();
}
