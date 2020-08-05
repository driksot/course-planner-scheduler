package com.derricksouthworth.course_planner_scheduler.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.derricksouthworth.course_planner_scheduler.dao.AssessmentDao;
import com.derricksouthworth.course_planner_scheduler.dao.CourseDao;
import com.derricksouthworth.course_planner_scheduler.dao.TermDao;
import com.derricksouthworth.course_planner_scheduler.entities.Assessment;
import com.derricksouthworth.course_planner_scheduler.entities.Course;
import com.derricksouthworth.course_planner_scheduler.entities.Term;
import com.derricksouthworth.course_planner_scheduler.utils.Converters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Term.class, Course.class, Assessment.class},
        exportSchema = false,
        version = 1)
@TypeConverters(Converters.class)
public abstract class FullDatabase extends RoomDatabase {
    public abstract TermDao termDao();
    public abstract CourseDao courseDao();
    public abstract AssessmentDao assessmentDao();

    private static volatile FullDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    // ExecutorService with fixed thread pool to run operations asynchronously
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    /**
     * singleton to prevent multiple instances of database
     * @param context
     * @return
     */
    static FullDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (FullDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FullDatabase.class, "full_db30")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
