package pdm.pratica09;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;

public class CityAdapter extends ArrayAdapter {

    RequestQueue queue;
    private City [] cities;
    public CityAdapter(Context context, int resource, City [] cities, RequestQueue queue) {
        super(context, resource, cities);
        this.cities = cities;
        this.queue = queue;
    }

    private void loadInBackground(final TextView weatherView, final City city) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority("api.openweathermap.org");
        builder.appendPath("data/2.5/weather");
        builder.appendQueryParameter("q", city.getName());
        builder.appendQueryParameter("mode", "json");
        builder.appendQueryParameter("units","metric");
        builder.appendQueryParameter("APPID", "a11ac945f2360e8cf7d496e7cb53dc00");
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                builder.build().toString(), null,
                response -> {
                    String weatherStr = getWeather(response);
                    if (weatherStr != null) {
                        city.setWeather(weatherStr);
                        weatherView.setText(weatherStr);
                    } else {
                        weatherView.setText("Erro!");
                    }
                },
                error -> weatherView.setText("Erro!"));
        queue.add(request);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View listItem = null;
        ViewHolder holder = null;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            listItem = inflater.inflate(R.layout.city_listitem, null, true);
            holder = new ViewHolder();
            holder.cityName = listItem.findViewById(R.id.city_name);
            holder.cityInfo = listItem.findViewById(R.id.city_info);
            listItem.setTag(holder);
        } else {
            listItem = view;
            holder = (ViewHolder)view.getTag();
        }
        holder.cityName.setText(cities[position].getName());
        if (cities[position].getWeather() != null) {
            holder.cityInfo.setText(cities[position].getWeather());
        } else {
            final City city = cities[position];
            final TextView weather = holder.cityInfo;
            weather.setText("Loading weather...");
            loadInBackground(weather, city);
        }
        return listItem;
    }

    static class ViewHolder {
        TextView cityName;
        TextView cityInfo;
    }
}
