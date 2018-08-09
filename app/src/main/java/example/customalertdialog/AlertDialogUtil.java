package example.customalertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jiawei on 2018/8/8.
 */

public class AlertDialogUtil {
public  Context mContext;
    public  String title;
    public  String content;

    public AlertDialogUtil(Context mContext, String title, String content) {
        this.mContext = mContext;
        this.title = title;
        this.content = content;
    }

    public void dialogShow2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext,R.style.dialog);
//        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.update_manage_dialog, null);
        TextView tv_content = (TextView) v.findViewById(R.id.dialog_content);
        TextView tv_title=   (TextView)v.findViewById(R.id.dialog_title);
        tv_content.setText(content);
        tv_title.setText(title);
        Button btn_sure = (Button) v.findViewById(R.id.dialog_btn_sure);

        //builer.setView(v);//这里如果使用builer.setView(v)，自定义布局只会覆盖title和button之间的那部分
        final Dialog dialog = builder.create();
        dialog.show();
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = mContext.getResources().getDisplayMetrics(); // 获取屏幕宽、高用

        lp.width = (int) (d.widthPixels * 0.8); // 宽度设置为屏幕的0.8
        dialogWindow.setAttributes(lp);
        dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后面
        //dialog.getWindow().setGravity(Gravity.CENTER);//可以设置显示的位置
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
    });


}

}
