package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomexample.DataModel.NotesItem;
import com.example.roomexample.Entities.Note;
import com.example.roomexample.ViewModel.NoteViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mTitle, mDescription;
    private Button mSubmit;
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                Log.d(TAG, "onChanged: NOTES : " + notes.toString());
            }
        });

    }

    private void init()
    {
        mTitle = findViewById(R.id.mytitle);
        mDescription = findViewById(R.id.description);
        mSubmit = findViewById(R.id.submit);

        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        mSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String title, description;
        title = mTitle.getText().toString();
        description = mDescription.getText().toString();

        if(title.isEmpty() || description.isEmpty())
        {
            Toast.makeText(this, "Both Field Required", Toast.LENGTH_SHORT).show();
            return;
        }

        NotesItem item = new NotesItem(title, description);
        Note note = new Note(title, description);

        noteViewModel.insert(note);


    }
}