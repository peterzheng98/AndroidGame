package com.example.myapplication2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.lang.String;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.text.Editable;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class game extends AppCompatActivity {

    View layout;

    boolean[] trash_state={true, true, true};
    boolean[] trash_wrong_state={false,false,false};
    int wrong_times=2;
    boolean trash_flag=true;
    boolean bin_flag =false;
    int now_trash_id=0;
    Button trash1, trash2, trash3, bin1, bin2, bin3, bin4;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        LayoutInflater inflater = getLayoutInflater();
        layout = inflater.inflate(R.layout.activity_game, (ViewGroup) findViewById(R.id.custom_toast_container));
        trash1 = (Button) findViewById(R.id.trash_1);
        trash2 = (Button) findViewById(R.id.trash_2);
        trash3 = (Button) findViewById(R.id.trash_3);
        bin1 = (Button) findViewById(R.id.bin_1);
        bin2 = (Button) findViewById(R.id.bin_2);
        bin3 = (Button) findViewById(R.id.bin_3);
        bin4 = (Button) findViewById(R.id.bin_4);
        //trash1.setText(R.string.trash1);

        trash1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!trash_flag) return;
                now_trash_id = 1;
                trash_flag = false;
                bin_flag = true;
            }
        });

        trash2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!trash_flag) return;
                now_trash_id = 2;
                trash_flag = false;
                bin_flag = true;
            }
        });

        trash3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!trash_flag) return;
                now_trash_id = 3;
                trash_flag = false;
                bin_flag = true;
            }
        });

        bin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bin_flag) return;

                trash_flag = true;
                bin_flag = false;
                if (!(now_trash_id == 1)) {
                    wrong_times++;
                    trash_wrong_state[now_trash_id-1] = true;
                }
                else {
                    trash1.setVisibility(View.INVISIBLE);
                    trash_state[0] = false;
                }

                if (wrong_times >= 3) {

                    showNormalDialog();
                    return ;
                    // TODO: jump!!!!!!!!!!
                }

                boolean success = true;
                int i = 0;
                for (i = 0; i <= 2; i++) {
                    if (trash_state[i]) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    Toast success_toast = Toast.makeText(getApplicationContext(), "Congratulations!", Toast.LENGTH_LONG);
                    success_toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    success_toast.show();
                    // TODO: jump!!!!!!!!!!
                }

            }
        });

        bin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bin_flag) return;

                trash_flag = true;
                bin_flag = false;
                if (!(now_trash_id == 2)) {
                    wrong_times++;
                    trash_wrong_state[now_trash_id-1] = true;
                }
                else {
                    trash2.setVisibility(View.INVISIBLE);
                    trash_state[1] = false;
                }

                if (wrong_times >= 3) {
                    showNormalDialog();
                    return;
                    // TODO: jump!!!!!!!!!!
                }

                boolean success = true;
                int i = 0;
                for (i = 0; i <= 2; i++) {
                    if (trash_state[i]) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    Toast success_toast = Toast.makeText(getApplicationContext(), "Congratulations!", Toast.LENGTH_LONG);
                    success_toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    success_toast.show();
                    // TODO: jump!!!!!!!!!!
                }

            }
        });

        bin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bin_flag) return;

                trash_flag = true;
                bin_flag = false;
                if (!(now_trash_id == 3)) {
                    wrong_times++;
                    trash_wrong_state[now_trash_id-1] = true;
                }
                else {
                    trash3.setVisibility(View.INVISIBLE);
                    trash_state[2] = false;
                }

                if (wrong_times >= 3) {
                    showNormalDialog();
                    return;
                    // TODO: jump!!!!!!!!!!
                }

                boolean success = true;
                int i = 0;
                for (i = 0; i <= 2; i++) {
                    if (trash_state[i]) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    Toast success_toast = Toast.makeText(getApplicationContext(), "Congratulations!", Toast.LENGTH_LONG);
                    success_toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    success_toast.show();
                    // TODO: jump!!!!!!!!!!
                }

            }
        });

        bin4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bin_flag) return;

                trash_flag = true;
                bin_flag = false;
                if (!(now_trash_id == 4)) {
                    wrong_times++;
                    trash_wrong_state[now_trash_id-1] = true;
                }
                else {
                    trash3.setVisibility(View.INVISIBLE);
                    trash_state[2] = false;
                }
                // case 1 : game over  and failed.
                if (wrong_times >= 3) {
                    showNormalDialog();
                    return;
                    // TODO: jump!!!!!!!!!!
                }
                // case 2:game over and succeed.
                boolean success = true;
                int i = 0;
                for (i = 0; i <= 2; i++) {
                    if (trash_state[i]) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    Toast success_toast = Toast.makeText(getApplicationContext(), "Congratulations!", Toast.LENGTH_LONG);
                    success_toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    success_toast.show();
                    // TODO: jump!!!!!!!!!!
                }

            }
        });
    }
    // TODO : NEED PARAMETERS
    private void showNormalDialog( ){
            /* @setIcon 设置对话框图标
             * @setTitle 设置对话框标题
             * @setMessage 设置对话框消息提示
             * setXXX方法返回Dialog对象，因此可以链式设置属性
             */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(game.this);
        final View failed_view1 = LayoutInflater.from(game.this).inflate(R.layout.failed_view_3, null);
        normalDialog.setIcon(R.drawable.ic_launcher_foreground);
        normalDialog.setView(failed_view1);
        normalDialog.setTitle("Failed!");
        normalDialog.setMessage("亲，这边建议看看垃圾错误信息呢~~");
        normalDialog.setPositiveButton("好哒",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String failed_info= "hhhhhhh";
                        int index=0;
                        for (index=0;index<3;index++) {
                            String hah_info= "hhhhhhh";
                            if (trash_wrong_state[index]) failed_info+=hah_info;
                        }


                        Toast failed_toast = Toast.makeText(getApplicationContext(), failed_info, Toast.LENGTH_SHORT);
                        failed_toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        failed_toast.setView(layout);
                        failed_toast.show();
                    }
                });
        normalDialog.setNegativeButton("残忍拒绝",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }
}
