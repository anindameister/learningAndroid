package com.poulomi.internshipedge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListOfEdge extends AppCompatActivity {

    RecyclerView recyclerView;
    private Adapter.RecyclerViewClickListener listener;
    private RequestQueue queue;
    List<Edges> allEdges;
    private static String url = "https://territoire.emse.fr/apps-library/osmhandler/edge-internship?city=stetienne&min_longitude=4.3820&min_latitude=45.4327&max_longitude=4.4004&max_latitude=45.4436";
    Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_edge);
        queue = Volley.newRequestQueue(this);

        recyclerView = findViewById(R.id.edgeList);
        allEdges = new ArrayList<>();
        parseJson();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new Adapter(this, allEdges,listener);
        recyclerView.setAdapter(adapter);

    }


    private void parseJson() {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Edges edges = new Edges();

                                edges.setOsm_id("osm_id:"+jsonObject.getString("osm_id").toString());
                                edges.setNameline("Name:"+jsonObject.getString("name").toString());
                                edges.setWay("Way:"+jsonObject.getString("way").toString());
                                edges.setHighway("Highway:"+jsonObject.getString("highway").toString());
                                edges.setMaxspeed("MaxSpeed:"+jsonObject.getString("maxspeed").toString());
                                allEdges.add(edges);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        setOnClickListener();
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        adapter = new Adapter(getApplicationContext(),allEdges,listener);
                        recyclerView.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(request);

    }

    private void setOnClickListener() {
     listener=  new Adapter.RecyclerViewClickListener() {
         @Override
         public void onClick(View v, int position) {
             Intent intent= new Intent(ListOfEdge.this, OnlineUpdateActivity.class);
            // Log.d("I am here","check me out");
             String speedmax= allEdges.get(position).getMaxspeed();
             String osm_id= allEdges.get(position).getOsm_id();
             String value = speedmax.split(":")[1];
             String value_1 = osm_id.split(":")[1];
            // Log.d("I am inside onClick---", value);
             intent.putExtra("MaxSpeed",value);
             intent.putExtra("osm_id",value_1);
             startActivity(intent);
         }
     };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edge_list_menu,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

}
