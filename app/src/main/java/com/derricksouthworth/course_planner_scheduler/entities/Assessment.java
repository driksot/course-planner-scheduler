package com.derricksouthworth.course_planner_scheduler.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "assessment_table",
        foreignKeys = @ForeignKey(
                entity = Course.class,
                parentColumns = "course_id",
                childColumns = "course_id_fk",
                onDelete = 1
        ))
public class Assessment {
    @PrimaryKey(autoGenerate = true)
    private int assessment_id;
    @ColumnInfo(name = "course_id_fk")
    private int course_id_fk;
    @ColumnInfo(name = "assessment_date")
    private Date assessment_date;
    @ColumnInfo(name = "assessment_type")
    private int assessment_type;
    @ColumnInfo(name = "assessment_status")
    private String assessment_status;

    public Assessment(int course_id_fk, Date assessment_date, int assessment_type, String assessment_status) {
        this.course_id_fk = course_id_fk;
        this.assessment_date = assessment_date;
        this.assessment_type = assessment_type;
        this.assessment_status = assessment_status;
    }

    public int getAssessment_id() {
        return assessment_id;
    }

    public void setAssessment_id(int assessment_id) {
        this.assessment_id = assessment_id;
    }

    public int getCourse_id_fk() {
        return course_id_fk;
    }

    public void setCourse_id_fk(int course_id_fk) {
        this.course_id_fk = course_id_fk;
    }

    public Date getAssessment_date() {
        return assessment_date;
    }

    public void setAssessment_date(Date assessment_date) {
        this.assessment_date = assessment_date;
    }

    public int getAssessment_type() {
        return assessment_type;
    }

    public void setAssessment_type(int assessment_type) {
        this.assessment_type = assessment_type;
    }

    public String getAssessment_status() {
        return assessment_status;
    }

    public void setAssessment_status(String assessment_status) {
        this.assessment_status = assessment_status;
    }
}
