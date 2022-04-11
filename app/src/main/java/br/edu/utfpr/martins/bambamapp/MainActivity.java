package br.edu.utfpr.martins.bambamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome, editTextCell;
    private CheckBox cbMonday, cbTuesday, cbWednesday, cbThursday, cbFriday, cbSaturday;
    private RadioGroup radioGroupGender;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startEditText();
        startSpinner();
        startRadioGroupGender();
        popularCheckbox();

    }

    private void startEditText(){
        editTextNome = findViewById(R.id.inputName);
        editTextCell = findViewById(R.id.inputCell);
    }

    private void startRadioGroupGender(){
        radioGroupGender = findViewById(R.id.radioGroupGender);
    }

    private void startSpinner(){
        spinner = (Spinner) findViewById(R.id.training_spinner);

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

    private String getTextEditName(){
        String name = editTextNome.getText().toString();
        boolean verify = validateTextEdit(name);

        if(!verify){
            editTextNome.requestFocus();
            Toast.makeText(this, R.string.name_clean, Toast.LENGTH_SHORT).show();
        }

        return name;
    }

    private String getTextEditCellNumber(){
        String cellNumber = editTextCell.getText().toString();
        boolean verify = validateTextEdit(cellNumber);
        if(!verify){
            editTextCell.requestFocus();
            Toast.makeText(this, R.string.cell_clean, Toast.LENGTH_SHORT).show();
        }

        return cellNumber;
    }

    private String getRadioGroupGender(){
        String typeGender = "";

        switch (radioGroupGender.getCheckedRadioButtonId()){
            case R.id.radioButtonFamale:
                typeGender = "Feminino";
                break;

            case R.id.radioButtonMale:
                typeGender = "Masculino";
                break;
        }

        boolean verify = validateTextEdit(typeGender);

        if(!verify){
            radioGroupGender.requestFocus();
            Toast.makeText(this, R.string.gender_clean, Toast.LENGTH_SHORT).show();
        }

        return typeGender;
    }

    private String getCheckbox(){
        String checkBox = getString(R.string.days_checked)  + "\n";
        if(!cbMonday.isChecked() && !cbTuesday.isChecked() && !cbWednesday.isChecked()&&
                !cbThursday.isChecked() && !cbFriday.isChecked() && !cbSaturday.isChecked()){
            Toast.makeText(this, R.string.checkbox_clean, Toast.LENGTH_SHORT).show();
            checkBox = "";
        }
        if(cbMonday.isChecked()){checkBox += getString(R.string.monday) + "\n";}
        if(cbTuesday.isChecked()){checkBox += getString(R.string.tuesday) + "\n";}
        if(cbWednesday.isChecked()){checkBox += getString(R.string.wednesday) + "\n";}
        if(cbThursday.isChecked()){checkBox += getString(R.string.thursday) + "\n";}
        if(cbFriday.isChecked()){checkBox += getString(R.string.friday) + "\n";}
        if(cbSaturday.isChecked()){checkBox += getString(R.string.saturday) + "\n";}

        return checkBox;

    }

    private String getSpinner(){
        String training = (String) spinner.getSelectedItem();

        if (training.equals(getString(R.string.training_spinner))){
            Toast.makeText(this, R.string.select_training, Toast.LENGTH_SHORT).show();
            training = "";
        }

        return training;
    }

    private void clearEditText(){
        editTextCell.setText(null);
        editTextNome.setText(null);
        editTextNome.requestFocus();
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
        clearEditText();

        Toast.makeText(this, R.string.clear_message, Toast.LENGTH_SHORT).show();
    }

    public void saveItems(View view){
        String cell = getTextEditCellNumber();
        String name = getTextEditName();
        String gender = getRadioGroupGender();
        String checkBox = getCheckbox();
        String spinner = getSpinner();

        if(!name.isEmpty() && !cell.isEmpty() && !gender.isEmpty() && !checkBox.equals("")
                && !spinner.equals("")){
            String message = getString(R.string.name) + " :" + name + "\n" +
                    getString(R.string.cellphone) + " :" + cell + "\n" +
                    getString(R.string.gender) + " :" + gender + "\n"
                 + checkBox + "\n" + getString(R.string.training_spinner) + " :" + spinner + "\n";

            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    private boolean validateTextEdit(String string){
        return !string.isEmpty();
    }

}