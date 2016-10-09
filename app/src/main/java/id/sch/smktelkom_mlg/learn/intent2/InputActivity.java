package id.sch.smktelkom_mlg.learn.intent2;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    public static final String NAMA = "Nama";
    public static final String TAHUN_LAHIR = "TahunLair";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        findViewById(R.id.buttonfinish).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                EditText etnama = (EditText) findViewById(R.id.editTextnama);
                EditText etthnlhr = (EditText) findViewById(R.id.editTexttahunlahir);
                String nama = etnama.getText().toString();
                String thnlhrstr = etthnlhr.getText().toString();

                int thnlhr = thnlhrstr.isEmpty() ?
                        Calendar.getInstance().get(Calendar.YEAR) :
                        Integer.parseInt(thnlhrstr);
                Intent intent = new Intent();
                intent.putExtra(NAMA, nama);
                intent.putExtra(TAHUN_LAHIR, thnlhr);

                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}
