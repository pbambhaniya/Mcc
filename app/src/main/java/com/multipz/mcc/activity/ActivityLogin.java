package com.multipz.mcc.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.multipz.mcc.AppController;
import com.multipz.mcc.R;
import com.multipz.mcc.utils.BasicMethods;
import com.multipz.mcc.utils.ConstantMethods;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 22-11-2017.
 */

public class ActivityLogin extends AppCompatActivity implements BasicMethods{

    Context context;
    Button btnLogin;
    LinearLayout lnrFb, lnrGp;
    EditText edtName, edtPassword;
    TextView txtSignUp, txtSkip;
    ProgressDialog pDialog;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;

        initReferences();
        initialize();
    }

    @Override
    public void initReferences() {

        btnLogin = (Button) findViewById(R.id.btn_login);

        lnrFb = (LinearLayout) findViewById(R.id.lnr_login_fb);
        lnrGp = (LinearLayout) findViewById(R.id.lnr_login_gp);

        edtName = (EditText) findViewById(R.id.edt_uid);
        edtPassword = (EditText) findViewById(R.id.edt_pwd);

        txtSignUp = (TextView) findViewById(R.id.txt_signup);
        txtSkip = (TextView) findViewById(R.id.txt_skip);

    }

    @Override
    public void initialize() {


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isValid()) {
                    //startActivity(new Intent(context, ActivityMenu.class));


                    String tag_string_req = "string_req";

                    String url = "http://192.168.0.56/mccapi/public/api/v1/service";
                    pDialog = new ProgressDialog(ActivityLogin.this);
                    pDialog.setMessage("Loading...");
                    pDialog.show();


                    StringRequest strReq = new StringRequest(Request.Method.POST,
                            url, new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            String Message;
                            try {

                                Log.e("Response", response);

                                JSONObject jsonObject = new JSONObject(response);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            pDialog.hide();
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(context, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                            pDialog.hide();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            String param = "{\"action\":\"configData\"}";

                            params.put("json", param);
                            return params;
                        }
                    };

                    // Adding request to request queue
                    AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
                }
            }
        });


        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ActivityUserType.class));
            }
        });

        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ActivityMenu.class));
            }
        });

    }

    private boolean isValid() {

        if (edtName.getText().toString().contentEquals("")){
            ConstantMethods.Toaster(context,"Enter Name");
            return false;
        }
        if (edtPassword.getText().toString().contentEquals("")){
            ConstantMethods.Toaster(context,"Enter Password");
            return false;
        }

        return true;
    }
}
