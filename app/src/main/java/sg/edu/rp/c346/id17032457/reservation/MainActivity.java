package sg.edu.rp.c346.id17032457.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //step1

    Button btnReset;
    Button btnConfirm;

    EditText etName;
    EditText etMobile;
    EditText etSize;

    CheckBox enableSmoke;
    DatePicker dp;
    TimePicker tp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Step 2: Link the field variables to UI components in layout

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        etName = findViewById(R.id.editTextName);
        etMobile = findViewById(R.id.editTextMobile);
        etSize = findViewById(R.id.editTextSize);
        enableSmoke = findViewById(R.id.EnabledSmoke);
        btnReset = findViewById(R.id.btnReset);
        btnConfirm = findViewById(R.id.btnConfirm);



        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isSmoke = "";
                if (enableSmoke.isChecked()){
                    isSmoke="smoking";
                }else{
                    isSmoke="non-smoking";
                }
                Toast.makeText(MainActivity.this, "Hi" + etName.getText().toString() + ", you have booked a "
                        + etSize.getText().toString() + " persons "
                        + isSmoke + "table on"
                        + dp.getYear() + "/" + (dp.getMonth()+1) + "/" + dp.getDayOfMonth()
                        + tp.getCurrentHour() +":" + tp.getCurrentMinute() + ", Your mobile phone"
                        + etMobile.getText().toString() + "="
                        , Toast.LENGTH_LONG).show();



            }

        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.setText("");
                etMobile.setText("");
                etSize.setText("");
                enableSmoke.setChecked(false);
                dp.updateDate(2020,5,1);
                tp.setCurrentHour(20);
                tp.setCurrentMinute(30);

            }
        });



    }
}
