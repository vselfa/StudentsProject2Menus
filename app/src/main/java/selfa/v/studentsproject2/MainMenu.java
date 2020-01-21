package selfa.v.studentsproject2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainMenu  extends AppCompatActivity {

    static String myMenuOption, myNewspaper;

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
        if (id == R.id.home) {
            Intent intent = new Intent (this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.my_buttons) {
            Intent intent = new Intent (this, MyButtonsActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.my_list) {
            Intent intent = new Intent (this, MyListActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.my_list2) {
            Intent intent = new Intent (this, MyListActivity2.class);
            startActivity(intent);
            return true;
        }

        // Menu options
        if (id == R.id.menuLevante) {
            Intent intent = new Intent (this, MyWebsActivity.class);
            startActivity(intent);
            myMenuOption = getString(R.string.levante_url);
            myNewspaper =  getString(R.string.levante);
            return true;
        }
        if (id == R.id.menuElDiarioEs) {
            Intent intent = new Intent (this, MyWebsActivity.class);
            startActivity(intent);
            myMenuOption = getString(R.string.el_diario_url);
            myNewspaper =  getString(R.string.el_diario);
            return true;
        }




        return super.onOptionsItemSelected(item);
    }
}
