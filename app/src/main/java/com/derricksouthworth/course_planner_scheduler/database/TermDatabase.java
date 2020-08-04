package com.derricksouthworth.course_planner_scheduler.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.derricksouthworth.course_planner_scheduler.models.Term;

@Database(entities = {Term.class}, version = 1, exportSchema = false)
public abstract class TermDatabase extends RoomDatabase {
}
