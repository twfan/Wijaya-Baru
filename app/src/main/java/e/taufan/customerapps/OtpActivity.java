package e.taufan.customerapps;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OtpActivity extends AppCompatActivity {

    Button button;
    TextView timer, resend_code, please_wait;
    TextView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, backspace;
    EditText number0, number1, number2, number3, number4;
    Integer ctr=0;
    Integer conver_int;
    List<Integer > KODE_OTP = new ArrayList<Integer>();
    private Vibrator mVibrator;
    String SEND_KODE_OTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        mVibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn0 = findViewById(R.id.button0);
        backspace = findViewById(R.id.backspace);

        number0 = findViewById(R.id.number0);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);

        resend_code = findViewById(R.id.resend_code);
        timer = findViewById(R.id.timer);
        please_wait = findViewById(R.id.txt_pleasewait);



        new CountDownTimer(90000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(""+String.format("%d : %d",
                        TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            @Override
            public void onFinish() {
                resend_code.setVisibility(View.VISIBLE);
                timer.setVisibility(View.GONE);
                please_wait.setVisibility(View.GONE);
            }
        }.start();


        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                clearNumber();
                KODE_OTP.remove(ctr);

                Log.d("_KODE-CEK-SIZE",String.valueOf(KODE_OTP.size()));
                Log.d("_KODE-CEK-CTR",String.valueOf(ctr));

                if(ctr==1||ctr==0){
                    ctr = 0;
                    KODE_OTP.clear();
                }else
                {
                    ctr--;
                }
                if(KODE_OTP.size()==1){
                    number0.setText(KODE_OTP.get(0).toString());
                }else if(KODE_OTP.size()==2){
                    number0.setText(KODE_OTP.get(0).toString());
                    number1.setText(KODE_OTP.get(1).toString());
                }else if(KODE_OTP.size()==3){
                    number0.setText(KODE_OTP.get(0).toString());
                    number1.setText(KODE_OTP.get(1).toString());
                    number2.setText(KODE_OTP.get(2).toString());
                }else if(KODE_OTP.size()==4){
                    number0.setText(KODE_OTP.get(0).toString());
                    number1.setText(KODE_OTP.get(1).toString());
                    number2.setText(KODE_OTP.get(2).toString());
                    number3.setText(KODE_OTP.get(3).toString());
                }else if(KODE_OTP.size()==5){
                    number0.setText(KODE_OTP.get(0).toString());
                    number1.setText(KODE_OTP.get(1).toString());
                    number2.setText(KODE_OTP.get(2).toString());
                    number3.setText(KODE_OTP.get(3).toString());
                }
            }
        });

        backspace.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                vibrate();
                clearNumber();
                return true;
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                getNumber(btn1.getText().toString());


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                getNumber(btn2.getText().toString());

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                getNumber(btn3.getText().toString());

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                getNumber(btn4.getText().toString());

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                getNumber(btn5.getText().toString());

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                getNumber(btn6.getText().toString());

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                getNumber(btn7.getText().toString());

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                getNumber(btn8.getText().toString());

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                getNumber(btn9.getText().toString());

            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                getNumber(btn0.getText().toString());

            }
        });
    }

    private void getNumber(String number){
        if(ctr>=4){

            conver_int = Integer.parseInt(number);
            KODE_OTP.add(conver_int);
            setNumber();
            ctr++;
            SEND_KODE_OTP = "" + KODE_OTP.get(0).toString() + KODE_OTP.get(1).toString() + KODE_OTP.get(2).toString() + KODE_OTP.get(3).toString() + KODE_OTP.get(4).toString();
            Log.d("_KODE-JUMLAH","Sudah 5"); //Send OTP Verifikasi
            Log.d("_KODE-SEND-KODE-OTP",SEND_KODE_OTP); //Send OTP Verifikasi
            ctr = 4;
            startActivity(new Intent(OtpActivity.this, HomeActivity.class));
            finish();
        }else
        {
            ctr++;
            conver_int = Integer.parseInt(number);
            KODE_OTP.add(conver_int);
            setNumber();

        }
    }

    private void clearNumber(){
        ctr = 0;
        KODE_OTP.clear();
        number0.setText("");
        number1.setText("");
        number2.setText("");
        number3.setText("");
        number4.setText("");
    }


    private void setNumber(){
        if(KODE_OTP.size()==1){
            number0.setText(KODE_OTP.get(0).toString());
        }else if(KODE_OTP.size()==2){
            number1.setText(KODE_OTP.get(1).toString());
        }else if(KODE_OTP.size()==3){
            number2.setText(KODE_OTP.get(2).toString());
        }else if(KODE_OTP.size()==4){
            number3.setText(KODE_OTP.get(3).toString());
        }else if(KODE_OTP.size()==5){
            number4.setText(KODE_OTP.get(4).toString());
        }
    }


    private void vibrate(){
        mVibrator.vibrate(100);
    }
}
