package com.example.leafidentifier;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.leafidentifier.plants.Anhui_Barberry;
import com.example.leafidentifier.plants.Beales_Barberry;
import com.example.leafidentifier.plants.Big_Fruited_Holly;
import com.example.leafidentifier.plants.Camphortree;
import com.example.leafidentifier.plants.Canadian_Poplar;
import com.example.leafidentifier.plants.Castor_Aralia;
import com.example.leafidentifier.plants.Chinese_Cinnamon;
import com.example.leafidentifier.plants.Chinese_Horse_Chestnut;
import com.example.leafidentifier.plants.Chinese_Redbud;
import com.example.leafidentifier.plants.Chinese_Toon;
import com.example.leafidentifier.plants.Chinese_Tulip_Tree;
import com.example.leafidentifier.plants.Crape_Myrtle;
import com.example.leafidentifier.plants.Deodar;
import com.example.leafidentifier.plants.Ford_Woodlotus;
import com.example.leafidentifier.plants.Glossy_Privet;
import com.example.leafidentifier.plants.Goldenrain_Tree;
import com.example.leafidentifier.plants.Japan_Arrowwood;
import com.example.leafidentifier.plants.Japanese_Cheesewood;
import com.example.leafidentifier.plants.Japanese_Flowering_Cherry;
import com.example.leafidentifier.plants.Japanese_Maple;
import com.example.leafidentifier.plants.Maidenhair_Tree;
import com.example.leafidentifier.plants.Nanmu;
import com.example.leafidentifier.plants.Oleander;
import com.example.leafidentifier.plants.Peach;
import com.example.leafidentifier.plants.Pubescent_Bamboo;
import com.example.leafidentifier.plants.Southern_Magnolia;
import com.example.leafidentifier.plants.Sweet_Osmanthus;
import com.example.leafidentifier.plants.Tangerine;
import com.example.leafidentifier.plants.Trident_Maple;
import com.example.leafidentifier.plants.True_Indigo;
import com.example.leafidentifier.plants.Wintersweet;
import com.example.leafidentifier.plants.Yew_Plum_Pine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {
    TextView scientificNameTextView;
    TextView otherNameTextView;
    TextView typeTextView;
    TextView familyTextView;
    TextView nativeRangeTextView;
    TextView heightTextView;
    TextView suggestedUseTextView;
    TextView evergreenTextView;
    ImageView resultLeafImageView;

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> titles;
    Map<String, List<String>> points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent(); //gets the intent with which this screen is brought to
        String leafName = intent.getStringExtra("leafName"); //extracts the leafName sent with intent when intent was started
        byte[] byteArray = getIntent().getByteArrayExtra("image"); //extracts the iamge sent as byteArray with intent when intent was started
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length); //converts the byte array to bitmap
        scientificNameTextView = (TextView) findViewById(R.id.scientificNameTextView);
        otherNameTextView = findViewById(R.id.otherNameTextView);
        typeTextView = findViewById(R.id.typeTextView);
        familyTextView = findViewById(R.id.familyTextView);
        nativeRangeTextView = findViewById(R.id.nativeRangeTextView);
        heightTextView = findViewById(R.id.heightTextView);
        suggestedUseTextView = findViewById(R.id.suggestedUseTextView);
        evergreenTextView = findViewById(R.id.evergreenTextView);
        resultLeafImageView = findViewById(R.id.resultLeafImageView);

        expandableListView = findViewById(R.id.expandableListView);
        fillData(leafName); //fill data on the textview with contents from respective leaf class selected on basis of result from server
        resultLeafImageView.setImageBitmap(bmp); //sets bitmap to the imageView on result screeb
        System.out.println(leafName);

        expandableListAdapter = new MyExpandableListAdapter(this, titles, points); //creates the expandable list adapter for cultivation,uses,....

        expandableListView.setAdapter(expandableListAdapter);//sets the adapter to the listview
    }

    @SuppressLint("SetTextI18n")
    public void fillData(String result) {
        titles =  new ArrayList<>(); //titles or parents are stored here i.e. cultivation, use, problems, characteristics
        points = new HashMap<>(); //points of respective parent title are stored with a map key being title and data being string array

        titles.add("Cultivation"); //adds titles to the titles arrayList
        titles.add("Characteristics");
        titles.add("Problems");
        titles.add("Garden uses");
        List<String> cultivation; //string list for cultivation points
        List<String> characteristics;
        List<String> problems;
        List<String> garden_uses;

        switch (result) {
            case "Anhui_Barberry":
                scientificNameTextView.setText(Anhui_Barberry.scientificName);
                otherNameTextView.setText("Common Name: " + Anhui_Barberry.other_name);
                typeTextView.setText("Type: " + Anhui_Barberry.type);
                familyTextView.setText("Family: " + Anhui_Barberry.family);
                nativeRangeTextView.setText("Native Range: " + Anhui_Barberry.native_range);
                heightTextView.setText("Height: " + Anhui_Barberry.height);
                suggestedUseTextView.setText("Suggested Use: " + Anhui_Barberry.suggested_use);
                evergreenTextView.setText("Evergreen: " + Anhui_Barberry.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Anhui_Barberry.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Anhui_Barberry.characteristics));
                problems = new ArrayList<>(Arrays.asList(Anhui_Barberry.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Anhui_Barberry.garden_uses));
                break;

            case "Beales_Barberry":
                scientificNameTextView.setText(Beales_Barberry.scientificName);
                otherNameTextView.setText("Common Name: " + Beales_Barberry.other_name);
                typeTextView.setText("Type: " + Beales_Barberry.type);
                familyTextView.setText("Family: " + Beales_Barberry.family);
                nativeRangeTextView.setText("Native Range: " + Beales_Barberry.native_range);
                heightTextView.setText("Height: " + Beales_Barberry.height);
                suggestedUseTextView.setText("Suggested Use: " + Beales_Barberry.suggested_use);
                evergreenTextView.setText("Evergreen: " + Beales_Barberry.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Beales_Barberry.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Beales_Barberry.characteristics));
                problems = new ArrayList<>(Arrays.asList(Beales_Barberry.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Beales_Barberry.garden_uses));
                break;

            case "Big_Fruited_Holly":
                scientificNameTextView.setText(Big_Fruited_Holly.scientificName);
                otherNameTextView.setText("Common Name: " + Big_Fruited_Holly.other_name);
                typeTextView.setText("Type: " + Big_Fruited_Holly.type);
                familyTextView.setText("Family: " + Big_Fruited_Holly.family);
                nativeRangeTextView.setText("Native Range: " + Big_Fruited_Holly.native_range);
                heightTextView.setText("Height: " + Big_Fruited_Holly.height);
                suggestedUseTextView.setText("Suggested Use: " + Big_Fruited_Holly.suggested_use);
                evergreenTextView.setText("Evergreen: " + Big_Fruited_Holly.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Big_Fruited_Holly.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Big_Fruited_Holly.characteristics));
                problems = new ArrayList<>(Arrays.asList(Big_Fruited_Holly.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Big_Fruited_Holly.garden_uses));
                break;

            case "Camphortree":
                scientificNameTextView.setText(Camphortree.scientificName);
                otherNameTextView.setText("Common Name: " + Camphortree.other_name);
                typeTextView.setText("Type: " + Camphortree.type);
                familyTextView.setText("Family: " + Camphortree.family);
                nativeRangeTextView.setText("Native Range: " + Camphortree.native_range);
                heightTextView.setText("Height: " + Camphortree.height);
                suggestedUseTextView.setText("Suggested Use: " + Camphortree.suggested_use);
                evergreenTextView.setText("Evergreen: " + Camphortree.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Camphortree.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Camphortree.characteristics));
                problems = new ArrayList<>(Arrays.asList(Camphortree.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Camphortree.garden_uses));
                break;

            case "Canadian_Poplar":
                scientificNameTextView.setText(Canadian_Poplar.scientificName);
                otherNameTextView.setText("Common Name: " + Canadian_Poplar.other_name);
                typeTextView.setText("Type: " + Canadian_Poplar.type);
                familyTextView.setText("Family: " + Canadian_Poplar.family);
                nativeRangeTextView.setText("Native Range: " + Canadian_Poplar.native_range);
                heightTextView.setText("Height: " + Canadian_Poplar.height);
                suggestedUseTextView.setText("Suggested Use: " + Canadian_Poplar.suggested_use);
                evergreenTextView.setText("Evergreen: " + Canadian_Poplar.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Canadian_Poplar.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Canadian_Poplar.characteristics));
                problems = new ArrayList<>(Arrays.asList(Canadian_Poplar.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Canadian_Poplar.garden_uses));
                break;

            case "Castor_Aralia":
                scientificNameTextView.setText(Castor_Aralia.scientificName);
                otherNameTextView.setText("Common Name: " + Castor_Aralia.other_name);
                typeTextView.setText("Type: " + Castor_Aralia.type);
                familyTextView.setText("Family: " + Castor_Aralia.family);
                nativeRangeTextView.setText("Native Range: " + Castor_Aralia.native_range);
                heightTextView.setText("Height: " + Castor_Aralia.height);
                suggestedUseTextView.setText("Suggested Use: " + Castor_Aralia.suggested_use);
                evergreenTextView.setText("Evergreen: " + Castor_Aralia.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Castor_Aralia.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Castor_Aralia.characteristics));
                problems = new ArrayList<>(Arrays.asList(Castor_Aralia.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Castor_Aralia.garden_uses));
                break;

            case "Chinese_Cinnamon":
                scientificNameTextView.setText(Chinese_Cinnamon.scientificName);
                otherNameTextView.setText("Common Name: " + Chinese_Cinnamon.other_name);
                typeTextView.setText("Type: " + Chinese_Cinnamon.type);
                familyTextView.setText("Family: " + Chinese_Cinnamon.family);
                nativeRangeTextView.setText("Native Range: " + Chinese_Cinnamon.native_range);
                heightTextView.setText("Height: " + Chinese_Cinnamon.height);
                suggestedUseTextView.setText("Suggested Use: " + Chinese_Cinnamon.suggested_use);
                evergreenTextView.setText("Evergreen: " + Chinese_Cinnamon.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Chinese_Cinnamon.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Chinese_Cinnamon.characteristics));
                problems = new ArrayList<>(Arrays.asList(Chinese_Cinnamon.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Chinese_Cinnamon.garden_uses));
                break;

            case "Chinese_Horse_Chestnut":
                scientificNameTextView.setText(Chinese_Horse_Chestnut.scientificName);
                otherNameTextView.setText("Common Name: " + Chinese_Horse_Chestnut.other_name);
                typeTextView.setText("Type: " + Chinese_Horse_Chestnut.type);
                familyTextView.setText("Family: " + Chinese_Horse_Chestnut.family);
                nativeRangeTextView.setText("Native Range: " + Chinese_Horse_Chestnut.native_range);
                heightTextView.setText("Height: " + Chinese_Horse_Chestnut.height);
                suggestedUseTextView.setText("Suggested Use: " + Chinese_Horse_Chestnut.suggested_use);
                evergreenTextView.setText("Evergreen: " + Chinese_Horse_Chestnut.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Chinese_Horse_Chestnut.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Chinese_Horse_Chestnut.characteristics));
                problems = new ArrayList<>(Arrays.asList(Chinese_Horse_Chestnut.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Chinese_Horse_Chestnut.garden_uses));
                break;

            case "Chinese_Redbud":
                scientificNameTextView.setText(Chinese_Redbud.scientificName);
                otherNameTextView.setText("Common Name: " + Chinese_Redbud.other_name);
                typeTextView.setText("Type: " + Chinese_Redbud.type);
                familyTextView.setText("Family: " + Chinese_Redbud.family);
                nativeRangeTextView.setText("Native Range: " + Chinese_Redbud.native_range);
                heightTextView.setText("Height: " + Chinese_Redbud.height);
                suggestedUseTextView.setText("Suggested Use: " + Chinese_Redbud.suggested_use);
                evergreenTextView.setText("Evergreen: " + Chinese_Redbud.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Chinese_Redbud.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Chinese_Redbud.characteristics));
                problems = new ArrayList<>(Arrays.asList(Chinese_Redbud.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Chinese_Redbud.garden_uses));
                break;

            case "Chinese_Toon":
                scientificNameTextView.setText(Chinese_Toon.scientificName);
                otherNameTextView.setText("Common Name: " + Chinese_Toon.other_name);
                typeTextView.setText("Type: " + Chinese_Toon.type);
                familyTextView.setText("Family: " + Chinese_Toon.family);
                nativeRangeTextView.setText("Native Range: " + Chinese_Toon.native_range);
                heightTextView.setText("Height: " + Chinese_Toon.height);
                suggestedUseTextView.setText("Suggested Use: " + Chinese_Toon.suggested_use);
                evergreenTextView.setText("Evergreen: " + Chinese_Toon.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Chinese_Toon.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Chinese_Toon.characteristics));
                problems = new ArrayList<>(Arrays.asList(Chinese_Toon.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Chinese_Toon.garden_uses));
                break;

            case "Chinese_Tulip_Tree":
                scientificNameTextView.setText(Chinese_Tulip_Tree.scientificName);
                otherNameTextView.setText("Common Name: " + Chinese_Tulip_Tree.other_name);
                typeTextView.setText("Type: " + Chinese_Tulip_Tree.type);
                familyTextView.setText("Family: " + Chinese_Tulip_Tree.family);
                nativeRangeTextView.setText("Native Range: " + Chinese_Tulip_Tree.native_range);
                heightTextView.setText("Height: " + Chinese_Tulip_Tree.height);
                suggestedUseTextView.setText("Suggested Use: " + Chinese_Tulip_Tree.suggested_use);
                evergreenTextView.setText("Evergreen: " + Chinese_Tulip_Tree.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Chinese_Tulip_Tree.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Chinese_Tulip_Tree.characteristics));
                problems = new ArrayList<>(Arrays.asList(Chinese_Tulip_Tree.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Chinese_Tulip_Tree.garden_uses));
                break;

            case "Crape_Myrtle":
                scientificNameTextView.setText(Crape_Myrtle.scientificName);
                otherNameTextView.setText("Common Name: " + Crape_Myrtle.other_name);
                typeTextView.setText("Type: " + Crape_Myrtle.type);
                familyTextView.setText("Family: " + Crape_Myrtle.family);
                nativeRangeTextView.setText("Native Range: " + Crape_Myrtle.native_range);
                heightTextView.setText("Height: " + Crape_Myrtle.height);
                suggestedUseTextView.setText("Suggested Use: " + Crape_Myrtle.suggested_use);
                evergreenTextView.setText("Evergreen: " + Crape_Myrtle.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Crape_Myrtle.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Crape_Myrtle.characteristics));
                problems = new ArrayList<>(Arrays.asList(Crape_Myrtle.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Crape_Myrtle.garden_uses));
                break;

            case "Deodar":
                scientificNameTextView.setText(Deodar.scientificName);
                otherNameTextView.setText("Common Name: " + Deodar.other_name);
                typeTextView.setText("Type: " + Deodar.type);
                familyTextView.setText("Family: " + Deodar.family);
                nativeRangeTextView.setText("Native Range: " + Deodar.native_range);
                heightTextView.setText("Height: " + Deodar.height);
                suggestedUseTextView.setText("Suggested Use: " + Deodar.suggested_use);
                evergreenTextView.setText("Evergreen: " + Deodar.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Deodar.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Deodar.characteristics));
                problems = new ArrayList<>(Arrays.asList(Deodar.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Deodar.garden_uses));
                break;

            case "Ford_Woodlotus":
                scientificNameTextView.setText(Ford_Woodlotus.scientificName);
                otherNameTextView.setText("Common Name: " + Ford_Woodlotus.other_name);
                typeTextView.setText("Type: " + Ford_Woodlotus.type);
                familyTextView.setText("Family: " + Ford_Woodlotus.family);
                nativeRangeTextView.setText("Native Range: " + Ford_Woodlotus.native_range);
                heightTextView.setText("Height: " + Ford_Woodlotus.height);
                suggestedUseTextView.setText("Suggested Use: " + Ford_Woodlotus.suggested_use);
                evergreenTextView.setText("Evergreen: " + Ford_Woodlotus.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Ford_Woodlotus.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Ford_Woodlotus.characteristics));
                problems = new ArrayList<>(Arrays.asList(Ford_Woodlotus.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Ford_Woodlotus.garden_uses));
                break;

            case "Glossy_Privet":
                scientificNameTextView.setText(Glossy_Privet.scientificName);
                otherNameTextView.setText("Common Name: " + Glossy_Privet.other_name);
                typeTextView.setText("Type: " + Glossy_Privet.type);
                familyTextView.setText("Family: " + Glossy_Privet.family);
                nativeRangeTextView.setText("Native Range: " + Glossy_Privet.native_range);
                heightTextView.setText("Height: " + Glossy_Privet.height);
                suggestedUseTextView.setText("Suggested Use: " + Glossy_Privet.suggested_use);
                evergreenTextView.setText("Evergreen: " + Glossy_Privet.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Glossy_Privet.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Glossy_Privet.characteristics));
                problems = new ArrayList<>(Arrays.asList(Glossy_Privet.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Glossy_Privet.garden_uses));
                break;

            case "Goldenrain_Tree":
                scientificNameTextView.setText(Goldenrain_Tree.scientificName);
                otherNameTextView.setText("Common Name: " + Goldenrain_Tree.other_name);
                typeTextView.setText("Type: " + Goldenrain_Tree.type);
                familyTextView.setText("Family: " + Goldenrain_Tree.family);
                nativeRangeTextView.setText("Native Range: " + Goldenrain_Tree.native_range);
                heightTextView.setText("Height: " + Goldenrain_Tree.height);
                suggestedUseTextView.setText("Suggested Use: " + Goldenrain_Tree.suggested_use);
                evergreenTextView.setText("Evergreen: " + Goldenrain_Tree.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Goldenrain_Tree.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Goldenrain_Tree.characteristics));
                problems = new ArrayList<>(Arrays.asList(Goldenrain_Tree.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Goldenrain_Tree.garden_uses));
                break;

            case "Japan_Arrowwood":
                scientificNameTextView.setText(Japan_Arrowwood.scientificName);
                otherNameTextView.setText("Common Name: " + Japan_Arrowwood.other_name);
                typeTextView.setText("Type: " + Japan_Arrowwood.type);
                familyTextView.setText("Family: " + Japan_Arrowwood.family);
                nativeRangeTextView.setText("Native Range: " + Japan_Arrowwood.native_range);
                heightTextView.setText("Height: " + Japan_Arrowwood.height);
                suggestedUseTextView.setText("Suggested Use: " + Japan_Arrowwood.suggested_use);
                evergreenTextView.setText("Evergreen: " + Japan_Arrowwood.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Japan_Arrowwood.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Japan_Arrowwood.characteristics));
                problems = new ArrayList<>(Arrays.asList(Japan_Arrowwood.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Japan_Arrowwood.garden_uses));
                break;

            case "Japanese_Cheesewood":
                scientificNameTextView.setText(Japanese_Cheesewood.scientificName);
                otherNameTextView.setText("Common Name: " + Japanese_Cheesewood.other_name);
                typeTextView.setText("Type: " + Japanese_Cheesewood.type);
                familyTextView.setText("Family: " + Japanese_Cheesewood.family);
                nativeRangeTextView.setText("Native Range: " + Japanese_Cheesewood.native_range);
                heightTextView.setText("Height: " + Japanese_Cheesewood.height);
                suggestedUseTextView.setText("Suggested Use: " + Japanese_Cheesewood.suggested_use);
                evergreenTextView.setText("Evergreen: " + Japanese_Cheesewood.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Japanese_Cheesewood.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Japanese_Cheesewood.characteristics));
                problems = new ArrayList<>(Arrays.asList(Japanese_Cheesewood.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Japanese_Cheesewood.garden_uses));
                break;

            case "Japanese_Flowering_Cherry":
                scientificNameTextView.setText(Japanese_Flowering_Cherry.scientificName);
                otherNameTextView.setText("Common Name: " + Japanese_Flowering_Cherry.other_name);
                typeTextView.setText("Type: " + Japanese_Flowering_Cherry.type);
                familyTextView.setText("Family: " + Japanese_Flowering_Cherry.family);
                nativeRangeTextView.setText("Native Range: " + Japanese_Flowering_Cherry.native_range);
                heightTextView.setText("Height: " + Japanese_Flowering_Cherry.height);
                suggestedUseTextView.setText("Suggested Use: " + Japanese_Flowering_Cherry.suggested_use);
                evergreenTextView.setText("Evergreen: " + Japanese_Flowering_Cherry.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Japanese_Flowering_Cherry.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Japanese_Flowering_Cherry.characteristics));
                problems = new ArrayList<>(Arrays.asList(Japanese_Flowering_Cherry.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Japanese_Flowering_Cherry.garden_uses));
                break;

            case "Japanese_Maple":
                scientificNameTextView.setText(Japanese_Maple.scientificName);
                otherNameTextView.setText("Common Name: " + Japanese_Maple.other_name);
                typeTextView.setText("Type: " + Japanese_Maple.type);
                familyTextView.setText("Family: " + Japanese_Maple.family);
                nativeRangeTextView.setText("Native Range: " + Japanese_Maple.native_range);
                heightTextView.setText("Height: " + Japanese_Maple.height);
                suggestedUseTextView.setText("Suggested Use: " + Japanese_Maple.suggested_use);
                evergreenTextView.setText("Evergreen: " + Japanese_Maple.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Japanese_Maple.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Japanese_Maple.characteristics));
                problems = new ArrayList<>(Arrays.asList(Japanese_Maple.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Japanese_Maple.garden_uses));
                break;

            case "Maidenhair_Tree":
                scientificNameTextView.setText(Maidenhair_Tree.scientificName);
                otherNameTextView.setText("Common Name: " + Maidenhair_Tree.other_name);
                typeTextView.setText("Type: " + Maidenhair_Tree.type);
                familyTextView.setText("Family: " + Maidenhair_Tree.family);
                nativeRangeTextView.setText("Native Range: " + Maidenhair_Tree.native_range);
                heightTextView.setText("Height: " + Maidenhair_Tree.height);
                suggestedUseTextView.setText("Suggested Use: " + Maidenhair_Tree.suggested_use);
                evergreenTextView.setText("Evergreen: " + Maidenhair_Tree.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Maidenhair_Tree.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Maidenhair_Tree.characteristics));
                problems = new ArrayList<>(Arrays.asList(Maidenhair_Tree.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Maidenhair_Tree.garden_uses));
                break;

            case "Nanmu":
                scientificNameTextView.setText(Nanmu.scientificName);
                otherNameTextView.setText("Common Name: " + Nanmu.other_name);
                typeTextView.setText("Type: " + Nanmu.type);
                familyTextView.setText("Family: " + Nanmu.family);
                nativeRangeTextView.setText("Native Range: " + Nanmu.native_range);
                heightTextView.setText("Height: " + Nanmu.height);
                suggestedUseTextView.setText("Suggested Use: " + Nanmu.suggested_use);
                evergreenTextView.setText("Evergreen: " + Nanmu.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Nanmu.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Nanmu.characteristics));
                problems = new ArrayList<>(Arrays.asList(Nanmu.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Nanmu.garden_uses));
                break;

            case "Oleander":
                scientificNameTextView.setText(Oleander.scientificName);
                otherNameTextView.setText("Common Name: " + Oleander.other_name);
                typeTextView.setText("Type: " + Oleander.type);
                familyTextView.setText("Family: " + Oleander.family);
                nativeRangeTextView.setText("Native Range: " + Oleander.native_range);
                heightTextView.setText("Height: " + Oleander.height);
                suggestedUseTextView.setText("Suggested Use: " + Oleander.suggested_use);
                evergreenTextView.setText("Evergreen: " + Oleander.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Oleander.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Oleander.characteristics));
                problems = new ArrayList<>(Arrays.asList(Oleander.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Oleander.garden_uses));
                break;

            case "Peach":
                scientificNameTextView.setText(Peach.scientificName);
                otherNameTextView.setText("Common Name: " + Peach.other_name);
                typeTextView.setText("Type: " + Peach.type);
                familyTextView.setText("Family: " + Peach.family);
                nativeRangeTextView.setText("Native Range: " + Peach.native_range);
                heightTextView.setText("Height: " + Peach.height);
                suggestedUseTextView.setText("Suggested Use: " + Peach.suggested_use);
                evergreenTextView.setText("Evergreen: " + Peach.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Peach.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Peach.characteristics));
                problems = new ArrayList<>(Arrays.asList(Peach.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Peach.garden_uses));
                break;

            case "Pubescent_Bamboo":
                scientificNameTextView.setText(Pubescent_Bamboo.scientificName);
                otherNameTextView.setText("Common Name: " + Pubescent_Bamboo.other_name);
                typeTextView.setText("Type: " + Pubescent_Bamboo.type);
                familyTextView.setText("Family: " + Pubescent_Bamboo.family);
                nativeRangeTextView.setText("Native Range: " + Pubescent_Bamboo.native_range);
                heightTextView.setText("Height: " + Pubescent_Bamboo.height);
                suggestedUseTextView.setText("Suggested Use: " + Pubescent_Bamboo.suggested_use);
                evergreenTextView.setText("Evergreen: " + Pubescent_Bamboo.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Pubescent_Bamboo.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Pubescent_Bamboo.characteristics));
                problems = new ArrayList<>(Arrays.asList(Pubescent_Bamboo.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Pubescent_Bamboo.garden_uses));
                break;

            case "Southern_Magnolia":
                scientificNameTextView.setText(Southern_Magnolia.scientificName);
                otherNameTextView.setText("Common Name: " + Southern_Magnolia.other_name);
                typeTextView.setText("Type: " + Southern_Magnolia.type);
                familyTextView.setText("Family: " + Southern_Magnolia.family);
                nativeRangeTextView.setText("Native Range: " + Southern_Magnolia.native_range);
                heightTextView.setText("Height: " + Southern_Magnolia.height);
                suggestedUseTextView.setText("Suggested Use: " + Southern_Magnolia.suggested_use);
                evergreenTextView.setText("Evergreen: " + Southern_Magnolia.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Southern_Magnolia.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Southern_Magnolia.characteristics));
                problems = new ArrayList<>(Arrays.asList(Southern_Magnolia.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Southern_Magnolia.garden_uses));
                break;

            case "Sweet_Osmanthus":
                scientificNameTextView.setText(Sweet_Osmanthus.scientificName);
                otherNameTextView.setText("Common Name: " + Sweet_Osmanthus.other_name);
                typeTextView.setText("Type: " + Sweet_Osmanthus.type);
                familyTextView.setText("Family: " + Sweet_Osmanthus.family);
                nativeRangeTextView.setText("Native Range: " + Sweet_Osmanthus.native_range);
                heightTextView.setText("Height: " + Sweet_Osmanthus.height);
                suggestedUseTextView.setText("Suggested Use: " + Sweet_Osmanthus.suggested_use);
                evergreenTextView.setText("Evergreen: " + Sweet_Osmanthus.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Sweet_Osmanthus.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Sweet_Osmanthus.characteristics));
                problems = new ArrayList<>(Arrays.asList(Sweet_Osmanthus.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Sweet_Osmanthus.garden_uses));
                break;

            case "Tangerine":
                scientificNameTextView.setText(Tangerine.scientificName);
                otherNameTextView.setText("Common Name: " + Tangerine.other_name);
                typeTextView.setText("Type: " + Tangerine.type);
                familyTextView.setText("Family: " + Tangerine.family);
                nativeRangeTextView.setText("Native Range: " + Tangerine.native_range);
                heightTextView.setText("Height: " + Tangerine.height);
                suggestedUseTextView.setText("Suggested Use: " + Tangerine.suggested_use);
                evergreenTextView.setText("Evergreen: " + Tangerine.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Tangerine.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Tangerine.characteristics));
                problems = new ArrayList<>(Arrays.asList(Tangerine.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Tangerine.garden_uses));
                break;

            case "Trident_Maple":
                scientificNameTextView.setText(Trident_Maple.scientificName);
                otherNameTextView.setText("Common Name: " + Trident_Maple.other_name);
                typeTextView.setText("Type: " + Trident_Maple.type);
                familyTextView.setText("Family: " + Trident_Maple.family);
                nativeRangeTextView.setText("Native Range: " + Trident_Maple.native_range);
                heightTextView.setText("Height: " + Trident_Maple.height);
                suggestedUseTextView.setText("Suggested Use: " + Trident_Maple.suggested_use);
                evergreenTextView.setText("Evergreen: " + Trident_Maple.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Trident_Maple.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Trident_Maple.characteristics));
                problems = new ArrayList<>(Arrays.asList(Trident_Maple.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Trident_Maple.garden_uses));
                break;

            case "True_Indigo":
                scientificNameTextView.setText(True_Indigo.scientificName);
                otherNameTextView.setText("Common Name: " + True_Indigo.other_name);
                typeTextView.setText("Type: " + True_Indigo.type);
                familyTextView.setText("Family: " + True_Indigo.family);
                nativeRangeTextView.setText("Native Range: " + True_Indigo.native_range);
                heightTextView.setText("Height: " + True_Indigo.height);
                suggestedUseTextView.setText("Suggested Use: " + True_Indigo.suggested_use);
                evergreenTextView.setText("Evergreen: " + True_Indigo.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(True_Indigo.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(True_Indigo.characteristics));
                problems = new ArrayList<>(Arrays.asList(True_Indigo.problems));
                garden_uses = new ArrayList<>(Arrays.asList(True_Indigo.garden_uses));
                break;

            case "Wintersweet":
                scientificNameTextView.setText(Wintersweet.scientificName);
                otherNameTextView.setText("Common Name: " + Wintersweet.other_name);
                typeTextView.setText("Type: " + Wintersweet.type);
                familyTextView.setText("Family: " + Wintersweet.family);
                nativeRangeTextView.setText("Native Range: " + Wintersweet.native_range);
                heightTextView.setText("Height: " + Wintersweet.height);
                suggestedUseTextView.setText("Suggested Use: " + Wintersweet.suggested_use);
                evergreenTextView.setText("Evergreen: " + Wintersweet.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Wintersweet.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Wintersweet.characteristics));
                problems = new ArrayList<>(Arrays.asList(Wintersweet.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Wintersweet.garden_uses));
                break;

            case "Yew_Plum_Pine":
                scientificNameTextView.setText(Yew_Plum_Pine.scientificName);
                otherNameTextView.setText("Common Name: " + Yew_Plum_Pine.other_name);
                typeTextView.setText("Type: " + Yew_Plum_Pine.type);
                familyTextView.setText("Family: " + Yew_Plum_Pine.family);
                nativeRangeTextView.setText("Native Range: " + Yew_Plum_Pine.native_range);
                heightTextView.setText("Height: " + Yew_Plum_Pine.height);
                suggestedUseTextView.setText("Suggested Use: " + Yew_Plum_Pine.suggested_use);
                evergreenTextView.setText("Evergreen: " + Yew_Plum_Pine.evergreen);
                cultivation = new ArrayList<>(Arrays.asList(Yew_Plum_Pine.cultivation));
                characteristics = new ArrayList<>(Arrays.asList(Yew_Plum_Pine.characteristics));
                problems = new ArrayList<>(Arrays.asList(Yew_Plum_Pine.problems));
                garden_uses = new ArrayList<>(Arrays.asList(Yew_Plum_Pine.garden_uses));
                break;

            default:
                scientificNameTextView.setText("Not Found");
                otherNameTextView.setText("Common Name: " + "Not Found");
                typeTextView.setText("Type: " + "Not Found");
                familyTextView.setText("Family: " + "Not Found");
                nativeRangeTextView.setText("Native Range: " + "Not Found");
                heightTextView.setText("Height: " + "Not Found");
                suggestedUseTextView.setText("Suggested Use: " + "Not Found");
                evergreenTextView.setText("Evergreen: " + "Not Found");
                cultivation = Collections.singletonList("Not Available");
                characteristics = Collections.singletonList("Not Available");
                problems = Collections.singletonList("Not Available");
                garden_uses = Collections.singletonList("Not Available");
                break;
        }
        points.put(titles.get(0), cultivation); //puts respective points to their own titles
        points.put(titles.get(1), characteristics);
        points.put(titles.get(2), problems);
        points.put(titles.get(3), garden_uses);
    }
}
