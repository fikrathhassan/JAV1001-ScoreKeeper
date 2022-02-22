package cambrian.fikrathhassan.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_teamIndiaScore, txt_teamAustraliaScore;
    SwitchCompat switch_changeTeam;
    RadioButton rdo_spnr, rdo_edt;
    Spinner spnr_scores;
    EditText edt_score;
    Button btn_scoreDecrease, btn_scoreIncrease;

    String scoreSpnr;
    int score_spnr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    /***
     * This method is used to reference the variable to layout
     */
    void initViews() {
        txt_teamIndiaScore = findViewById(R.id.txt_teamIndiaScore);
        txt_teamAustraliaScore = findViewById(R.id.txt_teamAustraliaScore);
        switch_changeTeam = findViewById(R.id.switch_changeTeam);
        rdo_spnr = findViewById(R.id.rdo_spnr);
        rdo_edt = findViewById(R.id.rdo_edt);
        spnr_scores = findViewById(R.id.spnr_scores);
        edt_score = findViewById(R.id.edt_score);
        btn_scoreDecrease = findViewById(R.id.btn_scoreDecrease);
        btn_scoreIncrease = findViewById(R.id.btn_scoreIncrease);
    }

    /***
     * This method is used to arrange variable's functionality
     */
    void initListeners() {
        // Adds values to the Spinner widget
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.scores, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr_scores.setAdapter(adapter);
        spnr_scores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                scoreSpnr = String.valueOf(adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Add click listeners for radio buttons
        rdo_spnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdo_edt.setChecked(false);
                rdo_spnr.setChecked(true);
            }
        });
        rdo_edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdo_spnr.setChecked(false);
                rdo_edt.setChecked(true);
            }
        });

        // Button to decrease score based on the scoring method and team selected
        btn_scoreDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score_spnr = Integer.parseInt(scoreSpnr);
                if (!switch_changeTeam.isChecked()) {
                    // For India
                    if (rdo_spnr.isChecked()) {
                        // Spinner scoring method
                        int score = Integer.parseInt(txt_teamIndiaScore.getText().toString()) - score_spnr;
                        if (score < 0) {
                            Toast.makeText(MainActivity.this, "Score cannot be less than 0", Toast.LENGTH_SHORT).show();
                        } else {
                            txt_teamIndiaScore.setText(String.valueOf(score));
                        }
                    }
                    if (rdo_edt.isChecked()) {
                        // Manual scoring method
                        int entered_value = Integer.parseInt(edt_score.getText().toString());
                        if (entered_value > 0 && entered_value < 99) {
                            int score = Integer.parseInt(txt_teamIndiaScore.getText().toString()) - entered_value;
                            if (score < 0) {
                                Toast.makeText(MainActivity.this, "Score cannot be less than 0", Toast.LENGTH_SHORT).show();
                            } else {
                                txt_teamIndiaScore.setText(String.valueOf(score));
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter a value between 0 and 99", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    // For Australia
                    if (rdo_spnr.isChecked()) {
                        // Spinner scoring method
                        int score = Integer.parseInt(txt_teamAustraliaScore.getText().toString()) - score_spnr;
                        if (score < 0) {
                            Toast.makeText(MainActivity.this, "Score cannot be less than 0", Toast.LENGTH_SHORT).show();
                        } else {
                            txt_teamAustraliaScore.setText(String.valueOf(score));
                        }
                    }
                    if (rdo_edt.isChecked()) {
                        // Manual scoring method
                        int entered_value = Integer.parseInt(edt_score.getText().toString());
                        if (entered_value > 0 && entered_value < 99) {
                            int score = Integer.parseInt(txt_teamAustraliaScore.getText().toString()) - entered_value;
                            if (score < 0) {
                                Toast.makeText(MainActivity.this, "Score cannot be less than 0", Toast.LENGTH_SHORT).show();
                            } else {
                                txt_teamAustraliaScore.setText(String.valueOf(score));
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter a value between 0 and 99", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        // Button to increase score based on the scoring method and team selected
        btn_scoreIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score_spnr = Integer.parseInt(scoreSpnr);
                if (!switch_changeTeam.isChecked()) {
                    // For India
                    if (rdo_spnr.isChecked()) {
                        // Spinner scoring method
                        int score = Integer.parseInt(txt_teamIndiaScore.getText().toString()) + score_spnr;
                        if (score < 0) {
                            Toast.makeText(MainActivity.this, "Score cannot be less than 0", Toast.LENGTH_SHORT).show();
                        } else {
                            txt_teamIndiaScore.setText(String.valueOf(score));
                        }
                    }
                    if (rdo_edt.isChecked()) {
                        // Manual scoring method
                        int entered_value = Integer.parseInt(edt_score.getText().toString());
                        if (entered_value > 0 && entered_value < 99) {
                            int score = Integer.parseInt(txt_teamIndiaScore.getText().toString()) + entered_value;
                            txt_teamIndiaScore.setText(String.valueOf(score));
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter a value between 0 and 99", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    // For Australia
                    if (rdo_spnr.isChecked()) {
                        // Spinner scoring method
                        int score = Integer.parseInt(txt_teamAustraliaScore.getText().toString()) + score_spnr;
                        if (score < 0) {
                            Toast.makeText(MainActivity.this, "Score cannot be less than 0", Toast.LENGTH_SHORT).show();
                        } else {
                            txt_teamAustraliaScore.setText(String.valueOf(score));
                        }
                    }
                    if (rdo_edt.isChecked()) {
                        // Manual scoring method
                        int entered_value = Integer.parseInt(edt_score.getText().toString());
                        if (entered_value > 0 && entered_value < 99) {
                            int score = Integer.parseInt(txt_teamAustraliaScore.getText().toString()) + entered_value;
                            txt_teamAustraliaScore.setText(String.valueOf(score));
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter a value between 0 and 99", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}