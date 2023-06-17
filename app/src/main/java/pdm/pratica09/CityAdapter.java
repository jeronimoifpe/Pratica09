package pdm.pratica09;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CityAdapter extends ArrayAdapter {
    private City [] cities;
    public CityAdapter(Context context, int resource, City [] cities) {
        super(context, resource, cities);
        this.cities = cities;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View listItem = null;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            listItem = inflater.inflate(R.layout.city_listitem, null, true);
        } else {
            listItem = view;
        }
        TextView cityName = listItem.findViewById(R.id.city_name);
        TextView cityInfo = listItem.findViewById(R.id.city_info);
        cityName.setText(cities[position].getName());
        cityInfo.setText(cities[position].getInfo());
        return listItem;
    }
}
