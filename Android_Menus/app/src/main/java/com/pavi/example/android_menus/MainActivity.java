package com.pavi.example.android_menus;
 import

 import android.os.Bundle;
 import android.view.Menu;
 import android.view.View;
 import android.widget.Button;
 import android.widget.Spinner;

 import androidx.appcompat.app.AppCompatActivity;

 import java.util.Calendar; ...

public class MainActivity extends AppCompatActivity {
    int date,month,year,min,hours;
    Button btn;
    Spinner sp;
    TextView textView_label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.showButton);
        sp=findViewById(R.id.spin);
        textView_label=findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myhero=sp.getSelectedItem().toString();
                textView_label.setText(myhero);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.android_menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Alert:
                showAlert();
                break;
            case R.id.datepicker:
                showDate();
                break;
            case R.id.timepicker:
                showTime();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlert() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert......!");
        builder.setMessage("Do You want to close the app");
        builder.setIcon(R.drawable.ic_baseline_warning_24);
        builder.setCancelable(false);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                dialog.dismiss();
            }
        });
        builder.show();
        //Toast.makeText(this,"Item Alert Picker",Toast.LENGTH_SHORT).show();
    }
    private void showDate()
    {
        Calendar c=Calendar.getInstance();
        date=c.get(Calendar.DATE);
        month=c.get(Calendar.MONTH);
        year=c.get(Calendar.YEAR);
        DatePickerDialog dialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this,"Select Your Date is:"+dayOfMonth,Toast.LENGTH_SHORT).show();
            }
        },year,month,date);
        dialog.show();
        //Toast.makeText(this,"Item Date Picker",Toast.LENGTH_SHORT).show();
    }
    private void showTime()
    {
        Calendar c=Calendar.getInstance();
        hours=c.get(Calendar.HOUR);
        min=c.get(Calendar.MINUTE);
        TimePickerDialog dialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time=hourOfDay+"-"+minute;
                Toast.makeText(MainActivity.this,"Select Your Time is:"+time,Toast.LENGTH_SHORT).show();
            }
        },hours,min,true);
        dialog.show();
        //Toast.makeText(this,"Item Time Picker",Toast.LENGTH_SHORT).show();
    }
}