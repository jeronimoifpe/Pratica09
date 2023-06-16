package pdm.pratica09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String [] cities = {"Recife", "João Pessoa", "Natal",
            "Fortaleza", "Rio de Janeiro", "São Paulo", "Salvador", "Vitória",
            "Florianópolis", "Porto Alegre", "São Luiz","Teresina",
            "Belém", "Manaus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, cities)
        );
    }
}