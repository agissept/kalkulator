package com.example.agis.kalkulator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText text;
    double angka1 = 0, angka2 = 0, jumlah = 0;
    int status, op;
    boolean statusTitik = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.text);
        status = 0;
    }

    public void display(String x) {

        if (op == 1) {
            text.setText("");
        }
        op = 0;
        text.setText(text.getText() + "" + x);
    }

    public void displayJumlah(double y) {

        System.out.println(String.valueOf(y).substring(String.valueOf(y).length()-2,String.valueOf(y).length()-1));
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
        if (String.valueOf(y).substring(String.valueOf(y).length()-2,String.valueOf(y).length()).equals(".0")){
            text.setText(String.valueOf(y).substring(0,String.valueOf(y).length()-2));

        }
        else {
            text.setText(String.valueOf(y));
        }
    }

    public void n1(View view) {
        display("1");
    }

    public void n2(View view) {
        display("2");
    }

    public void n3(View view) {
        display("3");
    }

    public void n4(View view) {
        display("4");
    }

    public void n5(View view) {
        display("5");
    }

    public void n6(View view) {
        display("6");
    }

    public void n7(View view) {
        display("7");
    }

    public void n8(View view) {
        display("8");
    }

    public void n9(View view) {
        display("9");
    }

    public void n0(View view) {
        display("0");
    }

    public void ntambah(View view) {
        if (!text.getText().toString().isEmpty() || statusTitik == false){
            angka1=Double.parseDouble(text.getText().toString());
            text.setText("+");
            status=1;
            op=1;
            statusTitik=true;
        }
    }

    public void nkurang(View view){
        if (!text.getText().toString().isEmpty()) {
            angka1 = Double.parseDouble(text.getText().toString());
            text.setText("-");
            status = 2;
            op = 1;
        }
    }

    public void nbagi(View view){
        if (!text.getText().toString().isEmpty()) {
            angka1 = Double.parseDouble(text.getText().toString());
            text.setText("/");
            status = 3;
            op = 1;
        }
    }

    public void nkali(View view){
        if (!text.getText().toString().isEmpty()) {
            angka1 = Double.parseDouble(text.getText().toString());
            text.setText("*");
            status = 4;
            op = 1;
        }
    }

    public void ntitik(View view){
        if (!text.getText().toString().isEmpty()) {
            display(".");
        }
    }

    public void nhapus(View view){

        text.setText("");
        status=0;
        angka1=0;
        angka2=0;
        op=0;
    }

    public void backspace(View view){
        if (!text.getText().toString().isEmpty()) {
            String txt;
            txt = text.getText().toString();
            txt = txt.substring(0, txt.length() - 1);
            text.setText(txt);
        }

    }

    public void nsamadengan(View view){
        angka2=Double.parseDouble(text.getText().toString());
        hasil(angka1,angka2);
    }

    public void hasil(double bil1,double bil2){
        if (!text.getText().toString().isEmpty()) {
            if (status == 1) {
                jumlah = bil1 + bil2;
            } else if (status == 2) {
                jumlah = bil1 - bil2;
            } else if (status == 3) {
                jumlah = bil1 / bil2;
            } else if (status == 4) {
                jumlah = bil1 * bil2;
            }
            displayJumlah(jumlah);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.credit) {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Credit by : ");
            alert.setMessage("Agista Septiyanto");
            alert.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                @Override

                public void onClick(DialogInterface dialogInterface,int i){

                }
            });
            alert.show();
        }
        return true;
    }
}
