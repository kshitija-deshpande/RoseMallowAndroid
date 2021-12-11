package com.kshitija.rosemallowtech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.accessibility.CaptioningManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ImageView undoButton;
    private TextView placeholder, firstCompentency, secondCompentency, thridCompentency;
    private EditText projectET, eventDateET, messageET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_main);

        undoButton = findViewById(R.id.undoButton);

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAllFields();
            }
        });

        projectET = findViewById(R.id.projectOrTaskTitleET);
        eventDateET = findViewById(R.id.eventDateET);
        messageET = findViewById(R.id.messageET);

        firstCompentency = findViewById(R.id.firstCompentency);
        secondCompentency = findViewById(R.id.secondCompentency);
        thridCompentency = findViewById(R.id.thirdCompentency);
        placeholder = findViewById(R.id.placeholder);

        final Calendar myCalendar = Calendar.getInstance();

        EditText edittext = (EditText) findViewById(R.id.eventDateET);
        LinearLayout competencyOutput = (LinearLayout) findViewById(R.id.compentencyOutput);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "dd MMM yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                edittext.setText(sdf.format(myCalendar.getTime()));
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        competencyOutput.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CompetencyActivity.class));
            }
        });


    }

    private void clearAllFields() {
        CompetencyManager.getsCompetencyManager().clearRatingAndSelection();
        updateOverallState();
        projectET.setText("");
        eventDateET.setText("");
        messageET.setText("");
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateOverallState();
    }

    private void updateOverallState() {
        int count = 0;
        String competency="";
        int stars = 0;
        placeholder.setVisibility(View.VISIBLE);
        firstCompentency.setVisibility(View.GONE);
        secondCompentency.setVisibility(View.GONE);
        thridCompentency.setVisibility(View.GONE);
        for (int i = 0; i < CompetencyManager.getsCompetencyManager().getCompetencyList().size(); i++) {
            if (CompetencyManager.getsCompetencyManager().getCompetencyList().get(i).selected != -1 &&
                CompetencyManager.getsCompetencyManager().getCompetencyList().get(i).rating != -1) {
                count++;
                competency = CompetencyManager.getsCompetencyManager().getCompetencyList().get(i).name;
                stars = CompetencyManager.getsCompetencyManager().getCompetencyList().get(i).rating;

                if (count == 1) {
                    firstCompentency.setText(stars+"\u2605 "+competency);
                    firstCompentency.setVisibility(View.VISIBLE);
                    placeholder.setVisibility(View.GONE);
                    firstCompentency.setBackground(getBackgroundFromStar(stars));
                    firstCompentency.setTextColor(getColorFromStar(stars));
                }
                if (count == 2) {
                    secondCompentency.setText(stars+"\u2605 "+competency);
                    secondCompentency.setVisibility(View.VISIBLE);
                    placeholder.setVisibility(View.GONE);
                    secondCompentency.setBackground(getBackgroundFromStar(stars));
                    secondCompentency.setTextColor(getColorFromStar(stars));
                }
                if (count == 3) {
                    thridCompentency.setText(stars+"\u2605 "+competency);
                    thridCompentency.setVisibility(View.VISIBLE);
                    placeholder.setVisibility(View.GONE);
                    thridCompentency.setBackground(getBackgroundFromStar(stars));
                    thridCompentency.setTextColor(getColorFromStar(stars));
                    break;
                }
            }
        }
    }

    private int getColorFromStar(int stars) {
        if (stars == 1) {
            return getResources().getColor(R.color.one_star);
        }
        if (stars == 2) {
            return getResources().getColor(R.color.two_star);
        }
        if (stars == 3) {
            return getResources().getColor(R.color.three_star);
        }
        if (stars == 4) {
            return getResources().getColor(R.color.four_star);
        }
        if (stars == 5) {
            return getResources().getColor(R.color.five_star);
        }
        return getResources().getColor(R.color.five_star);
    }

    private Drawable getBackgroundFromStar(int stars) {
        if (stars == 1) {
            return getResources().getDrawable( R.drawable.capsule_bg_1 );
        }
        if (stars == 2) {
            return getResources().getDrawable( R.drawable.capsule_bg_2 );
        }
        if (stars == 3) {
            return getResources().getDrawable( R.drawable.capsule_bg_3 );
        }
        if (stars == 4) {
            return getResources().getDrawable( R.drawable.capsule_bg_4 );
        }
        if (stars == 5) {
            return getResources().getDrawable( R.drawable.capsule_bg_5 );
        }
        return getResources().getDrawable( R.drawable.capsule_bg_5 );
    }
}