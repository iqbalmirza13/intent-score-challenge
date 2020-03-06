package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ScorerActivity extends AppCompatActivity {
    private EditText score;
    private EditText minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorer);
    }

    public void handleSubmit(View view) {

        // Get the text from the EditText
        score = findViewById(R.id.edit_score);
        minutes = findViewById(R.id.edit_minutes);
        String stringToPassBack1 = score.getText().toString();
        String stringToPassBack2 = minutes.getText().toString();

        // Put the String to pass back into an Intent and close this activity
        Intent intent = new Intent();
        intent.putExtra("score", stringToPassBack1);
        intent.putExtra("minutes", stringToPassBack2);
        setResult(RESULT_OK, intent);
        finish();
    }
}
