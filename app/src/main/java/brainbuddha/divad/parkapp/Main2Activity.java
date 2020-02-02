package brainbuddha.divad.parkapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
     String role,vehicle,slot,rem="";
     int remainder=0;
     TextView rol,veh,slo,re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        role = intent.getStringExtra("role");
        vehicle=intent.getStringExtra("vehicle");
        slot=intent.getStringExtra("slot");
        rem=intent.getStringExtra("Remainder");
        remainder=Integer.parseInt(rem);
        rol=(TextView)findViewById(R.id.textView4);
        veh=(TextView)findViewById(R.id.textView5);
        slo=(TextView)findViewById(R.id.textView6);
        re=(TextView)findViewById(R.id.textView7);
        rol.setText("Role : "+role);
        veh.setText("Vehicle Type : "+vehicle);
        slo.setText("Slot Chosen : "+slot);
        re.setText("Remaining Slots : "+rem);
    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(i);
    }
}
