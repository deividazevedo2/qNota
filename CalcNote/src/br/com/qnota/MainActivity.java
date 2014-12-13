package br.com.qnota;

import java.text.DecimalFormat;

import br.com.qnota.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView tvInformeMedia, tvTituloCalcular, tvTituloSobre, tvDescricao,
			tvObservacao, tvConheca, tvDescricaoResult, tvTituloResultado,
			tvSeuResultado, tvValorResultado, tvNaFinal;
	EditText etDigiteMedia;
	boolean telaCalcular = true;
	ImageButton btCalcular, btSobre, btSair, btCalcCalc, btSobreVoltar,
			btNovoCalculo, btVoltar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Toast.makeText(MainActivity.this, "Bem-vindo", Toast.LENGTH_LONG)
				.show();
		chamaTelaInicial();
		transicaoDeTela();

	}

	/**
	 * Método para realizar uma transição de tela mais agradável na entrada e
	 * saída do app.
	 */
	private void transicaoDeTela() {
		overridePendingTransition(android.R.anim.slide_in_left,
				android.R.anim.slide_out_right);

	}

	/**
	 * Método que chama a tela inicial, inicializa os objetos desta tela e as
	 * capturas de botões.
	 */
	private void chamaTelaInicial() {
		setContentView(R.layout.activity_main);
		inicializaObjetosDaTelaInicial();
		listeners();
	}

	/**
	 * Método que chama a tela configurar, inicializa os objetos desta tela e as
	 * capturas de botões.
	 */
	private void chamaTelaCalcular() {
		setContentView(R.layout.calcular);
		inicializaObjetosDaTelaCalcular();
		listeners();
	}

	/**
	 * Método que chama a tela Sobre, inicializa os objetos desta tela e as
	 * capturas de botões.
	 */
	private void chamaTelaSobre() {
		setContentView(R.layout.sobre);
		inicializaObjetosDaTelaSobre();
		listeners();
	}

	/**
	 * Método que chama a tela Resultado, inicializa os objetos desta tela e as
	 * capturas de botões.
	 */
	private void chamaTelaResultado() {
		setContentView(R.layout.resultado);
		inicializaObjetosDaTelaResultado();
		listeners();
	}

	/**
	 * Método para chamar o comando Sair.
	 */
	private void chamaTelaSair() {
		Toast.makeText(MainActivity.this, "Saindo...", Toast.LENGTH_SHORT)
				.show();
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
		transicaoDeTela();
	}

	/**
	 * Método utilizado apenas para alterar a fonte utilizada nos titulos de
	 * cada tela. Este método recebe o TextView da tela .xml e a fonte utilzada.
	 * 
	 * @param tv
	 * @param fonte
	 */
	private void mudarFonte(TextView tv) {
		// seta a fonte para o TextView
		Typeface type = Typeface.createFromAsset(getAssets(),
				"fonts/vtks_giz.ttf");
		tv.setTypeface(type);
		// Esta linha serve para colocar sombra preta no textView
		tv.setShadowLayer(3, 1, 1, Color.BLACK);
		tv.setTextSize(50); // tamanho do text textView
	}

	/**
	 * Método para inicializar os objetos utilizados na tela inicial do
	 * aplicativo.
	 */
	private void inicializaObjetosDaTelaInicial() {

		try {
			// INICIALIZA OBJETOS DA TELA INICIAL
			btCalcular = (ImageButton) findViewById(R.id.btCalcular);
			btSobre = (ImageButton) findViewById(R.id.btSobre);
			btSair = (ImageButton) findViewById(R.id.btSair);
		} catch (Exception e) {

		}
	}

	/**
	 * Método para inicializar os objetos utilizados na tela calcular do
	 * aplicativo.
	 */
	private void inicializaObjetosDaTelaCalcular() {
		try {
			// INICIALIZA OBJETOS DA TELA CALCULAR
			tvTituloCalcular = (TextView) findViewById(R.id.tvTituloCalcular);
			mudarFonte(tvTituloCalcular);
			tvInformeMedia = (TextView) findViewById(R.id.tvInformeMedia);
			etDigiteMedia = (EditText) findViewById(R.id.etDigiteMedia);
			tvObservacao = (TextView) findViewById(R.id.tvObsevacao);
			btCalcCalc = (ImageButton) findViewById(R.id.btCalcular);
			btVoltar = (ImageButton) findViewById(R.id.btVoltar);
			if (telaCalcular)
				mensagem("", "Insira sua média no campo", "Entendi!");
		} catch (Exception e) {

		}

	}

	/**
	 * Método para inicializar os objetos utilizados na tela sobre do
	 * aplicativo.
	 */
	private void inicializaObjetosDaTelaSobre() {
		try {
			// INICIALIZA OBJETOS DA TELA SOBRE
			tvTituloSobre = (TextView) findViewById(R.id.tvTituloSobre);
			mudarFonte(tvTituloSobre);
			tvDescricao = (TextView) findViewById(R.id.tvDescricao);
			tvConheca = (TextView) findViewById(R.id.tvConheca);
			tvDescricaoResult = (TextView) findViewById(R.id.tvDescricaoResult);
			btSobreVoltar = (ImageButton) findViewById(R.id.btVoltar);
		} catch (Exception e) {

		}

	}

	/**
	 * Método para inicializar os objetos utilizados na tela resultado do
	 * aplicativo.
	 */
	private void inicializaObjetosDaTelaResultado() {
		try {
			// INICIALIZA OBJETOS DA TELA RESULTADO
			tvTituloResultado = (TextView) findViewById(R.id.tvTituloResultado);
			mudarFonte(tvTituloResultado);
			tvSeuResultado = (TextView) findViewById(R.id.tvSeuResultado);
			tvValorResultado = (TextView) findViewById(R.id.tvValorResultado);
			tvValorResultado.setText(resultado());
			tvNaFinal = (TextView) findViewById(R.id.tvNaFinal);
			btNovoCalculo = (ImageButton) findViewById(R.id.btNovoCalculo);
		} catch (Exception e) {

		}

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
	private void mensagem(String titulo, String msg, String botao) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(
				MainActivity.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(msg);
		mensagem.setNeutralButton(botao, null);
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
		// LISTENERS DA TELA INICIAL
		try {
			btCalcular.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaTelaCalcular();

				}
			});
			btSobre.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaTelaSobre();

				}
			});
			btSair.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaTelaSair();

				}
			});
		} catch (Exception e) {

		}

		// LISTENERS DA TELA CALCULAR
		try {
			btCalcCalc.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaTelaResultado();

				}
			});
			btVoltar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaTelaInicial();

				}
			});
		} catch (Exception e) {

		}

		// LISTENERS DA TELA RESULTADO
		try {
			btNovoCalculo.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaTelaCalcular();
				}
			});
		} catch (Exception e) {

		}

		// LISTENERS DA TELA SOBRE
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

	/**
	 * Método que captura a nota da média inserida pelo usuário e transforma
	 * este valor em um Float para assim efetuar o cálculo de forma correta,
	 * retornando uma String com o valor formatado e reduzido em apenas duas
	 * casas decimais.
	 * 
	 * @return
	 */
	private String resultado() {
		float x, y, z = 0, result;
		String mediaInserida = etDigiteMedia.getText().toString();
		if (mediaInserida.equals("")) {
			chamaTelaCalcular();
		}
		result = Float.parseFloat(mediaInserida);
		if (!verificaValor(result)) {
			chamaTelaCalcular();
		} else {
			x = result * 6;
			y = 50 - x;
			z = y / 4;
		}
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(1);
		telaCalcular = true;
		return df.format(z);
	}

	/**
	 * Este método faz uma verificação no valor da nota final já calculada para
	 * exibir ao usuário a mensagem referente a esta nota.
	 * 
	 * @param valor
	 * @return
	 */
	private boolean verificaValor(Float valor) {
		if (valor > 4.0 && valor < 7.0) {
			telaCalcular = true;
			return true;
		} else if (valor > 6.9 && valor < 10.1) {
			mensagem("UHU!", "Aprovado por média. Parabéns!", "THANKS");
			telaCalcular = false;
			return false;
		} else if (valor < 4.0 && valor > 0) {
			mensagem(
					"OPS!",
					"Média insuficiente para realizar Prova Final! Estude mais no próximo período.",
					"OK");
			telaCalcular = false;
			return false;
		}
		telaCalcular = false;
		return false;
	}
}
