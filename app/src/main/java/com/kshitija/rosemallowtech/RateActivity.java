package com.kshitija.rosemallowtech;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RateActivity extends AppCompatActivity {

    private TextView heading1, heading2, heading3;
    private TextView subheading1, subheading2, subheading3;
    private RatingBar ratingBar1, ratingBar2, ratingBar3;
    private int selectedIndex1, selectedIndex2, selectedIndex3;
    private Button nextButton;
    private ImageView undoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_ratings);

        undoButton = findViewById(R.id.undoButton);

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompetencyManager.getsCompetencyManager().clearRating();
                updateOverallState();
            }
        });

        heading1 = findViewById(R.id.heading1);
        heading2 = findViewById(R.id.heading2);
        heading3 = findViewById(R.id.heading3);

        subheading1 = findViewById(R.id.subheading1);
        subheading2 = findViewById(R.id.subheading2);
        subheading3 = findViewById(R.id.subheading3);

        ratingBar1 = findViewById(R.id.ratingBar1);
        ratingBar2 = findViewById(R.id.ratingBar2);
        ratingBar3 = findViewById(R.id.ratingBar3);

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        assignHeadingsAndSubheadings();
        updateNextButton();

        ratingBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int)v;
                if (rating != 0) {
                    CompetencyManager.getsCompetencyManager().getCompetencyList().get(selectedIndex1).rating = rating;
                } else {
                    CompetencyManager.getsCompetencyManager().getCompetencyList().get(selectedIndex1).rating = -1;
                }
                updateNextButton();
            }
        });
        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int)v;
                if (rating != 0) {
                    CompetencyManager.getsCompetencyManager().getCompetencyList().get(selectedIndex2).rating = rating;
                } else {
                    CompetencyManager.getsCompetencyManager().getCompetencyList().get(selectedIndex2).rating = -1;
                }
                updateNextButton();
            }
        });
        ratingBar3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int)v;
                if (rating != 0) {
                    CompetencyManager.getsCompetencyManager().getCompetencyList().get(selectedIndex3).rating = rating;
                } else {
                    CompetencyManager.getsCompetencyManager().getCompetencyList().get(selectedIndex3).rating = -1;
                }
                updateNextButton();
            }
        });

    }

    private void updateOverallState() {
        ratingBar1.setRating(0);
        ratingBar2.setRating(0);
        ratingBar3.setRating(0);
    }

    private void updateNextButton() {
        if (CompetencyManager.getsCompetencyManager().getCompetencyList().get(selectedIndex1).rating != -1 &&
                CompetencyManager.getsCompetencyManager().getCompetencyList().get(selectedIndex2).rating != -1 &&
                CompetencyManager.getsCompetencyManager().getCompetencyList().get(selectedIndex3).rating != -1) {
            nextButton.setEnabled(true);
            nextButton.setBackgroundColor(Color.BLUE);
        } else {
            nextButton.setEnabled(false);
            nextButton.setBackgroundColor(Color.GRAY);
        }
    }

    private void assignHeadingsAndSubheadings() {
        int count = 0;
        int counter = 0;
        String heading="";
        String subheading="";
        for (Competency competency : CompetencyManager.getsCompetencyManager().getCompetencyList())  {
            if (competency.selected == 1) {
                count++;
                heading = competency.name;
                subheading = competency.category;
                if (count == 1) {
                    heading1.setText(heading);
                    subheading1.setText(subheading);
                    selectedIndex1 = counter;
                }
                if (count == 2) {
                    heading2.setText(heading);
                    subheading2.setText(subheading);
                    selectedIndex2 = counter;
                }
                if (count == 3) {
                    heading3.setText(heading);
                    subheading3.setText(subheading);
                    selectedIndex3 = counter;
                    break;
                }
            }

            counter++;
        }
    }

    @Override
    public void onBackPressed() {
        CompetencyManager.getsCompetencyManager().clearRating();
        super.onBackPressed();
    }
}