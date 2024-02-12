package com.example.gpa_m50072892_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText course1Grade, course2Grade, course3Grade, course4Grade, course5Grade;
    private Button computeButton;
    private TextView gpaDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        course1Grade = findViewById(R.id.course1Grade);
        course2Grade = findViewById(R.id.course2Grade);
        course3Grade = findViewById(R.id.course3Grade);
        course4Grade = findViewById(R.id.course4Grade);
        course5Grade = findViewById(R.id.course5Grade);
        computeButton = findViewById(R.id.computeButton);
        gpaDisplay = findViewById(R.id.gpaDisplay);

        // Change button text to clear form once clicked
        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeGPA();
                // Change button text back to compute GPA
                computeButton.setText("Compute GPA");
                computeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        computeGPA();
                    }
                });
            }
        });
    }

    private void computeGPA() {
        // Clear previous GPA result
        gpaDisplay.setText("GPA: ");

        // Check if any field is empty
        if (course1Grade.getText().toString().isEmpty() || course2Grade.getText().toString().isEmpty() ||
                course3Grade.getText().toString().isEmpty() || course4Grade.getText().toString().isEmpty() ||
                course5Grade.getText().toString().isEmpty()) {
            // Show error message
            gpaDisplay.setText("Error: All fields must be filled out");
            return;
        }

        // Calculate GPA
        double gpa = (Double.parseDouble(course1Grade.getText().toString()) +
                Double.parseDouble(course2Grade.getText().toString()) +
                Double.parseDouble(course3Grade.getText().toString()) +
                Double.parseDouble(course4Grade.getText().toString()) +
                Double.parseDouble(course5Grade.getText().toString())) / 5;

        // Set background color based on GPA
        if (gpa < 60) {
            gpaDisplay.setBackgroundColor(0xFFFF0000); // Red
        } else if (gpa < 70) {
            gpaDisplay.setBackgroundColor(0xFFFFFF00); // Yellow
        } else {
            gpaDisplay.setBackgroundColor(0xFF00FF00); // Green
        }

        // Clear input fields
        course1Grade.setText("");
        course2Grade.setText("");
        course3Grade.setText("");
        course4Grade.setText("");
        course5Grade.setText("");

        // Display GPA
        gpaDisplay.setText("GPA: " + String.format("%.2f", gpa));
    }
}