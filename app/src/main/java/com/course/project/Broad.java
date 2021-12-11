package com.course.project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Broad extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if ("com.course.Project.Call".equals(intent.getAction())){
            Toast.makeText(context, "전화 연결로 이동", Toast.LENGTH_SHORT).show();
        }
        else if("com.course.Project.SMS".equals(intent.getAction())){
            Toast.makeText(context, "메일 전송으로 이동", Toast.LENGTH_SHORT).show();
        }
        else if("com.course.Project.Location".equals(intent.getAction())){
            Toast.makeText(context, "위치 확인으로 이동", Toast.LENGTH_SHORT).show();
        }
        else if("com.course.Project.site".equals(intent.getAction())){
            Toast.makeText(context, "상품 판매 사이트로 이동", Toast.LENGTH_SHORT).show();
        }
        else if("com.course.Project.product".equals(intent.getAction())){
            Toast.makeText(context, "선택하신 상품 정보", Toast.LENGTH_SHORT).show();
        }
    }
}