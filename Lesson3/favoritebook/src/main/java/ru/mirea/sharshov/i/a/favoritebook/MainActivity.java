package ru.mirea.sharshov.i.a.favoritebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    private TextView textView;
    private static final String DEFAULT_TEXT = "Тут появится название вашей любимой книги и любимая цитата из нее!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация текстового поля (TextView)
        textView = findViewById(R.id.textView);
        textView.setText(DEFAULT_TEXT);



        // Кнопка для открытия InputActivity
        Button buttonOpenInput = findViewById(R.id.button);
        buttonOpenInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                startActivityForResult(intent, 1); // Ожидаем результат от InputActivity
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Проверяем, что результат пришел успешно из InputActivity
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String bookName = data.getStringExtra("BOOK_NAME");
            String quote = data.getStringExtra("QUOTE");
            textView.setText("Название вашей любимой книги: " + bookName + ". Цитата: " + quote);
        }
    }
}