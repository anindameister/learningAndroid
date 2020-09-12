package com.poulomi.internshipedge;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class OnlineUpdateActivity extends AppCompatActivity {
    Button update;
    EditText maxSpeed;
     TextView id;
    private RequestQueue requestQueue;
    String maxspeed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_update);
        update= findViewById(R.id.update_button);
        maxSpeed = findViewById(R.id.maxspeed_input2);
        id=findViewById(R.id.osm_id_fetch);
        maxspeed = getIntent().getExtras().getString("MaxSpeed");
        final String osm_id = getIntent().getExtras().getString("osm_id");
         id.setText(osm_id);

        if (maxSpeed != null) {
            maxSpeed.setText(maxspeed);
        } else {
            //Log.d("I am in settext ", "555");
        }
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("------------------","======");
                String data =   "["+"{"+
                        "\"osm_id\"" +":"+ "\"" + id.getText().toString()+ "\","+
                        "\"maxspeed\"" +":"+ "\"" + maxspeed+ "\","+
                        "\"requested_maxspeed\"" +":"+ "\"" + maxSpeed.getText().toString() + "\""+
                        "}"+"]";
                Log.d("///////////////",data);
                 mySync(data);

            }
        });
    }

    private void mySync(String data) {
        final String savedata= data;
        String URL="http://10.42.3.241:5004/post_edge";  //10.42.3.241 for real device  //10.0.2.2 for emulator

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject objres=new JSONObject(response);
                    String msg = objres.get("msg").toString();
                   if (!(msg.equals("Updated Successfull!") || msg.equals("ReUpdated!")))
                   {
                       AlertDialog.Builder builder= new AlertDialog.Builder(OnlineUpdateActivity.this);
                       builder.setTitle("ALERT");
                       builder.setMessage(msg);
                       builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               Toast.makeText(OnlineUpdateActivity.this,"YES click",Toast.LENGTH_LONG).show();
                               String data2="["+"{"+
                                       "\"yes/no\"" +":"+ "\"" +"yes" + "\""+
                                       "}"+"]";
                               secondPOST(data2);
                           }
                       });
                       builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               String data2="["+"{"+
                                       "\"yes/no\"" +":"+ "\"" +"no" + "\""+
                                       "}"+"]";
                               secondPOST(data2);
                           }
                       }) ;
                       AlertDialog dialog= builder.create();
                       dialog.show();

//
                   }
                   //if(!objres.toString().equals("{"+"msg"+":"+"Updated Successfully!"+"}")  && !objres.toString().equals("{msg:Okay! already updated. }")){
                    else{
                       Toast.makeText(getApplicationContext(), objres.toString(), Toast.LENGTH_LONG).show();
                    }


                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();

                }
                //Log.i("VOLLEY", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "ERROR:404"+error.getMessage(), Toast.LENGTH_SHORT).show();

                Log.v("VOLLEY-------------", error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return savedata == null ? null : savedata.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    Log.d("--------", savedata);
                    return null;
                }
            }

        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(stringRequest);


    }

    private void secondPOST(String data2) {
        final String savedata2= data2;
        String URL="http://10.42.3.241:5004/yesORno";  //10.42.3.241 for real device  //10.0.2.2 for emulator//192.168.1.51:5003

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject objres=new JSONObject(response);

                        Toast.makeText(getApplicationContext(), objres.toString(), Toast.LENGTH_LONG).show();




                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();

                }
                //Log.i("VOLLEY", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "ERROR:404"+error.getMessage(), Toast.LENGTH_SHORT).show();

                Log.v("VOLLEY-------------", error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return savedata2 == null ? null : savedata2.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    Log.d("--------", savedata2);
                    return null;
                }
            }

        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(stringRequest);


    }

}
