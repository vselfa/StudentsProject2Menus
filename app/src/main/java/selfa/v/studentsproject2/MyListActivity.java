package selfa.v.studentsproject2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyListActivity extends MainMenu {

    private String[] names = {"Jaume Cabré", "John Grisman", "Santiago Posteguillo"};
    private String[] books = {"Senyoria", "Càmara de gas", "Els assassins de l'emperador"};
    private int[] photosWriters = {R.drawable.jaume_cabre, R.drawable.john_grisham, R.drawable.santiago_posteguillo};
    private int[] photosBooks = {R.drawable.senyoria, R.drawable.camara_de_gas, R.drawable.assassins_emperador};
    private ListView myWriters;
    TextView textWriters;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        List<Map<String ,Object>> data = new ArrayList<Map<String , Object>>();
        for (int i = 0; i < 3; i++) {
            Map<String ,Object> datum = new HashMap<String ,Object>(2);
            datum.put("photo", photosWriters[i]);
            datum.put("name", names[i]);
            data.add(datum);

            Log.d("Fotos", "Fotos i: " + i + " " + data.get(i));

        }

        textWriters = findViewById(R.id.textWriters);
        textWriters.setText(R.string.text_writers);
        myWriters = findViewById(R.id.lstWriters);
        myWriters.setAdapter(new SimpleAdapter(this, data, R.layout.item_list,
                new String[] {"photo","name"}, new int[] {R.id.photo, R.id.name}));


        myWriters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                buildDialog ( names[position], getString(R.string.book) + ": " + books [position], position );
            }
        });

    }



    // Out of onCreate
    public void buildDialog (String title, String message, int position) {
        // Imprescindible instanciar una nova imatge cada vegada!!!
        // Per evitar problemes del tipus: The specified child already has a parent.
        final ImageView image = new ImageView(this);
        image.setImageResource(photosBooks[position]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.setView(image);

        Log.d("Fotos", "Image: " + image);

        builder.create();
        builder.show();
    }


}
