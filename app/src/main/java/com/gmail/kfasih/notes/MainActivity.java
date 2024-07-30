package com.gmail.kfasih.notes;

import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.kfasih.notes.BuildConfig;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    FloatingActionButton floatingNotesAddBtn;
    RecyclerView rvNotesList;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        rvNotesList = findViewById(R.id.rvNotesList);

        floatingNotesAddBtn = findViewById(R.id.floatingNotesAddBtn);
        rvNotesList = findViewById(R.id.rvNotesList);

        NotesViewListAdaptor notesViewListAdaptor = new NotesViewListAdaptor(DB.getInstance(MainActivity.this).getAllNotes());
        rvNotesList.setAdapter(notesViewListAdaptor);
        rvNotesList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvNotesList.setHasFixedSize(true);
        notesViewListAdaptor.setOnViewClickListener(new OnViewClickListener() {
            @Override
            public void onItemViewClick(NotesModel notesModel, int position) {
                Intent intent = new Intent(MainActivity.this, Update.class);
                intent.putExtra(NotesModel.COL_Title,notesModel.getTitle());
                intent.putExtra(NotesModel.COL_DESCRIPTION,notesModel.getDescription());
                intent.putExtra(NotesModel.COL_DATE,notesModel.getDate());
                if(notesModel.getImagePath()!=null){
                    intent.putExtra(NotesModel.COL_IMAGE_PATH,notesModel.getImagePath());
                }
                intent.putExtra(NotesModel.COL_BACKGROUND_RESOURCE_ID,notesModel.getBackgroundResourceId());
                intent.putExtra(NotesModel.COL_ID,notesModel.getId());
                startActivity(intent);
            }
        });


        floatingNotesAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EditNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        NotesViewListAdaptor notesViewListAdaptor = new NotesViewListAdaptor(DB.getInstance(MainActivity.this).getAllNotes());
        rvNotesList.setAdapter(notesViewListAdaptor);
        rvNotesList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvNotesList.setHasFixedSize(true);
        notesViewListAdaptor.setOnViewClickListener(new OnViewClickListener() {
            @Override
            public void onItemViewClick(NotesModel notesModel, int position) {
                Intent intent = new Intent(MainActivity.this, Update.class);
                intent.putExtra(NotesModel.COL_Title,notesModel.getTitle());
                intent.putExtra(NotesModel.COL_DESCRIPTION,notesModel.getDescription());
                intent.putExtra(NotesModel.COL_DATE,notesModel.getDate());
                if(notesModel.getImagePath()!=null){
                    intent.putExtra(NotesModel.COL_IMAGE_PATH,notesModel.getImagePath());
                }
                intent.putExtra(NotesModel.COL_BACKGROUND_RESOURCE_ID,notesModel.getBackgroundResourceId());
                intent.putExtra(NotesModel.COL_ID,notesModel.getId());
                startActivity(intent);
            }
        });

    }
}