package com.vicentearmenta.androidtriviatesting.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.vicentearmenta.androidtriviatesting.R;
import com.vicentearmenta.androidtriviatesting.database.DatabaseOperations;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    TextView highScoresTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        highScoresTextView = findViewById(R.id.highScoresTextView);

        DatabaseOperations databaseOperations = new DatabaseOperations(this);
        List<String> highScores = databaseOperations.getHighScores();

        if (highScores.isEmpty()) {
            highScoresTextView.setText("No high scores yet.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < highScores.size(); i++) {
                sb.append(i + 1).append(". ").append(highScores.get(i)).append("\n");
            }
            highScoresTextView.setText(sb.toString());
        }
    }
}