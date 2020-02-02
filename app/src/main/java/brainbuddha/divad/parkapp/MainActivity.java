package brainbuddha.divad.parkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] user = {"Student","Faculty"};
    Spinner userType;
    Button car,bike,confirm,A1,B1,C1,A2,B2,C2,D2,E2;
    boolean reserve=false,carv=true,bikev=false,selected=false;
    String role="Student",vehicle="Car",slot="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userType = (Spinner) findViewById(R.id.spinner);//initialisation
        car=(Button)findViewById(R.id.carbutton);
        bike=(Button)findViewById(R.id.bikebutton);
        A1=(Button)findViewById(R.id.a1);
        B1=(Button)findViewById(R.id.b1);
        C1=(Button)findViewById(R.id.c1);
        A2=(Button)findViewById(R.id.a2);
        B2=(Button)findViewById(R.id.b2);
        C2=(Button)findViewById(R.id.c2);
        D2=(Button)findViewById(R.id.d2);
        E2=(Button)findViewById(R.id.e2);
        confirm=(Button)findViewById(R.id.confirm);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                car.performClick();
            }
        },000);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, user);
        userType.setAdapter(arrayAdapter);
        userType.setSelection(0);

        userType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//role selection

                if(position==0)
                {
                    reserve=true;
                    role="Student";
                    slot="";
                    selected=false;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(carv)
                            {C1.setBackgroundResource(R.drawable.reserved);
                            B1.setBackgroundResource(R.drawable.vacant);
                            }
                            else{
                            A2.setBackgroundResource(R.drawable.reserved);
                            B2.setBackgroundResource(R.drawable.reserved);
                            C2.setBackgroundResource(R.drawable.vacant);
                            D2.setBackgroundResource(R.drawable.vacant);}
                        }
                    },001);
                }
                else if(position==1)
                {
                    reserve=false;
                    role="Faculty";
                    slot="";
                    selected=false;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(carv)
                            {C1.setBackgroundResource(R.drawable.vacant);}
                            else{
                                A2.setBackgroundResource(R.drawable.vacant);
                                B2.setBackgroundResource(R.drawable.vacant);}
                        }
                    },001);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this,"Select Role to Proceed",Toast.LENGTH_LONG).show();
            }


        });
    car.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            bikev=false;
            carv=true;
            vehicle="Car";
            //car button func.
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    A2.setBackgroundResource(R.drawable.unsuitable);
                    B2.setBackgroundResource(R.drawable.unsuitable);
                    C2.setBackgroundResource(R.drawable.unsuitable);
                    D2.setBackgroundResource(R.drawable.unsuitable);
                    E2.setBackgroundResource(R.drawable.unsuitable);
                    A1.setBackgroundResource(R.drawable.occupied);
                    car.setBackgroundResource(R.drawable.carblack);
                    bike.setBackgroundResource(R.drawable.bike);
                    B1.setBackgroundResource(R.drawable.vacant);
                    if(reserve)
                    {
                        C1.setBackgroundResource(R.drawable.reserved);
                    }
                    else
                        C1.setBackgroundResource(R.drawable.vacant);
                }
            },001);
        }
    });

    bike.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            carv=false;
            bikev=true;
            vehicle="Bike";
            A1.setBackgroundResource(R.drawable.unsuitable);
            B1.setBackgroundResource(R.drawable.unsuitable);
            C1.setBackgroundResource(R.drawable.unsuitable);
            E2.setBackgroundResource(R.drawable.occupied);
            bike.setBackgroundResource(R.drawable.bikeblack);
            car.setBackgroundResource(R.drawable.carone);
            C2.setBackgroundResource(R.drawable.vacant);
            D2.setBackgroundResource(R.drawable.vacant);
            if(reserve)
            {
                A2.setBackgroundResource(R.drawable.reserved);
                B2.setBackgroundResource(R.drawable.reserved);
            }
            else
            {
                A2.setBackgroundResource(R.drawable.vacant);
                B2.setBackgroundResource(R.drawable.vacant);
            }
        }
    });
    A1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"Choose a Valid Slot",Toast.LENGTH_SHORT).show();
        }
    });
    E2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"Choose a Valid Slot",Toast.LENGTH_SHORT).show();
        }
    });
    C1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(reserve || bikev)
            {
                Toast.makeText(MainActivity.this,"Choose a Valid Slot",Toast.LENGTH_SHORT).show();
            }
            else if(selected && slot.equals("C1"))
            {
                selected=false;
                slot="";
                if(bikev)
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            C1.setBackgroundResource(R.drawable.unsuitable);

                        }
                    },000);
                }
                else if(reserve)
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            C1.setBackgroundResource(R.drawable.reserved);

                        }
                    },000);
                }
                else
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            C1.setBackgroundResource(R.drawable.vacant);

                        }
                    },000);
                }

            }
            else
            {
                if(!(slot.equals("")))
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            B1.setBackgroundResource(R.drawable.vacant);
                        }
                    },00);
                }
                selected=true;
                slot="C1";
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        C1.setBackgroundResource(R.drawable.selected);
                    }
                },100);
            }
        }
    });
        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(reserve || carv)
                {
                    Toast.makeText(MainActivity.this,"Choose a Valid Slot",Toast.LENGTH_SHORT).show();
                }
                else if(selected && slot.equals("A2"))
                {
                    selected=false;
                    slot="";
                    if(carv)
                    {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                A2.setBackgroundResource(R.drawable.unsuitable);

                            }
                        },000);
                    }
                    else if(reserve)
                    {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                A2.setBackgroundResource(R.drawable.reserved);

                            }
                        },000);
                    }
                    else
                    {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                A2.setBackgroundResource(R.drawable.vacant);

                            }
                        },000);
                    }

                }
                else
                {
                    if(!(slot.equals("")))
                    {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                C2.setBackgroundResource(R.drawable.vacant);
                                D2.setBackgroundResource(R.drawable.vacant);
                                B2.setBackgroundResource(R.drawable.vacant);
                            }
                        },00);
                    }
                    selected=true;
                    slot="A2";
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            A2.setBackgroundResource(R.drawable.selected);
                        }
                    },100);
                }
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(reserve || carv)
                {
                    Toast.makeText(MainActivity.this,"Choose a Valid Slot",Toast.LENGTH_SHORT).show();
                }
                else if(selected && slot.equals("B2"))
                {
                    selected=false;
                    slot="";
                    if(carv)
                    {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                B2.setBackgroundResource(R.drawable.unsuitable);

                            }
                        },000);
                    }
                    else if(reserve)
                    {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                B2.setBackgroundResource(R.drawable.reserved);

                            }
                        },000);
                    }
                    else
                    {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                B2.setBackgroundResource(R.drawable.vacant);

                            }
                        },000);
                    }

                }
                else
                {
                    if(!(slot.equals("")))
                    {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                A2.setBackgroundResource(R.drawable.vacant);
                                C2.setBackgroundResource(R.drawable.vacant);
                                D2.setBackgroundResource(R.drawable.vacant);
                            }
                        },00);
                    }
                    selected=true;
                    slot="B2";
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            B2.setBackgroundResource(R.drawable.selected);
                        }
                    },100);
                }
            }
        });
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bikev)
                {
                    Toast.makeText(MainActivity.this,"Choose a Valid Slot",Toast.LENGTH_SHORT).show();
                }
                else if(selected && slot.equals("B1"))
                {
                    selected=false;
                    slot="";




                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                B1.setBackgroundResource(R.drawable.vacant);

                            }
                        },000);


                }
                else
                {
                    if(!(slot.equals("")))
                    {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                               if(reserve)
                                C1.setBackgroundResource(R.drawable.reserved);
                               else
                                C1.setBackgroundResource(R.drawable.vacant);
                            }
                        },00);
                    }
                    selected=true;
                    slot="B1";
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            B1.setBackgroundResource(R.drawable.selected);
                        }
                    },100);
                }
            }
        });
        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(carv)
                {
                    Toast.makeText(MainActivity.this,"Choose a Valid Slot",Toast.LENGTH_SHORT).show();
                }
                else if(selected && slot.equals("C2"))
                {
                    selected=false;
                    slot="";




                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            C2.setBackgroundResource(R.drawable.vacant);

                        }
                    },000);


                }
                else
                {
                    if(!(slot.equals("")))
                    {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                 D2.setBackgroundResource(R.drawable.vacant);
                                if(reserve){
                                    A2.setBackgroundResource(R.drawable.reserved);
                                    B2.setBackgroundResource(R.drawable.reserved);
                                }
                                else
                                {
                                    A2.setBackgroundResource(R.drawable.vacant);
                                    B2.setBackgroundResource(R.drawable.vacant);
                                }

                            }
                        },00);
                    }
                    selected=true;
                    slot="C2";
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            C2.setBackgroundResource(R.drawable.selected);
                        }
                    },100);
                }
            }
        });
        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(carv)
                {
                    Toast.makeText(MainActivity.this,"Choose a Valid Slot",Toast.LENGTH_SHORT).show();
                }
                else if(selected && slot.equals("D2"))
                {
                    selected=false;
                    slot="";




                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            D2.setBackgroundResource(R.drawable.vacant);

                        }
                    },000);


                }
                else
                {
                    if(!(slot.equals("")))
                    {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                C2.setBackgroundResource(R.drawable.vacant);
                                if(reserve){
                                    A2.setBackgroundResource(R.drawable.reserved);
                                    B2.setBackgroundResource(R.drawable.reserved);
                                }
                                else
                                {
                                    A2.setBackgroundResource(R.drawable.vacant);
                                    B2.setBackgroundResource(R.drawable.vacant);
                                }

                            }
                        },00);
                    }
                    selected=true;
                    slot="D2";
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            D2.setBackgroundResource(R.drawable.selected);
                        }
                    },100);
                }
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected)
                {
                 Intent i=new Intent(MainActivity.this,Main2Activity.class);
                    i.putExtra("role",role);
                    i.putExtra("vehicle",vehicle);
                    i.putExtra("slot",slot);
                    i.putExtra("Remainder","5");
                    startActivity(i);
                }
                else
                    Toast.makeText(MainActivity.this,"Select a Slot First !!",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
