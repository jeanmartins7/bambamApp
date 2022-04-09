package jeanmartins.utfpr.edu.bambamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbMonday, cbTuesday, cbWednesday, cbThursday, cbFriday, cbSaturday;
    private RadioGroup radioGroupGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popularSpinner();
        popularCheckbox();
        radioGroupGender = findViewById(R.id.radioGroupGender);
    }

    private void popularSpinner(){
        Spinner spinner = (Spinner) findViewById(R.id.training_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.training_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    private void popularCheckbox(){
        cbMonday = findViewById(R.id.checkBoxMonday);
        cbTuesday = findViewById(R.id.checkBoxTuesday);
        cbWednesday = findViewById(R.id.checkBoxWednesday);
        cbThursday = findViewById(R.id.checkBoxThursday);
        cbFriday = findViewById(R.id.checkBoxFriday);
        cbSaturday = findViewById(R.id.checkBoxSaturday);
    }


    private void clearAllCheckBox(){
        cbMonday.setChecked(false);
        cbTuesday.setChecked(false);
        cbWednesday.setChecked(false);
        cbThursday.setChecked(false);
        cbFriday.setChecked(false);
        cbSaturday.setChecked(false);
    }

    private void clearRadioGroupGender(){
        radioGroupGender.clearCheck();
    }

    public void clearAllItems(View view){
        clearAllCheckBox();
        clearRadioGroupGender();
    }




}