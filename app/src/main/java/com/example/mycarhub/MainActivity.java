package com.example.mycarhub;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    // Системная разметка
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView civicImage = findViewById(R.id.imageView); // находим картинку по id которая лежит в XML
        // делаем кнопку кликабельной
        civicImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Выводим всплывающее сообщение
                Toast.makeText(MainActivity.this, "VTEC Kick In! 160 hp!", Toast.LENGTH_SHORT).show();
            }
        });



        Button btnSpecs = findViewById(R.id.btnSpecs); // нашли кнопку по id которая хранится в XML
        TextView carTitle = findViewById(R.id.textView);

        btnSpecs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carTitle.setText("B16B Eninge | 160 hp | 160 Nm | FWD"); // меняем текст на хар-ки

                // Вывыдем, что данные обновлены
                Toast.makeText(MainActivity.this, "Характеристики загружены", Toast.LENGTH_SHORT).show();
            }
        });
    }
}