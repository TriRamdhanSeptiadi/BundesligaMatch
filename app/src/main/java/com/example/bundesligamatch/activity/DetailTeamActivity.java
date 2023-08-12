package com.example.bundesligamatch.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bundesligamatch.R;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

public class DetailTeamActivity extends AppCompatActivity {

    @BindView(R.id.ivLogo)
    ImageView ivLogo;

    @BindView(R.id.tvTitleShort)
    TextView tvTitleShort;

    @BindView(R.id.tvDescription0)
    TextView tvDescription0;

    @BindView(R.id.tvTitleAlternate)
    TextView tvTitleAlternate;

    @BindView(R.id.tvDescription1)
    TextView tvDescription1;

    @BindView(R.id.tvTitleYear)
    TextView tvTitleYear;

    @BindView(R.id.tvName)
    TextView tvNama;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.tvTitleStadium)
    TextView tvTitleStadium;

    @BindView(R.id.tvDescription2)
    TextView tvDescription2;

    @BindView(R.id.tvTitleLocationStadium)
    TextView tvTitleLocationStadium;

    @BindView(R.id.tvDescription3)
    TextView tvDescription3;

    @BindView(R.id.tvTitleCapacityStadium)
    TextView tvTitleCapacityStadium;

    @BindView(R.id.tvDescription4)
    TextView tvDescription4;

    @BindView(R.id.tvTitleCountry)
    TextView tvTitleCountry;

    @BindView(R.id.tvDescription5)
    TextView tvDescription5;

    private Context context;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);

        ButterKnife.bind(this);

        Bundle mBundle=getIntent().getExtras();
        tvNama.setText(mBundle.getString("nama"));

        tvTitleShort.setText("Nama Singkatan");

        tvDescription0.setText(mBundle.getString("namapendek"));

        tvTitleAlternate.setText("Nama Alternatif");

        tvDescription1.setText(mBundle.getString("namaalternatif"));

        tvTitleYear.setText("Tahun Dibentuk");

        tvDescription.setText(mBundle.getString("tahun"));

        tvTitleStadium.setText("Nama Stadion");

        tvDescription2.setText(mBundle.getString("namastadion"));

        tvTitleLocationStadium.setText("Lokasi Stadion");

        tvDescription3.setText(mBundle.getString("lokasitadion"));

        tvTitleCapacityStadium.setText("Kapasitas Stadion");

        tvDescription4.setText(mBundle.getString("kapasitasstadion"));

        tvTitleCountry.setText("Negara");

        tvDescription5.setText(mBundle.getString("negara"));

        Picasso.with(context)
                .load(mBundle.getString("logo")).resize(100,100)
                .into(ivLogo);

        id=Bundle.EMPTY.getString("id");
    }
}