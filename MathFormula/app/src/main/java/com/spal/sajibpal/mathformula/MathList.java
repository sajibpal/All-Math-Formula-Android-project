package com.spal.sajibpal.mathformula;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MathList extends AppCompatActivity {

     ListView vlist;
     String[] coun;
     String menuname;

    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_list);




        vlist=(ListView) findViewById(R.id.list);

          menuname=getIntent().getStringExtra("optionmenu");

        if(menuname.equals("algebra")){

            coun=getResources().getStringArray(R.array.algebralist);
        }
        if(menuname.equals("calculas")){

            coun=getResources().getStringArray(R.array.calculaslist);
        }
        if(menuname.equals("other")){

            coun=getResources().getStringArray(R.array.otherlist);
        }


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MathList.this,R.layout.datastring,R.id.txt,coun);
        vlist.setAdapter(adapter);

        vlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                if(menuname.equals("algebra")){

                    String name=coun[position];

                    if(name.equals("Algebra Formula")){

                        startActivity(new Intent(MathList.this,Slide.class).putExtra("title","Algebra Formula"));
                    }
                    if(name.equals("Algebra Powers")){

                        startActivity(new Intent(MathList.this,Slide.class).putExtra("title","Algebra Powers"));
                    }
                    if(name.equals("Algebra Logarithm")){

                        startActivity(new Intent(MathList.this,Slide.class).putExtra("title","Algebra Logarithm"));
                    }

                    if(name.equals("Algebra Equations")){

                        startActivity(new Intent(MathList.this,Slide.class).putExtra("title","Algebra Equations"));
                    }
                }

                if(menuname.equals("calculas")){

                    String name=coun[position];

                    if(name.equals("Differentiation")){

                        startActivity(new Intent(MathList.this,Slide.class).putExtra("title","Differentiation"));
                    }
                    if(name.equals("Integration")){

                        startActivity(new Intent(MathList.this,Slide.class).putExtra("title","Integration"));
                    }
                    if(name.equals("Limit")) {

                        startActivity(new Intent(MathList.this, Slide.class).putExtra("title", "Limit"));
                    }
                }

                if(menuname.equals("other")){

                    String name=coun[position];

                   if(name.equals("Series Formula")){

                        startActivity(new Intent(MathList.this,Slide.class).putExtra("title","Series Formula"));
                    }
                    if(name.equals("Set Formula")){

                        startActivity(new Intent(MathList.this,Slide.class).putExtra("title","Set Formula"));
                    }

                }

            }
        });
    }
}
