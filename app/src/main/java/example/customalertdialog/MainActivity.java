package example.customalertdialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button button =  (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                 AlertDialogUtil alertDialogUtil = new AlertDialogUtil(this,"温馨提示","请连接打印机");
                alertDialogUtil.dialogShow2();
                break;
        }
    }
}
