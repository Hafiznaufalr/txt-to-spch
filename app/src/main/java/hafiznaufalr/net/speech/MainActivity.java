package hafiznaufalr.net.speech;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;

/*

Fathurrahman (okedroid.com)
 */
public class MainActivity extends AppCompatActivity {


    ImageButton buttonSpeak;
    EditText editText;
    TextToSpeech textToSpeech;

    //deklarasi var atau object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        getSupportActionBar().setTitle("Contoh Text to Speech ");
        getSupportActionBar().setSubtitle("Belajar di okedroid.com");

        buttonSpeak = (ImageButton)findViewById(R.id.buttonSpeak);
        editText = (EditText)findViewById(R.id.editText);
        //inisialisasi button dan edditext

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                //method untuk mendeteksi suara dari text

                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(new Locale("id","ID"));
                    //menggunakan bahasa ID (id)

                }
            }
        });


        buttonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //mengambil nilai value dari inputan edittext
                String text = editText.getText().toString();
                //untuk penanganan masalah deprecated pada saat memanggil suara
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);



                } else {
                    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });



    }


}