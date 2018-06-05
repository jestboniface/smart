package com.jest.smart;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    ListView listDisease;
    ArrayList<DiseaseAdapter> ListDiseasesData;
    MyCustomAdapter myadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        listDisease = findViewById(R.id.listDisease1);


        ListDiseasesData = new ArrayList<>();
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.animal,"ANIMALS","A number of animal diseases and their treatment"));
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.poultry,"POULTRY","See how to treat or prevent poutry diseases"));
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.maizeblight,"PLANTS","View various plants diseases"));


        myadapter =new MyCustomAdapter(ListDiseasesData);
        listDisease.setAdapter(myadapter);

        listDisease.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Intent animal =new Intent(getApplicationContext(), AnimalDisease.class);
                startActivity(animal);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private class MyCustomAdapter extends BaseAdapter {

        public ArrayList<DiseaseAdapter> ListOfDiseasesAdapter;

        public MyCustomAdapter(ArrayList<DiseaseAdapter> ListOfDiseases){
            this.ListOfDiseasesAdapter=ListOfDiseases;
        }

        @Override
        public int getCount() {
            return ListOfDiseasesAdapter.size();
        }

        @Override
        public String getItem(int position){
            return null;
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflateDisease = getLayoutInflater();
            View viewDisease = inflateDisease.inflate(R.layout.homepage_content,null);

            final DiseaseAdapter x =ListOfDiseasesAdapter.get(position);

//            TextView ID = viewDisease.findViewById(R.id.textView_id);
//            ID.setText("ID:"+x.ID);

            ImageView image = viewDisease.findViewById(R.id.diseaseImage);
            image.setImageResource(x.ID);


            TextView diseaseTitle = viewDisease.findViewById(R.id.textView_title);
            diseaseTitle.setText(x.DiseaseTitle);

            TextView diseaseDesc = viewDisease.findViewById(R.id.textView_desc);
            diseaseDesc.setText(x.Description);

            return viewDisease;
        }
    }






    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            Intent About = new Intent(this, About.class);
            startActivity(About);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_plants) {
            // Handle the plants action
            Intent Plant = new Intent(this, PlantDisease.class);
            startActivity(Plant);
        }

        else if (id == R.id.nav_animal) {
            Intent Animal = new Intent(this, AnimalDisease.class);
            startActivity(Animal);

        } else if (id == R.id.nav_poultry) {
            Intent Poultry = new Intent(this, PoultryDisease.class);
            startActivity(Poultry);

        } else if (id == R.id.nav_feedback) {

            Intent Feedback = new Intent(this, Feedback.class);
            startActivity(Feedback);

        } else if (id == R.id.nav_about) {
            Intent About = new Intent(this, About.class);
            startActivity(About);

        }else if (id == R.id.nav_exit) {
            finish();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
