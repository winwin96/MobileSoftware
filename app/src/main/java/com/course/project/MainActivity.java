package com.course.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;
    private BroadcastReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        br = new Broad();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("com.course.Project.Call");
        filter.addAction("com.course.Project.SMS");
        filter.addAction("com.course.Project.Location");
        registerReceiver(br, filter);

        this.registerReceiver(br, filter);

        Button telephone = (Button)findViewById(R.id.button2);
        telephone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01012345678"));
                startActivity(intent);

                Intent in = new Intent();
                in.setAction("com.course.Project.Call");
                sendBroadcast(in);
            }
        });

        Button mail = (Button)findViewById(R.id.button3);
        mail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sendEmail();

                Intent in = new Intent();
                in.setAction("com.course.Project.SMS");
                sendBroadcast(in);
            }
        });

        Button location = (Button)findViewById(R.id.button4);
        location.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri uri = Uri.parse("geo:37.5581,126.9982?q=동국대학교 신공학관");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

                Intent in = new Intent();
                in.setAction("com.course.Project.Location");
                sendBroadcast(in);
            }
        });

        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        ArrayList<Products> ProductsInfo = new ArrayList<>();

        ProductsInfo.add(new Products(R.drawable.amond1,R.drawable.amond2,"아몬드봉봉","배스킨라빈스의 메인 플레이버 바닐라 아이스크림에 초콜릿 코팅 아몬드, 초콜릿 시럽이 들어 있다. 한국 배스킨라빈스에서 꾸준히 top5 안에 드는 메뉴.","3200", "http://www.baskinrobbins.co.kr/menu/view.php?seq=548"));
        ProductsInfo.add(new Products(R.drawable.alien1,R.drawable.alien2,"엄마는외계인","한국 배스킨라빈스의 스테디셀러다. 밀크 초콜릿, 다크 초콜릿, 화이트 초콜릿 무스 세 가지 아이스크림에 달콤 짭짤한 초코볼이 더해진 아이스크림이다.","3200", "http://www.baskinrobbins.co.kr/menu/view.php?seq=1167"));
        ProductsInfo.add(new Products(R.drawable.cherry1,R.drawable.cherry2,"체리쥬빌레","배스킨라빈스의 메인 플레이버. 많이 달지 않고 가벼운 맛이다. 체리 과육이 들어 있다. 이름 속 쥬빌레(jubilee)는 기념일이라는 뜻이다.","3200", "http://www.baskinrobbins.co.kr/menu/view.php?seq=13"));
        ProductsInfo.add(new Products(R.drawable.choco1,R.drawable.choco2,"초코브라우니설빙","초코가루와 오레오가루가 섞여 맛있는 초코맛 설빙이다.","12000", "https://sulbing.com/bbs/board.php?bo_table=menu&wr_id=26&sca=%EB%B9%99%EC%88%98"));
        ProductsInfo.add(new Products(R.drawable.green1,R.drawable.green2,"그린티초코설빙","녹차맛이 쌉싸름하여 초코의 단맛을 잡아주어 매우 조화롭고 고급진 맛을 내는 설빙의 메뉴이다.","12000", "https://sulbing.com/bbs/board.php?bo_table=menu&wr_id=32&sca=%EB%B9%99%EC%88%98"));
        ProductsInfo.add(new Products(R.drawable.mango,R.drawable.mango2,"애플망고치즈설빙","남녀노소 모두 좋아하는 망고의 최상급 품질인 애플망고의 달콤함과 깊고 진한 치즈 케이크가 만나 신선하고 상큼한 애플망고의 풍미를 온전히 느낄 수 있는 제품","12000", "https://sulbing.com/bbs/board.php?bo_table=menu&wr_id=25&sca=%EB%B9%99%EC%88%98"));
        ProductsInfo.add(new Products(R.drawable.melon1,R.drawable.melon2,"멜론설빙","현재 시즌외로 인해 판매하고있지 않습니다.","12000", "https://sulbing.com/bbs/board.php?bo_table=menu&page=1"));
        ProductsInfo.add(new Products(R.drawable.moose1,R.drawable.moose2,"초콜릿무스","초콜릿맛 베이스 아이스크림에 초코칩이 들어 있으며, 초콜릿보다는 맛이 연하다. 초콜릿이 다크 초콜릿 맛이라면 초콜릿 무스는 밀크 초콜릿 맛이 난다.","3200", "http://www.baskinrobbins.co.kr/menu/view.php?seq=12"));
        ProductsInfo.add(new Products(R.drawable.oreo1,R.drawable.oreo2,"오레오초코설빙","화려한 비쥬얼로 압도하는 역대급 몬스터 크기! 맛도 모양도 몬스터!","12000", "https://sulbing.com/bbs/board.php?bo_table=menu&wr_id=48&sca=%EB%B9%99%EC%88%98"));
        ProductsInfo.add(new Products(R.drawable.shooting1,R.drawable.shooting2,"슈팅스타","톡톡 터지는 팝핑 캔디와 스프링클 캔디,상큼한 체리 시럽이 들어있는 제품","3200", "http://www.baskinrobbins.co.kr/menu/view.php?seq=313"));
        ProductsInfo.add(new Products(R.drawable.tree1,R.drawable.tree2,"초코나무숲","녹차맛 아이스크림과 초콜릿 아이스크림이 진하게 섞여 있는 아이스크림. 짭짤한 초콜릿 코팅이 된 과자와 쿠키가 들어 있다. 현재는 단종중","3200", "http://www.baskinrobbins.co.kr/menu/list.php?Page=1&top=A&sub="));

        MyAdapter myAdapter = new MyAdapter(ProductsInfo);
        myRecyclerView.setAdapter(myAdapter);

    }

    @SuppressLint("IntentReset")
    protected void sendEmail() {
        String[] TO = {"Songhj96@naver.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"문의사항");
        try {
            startActivity(Intent.createChooser(emailIntent,
                    "이메일 보내기..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(MainActivity.this, "이메일 클라이언트가 없네요.", Toast.LENGTH_SHORT).show();
        }
    }

}












