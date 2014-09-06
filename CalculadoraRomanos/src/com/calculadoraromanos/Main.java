package com.calculadoraromanos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener{
	
	
	/*
	 * Numero romanos 
	 * Declaracion 
	 * */
	public Roman I = new Roman (1,"I"); 
	public Roman V = new Roman (5,"V");
	public Roman X = new Roman (10,"X");
	public Roman L = new Roman (50,"L");
	public Roman C = new Roman (100,"C");
	public Roman D = new Roman (500,"D");
	public Roman M = new Roman (1000,"M");
	

	final int NUMERO1=0; 
	final int NUMERO2=2;
	final int RESULTADO=3; 
	final int BORRAR=4;
	Button simbol1,simbol2,simbol3,simbol4,simbol5,simbol6,simbol7,simboligual,Ope_suma,clear;
	TextView Text_Rout,Text_Nout;
	TextView Text_rAdd1out, Text_rAdd2out; 
	TextView Text_iAdd1out, Text_iAdd2out; 
	String Add1="";
	String Add2=""; 	
	String acumulador="";
	String Prueba;
	int FlagGui=NUMERO1; 
	int Stotal=0,S1=0,S2=0,S3=0,S4=0,S5=0,S6=0,S7=0;
	int Cont = 0 , banderaS3 = 0, banderaClear = 0, Repetsuma=0;
	public RomanSum mRomanSum; 
	//RomanostoEnteros ad = new RomanostoEnteros();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//obtenemos referencias a los componentes (views)
		ubicarComponentes();
		//adiciona escucha de eventos a los botones (implementados por esta clase)
		asignarEscuchasBotones();
	}

	private void ubicarComponentes(){

		simbol1 = (Button)findViewById(R.id.btn1);
		simbol2 = (Button)findViewById(R.id.btn2);
		simbol3 = (Button)findViewById(R.id.btn3);
		simbol4 = (Button)findViewById(R.id.btn4);
		simbol5 = (Button)findViewById(R.id.btn5);
		simbol6 = (Button)findViewById(R.id.btn6);
		simbol7 = (Button)findViewById(R.id.btn7);
		Ope_suma = (Button)findViewById(R.id.btnsuma);
		simboligual = (Button)findViewById(R.id.btnigual);
		clear = (Button)findViewById(R.id.btnclc);

		Text_Rout = (TextView)findViewById(R.id.resultadoRomano);
		Text_Nout = (TextView)findViewById(R.id.resultado);
		Text_iAdd1out= (TextView)findViewById(R.id.numero1); 
		Text_iAdd2out= (TextView)findViewById(R.id.numero2);
		Text_rAdd1out= (TextView)findViewById(R.id.numeroRomano1); 
		Text_rAdd2out= (TextView)findViewById(R.id.NumeroRomano2); 		
	}


	private void asignarEscuchasBotones(){
		simbol1.setOnClickListener(this);
		simbol2.setOnClickListener(this);
		simbol3.setOnClickListener(this);
		simbol4.setOnClickListener(this);
		simbol5.setOnClickListener(this);
		simbol6.setOnClickListener(this);
		simbol7.setOnClickListener(this);
		Ope_suma.setOnClickListener(this);
		simboligual.setOnClickListener(this);
		clear.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()){

		case R.id.btn1:           //Número romano I
			
			if (banderaClear==1){
			clearAllGui();
			banderaClear=0;
			}	
			acumulador = acumulador + I.getVis();
			mRomanSum = new RomanSum(acumulador);
			refreshGUI(FlagGui); 
			break;
			
		case R.id.btn2:           //Numero romano V
			if (banderaClear==1){
				clearAllGui();
				banderaClear=0;
				}
			acumulador = acumulador + V.getVis();
			mRomanSum = new RomanSum(acumulador);
			refreshGUI(FlagGui); 
			break;

		case R.id.btn3:			//Numero romano X
			if (banderaClear==1){
				clearAllGui();
				banderaClear=0;
				}
			acumulador = acumulador + X.getVis();
			mRomanSum = new RomanSum(acumulador);
			refreshGUI(FlagGui); 
			break;
			
		case R.id.btn4:			//Numero romano L
			if (banderaClear==1){
				clearAllGui();
				banderaClear=0;
				}
			acumulador = acumulador + L.getVis();
			mRomanSum = new RomanSum(acumulador);
			refreshGUI(FlagGui); 
			break;

		case R.id.btn5:			//Numero romano C
			if (banderaClear==1){
				clearAllGui();
				banderaClear=0;
				}
			acumulador = acumulador + C.getVis();
			mRomanSum = new RomanSum(acumulador);
			refreshGUI(FlagGui);
			break;

		case R.id.btn6:			//Numero romano D
			if (banderaClear==1){
				clearAllGui();
				banderaClear=0;
				}
			acumulador = acumulador + D.getVis();
			mRomanSum = new RomanSum(acumulador);
			refreshGUI(FlagGui); 
			break;

		case R.id.btn7:			//Numero romano M
			if (banderaClear==1){
				clearAllGui();
				banderaClear=0;
				}
			acumulador = acumulador + M.getVis();
			mRomanSum = new RomanSum(acumulador); 
			refreshGUI(FlagGui); 
			break;

		case R.id.btnigual:
			
			Add2=acumulador; 
		
			if (Add2.length()>0 && Add1.length()>0)
			{
				mRomanSum = new RomanSum(Add1, Add2);
				FlagGui=RESULTADO; 
				refreshGUI(FlagGui); 
				FlagGui=NUMERO1;
				banderaClear = 1;
				Repetsuma = 0;
			}else 
			{
				Toast.makeText(getApplicationContext(), "Por favor llena ambos campos", Toast.LENGTH_SHORT).show(); 
			}
			break;

		case R.id.btnsuma:
			
			if (Repetsuma==0){
				Repetsuma = Repetsuma+1;
			if (acumulador.length()>0)
			{
				Add1=acumulador;
				FlagGui=NUMERO2; 
				acumulador=""; 
			}
			}

			break;
			
		case R.id.btnclc:
			FlagGui=BORRAR; 
			refreshGUI(FlagGui); 
			FlagGui=NUMERO1; 
			break;
		}
	}

	private void refreshGUI(int flag) {
		switch (flag){
		case NUMERO1: 
			//			clearAllGui();
			Text_iAdd1out.setText(""+mRomanSum.getIntResult()); 
			Text_rAdd1out.setText(acumulador); 		
			break; 
		case NUMERO2:
			Text_iAdd2out.setText(""+mRomanSum.getIntResult()); 
			Text_rAdd2out.setText(acumulador); 		
			break; 	
		case RESULTADO: 
			Text_Nout.setText(""+mRomanSum.getIntResult());
			Text_Rout.setText(mRomanSum.getStringResult()); 
			break; 
		case BORRAR: 
			clearAllGui(); 
			break; 
			
		}
		
	}

	private void clearAllGui() {
		acumulador = "";
		Add1=""; 
		Add2="";
		Text_iAdd1out.setText(""); 
		Text_rAdd1out.setText(""); 	
		Text_iAdd2out.setText(""); 
		Text_rAdd2out.setText(""); 		
		Text_Nout.setText("");
		Text_Rout.setText("");			
	}





}
