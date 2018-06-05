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

public class PlantDisease extends AppCompatActivity {

    ListView listDisease;
    ArrayList<DiseaseAdapter> ListDiseasesData;
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disease_list);

        listDisease = findViewById(R.id.listDisease);


        ListDiseasesData = new ArrayList<>();
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.tomatobligt,"Tomato Blight,","A disease that attacks a plant's foliage, stems, and even fruit. Early blight (one form of tomato blight) is caused by a fungus, Alternaria solani, which over-winters in the soil and infected plants."));
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.alternaria," Alternaria Leaf Spo","Symptoms of Alternaria Leaf Spot on cabbage may first develop on young plants in seedbeds, where leaf spots, stunting, or damping off may occur "));
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.maizevirus,"Maize Dwarf Mosaic Virus","A pathogenic virus of the family Potyviridae. Depending on the corn plant’s growth stage, the virus can have severe implications to the corn plant’s development which can also result in economic consequences to the producer of the crop."));
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.maizeblight,"Maize chlorotic dwarf","Caused by Maize chlorotic dwarf virus. Identification of a maize chlorotic dwarf virus silencing suppressor protein. This disease belongs to a unique group of plant viruses, classified as the genus Waikavirus, within the family Secoviridae. Seed treatment with systemic insecticide produces optimum efficacy against the leafhopper and other pests"));


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