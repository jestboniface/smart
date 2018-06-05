package com.jest.smart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PoultryDisease extends AppCompatActivity {

    ListView listDisease;
    ArrayList<DiseaseAdapter> ListDiseasesData;
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disease_list);

        listDisease = findViewById(R.id.listDisease);


        ListDiseasesData = new ArrayList<>();
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.powlpoxx,"Fowlpox","Fowlpox is a slow-spreading viral infection of chickens and turkeys characterized by proliferative lesions in the skin that progress to thick scabs (cutaneous form) and by lesions in the upper GI and respiratory tracts."));
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.fowlcholera,"Fowl Cholera(Duck)","Fowl Cholera(Duck) is a serious, highly contagious disease caused by the bacterium Pasteurella multocida in a range of avian species including chickens, turkeys, and water fowl. Treatment is by P multocida"));
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.arizonos,"Arizonosis","Arizonosis cause by Salmonella Arizona and its signs are Poults unthrifty and may develop eye topacity and blindness. Susceptible age 3-4 weeks. This is treated by Elimination of infected breeder flock and hatchery fumigation and sanitation"));

        myadapter =new MyCustomAdapter(ListDiseasesData);
        listDisease.setAdapter(myadapter);

//        listDisease.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

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
            View viewDisease = inflateDisease.inflate(R.layout.disease_content,null);

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
}
