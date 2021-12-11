package com.course.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductView extends AppCompatActivity {

    private BroadcastReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        br = new Broad();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("com.course.Project.product");
        filter.addAction("com.course.Project.site");
        registerReceiver(br, filter);

        Intent in = new Intent();
        in.setAction("com.course.Project.product");
        sendBroadcast(in);

        ImageView first_image = (ImageView)findViewById(R.id.imageView2);
        ImageView second_image = (ImageView)findViewById(R.id.imageView3);
        TextView product_name = (TextView)findViewById(R.id.textView2);
        TextView price = (TextView)findViewById(R.id.textView4);
        TextView description = (TextView)findViewById(R.id.textView3);
        Button go_site = (Button)findViewById(R.id.button);

        Intent intent = getIntent();

        first_image.setImageResource(intent.getExtras().getInt("FirstImage"));
        second_image.setImageResource(intent.getExtras().getInt("SecondImage"));
        product_name.setText(intent.getExtras().getString("ProductName"));
        price.setText(intent.getExtras().getString("price")+"원");
        description.setText(intent.getExtras().getString("Description"));
        String url = intent.getExtras().getString("url");

        go_site.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Uri uri = Uri.parse(url);
                Intent inte = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(inte);

                Intent in = new Intent();
                in.setAction("com.course.Project.site");
                sendBroadcast(in);
            }
        });
    }

}