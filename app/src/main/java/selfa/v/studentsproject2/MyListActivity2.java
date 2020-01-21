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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListActivity2 extends MainMenu {

    // Example of using an ArrayAdapter class

    private String[] writersName = {"Jaume Cabré", "John Grisman", "Santiago Posteguillo"};
    private int[] writersPhoto = {R.drawable.jaume_cabre, R.drawable.john_grisham, R.drawable.santiago_posteguillo};

    private String[] books = {"Senyoria", "Càmara de gas", "Els assassins de l'emperador"};
    private int[] photosBooks = {R.drawable.senyoria, R.drawable.camara_de_gas, R.drawable.assassins_emperador};

    private ListView myWritersListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Construct the data source
        ArrayList<MyWriter> myWriters = new ArrayList<MyWriter>();
        for (int i=0; i<3; i++) {
            // Create a writer object
            MyWriter aux = new MyWriter(writersName[i], writersPhoto[i]);
            // Add to the ArrayList
            myWriters.add(aux);
        }

        // Create the adapter to convert the array to views
        MyWritersAdapter adapter = new MyWritersAdapter(this, myWriters);
        // Attach the adapter to a ListView
        myWritersListView = findViewById(R.id.lstWriters2);
        myWritersListView.setAdapter(adapter);

        myWritersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                buildDialog ( writersName[position], getString(R.string.book) + ": " + books [position], position );
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
