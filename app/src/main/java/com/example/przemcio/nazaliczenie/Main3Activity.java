package com.example.przemcio.nazaliczenie;

import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class Main3Activity extends AppCompatActivity {

    Button guzik;
    MediaRecorder mediaRecorder;
    SurfaceHolder surfaceHolder;
    SurfaceView surfaceView;
    boolean nagrywanie;
    String sciezkaPliku = "/sdcard/nagrywanie.mp4";

    public void klikniecie(){
        if(nagrywanie){
            mediaRecorder.stop();
            mediaRecorder.release();
            finish();
            File f = new File(sciezkaPliku);
            if(f.exists()){
                Log.d("Kamera", "Jest plik! ");
            }
            else {
                Log.d("Kamera","Nie ma pliku");
            }
        }
        else
        {
            mediaRecorder.start();
            nagrywanie=true;
            guzik.setText("Koniec");
        }
    }

    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 100;
    Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        File imagesFolder = new File(Environment.getExternalStorageDirectory(), "MyImages");
        imagesFolder.mkdirs();

        //  String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File image = new File(imagesFolder + ".avi");
        Uri uriSavedImage = Uri.fromFile(image);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
        startActivityForResult(intent, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);

        Button powrot = (Button)findViewById(R.id.powrot);
        powrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context,MainActivity.class);
                startActivity(intent);
            }
        });



    }


}
