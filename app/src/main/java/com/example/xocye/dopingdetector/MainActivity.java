package com.example.xocye.dopingdetector;

import android.support.design.widget.TabLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import android.widget.Button;

import com.example.xocye.dopingdetector.fragment.Tab1Shear;
import com.example.xocye.dopingdetector.fragment.Tab2Scan;
import com.example.xocye.dopingdetector.fragment.Tab3Form;

import com.example.xocye.dopingdetector.dataaccess.DataAccess;

// Doping Detector :-) :-P
public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private EditText et1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);// Para iniciar en la prosión 1

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        /////  ook

        et1 = (EditText) findViewById(R.id.Text_Codigo);

        /**btn1 = (Button) findViewById(R.id.Busqueda;
         btn1.setOnClickListener(new OnClickListener() {
        @Override public void onClick(View v) {
        }
        });
         */
    }//onCreate


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {


            switch (position) {
                case 0:
                    Tab1Shear tab1 = new Tab1Shear();
                    return tab1;

                case 1:
                    Tab2Scan tab2 = new Tab2Scan();
                    return tab2;
                case 2:
                    Tab3Form tab3 = new Tab3Form();
                    return tab3;
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Busqueda";
                case 1:
                    return "Escaner";

                case 2:
                    return "Formulario";
            }
            return null;
        }
    }

    // Hacemos búsqueda por codigo

    public void Busqueda(View v) {
        DataAccess dd = new DataAccess(this,
                "DD", null, 1);
        SQLiteDatabase bd = dd.getWritableDatabase();
        String cod = et1.getText().toString();
        Cursor fila = bd.rawQuery(
                "select Code, Name from Farmaco where Code=" + cod, null);
        if (fila.moveToFirst()) {

        } else
            Toast.makeText(this, "No existe el farmaco",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

}////class
