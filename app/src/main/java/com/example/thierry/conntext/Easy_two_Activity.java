package com.example.thierry.conntext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Easy_two_Activity extends AppCompatActivity {

    private Button btnResponder;
    public TextView txtVidas;
    public RadioGroup rgRespostas;
    int lifeGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_two_layout);

        btnResponder = (Button) findViewById(R.id.btnEnviar);
        btnResponder.setOnClickListener(maisHandle);
        txtVidas = (TextView) findViewById(R.id.idVidas);
    }

    public int getLife(){
        Intent it = getIntent();
        Bundle param = it.getExtras();
        String captureLife = param.getString("life");
        lifeGame = Integer.parseInt(captureLife);
        return lifeGame;
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
                    lifeGame--;
                    txtVidas.setText(String.valueOf(lifeGame));
                    Toast.makeText(getApplicationContext(), "Errou, tente novamente", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Acertou", Toast.LENGTH_LONG).show();

                    Bundle bundle = new Bundle();
                    bundle.putInt("life", lifeGame);
                    Intent intent = new Intent (Easy_two_Activity.this, Easy_three_Activity.class);
                    startActivity(intent);
                }
            }



        };
    }
}
