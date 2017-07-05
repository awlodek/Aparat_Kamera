package com.example.przemcio.nazaliczenie;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class Main2Activity extends AppCompatActivity {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        File imagesFolder = new File(Environment.getExternalStorageDirectory(), "MyImages");
        imagesFolder.mkdirs();

            //  String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File image = new File(imagesFolder + ".jpg");
            Uri uriSavedImage = Uri.fromFile(image);

            intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

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
