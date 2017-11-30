package my.edu.tarc.lab32inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoke;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking UI to program
        spinnerAge = (Spinner)findViewById(R.id.spinner);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoke = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

        //Create an adapter for spinner;
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this,R.array.age_group,android.R.layout.simple_spinner_item
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_dropdown_item_1line
        );

        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"Posiion :"+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int pos;
        pos = spinnerAge.getSelectedItemPosition();

        int indexGender;
        indexGender = radioGroupGender.getCheckedRadioButtonId();

        int totalPremium = 0;

        if(indexGender == R.id.radioButtonMale){
            //TODO: calculate premium for male
            if(pos == 0){
            totalPremium += 50;
            }
            else if(pos == 1){
                totalPremium+=55;
            }
            else if(pos == 2){
                totalPremium+=110;
            }
            else if(pos == 3){
                totalPremium+=170;
            }
            else if(pos == 4){
                totalPremium+=220;
            }
            else if(pos == 5){
                totalPremium+=210;
            }
            else if(pos == 6){
                totalPremium+=200;
            }
            else if(pos == 7){
                totalPremium+=250;
            }
        }
        else if (indexGender == R.id.radioButtonFemale){
            if(pos == 0){
                totalPremium += 50;
            }
            else if(pos == 1){
                totalPremium+=55;
            }
            else if(pos == 2){
                totalPremium+=60;
            }
            else if(pos == 3){
                totalPremium+=70;
            }
            else if(pos == 4){
                totalPremium+=120;
            }
            else if(pos == 5){
                totalPremium+=160;
            }
            else if(pos == 6){
                totalPremium+=200;
            }
            else if(pos == 7){
                totalPremium+=250;
            }
        }


        if(checkBoxSmoke.isChecked()){
            //TODO:calculate premium of smoker

            if(pos == 3){
                totalPremium+=100;
            }
            else if(pos == 4){
                totalPremium+=150;
            }
            else if(pos == 5){
                totalPremium+=150;
            }
            else if(pos == 6){
                totalPremium+=250;
            }
            else if(pos == 7){
                totalPremium+=250;
            }
        }

        textViewPremium.setText(getString(R.string.premium) + totalPremium);


       // Locale locale = Locale.getDefault();

       // NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        //String currencyText = fmt.format(premium);


    }

    public void resetPremium(View view){
        textViewPremium.setText(getString(R.string.premium));
        checkBoxSmoke.setChecked(false);
    }



}
