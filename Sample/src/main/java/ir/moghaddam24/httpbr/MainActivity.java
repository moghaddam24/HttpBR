package ir.moghaddam24.httpbr;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.berans.lib.HttpBR;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Activity activity = this;

        final EditText textDomain = (EditText) findViewById(R.id.textDomain);
        final TextView textResult = (TextView) findViewById(R.id.textResult);

        Button buttonGetData = (Button)findViewById(R.id.buttonGetData);
        buttonGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpBR http = new HttpBR(activity, "http://api.hackertarget.com/nping/");
                http.parseGet("q=" + textDomain.getText().toString());
                http.setOnFinishListener(new HttpBR.OnFinishListener() {
                    @Override
                    public void onFinish(String data) {
                        textResult.setText(data);
                    }
                });
                http.setOnNetworkErrorListener(new HttpBR.OnNetworkErrorListener() {
                    @Override
                    public void onNetworkError() {
                        textResult.setText("Error in get data.");
                    }
                });
                http.setLoading("Please Wait ...");
                http.execute();
            }
        });
    }

}
