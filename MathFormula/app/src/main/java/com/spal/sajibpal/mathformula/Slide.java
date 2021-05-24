package com.spal.sajibpal.mathformula;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class Slide extends AppCompatActivity {

    ViewPager pager;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);


        String titlename=getIntent().getStringExtra("title");

        //for algebra
        if(titlename.equals("Algebra Formula")||titlename.equals("Algebra Powers")||
                titlename.equals("Algebra Logarithm")||titlename.equals("Algebra Equations")) {

            if (titlename.equals("Algebra Formula")) {

                int[] images = {R.drawable.algebra, R.drawable.algrba1};
                adapter = new CustomAdapter(this, images);
            }
            if (titlename.equals("Algebra Powers")) {

                int[] images = {R.drawable.algebrapower};
                adapter = new CustomAdapter(this, images);
            }
            if (titlename.equals("Algebra Logarithm")) {

                int[] images = {R.drawable.algebralogrithm};
                adapter = new CustomAdapter(this, images);
            }
            if (titlename.equals("Algebra Equations")) {

                int[] images = {R.drawable.algebraequation};
                adapter = new CustomAdapter(this, images);
            }
        }
        //foe calculas

        if(titlename.equals("Differentiation")||titlename.equals("Integration")||
                titlename.equals("Limit")) {

            if(titlename.equals("Differentiation")){

                int[] images={R.drawable.differentiation,R.drawable.differentiation1};
                adapter=new CustomAdapter(this,images);
            }
            if(titlename.equals("Integration")){

                int[] images={R.drawable.integration,R.drawable.integration1};
                adapter=new CustomAdapter(this,images);
            }
            if(titlename.equals("Limit")){

                int[] images={R.drawable.limit};
                adapter=new CustomAdapter(this,images);
            }

        }

        //for trigonometic
        if(titlename.equals("trigonal")){

            int[] images={R.drawable.trigonometric1,R.drawable.trigonometric2,R.drawable.trigonometric3,
                    R.drawable.trigonometric4,R.drawable.trigonometric5};
            adapter=new CustomAdapter(this,images);
        }

       //for probality
        if(titlename.equals("probality")){

            int[] images={R.drawable.probability2,R.drawable.probability3};
            adapter=new CustomAdapter(this,images);
        }

        //for geometry
        if(titlename.equals("geometry")){

            int[] images={R.drawable.geometry1,R.drawable.geometry2};
            adapter=new CustomAdapter(this,images);
        }

        //for others

        if(titlename.equals("Set Formula")||titlename.equals("Series Formula")) {

            if(titlename.equals("Series Formula")){

                int[] images={R.drawable.seria1,R.drawable.serias2};
                adapter=new CustomAdapter(this,images);
            }
            if(titlename.equals("Set Formula")){

                int[] images={R.drawable.set,R.drawable.set1,R.drawable.set2};
                adapter=new CustomAdapter(this,images);
            }
        }

        pager=(ViewPager) findViewById(R.id.page);
        pager.setAdapter(adapter);

    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nextmenu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.next) {

            Toast.makeText(this, "Please Image Slide for next Formula &\nImage Double click zoom image in/out", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
