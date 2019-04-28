package edu.illinois.cs.cs125.spring2019.lab12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.lib2.Budget;

/**
 * Main class for our UI design lab.
 */
public final class MainActivity extends AppCompatActivity {
    /**
     * Mins.
     */
    public static final float MINS = 60;
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "Lab12:Main";

    /** Request queue for our API requests. */
    //private static RequestQueue requestQueue;

    /**
     * Run when this activity comes to the foreground.
     *
     * @param savedInstanceState unused
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputSalary = findViewById(R.id.addSalary);
        Button confirm = findViewById(R.id.button);
        TextView salSeconds = (TextView) findViewById(R.id.salarySeconds);
        TextView salMins = (TextView) findViewById(R.id.salaryMins);
        TextView salHours = (TextView) findViewById(R.id.salaryHours);
        TextView salDays = (TextView) findViewById(R.id.salaryDays);
        TextView salWeeks = (TextView) findViewById(R.id.salaryWeeks);
        confirm.setOnClickListener(v -> {
            int val = Integer.parseInt(inputSalary.getText().toString());
            salSeconds.setText("Money/Second: $" + (Budget.getMins(val) / MINS));
            salMins.setText("Money/Minute: $" + Budget.getMins(val));
            salHours.setText("Money/Hour: $" + Budget.getHours(val));
            salDays.setText("Money/Day: $" + Budget.getDays(val));
            salWeeks.setText("Money/Week: $" + Budget.getWeeks(val));
        });
        EditText itemPrice = findViewById(R.id.Price);
        Button calcTime = findViewById(R.id.calculate_Time);
        TextView itemSec = findViewById(R.id.displayTimeS);
        TextView itemMin = findViewById(R.id.displayTimeM);
        TextView itemHour = findViewById(R.id.displayTimeHours);
        TextView itemDay = findViewById(R.id.displayTimeDays);
        TextView itemWeek = findViewById(R.id.displayTimeW);
        calcTime.setOnClickListener(v -> {
            int item = Integer.parseInt(itemPrice.getText().toString());
            int val = Integer.parseInt(inputSalary.getText().toString());
            itemSec.setText("In Seconds: " + item / (Budget.getMins(val) / MINS));
            itemMin.setText("In Mins: " + item / (Budget.getMins(val)));
            itemHour.setText("In Hours: " + item / (Budget.getHours(val)));
            itemDay.setText("In Days: " + item / (Budget.getDays(val)));
            itemWeek.setText("In Weeks: " + item / (Budget.getWeeks(val)));
        });

        EditText rate = findViewById(R.id.addRate);
        EditText principal = findViewById(R.id.addPrincipal);
        EditText payOff = findViewById(R.id.addPayOff);
        Button calcYears = findViewById(R.id.calculateYears);
        TextView loanYears = findViewById(R.id.displayTimeLoan);
        calcYears.setOnClickListener(v -> {
            double rateNum = Double.parseDouble(rate.getText().toString());
            double principalNum = Double.parseDouble(principal.getText().toString());
            double payOffNum = Double.parseDouble(payOff.getText().toString());
            loanYears.setText("Approximate Years: " + Budget.loanCalc(rateNum, principalNum, payOffNum) + " Years");
        });

        /*
        // Set up the queue for our API requests
        requestQueue = Volley.newRequestQueue(this);

        setContentView(R.layout.activity_main);

        startAPICall("192.17.96.8");
        */
    }

    /**
     * Run when this activity is no longer visible.
     */
    /*
    @Override
    protected void onPause() {
        super.onPause();
    }
    */
    /**
     * Make a call to the IP geolocation API.
     *
     * @param ipAddress IP address to look up
     */
    /*
    void startAPICall(final String ipAddress) {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://ipinfo.io/" + ipAddress + "/json",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            apiCallDone(response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(final VolleyError error) {
                            Log.e(TAG, error.toString());
                        }
                    });
            jsonObjectRequest.setShouldCache(false);
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handle the response from our IP geolocation API.
     *
     * @param response response from our IP geolocation API.
     */
    /*
    void apiCallDone(final JSONObject response) {
        try {
            Log.d(TAG, response.toString(2));
            // Example of how to pull a field off the returned JSON object
            Log.i(TAG, response.get("hostname").toString());
        } catch (JSONException ignored) { }
    }
    */
}
