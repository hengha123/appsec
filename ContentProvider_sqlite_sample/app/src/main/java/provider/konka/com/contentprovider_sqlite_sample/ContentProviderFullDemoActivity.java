package provider.konka.com.contentprovider_sqlite_sample;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;

public class ContentProviderFullDemoActivity extends AppCompatActivity implements View.OnClickListener {

    public static String TAG = "ContentProviderFullDemoActivity";

    public Uri uri = Employees.Employee.CONTENT_URI;

    private Button insertData = null;
    private Button createFile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider_full_demo);

        insertData = (Button)findViewById(R.id.insertData);
        insertData.setOnClickListener(ContentProviderFullDemoActivity.this);

        createFile = (Button)findViewById(R.id.createFile);
        createFile.setOnClickListener(ContentProviderFullDemoActivity.this);

    }

    @Override
    public void onClick(View view){
        //TODO Auto-generated method stub
        if(view == insertData){
            ContentValues values = new ContentValues();
            values.put(Employees.Employee.NAME,((EditText)findViewById(R.id.editText1)).getText().toString());
            values.put(Employees.Employee.GENDER,((EditText)findViewById(R.id.editText2)).getText().toString());
            values.put(Employees.Employee.AGE,((EditText)findViewById(R.id.editText3)).getText().toString());
            //插入
            insert(uri,values);
            Log.i(TAG,"insert");
        }else if(view == createFile){
            String filename = "test";
            String string = "Hello World!";
            FileOutputStream outputStream;

            try{
                outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                outputStream.write(string.getBytes());
                outputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //insert
    private void insert(Uri uri,ContentValues values) {
        getContentResolver().insert(uri,values);
    }

}
