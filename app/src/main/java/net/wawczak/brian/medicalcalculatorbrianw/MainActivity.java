package net.wawczak.brian.medicalcalculatorbrianw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText weight = findViewById(R.id.txtWeight);
        final RadioButton lbToKilo = findViewById(R.id.radLbToKilo);
        final RadioButton kiloToLb = findViewById(R.id.radKiloToLb);
        final TextView result = findViewById(R.id.txtResult);
        Button convert = findViewById(R.id.btnConvert);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");
                if(lbToKilo.isChecked()){
                    if(weightEntered <= 500) {
                        convertedWeight = weightEntered / conversionRate;
                        result.setText(String.format("%s kilograms", tenth.format(convertedWeight)));
                    }else{
                        Toast.makeText(MainActivity.this,"Pounds must be less than 500", Toast.LENGTH_LONG).show();

                    }
                }if(kiloToLb.isChecked()) {
                    if(weightEntered <= 225) {
                        convertedWeight = weightEntered * conversionRate;
                        result.setText(String.format("%s pounds", tenth.format(convertedWeight)));
                    }else {
                        Toast.makeText(MainActivity.this, "Kilos must be less than 225", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
