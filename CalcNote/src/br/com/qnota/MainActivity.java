package br.com.qnota;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import br.com.qnota.R;

public class MainActivity extends Activity {

	Registro objRegistro, regAuxiliar, ultimoRegistro, primeiroRegistro;
	EditText etOutra;
	int contadorRegistros = 0, posicao = 0, media, quantidadeNotas;
	boolean radio;
	RadioButton rbUma, rbDuas, rbTres, rbQuatro, rbMediaSete, srMediaOutra;
	Button btCalcular, btConfigurar, btConsultaVoltar, btProxReg, btRegAnt,
			btCadastroVoltar, btPacienteGravar, btPacienteVoltar,
			btMedicoGravar, btMedicoVoltar, btMedicamentoGravar,
			btMedicamentoVoltar, btSobre, btOk, btCadastroPaciente,
			btCadastroMedico, btCadastroMedicamento;
	TextView tvNome, tvEndereco, tvTelefone, tvSobre;

	SQLiteDatabase bancoDados = null;
	Cursor cursor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		primeiroRegistro = null;
		ultimoRegistro = null;
		chamaMenuPrincipal();
	}

	private void gravarRegistro() {
		capturaRadioButtonSelecionado();
		try {
			String sql = "INSERT INTO medias (quantidadeNotas, media) VALUES ('"
					+ etOutra.getText().toString()
					+ "','"
					+ rbUma.getText().toString() + "')";
			bancoDados.execSQL(sql);
		} catch (Exception ex) {
		}
	}

	private void capturaRadioButtonSelecionado() {
		radio = rbUma.isSelected();
		if (radio == true) {
			quantidadeNotas = 1;
		}
		radio = rbDuas.isSelected();
		if (radio == true) {
			quantidadeNotas = 2;
		}
		radio = rbTres.isSelected();
		if (radio == true) {
			quantidadeNotas = 3;
		}
		radio = rbQuatro.isSelected();
		if (radio == true) {
			quantidadeNotas = 4;
		}
	}

	public boolean buscarDados() {
		try {
			cursor = bancoDados.query("pessoas", new String[] { "nome",
					"endereco", "telefone" }, null, // ,
					null, // selectionArgs,
					null, // groupBy,
					null, // having,
					null,// rderBy "order by nome")
					null);// LIMITE DE REGISTROS RETORNADOS

			int numeroDeRegistros = cursor.getCount();
			if (numeroDeRegistros != 0) {
				cursor.moveToFirst(); // posiciona no primeiro registro
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			mensagem("ERRO", "Erro ao buscar dados no banco.");
		}
		return false;
	}

	public void chamaCalcular() {
		setContentView(R.layout.calcular);
		inicializaObjetos();
		listeners();

	}

	public void chamaConfigurar() {
		setContentView(R.layout.configurar);
		inicializaObjetos();
		listeners();

	}

	public void chamaSobre() {
		setContentView(R.layout.sobre);
		inicializaObjetos();
		listeners();

	}

	private void mensagem(String titulo, String msg) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(
				MainActivity.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(msg);
		mensagem.setNeutralButton("OK", null);
		mensagem.show();

	}

	public void chamaMenuPrincipal() {
		setContentView(R.layout.activity_main);
		inicializaObjetos();
		listeners();

	}

	private void inicializaObjetos() {
		try {
			// OBJETOS DA TELA INICIAL
			btCalcular = (Button) findViewById(R.id.btCalcular);
			btConfigurar = (Button) findViewById(R.id.btConfigurar);
			btSobre = (Button) findViewById(R.id.btSobre);
		} catch (Exception erro) {

		}
		try {
			// OBJETOS DA TELA DE CONFIGURAR
			rbUma = (RadioButton) findViewById(R.id.rbUma);
			rbDuas = (RadioButton) findViewById(R.id.rbDuas);
			rbTres = (RadioButton) findViewById(R.id.rbTres);
			rbQuatro = (RadioButton) findViewById(R.id.rbQuatro);
			// btConsultaVoltar = (Button) findViewById(R.id.btConsultaVoltar);
			// btProxReg = (Button) findViewById(R.id.btProxReg);
			// btRegAnt = (Button) findViewById(R.id.btRegAnt);
		} catch (Exception erro) {

		}

		try {
			// OBJETOS DA TELA DE CADASTRO GERAL
			// btCadastroPaciente = (Button)
			// findViewById(R.id.btCadastroPaciente);
			// btCadastroMedico = (Button) findViewById(R.id.btCadastroMedico);
			// btCadastroMedicamento = (Button)
			// findViewById(R.id.btCadastroMedicamento);
			// btCadastroVoltar = (Button) findViewById(R.id.btCadastroVoltar);

		} catch (Exception erro) {

		}

		try {
			// OBJETOS DA TELA DE CADASTRO DO PACIENTE
			// etPacienteNome = (EditText) findViewById(R.id.pacienteNome);
			// etPacienteCpf = (EditText) findViewById(R.id.pacienteCpf);
			// etPacienteEndereco = (EditText)
			// findViewById(R.id.pacienteEndereco);
			// etPacienteTelefone = (EditText)
			// findViewById(R.id.pacienteTelefone);
			//
			// btPacienteVoltar = (Button) findViewById(R.id.btCadastroVoltar);
			// btPacienteGravar = (Button) findViewById(R.id.btPacienteGravar);

		} catch (Exception erro) {

		}

		try {
			// OBJETOS DA TELA SOBRE
			tvSobre = (TextView) findViewById(R.id.tvSobre);
			btOk = (Button) findViewById(R.id.btOk);
		} catch (Exception erro) {

		}

	}

	private void listeners() {
		try {
			btCalcular.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaCalcular();

				}
			});

			btConfigurar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaConfigurar();

				}
			});
			btSobre.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaSobre();

				}
			});

		} catch (Exception erro) {

		}

		try {
			btCadastroPaciente.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// chamaCadastroPaciente();
				}
			});

			btCadastroMedico.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// chamaCadastroMedico();
				}
			});

			btCadastroMedicamento
					.setOnClickListener(new View.OnClickListener() {

						@Override
						public void onClick(View arg0) {
							// chamaCadastroMedicamento();
						}
					});

		} catch (Exception erro) {

		}

		try {
			btMedicoVoltar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// chamaCadastroGeral();
				}
			});

			btMedicoGravar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// chamaCadastroPaciente();
				}
			});

		} catch (Exception erro) {

		}

		try {
			btPacienteVoltar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// chamaCadastroGeral();
				}
			});

			btPacienteGravar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					try {
						gravarRegistro();
						mensagem("AVISO BANCO", "Dados gravados com sucesso!");
						// etPacienteNome.setText(null);
						// etPacienteEndereco.setText(null);
						// etPacienteTelefone.setText(null);
						// etPacienteNome.requestFocus();
					} catch (Exception ex) {
						mensagem(
								"ERRO BANCO",
								"Erro ao gravar dados no banco: "
										+ ex.getMessage());
					}
				}
			});

		} catch (Exception erro) {

		}
		try {
			btConsultaVoltar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					cursor.close();
					chamaMenuPrincipal();
				}
			});

			btProxReg.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// mostrarProximoRegistro();

				}

			});

			btRegAnt.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// mostrarRegistroAnterior();
				}

			});
		} catch (Exception erro) {

		}
		try {
			btOk.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					chamaMenuPrincipal();
				}
			});
		} catch (Exception erro) {

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// CRIAR MENU PEGANDO DO XML
		// getMenuInflater().inflate(R.menu.itensmenu, menu);

		// CRIAR SUBMENU SEM SER PELO XML
		SubMenu utilitario = menu.addSubMenu("Utilitarios");
		utilitario.add(0, 3, 0, "Pesquisa");
		utilitario.add(0, 4, 0, "Alterar");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		// case id.gravar:
		// mensagem("GRAVAR", "Gravar");
		// break;
		// case id.sair:
		// mensagem("SAIR", "Deseja sair?");
		// break;
		case 3:
			mensagem("Pesquisa", "Localizar");
			break;
		case 4:
			mensagem("Altera", "Editar");
			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

}
