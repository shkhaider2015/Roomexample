package com.example.roomexample.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomexample.DataAccessObject.NoteDao;
import com.example.roomexample.Entities.Note;

@Database(entities = Note.class, version = 1, exportSchema = false)
public class NotesDatabase extends RoomDatabase {

    private static NotesDatabase notesDatabaseInstance;
    public abstract NoteDao noteDao();

    public static synchronized NotesDatabase getInstance(Context context)
    {
        if (notesDatabaseInstance == null)
        {
            notesDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(), NotesDatabase.class, "NOTES_DATABASE")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return notesDatabaseInstance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

}
