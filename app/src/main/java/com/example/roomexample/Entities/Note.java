package com.example.roomexample.Entities;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {



    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String description;


    public Note(@NonNull String title,@NonNull String description)
    {
        this.title = title;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
