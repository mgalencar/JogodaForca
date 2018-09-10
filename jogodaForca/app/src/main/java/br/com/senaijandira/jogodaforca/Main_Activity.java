package br.com.senaijandira.jogodaforca;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Random;

public class Main_Activity extends Activity {

    TextView caixaPalavra;
    String[]palavras = {"theon",
            "davos",
            "jaime",
            "jaqen",
            "varys",
            "tywin",
            "renly",
            "mance",
            "loras",
            "jorah",
            "dario",
            "jorah"};
    StringBuilder  palavraEscondida = new StringBuilder("*****");

    Random random = new Random();
    int contador;
    int numAleatorio;
    int contadorLetras;
    int contadorErros;
    Button clicado;
    String letra;
    Button[]botoes = new Button[26];
    int id;
    int qntAcertos, qntErros;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //deixando visivel
        setContentView(R.layout.main_activity);
        //recebendo id da Layout
        caixaPalavra = findViewById(R.id.txtBoxWord);
        img = findViewById(R.id.westeros);
        caixaPalavra.setText(palavraEscondida.toString());
        img.setBackgroundResource(R.drawable.westeros);
        for(int i = 0; i<=25; i++) {
            id = getResources().getIdentifier("btn" + i, "id", getPackageName());
            botoes[i] = findViewById(id);
        }

        numAleatorio();
    }
    public void clickBtn (View vi){
        //-criar botão
         clicado = (Button)vi;
        //-pegar o botão clicado pelo view
        letra = vi.getTag().toString();
        //verificar se a palavra clicada existe no vetor de palavras
        if(palavras[numAleatorio].contains(letra)){

           for(int i= 0; i<palavras[numAleatorio].length();i++ ){
            //pegar um pedaço da palavra de acordo com a letra digitada
                String pedaco = palavras[numAleatorio].substring(i, i+1);

                if(pedaco.equals(letra)){
                //trocar o caracter pela letra
                    palavraEscondida.setCharAt(i, pedaco.charAt(0));
                    caixaPalavra.setText(palavraEscondida.toString());
                }
           }

           clicado.setBackgroundColor(getResources().getColor(R.color.green));
            clicado.setEnabled(false);
            qntAcertos++;
            contadorLetras++;


        }else {
            clicado.setBackgroundColor(getResources().getColor(R.color.red));
            clicado.setEnabled(false);
            qntErros++;
            contadorErros++;
            changeImg();

        }
        if(contadorLetras>=palavras[numAleatorio].length()){
            img.setBackgroundResource(R.drawable.westeros);
            proxPalavra();
        }
        verificaVitoria();

    }
    public void numAleatorio(){
        contador = palavras.length;
        numAleatorio = random.nextInt(contador);
    }
    public void proxPalavra(){
        alert("Acerto: "+qntAcertos +"\nErros: "+qntErros, "Pontuação");
        for(int i =0; i<25; i++){
           botoes[i].setBackgroundColor(getResources().getColor(R.color.black));
           botoes[i].setEnabled(true);
        }
        contadorErros = 0;
        letra = "";
        caixaPalavra.setText("*****");
        contadorLetras = 0;
        numAleatorio();
        palavraEscondida= new StringBuilder("*****");


    }
    public void alert(String mensagem, String titulo){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(mensagem);
        alert.setTitle(titulo);
        alert.create().show();
     }
     public void changeImg(){

        if(contadorErros >= 1){
            img.setBackgroundResource(R.drawable.mapa1);
        }if(contadorErros >=2){
            img.setBackgroundResource(R.drawable.mapa2);
         }if(contadorErros >=3){
            img.setBackgroundResource(R.drawable.mapa3);
         }if(contadorErros >=4){
            img.setBackgroundResource(R.drawable.mapa4);
         }if(contadorErros >=5){
            img.setBackgroundResource(R.drawable.mapa5);
         }if(contadorErros >=6){
            img.setBackgroundResource(R.drawable.mapa6);
         }if(contadorErros >=7){
            img.setBackgroundResource(R.drawable.mapa7);
         }if(contadorErros >=8){
            img.setBackgroundResource(R.drawable.mapa8);
         }
         if(contadorErros >=9){
             gameover();
         }
     }
     public void gameover(){
            Intent intent = new Intent(this, GameOver_Activity.class);
             startActivity(intent);
             finish();

        }





//         AlertDialog.Builder alert = new AlertDialog.Builder(this);
//         alert.setMessage("Voce perdeu");
//         alert.setTitle("Game Over");
//         alert.setCancelable(false);
//         alert.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
//             @Override
//             public void onClick(DialogInterface dialogInterface, int i) {
//                 finish();
//             }
//         });
//         alert.setPositiveButton("Jogar Novamente?", new DialogInterface.OnClickListener() {
//             @Override
//             public void onClick(DialogInterface dialogInterface, int i) {
////                 Intent intent = new Intent(getApplicationContext(), Inicio_Activity.class);
////                 startActivity(intent);
////                 finish();
//             }
//         });
//         alert.create().show();

     public void verificaVitoria(){
        if(qntAcertos >= 30){
            Intent intent = new Intent(this, Vitoria_Activity.class);
            startActivity(intent);
            finish();
        }
     }



}




