package br.com.qnota;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tvQuantidade, tvMediaGeral, tvTituloConfig;
	EditText etMediaOutra;
	RadioGroup rgNotas;
	int quantidadeDeNotas, mediaGeral;
	RadioButton rbUma, rbDuas, rbTres, rbQuatro, rbMediaSete, rbMediaOutra;
	ImageButton btCalcular, btConfigurar, btSobre;
	Button btConfigVoltar, btConfigSalvar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		chamaTelaInicial();
	}

	private void chamaTelaInicial() {
		setContentView(R.layout.activity_main);
		inicializaObjetos();
		listeners();
	}

	private void chamaTelaConfigurar() {
		setContentView(R.layout.configurar);
		inicializaObjetos();
		listeners();

	}

	private void inicializaObjetos() {

		try {
			// INICIALIZA OBJETOS DA TELA INICIAL
			btCalcular = (ImageButton) findViewById(R.id.btCalcular);
			btConfigurar = (ImageButton) findViewById(R.id.btConfigurar);
			btSobre = (ImageButton) findViewById(R.id.btSobre);
		} catch (Exception e) {

		}
		try {
			// INICIALIZA OBJETOS DA TELA CONFIGURAÇÃO
			tvTituloConfig = (TextView) findViewById(R.id.tvTituloConfig);
			tvQuantidade = (TextView) findViewById(R.id.tvQuantidade);
			rgNotas = (RadioGroup) findViewById(R.id.radioGroup1);
			rbUma = (RadioButton) findViewById(R.id.rbUma);
			rbDuas = (RadioButton) findViewById(R.id.rbDuas);
			rbTres = (RadioButton) findViewById(R.id.rbTres);
			rbQuatro = (RadioButton) findViewById(R.id.rbQuatro);
			rgNotas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

				public void onCheckedChanged(RadioGroup grupo, int opcaoID) {
					if (rbUma.isChecked()) {
						quantidadeDeNotas = 1;
					} else if (rbDuas.isChecked()) {
						quantidadeDeNotas = 2;
					} else if (rbTres.isChecked()) {
						quantidadeDeNotas = 3;
					} else if (rbQuatro.isChecked()) {
						quantidadeDeNotas = 4;
					}

				}
			});
			tvMediaGeral = (TextView) findViewById(R.id.tvMedia);
			rbMediaSete = (RadioButton) findViewById(R.id.rbMediaSete);
			rbMediaOutra = (RadioButton) findViewById(R.id.rbMediaOutra);
			etMediaOutra = (EditText) findViewById(R.id.etOutra);
			btConfigVoltar = (Button) findViewById(R.id.btConfigVoltar);
			btConfigSalvar = (Button) findViewById(R.id.btConfigSalvar);
		} catch (Exception e) {

		}
	}

	private void listeners() {
		try {
			btConfigurar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaTelaConfigurar();

				}
			});
		} catch (Exception e) {

		}
		try {
			btConfigVoltar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaTelaInicial();

				}
			});
		} catch (Exception e) {

		}
		try {
			btConfigSalvar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaTelaInicial();

				}
			});
		} catch (Exception e) {

		}

	}
}
