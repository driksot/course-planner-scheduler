package com.derricksouthworth.course_planner_scheduler.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.derricksouthworth.course_planner_scheduler.dao.TermDao;
import com.derricksouthworth.course_planner_scheduler.entities.Term;

import java.util.List;

public class TermRepository {
    private TermDao termDao;
    private LiveData<List<Term>> allTerms;

    /**
     * pass Dao into repository constructor to avoid exposing entire database
     * to repository
     * @param application
     */
    public TermRepository(Application application) {
        FullDatabase db = FullDatabase.getDatabase(application);
        termDao = db.termDao();
        allTerms = termDao.getAllTerms();
    }

    /**
     * The following 'insert', 'update', 'delete', and 'deleteAll' methods are accessible
     * outside of TermRepository to be used by the ViewModel
     * @param term
     */
    public void insert(final Term term) {
        FullDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                termDao.insert(term);
            }
        });
    }

    public void update(final Term term) {
        FullDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                termDao.update(term);
            }
        });
    }

    public void delete(final Term term) {
        FullDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                termDao.delete(term);
            }
        });
    }

    public void deleteAllTerms() {
        FullDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                termDao.deleteAllTerms();
            }
        });
    }

    public LiveData<List<Term>> getAllTerms() {
        return allTerms;
    }
}
