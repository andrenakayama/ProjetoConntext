package com.example.thierry.conntext;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Easy_one_Activity extends AppCompatActivity {

    int lifeGame = 5;
    private Button btnResponder;
    public TextView txtVidas;
    public RadioGroup rgRespostas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_one_layout);

        btnResponder = (Button) findViewById(R.id.btnEnviar);
        btnResponder.setOnClickListener(maisHandle);
        txtVidas = (TextView) findViewById(R.id.idVidas);

    }


    View.OnClickListener maisHandle;
    {
        maisHandle = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rgRespostas = (RadioGroup) findViewById(R.id.rgRepostas);
                if  (lifeGame == 0){
                    Toast.makeText(getApplicationContext(), "Suas chances acabaram, comece o Teste novamente", Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(this, Dificuldades_Activity.class));


                }else if (rgRespostas.getCheckedRadioButtonId() != R.id.radYou) {
                    lifeGame -= 1;
                    txtVidas.setText(String.valueOf(lifeGame));
                    Toast.makeText(getApplicationContext(), "Errou, tente novamente", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Acertou", Toast.LENGTH_LONG).show();

                    Bundle bundle = new Bundle();
                    bundle.putInt("life", lifeGame);
                    Intent intent = new Intent (Easy_one_Activity.this, Easy_two_Activity.class);
                    startActivity(intent);
            }
        }



        };
    }


}

