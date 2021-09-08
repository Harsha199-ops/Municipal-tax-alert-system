package com.example.navigsample;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class watertax extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public watertax() {
        // Required empty public constructor
    }

    public static watertax newInstance(String param1, String param2) {
        watertax fragment = new watertax();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1= inflater.inflate(R.layout.fragment_watertax, container, false);
        final String[] s = {""};
        Button button=(Button) v1.findViewById(R.id.button3);
        Button add=(Button) v1.findViewById(R.id.addwt);
        TextView text= v1.findViewById(R.id.textView5);
        text.setMovementMethod(new ScrollingMovementMethod());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readw();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(watertax.this.getActivity(), writetowatertax.class);
                startActivity(intent);
            }
        });
        return v1;
    }
    public void readw()
    {
        String datan;
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference().child("water_tax");
        ValueEventListener valueEventListener = databaseRef.addValueEventListener((new ValueEventListener() {
            private static final String TAG = "";
            public String datan="";

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int t=1;

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    users mCategory = postSnapshot.getValue(users.class);
                    String mname=mCategory.getName();
                    String mamount=mCategory.getAmount();
                    String mnumber=mCategory.getNumber();
                    String mduedate=mCategory.getDuedate();

                    datan+= t+".Name: "+mname+"\n number: "+mnumber+"\n amount: "+mamount+"\n\n";

                    String data = "ప్రియమైన తాడిగడప నివాసుడా!\nమీరు నీటి పన్ను ఇంకా చెల్లించ లేదు!\nమీ వివరాలు చూడండి,\n\nమీ పేరు=" + mname + "\nఫోన్ నంబర్=" + mnumber + "\nమీ ఇంటి పన్ను:=" + mamount + "రూ\n\nమీరు ఆన్ లైన్ లో చెల్లించాలనుకుంటే ఈ లింక్ ని నొక్కండి\n https://vijayawada.emunicipal.ap.gov.in/ptis/citizen/search/search-searchForm.action#no-back-button\n\nదయచేసి ఈ తేదీ లోగా పన్ను చెల్లించండి" + mduedate + "\nమీరు ఇప్పటికే పన్ను కట్టినచో ఈ మెసేజ్ ని వదిలేయండి.\n\nధన్యవాదాలు\nజారీ చేయువారు,\nతాడిగడప మున్సిపాలిటీ";
                    try {
                        SmsManager smsManager=SmsManager.getDefault();
                        ArrayList<String> parts =smsManager.divideMessage(data);
                        int numParts = parts.size();

                        ArrayList<PendingIntent> sentIntents = new ArrayList<PendingIntent>();
                        ArrayList<PendingIntent> deliveryIntents = new ArrayList<PendingIntent>();

                        for (int k = 0; k < numParts; k++) {
                            Intent mSendIntent=new Intent();
                            sentIntents.add(PendingIntent.getBroadcast(getContext(), 0, mSendIntent, 0));
                            Intent mDeliveryIntent=new Intent();
                            deliveryIntents.add(PendingIntent.getBroadcast(getContext(), 0, mDeliveryIntent, 0));
                        }
                        smsManager.sendMultipartTextMessage(mnumber,null,parts,null,null);
                        Toast toast=new Toast(getActivity().getApplicationContext());
                        toast.setGravity(Gravity.TOP, 0, 20);
                        toast.makeText(getActivity().getApplicationContext(),"Message Sent to: "+mname,Toast.LENGTH_LONG).show();
                        t=t+1;
                    }catch (Exception e)
                    {
                        Toast.makeText(getActivity().getApplicationContext(),"Check SMS permission given or not!",Toast.LENGTH_LONG).show();
                    }


                }
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

            };


        }));

    }
    private String sendsms() {
        String strJson= " {\"result\":[{\"name\":\"S.SRI HARSHA\",\"number\":\"6304486686\",\"amount\":\"2000\",\"duedate\":\"20-06-2021\"}," +
                "{\"name\":\"M.SAI SUBHASH\",\"number\":\"9494557780\",\"amount\":\"1200\",\"duedate\":\"20-06-2021\"}," +
                "{\"name\":\"MONIKA\",\"number\":\"7093226399\",\"amount\":\"2300\",\"duedate\":\"20-06-2021\"}," +
                "{\"name\":\"PREETI\",\"number\":\"7780576775\",\"amount\":\"5300\",\"duedate\":\"20-06-2021\"}," +
                "{\"name\":\"PREETI\",\"number\":\"7780576775\",\"amount\":\"5300\",\"duedate\":\"20-06-2021\"}," +
                "{\"name\":\"SETHU SANDEEP\",\"number\":\"6301512125\",\"amount\":\"7200\",\"duedate\":\"20-06-2021\"}," +
                "{\"name\":\"K. SRINIVAS\",\"number\":\"9440736108\",\"amount\":\"11200\",\"duedate\":\"20-06-2021\"}," +
                "{\"name\":\"D.SOUMYA\",\"number\":\"8985323279\",\"amount\":\"2345\",\"duedate\":\"20-06-2021\"}]}";
        String data = "";
        String datan = "";

        try {
            // Create the root JSONObject from the JSON string.
            JSONObject jsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("result");
            String msg="DETAILS OF USERS\n";
            String d="";
            int t=0;

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String name = jsonObject.optString("name").toString();
                String salary = jsonObject.optString("number").toString() ;
                int amount= Integer.parseInt(jsonObject.optString("amount").toString());
                String date =jsonObject.optString("duedate").toString();

                t+=1;
                datan+= t+".Name: "+name+"\n number: "+salary+"\n amount: "+amount+"\n\n";

                data = "Hello dear tax payer!\nYour Water tax is due!\nHere are your details,\n\nName="+name+"\nMobileNumber="+salary+"\nAmount="+amount+"\n\nPay from this link below\n https://vijayawada.emunicipal.ap.gov.in/wtms/search/waterSearch/\n\nPlease pay on or before:"+date+"\nIf already paid ignore this message\n\nThank You\nMobile Alert by\nTadigadapa Muncipality";
                try {
                    SmsManager smsManager=SmsManager.getDefault();
                    ArrayList<String> parts =smsManager.divideMessage(data);
                    int numParts = parts.size();

                    ArrayList<PendingIntent> sentIntents = new ArrayList<PendingIntent>();
                    ArrayList<PendingIntent> deliveryIntents = new ArrayList<PendingIntent>();

                    for (int k = 0; k < numParts; k++) {
                        Intent mSendIntent=new Intent();
                        sentIntents.add(PendingIntent.getBroadcast(getContext(), 0, mSendIntent, 0));
                        Intent mDeliveryIntent=new Intent();
                        deliveryIntents.add(PendingIntent.getBroadcast(getContext(), 0, mDeliveryIntent, 0));
                    }
                    smsManager.sendMultipartTextMessage(salary,null,parts,null,null);
                    Toast.makeText(getActivity().getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();
                }catch (Exception e)
                {
                    Toast.makeText(getActivity().getApplicationContext(),"Some fields is Empty",Toast.LENGTH_LONG).show();
                }
            }
            t=0;


        } catch (JSONException e) {e.printStackTrace();}
        return datan;
    }
}