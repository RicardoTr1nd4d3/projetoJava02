package controllers;

import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Funcionario;
import enums.TipoContratacao;
import repositories.FuncionarioRepository;

public class FuncionarioControl 
{
	public void cadastrarFuncionario () 
	{
		var funcionario = new Funcionario ();
		
		try
		{
			funcionario.setId(UUID.randomUUID());
			funcionario.setNome(JOptionPane.showInputDialog("Nome do funcionario: "));
			funcionario.setMatricula(JOptionPane.showInputDialog("Matricula: "));
			funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane.showInputDialog("Data de admissao ")));
			
			var opcao = JOptionPane.showInputDialog("Informe (1)Estágio, (2)CLT ou (3)Terceirizado: ");
			
			switch(opcao) 
			{
			case "1": funcionario.setTipoContratacao(TipoContratacao.ESTAGIO); break;
			case "2": funcionario.setTipoContratacao(TipoContratacao.CLT); break;
			case "3": funcionario.setTipoContratacao(TipoContratacao.TERCERIZADO); break;
			}
			
			var funcionarioRepository = new FuncionarioRepository();
			funcionarioRepository.exportarDados(funcionario);
		
		}
		
		catch(Exception e)
		{
			System.out.println("Falha na captura dos dados" + e.getMessage());
		}
		
	}
}
