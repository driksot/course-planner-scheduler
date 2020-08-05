package com.derricksouthworth.course_planner_scheduler.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "course_table",
        foreignKeys = @ForeignKey(
                entity = Term.class,
                parentColumns = "term_id",
                childColumns = "term_id_fk",
                onDelete = 1
        ))
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int course_id;
    @ColumnInfo(name = "term_id_fk")
    private int term_id_fk;
    @ColumnInfo(name = "course_name")
    private String course_name;
    @ColumnInfo(name = "course_start")
    private Date course_start;
    @ColumnInfo(name = "course_end")
    private Date course_end;
    @ColumnInfo(name = "course_status")
    private String course_status;
    @ColumnInfo(name = "course_alert_date")
    private Date course_alert_date;
    @ColumnInfo(name = "course_mentor_name")
    private String course_mentor_name;
    @ColumnInfo(name = "course_mentor_email")
    private String course_mentor_email;
    @ColumnInfo(name = "course_mentor_phone")
    private String course_mentor_phone;

    public Course(int term_id_fk, String course_name, Date course_start, Date course_end, String course_status, Date course_alert_date, String course_mentor_name, String course_mentor_email, String course_mentor_phone) {
        this.term_id_fk = term_id_fk;
        this.course_name = course_name;
        this.course_start = course_start;
        this.course_end = course_end;
        this.course_status = course_status;
        this.course_alert_date = course_alert_date;
        this.course_mentor_name = course_mentor_name;
        this.course_mentor_email = course_mentor_email;
        this.course_mentor_phone = course_mentor_phone;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getTerm_id_fk() {
        return term_id_fk;
    }

    public void setTerm_id_fk(int term_id_fk) {
        this.term_id_fk = term_id_fk;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Date getCourse_start() {
        return course_start;
    }

    public void setCourse_start(Date course_start) {
        this.course_start = course_start;
    }

    public Date getCourse_end() {
        return course_end;
    }

    public void setCourse_end(Date course_end) {
        this.course_end = course_end;
    }

    public String getCourse_status() {
        return course_status;
    }

    public void setCourse_status(String course_status) {
        this.course_status = course_status;
    }

    public Date getCourse_alert_date() {
        return course_alert_date;
    }

    public void setCourse_alert_date(Date course_alert_date) {
        this.course_alert_date = course_alert_date;
    }

    public String getCourse_mentor_name() {
        return course_mentor_name;
    }

    public void setCourse_mentor_name(String course_mentor_name) {
        this.course_mentor_name = course_mentor_name;
    }

    public String getCourse_mentor_email() {
        return course_mentor_email;
    }

    public void setCourse_mentor_email(String course_mentor_email) {
        this.course_mentor_email = course_mentor_email;
    }

    public String getCourse_mentor_phone() {
        return course_mentor_phone;
    }

    public void setCourse_mentor_phone(String course_mentor_phone) {
        this.course_mentor_phone = course_mentor_phone;
    }
}
