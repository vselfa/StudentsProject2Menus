package selfa.v.studentsproject2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyWritersAdapter extends ArrayAdapter {

    public MyWritersAdapter( Context context, List objects) {
        // (context, 0, objects) needed to match the parent constructor!!!
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MyWriter myWriter = (MyWriter) getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }
        // Lookup view for data population
        ImageView writerPhoto = convertView.findViewById(R.id.photo);
        TextView  writerName  = convertView.findViewById(R.id.name);
        // Populate the data into the template view using the data object
        writerPhoto.setImageResource(myWriter.getPhoto());
        writerName.setText(myWriter.getName());
        // Return the completed view to render on screen
        return convertView;
    }
}
