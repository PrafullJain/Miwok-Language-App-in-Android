package prafull.com.mymiwok;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import prafull.com.mymiwok.R;

public class MainActivity extends AppCompatActivity {

   /* final Fragment fragment1 = new NumbersFragment();
   *//* final Fragment fragment2 = new DashboardFragment();
    final Fragment fragment3 = new NotificationsFragment();
   *//*
   final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();

        fm.beginTransaction().add(R.id.frm_contain,fragment1, "1").commit();
        BottomNavigationView bottom=findViewById(R.id.upper_nav);
        bottom.setOnNavigationItemSelectedListener(navi);
    */
    }
    /*
    private BottomNavigationView.OnNavigationItemSelectedListener navi=new BottomNavigationView.OnNavigationItemSelectedListener()
    {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId())
            {
                case R.id.numb:
                    Log.i("MSG","No Frag is clicked");
                    fm.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1;
                    return true;
                case R.id.fm:
                    fm.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1;
                    return true;
                case R.id.col:
                    fm.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1;
                    return true;
                case R.id.phra:
                    fm.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1;
                    return true;

            }
            return false;
        }
    };
     */
    public void numberList(View v)
    {
        startActivity(new Intent(this, prafull.com.mymiwok.NumberActivity.class));
    }
    public void familyList(View v)
    {
        startActivity(new Intent(this, prafull.com.mymiwok.FamilyActivity.class));
    }public void phraseList(View v)
    {
        startActivity(new Intent(this, prafull.com.mymiwok.PhraseActivity.class));
    }public void colorList(View v)
    {
        startActivity(new Intent(this, prafull.com.mymiwok.ColorActivity.class));
    }
}
