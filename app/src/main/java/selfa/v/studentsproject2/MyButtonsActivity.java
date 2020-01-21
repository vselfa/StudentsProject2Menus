package selfa.v.studentsproject2;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MyButtonsActivity extends MainMenu implements CompoundButton.OnCheckedChangeListener  {

    Switch mySwitch = null;
    ToggleButton myToggleButton;
    TableLayout myTableLayout;
    TextView myTextView;
    ImageButton myImage; Boolean ON = true;
    RadioButton myRadioButtonWoman, myRadioButtonMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_buttons);
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

        // Controlers and views
        mySwitch = findViewById(R.id.switch1);
        myTableLayout = findViewById(R.id.tableLayout);
        myTextView = findViewById(R.id.textSwitch);
        myImage = findViewById(R.id.imageButton);
        myToggleButton = findViewById(R.id.toggleButton);
        myRadioButtonWoman = findViewById(R.id.radio_dona);
        myRadioButtonMan = findViewById(R.id.radio_home);


        // Actions
        mySwitch.setOnCheckedChangeListener(this);
        myToggleButton.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    displayToast ("Enabled!");
                } else {
                    displayToast ("Disabled!");
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            myTableLayout.setVisibility(View.VISIBLE);
            myTextView.setText(R.string.switch_on);

        } else {
            myTableLayout.setVisibility(View.INVISIBLE);
            myTextView.setText(R.string.switch_off);
        }
    }

    public void buttonONOFF (View v) {
        if (ON) {
            myImage.setImageResource(R.drawable.off);
            ON = false;
        }
        else {
            myImage.setImageResource(R.drawable.on);
            ON = true;
        }
    }

    public void displayToast (String text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);        toast.show();
    }

    public void buildDialog (String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("Cancel", null);
        builder.create();
        builder.show();
    }


    public void onRadioButtonClicked(View view) {

        String title = "Radio button action.";
        String text, message;
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which checkbox was clicked
        text = ((RadioButton) view).getText().toString();
        if (checked) {
            message = getString(R.string.selected_element) +" " + text;
            buildDialog(title, message);
        }
        else {
            buildDialog (title,  "No element selected");
        }

    }
}
