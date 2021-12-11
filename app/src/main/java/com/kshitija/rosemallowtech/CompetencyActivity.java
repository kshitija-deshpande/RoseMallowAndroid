package com.kshitija.rosemallowtech;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CompetencyActivity extends AppCompatActivity {

    private CheckBox c11, c12, c13;
    private CheckBox c21, c22, c23;
    private CheckBox c31, c32, c33;

    private ImageView arrow1, arrow2, arrow3;

    private LinearLayout hiddenView1, hiddenView2, hiddenView3;

    private TextView subheading21, subheading22, subheading23;

    private Button rateCompetency;

    private ImageView undoButton;

    private int count1 = 0, count2 = 0, count3 = 0; // holds count of three competency to show subheading

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_compentency);

        undoButton = findViewById(R.id.undoButton);

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompetencyManager.getsCompetencyManager().clearRatingAndSelection();
                updateOverallState();
            }
        });

        arrow1 = findViewById(R.id.arrow_button1);
        arrow2 = findViewById(R.id.arrow_button2);
        arrow3 = findViewById(R.id.arrow_button3);

        hiddenView1 = findViewById(R.id.hidden_view1);
        hiddenView2 = findViewById(R.id.hidden_view2);
        hiddenView3 = findViewById(R.id.hidden_view3);

        subheading21 = findViewById(R.id.subheading21);
        subheading22 = findViewById(R.id.subheading22);
        subheading23 = findViewById(R.id.subheading23);

        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView1.getVisibility() == View.GONE) {
                    hiddenView1.setVisibility(View.VISIBLE);
                    arrow1.setImageResource(R.drawable.ic_baseline_expand_more_24);
                } else {
                    hiddenView1.setVisibility(View.GONE);
                    arrow1.setImageResource(R.drawable.ic_baseline_shrink_more_24);
                }
            }
        });

        arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView2.getVisibility() == View.GONE) {
                    hiddenView2.setVisibility(View.VISIBLE);
                    arrow2.setImageResource(R.drawable.ic_baseline_expand_more_24);
                } else {
                    hiddenView2.setVisibility(View.GONE);
                    arrow2.setImageResource(R.drawable.ic_baseline_shrink_more_24);
                }
            }
        });

        arrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView3.getVisibility() == View.GONE) {
                    hiddenView3.setVisibility(View.VISIBLE);
                    arrow3.setImageResource(R.drawable.ic_baseline_expand_more_24);
                } else {
                    hiddenView3.setVisibility(View.GONE);
                    arrow3.setImageResource(R.drawable.ic_baseline_shrink_more_24);
                }
            }
        });

        rateCompetency = findViewById(R.id.rateCompetencyButton);

        updateRatCompentencyButton();
        updateSubheadings();

        rateCompetency.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(CompetencyActivity.this, RateActivity.class));
                        finish();
                    }
                }
        );



        c11 = findViewById(R.id.item11);
        c12 = findViewById(R.id.item21);
        c13 = findViewById(R.id.item31);

        c21 = findViewById(R.id.item12);
        c22 = findViewById(R.id.item22);
        c23 = findViewById(R.id.item32);

        c31 = findViewById(R.id.item13);
        c32 = findViewById(R.id.item23);
        c33 = findViewById(R.id.item33);

        updateOverallState();

        //Compentency Category - 1
        c11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (!threeCompetenciesChecked()) {
                        checkCompetency(0);
                    } else {
                        c11.setChecked(false);
                        Toast.makeText(CompetencyActivity.this, "Can't select more than 3 competencies", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    uncheckCompetency(0);
                }
            }
        });

        c12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (!threeCompetenciesChecked()) {
                        checkCompetency(1);
                    } else {
                        c12.setChecked(false);
                        Toast.makeText(CompetencyActivity.this, "Can't select more than 3 competencies", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    uncheckCompetency(1);
                }
            }
        });

        c13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (!threeCompetenciesChecked()) {
                        checkCompetency(2);
                    } else {
                        c13.setChecked(false);
                        Toast.makeText(CompetencyActivity.this, "Can't select more than 3 competencies", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    uncheckCompetency(2);
                }
            }
        });

        //Compentency Category - 2
        c21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (!threeCompetenciesChecked()) {
                        checkCompetency(3);
                    } else {
                        c21.setChecked(false);
                        Toast.makeText(CompetencyActivity.this, "Can't select more than 3 competencies", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    uncheckCompetency(3);
                }
            }
        });

        c22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (!threeCompetenciesChecked()) {
                        checkCompetency(4);
                    } else {
                        c22.setChecked(false);
                        Toast.makeText(CompetencyActivity.this, "Can't select more than 3 competencies", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    uncheckCompetency(4);
                }
            }
        });

        c23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (!threeCompetenciesChecked()) {
                        checkCompetency(5);
                    } else {
                        c23.setChecked(false);
                        Toast.makeText(CompetencyActivity.this, "Can't select more than 3 competencies", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    uncheckCompetency(5);
                }
            }
        });

        //Compentency Category - 3
        c31.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (!threeCompetenciesChecked()) {
                        checkCompetency(6);
                    } else {
                        c31.setChecked(false);
                        Toast.makeText(CompetencyActivity.this, "Can't select more than 3 competencies", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    uncheckCompetency(6);
                }
            }
        });

        c32.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (!threeCompetenciesChecked()) {
                        checkCompetency(7);
                    } else {
                        c32.setChecked(false);
                        Toast.makeText(CompetencyActivity.this, "Can't select more than 3 competencies", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    uncheckCompetency(7);
                }
            }
        });

        c33.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (!threeCompetenciesChecked()) {
                        checkCompetency(8);
                    } else {
                        c33.setChecked(false);
                        Toast.makeText(CompetencyActivity.this, "Can't select more than 3 competencies", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    uncheckCompetency(8);
                }
            }
        });
    }

    private void updateRatCompentencyButton() {
        if (threeCompetenciesChecked()) {
            rateCompetency.setEnabled(true);
            rateCompetency.setBackgroundColor(Color.BLUE);
        } else {
            rateCompetency.setEnabled(false);
            rateCompetency.setBackgroundColor(Color.GRAY);
        }
    }

    private boolean threeCompetenciesChecked() {
        int count = 0;
        for (Competency competency : CompetencyManager.getsCompetencyManager().getCompetencyList()){
            if (competency.selected != -1) {
                count++;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    private void checkCompetency(int index) {
        incrementCount(index);
        CompetencyManager.getsCompetencyManager().getCompetencyList().get(index).selected = 1;
        updateRatCompentencyButton();
        updateSubheadings();
    }

    private void incrementCount(int index) {
        if (index >= 0 && index <= 2) {
            count1++;
        } else if (index >= 3 && index <= 5) {
            count2++;
        } else {
            count3++;
        }
    }

    private void uncheckCompetency(int index) {
        decrementCount(index);
        CompetencyManager.getsCompetencyManager().getCompetencyList().get(index).selected = -1;
        updateRatCompentencyButton();
        updateSubheadings();
    }

    private void decrementCount(int index) {
        if (index >= 0 && index <= 2) {
            count1--;
        } else if (index >= 3 && index <= 5) {
            count2--;
        } else {
            count3--;
        }
    }

    private void updateSubheadings() {
        subheading21.setVisibility(View.GONE);
        subheading22.setVisibility(View.GONE);
        subheading23.setVisibility(View.GONE);

        if (count1 > 0) {
            subheading21.setText(count1 + " Selected");
            subheading21.setVisibility(View.VISIBLE);
        }
        if (count2 > 0) {
            subheading22.setText(count2 + " Selected");
            subheading22.setVisibility(View.VISIBLE);
        }
        if (count3 > 0) {
            subheading23.setText(count3 + " Selected");
            subheading23.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onResume() {
        //updateOverallState();
        super.onResume();

    }

    private void updateOverallState() {
        c11.setChecked(false);
        c12.setChecked(false);
        c13.setChecked(false);
        c21.setChecked(false);
        c22.setChecked(false);
        c23.setChecked(false);
        c31.setChecked(false);
        c32.setChecked(false);
        c33.setChecked(false);
        for (int i = 0; i < CompetencyManager.getsCompetencyManager().getCompetencyList().size(); i++) {
            if (CompetencyManager.getsCompetencyManager().getCompetencyList().get(i).selected != -1) {
                if (i == 0) {
                    c11.setChecked(true);
                } else if (i == 1) {
                    c12.setChecked(true);
                }  else if (i == 2) {
                    c13.setChecked(true);
                }  else if (i == 3) {
                    c21.setChecked(true);
                }  else if (i == 4) {
                    c22.setChecked(true);
                }  else if (i == 5) {
                    c23.setChecked(true);
                }  else if (i == 6) {
                    c31.setChecked(true);
                }  else if (i == 7) {
                    c32.setChecked(true);
                }  else if (i == 8) {
                    c33.setChecked(true);
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        CompetencyManager.getsCompetencyManager().clearRatingAndSelection();
        super.onBackPressed();
    }
}