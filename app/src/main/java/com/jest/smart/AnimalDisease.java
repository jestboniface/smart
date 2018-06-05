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

public class AnimalDisease extends AppCompatActivity {

    ListView listDisease;
    ArrayList<DiseaseAdapter> ListDiseasesData;
    MyCustomAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disease_list);

        listDisease = findViewById(R.id.listDisease);


        ListDiseasesData = new ArrayList<>();
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.blacklegdisease,"Blackleg Disease","Burning the upper layer of soil to eradicate left-over spores is the best way to stop the spread of blackleg from diseased cattle. Diseased cattle should be isolated. Treatment is generally unrewarding due to the rapid progression of the disease, but penicillin is the drug of choice for treatment."));
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.contagious,"Contagious Ecthyma","Also known as orf or sore mouth, is a zoonotic disease, which means that it is easily transmitted from animals to humans. It induces acute pustular lesions in the skin of goats, sheep, and wild ruminants worldwide."));
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.cattle_mastitis,"Mastitis","Mastitis is an inflammation of the mammary gland or udder. Mastitis in dairy cows is caused by udder infections, usually resulting from bacteria introduced either during the milking process or from environmental contact. ... Antibiotics can be administered to treat mastitis in dairy cows."));
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.soremouth,"Sore mouth","Can affect production and performance in sheep and goats. Sore mouth, also known as contagious ecthyma (CE) or orf, is an acute infectious disease of sheep and goats. ... The infection may be transmitted to the teats and udder causing pain and abandonment of lambs and kids"));
        ListDiseasesData.add(new DiseaseAdapter(R.drawable.johnes,"Johne's Disease","Preventing and reducing Johne's disease requires a combination of management practices to avoid introducing infected cattle, colostrum or manure into the operation, and calving, feeding and grazing management practices that reduce the risk that young calves will consume infected manure and colostrum."));

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
