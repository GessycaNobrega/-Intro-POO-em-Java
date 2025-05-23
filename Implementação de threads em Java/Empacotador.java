package com.mycompany.empacotadoraACME;
//Importações
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Prof Marlos M Corrêa
 */
public class Empacotador implements Runnable {
	//Atributos
	private final Equipe equipe;
	private final ContadorSinc empacotamentos;
	private final String nome;
	private String lista_threads_id;
	//Métodos
	public Empacotador(int nr_empacotador, Equipe equipe) {
		this.equipe = equipe;
		this.lista_threads_id = new String();
		this.nome = "Emp[" + nr_empacotador + "]@" + equipe.getName();
		Thread.currentThread().setName(nome);
		empacotamentos = new ContadorSinc(0);
	}
	public void listarIdThreads() {
		System.out.println(" |----- Lista de threads executadas por " + nome + " : " + lista_threads_id);
	}
	public void listarEmpacotamentos() {
		System.out.println(" |----- Empacotamentos feitos por " + nome + " : " + empacotamentos.getContador());
	}
	@Override
	public void run() {
		try {
			synchronized(lista_threads_id) {
				lista_threads_id = lista_threads_id + "[" + Thread.currentThread().getId() + "]"; //Constrói na instância de Empacotador uma lista com todas as threads que foram criadas.
			}
			System.out.println(nome + " empacotando (" + System.currentTimeMillis() + ")");
			Thread.sleep((int)(Math.random() * 899 + 100)); //Coloca a thread para dormir por um período aleatório entre 100 e 999 milissegundos.
			System.out.println(nome + " concluiu  (" + System.currentTimeMillis() + ")");
			empacotamentos.incrementar(); //Incrementa o contador de empacotamentos da instância de Empacotador.
			equipe.liberarFita();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
