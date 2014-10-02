package br.com.qnota;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	TextView tvQuantidade, tvMediaGeral, tvTituloConfig, tvTituloSobre,
			tvDescricao, tvComoConfigurar, tvQuantidadeSobre,
			tvDescricaoConfiguracao, tvObterResult, tvDescricaoResult;
	EditText etMediaOutra;
	RadioGroup rgNotas, rgMediaGeralAdotada;
	int quantidadeDeNotas, mediaGeral;
	RadioButton rbUma, rbDuas, rbTres, rbQuatro, rbMediaSete, rbMediaOutra;
	ImageButton btCalcular, btConfigurar, btSobre;
	Button btConfigVoltar, btConfigSalvar, btSobreVoltar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		chamaTelaInicial();
	}

	/**
	 * Método que chama a tela inicial, inicializa os objetos desta tela e as
	 * capturas de botões.
	 */
	private void chamaTelaInicial() {
		setContentView(R.layout.activity_main);
		inicializaObjetos();
		listeners();
	}

	/**
	 * Método que chama a tela configurar, inicializa os objetos desta tela e as
	 * capturas de botões.
	 */
	private void chamaTelaConfigurar() {
		setContentView(R.layout.configurar);
		inicializaObjetos();
		listeners();

	}

	/**
	 * Método que chama a tela configurar, inicializa os objetos desta tela e as
	 * capturas de botões.
	 */
	private void chamaTelaSobre() {
		setContentView(R.layout.sobre);
		inicializaObjetos();
		listeners();

	}

	/**
	 * Neste método todos os objetos são inicializados de acordo com a tela a
	 * qual pertencem. É importante perceber que os botões referentes a tela
	 * inicial estão dentro de um trycatch. Os objetos das outras telas estão
	 * dentro de outro trycatch. É assim que deve continuar: cada tela e seus
	 * respectivos botões devem estar em trycatch diferentes de outras telas.
	 */
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
			rgNotas = (RadioGroup) findViewById(R.id.rgQuantidadeNotas);
			rbUma = (RadioButton) findViewById(R.id.rbUma);
			rbDuas = (RadioButton) findViewById(R.id.rbDuas);
			rbTres = (RadioButton) findViewById(R.id.rbTres);
			rbQuatro = (RadioButton) findViewById(R.id.rbQuatro);
			quantidadeDeNotas();

			tvMediaGeral = (TextView) findViewById(R.id.tvMedia);
			rgMediaGeralAdotada = (RadioGroup) findViewById(R.id.rgMediaGeralAdotada);
			rbMediaSete = (RadioButton) findViewById(R.id.rbMediaSete);
			rbMediaOutra = (RadioButton) findViewById(R.id.rbMediaOutra);
			mediaGeralAdotada();

			System.out.println(mediaGeral);
			btConfigVoltar = (Button) findViewById(R.id.btConfigVoltar);
			btConfigSalvar = (Button) findViewById(R.id.btConfigSalvar);
		} catch (Exception e) {

		}
		try {
			// INICIALIZA OBJETOS DA TELA SOBRE
			tvTituloSobre = (TextView) findViewById(R.id.tvTituloSobre);
			tvDescricao = (TextView) findViewById(R.id.tvDescricao);
			tvQuantidadeSobre = (TextView) findViewById(R.id.tvQuantidadeSobre);
			tvComoConfigurar = (TextView) findViewById(R.id.tvComoConfigurar);
			tvDescricaoConfiguracao = (TextView) findViewById(R.id.tvDescricaoConfiguracao);
			tvObterResult = (TextView) findViewById(R.id.tvObterResult);
			tvDescricaoResult = (TextView) findViewById(R.id.tvDescricaoResult);
			btSobreVoltar = (Button) findViewById(R.id.btVoltar);
		} catch (Exception e) {

		}
	}

	/**
	 * Método que recebe a configuração do usuário para a quantidade de notas a
	 * partir da interface.
	 */
	private void quantidadeDeNotas() {
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
	}

	/**
	 * Método que captura a média Geral Adotada que o usuário está configurando
	 * neste momento.
	 */
	private void mediaGeralAdotada() {
		rgMediaGeralAdotada
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					public void onCheckedChanged(RadioGroup grupo, int opcaoID) {
						if (rbMediaSete.isChecked()) {
							mediaGeral = 7;
						} else if (rbMediaOutra.isChecked()) {
							etMediaOutra = (EditText) findViewById(R.id.etOutra);
							String media = etMediaOutra.getText().toString();
							if (media.isEmpty()) {
								mediaGeral = 7;
							} else {
								mediaGeral = Integer.parseInt(media);
							}
						}
					}
				});

	}

	/**
	 * Método utilizado para exibir caixa de diálogo com mensagens para o
	 * usuário. É necessário passar como parâmetro o título e a mensagem em si.
	 * Esta caixa de diálogo apresentará as informações e um botão "OK" apenas
	 * para o usuário clicar e ela desaparecer.
	 * 
	 * @param titulo
	 *            da caixa de diálogo
	 * @param msg
	 *            que irá ser exibida ao usuário
	 */
	private void mensagem(String titulo, String msg) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(
				MainActivity.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(msg);
		mensagem.setNeutralButton("OK", null);
		mensagem.show();

	}

	/**
	 * Método que realiza todas as capturas dos botões do aplicativo. É
	 * necessário que os botões de cada tela fiquem dentro de um try catch, caso
	 * contrário não é executado este método. Botões de uma tela podem ficar
	 * dentro de apenas um trycatch. Botões de telas diferentes devem ficar em
	 * trycatch's diferentes.
	 */
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
			btSobre.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaTelaSobre();

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
			btConfigSalvar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					mensagem("Configurações Salvas",
							"Suas configurações foram Salvas com sucesso!");
					chamaTelaInicial();

				}
			});
		} catch (Exception e) {

		}
		try {
			btSobreVoltar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaTelaInicial();
				}
			});
		} catch (Exception e) {

		}

	}
}
