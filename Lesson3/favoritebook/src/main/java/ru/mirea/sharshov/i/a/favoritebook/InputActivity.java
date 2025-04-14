package ru.mirea.sharshov.i.a.favoritebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input);

        EditText editTextBookName = findViewById(R.id.editTextTextMultiLine);
        EditText editTextQuote = findViewById(R.id.editTextTextMultiLine2);
        Button buttonSubmit = findViewById(R.id.button2);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookName = editTextBookName.getText().toString();
                String quote = editTextQuote.getText().toString();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("BOOK_NAME", bookName);
                returnIntent.putExtra("QUOTE", quote);
                setResult(RESULT_OK, returnIntent);
                finish();

            }
        });
    }
}