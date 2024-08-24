package repositories;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import entities.Funcionario;

public class FuncionarioRepository 
{
	public void exportarDados(Funcionario funcionario)
	{
		
		try 
		{
			var fileWriter = new FileWriter("c:\\temp\\funcionarios.txt", true);
			var printWriter = new PrintWriter(fileWriter);
			printWriter.write("\nId do Funcionario..: "+ funcionario.getId());
			printWriter.write("\nNome...............: "+ funcionario.getNome());
			printWriter.write("\nMatricula..........: "+ funcionario.getMatricula());
			printWriter.write("\nData de admissão...: "+ funcionario.getDataAdmissao());
			printWriter.write("\nTipo de Contratação: "+ funcionario.getTipoContratacao());
			printWriter.write("\n");
			
			printWriter.close();
			
			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
		}
		
		catch(Exception e)
		{
			System.out.println("\n Falha ao gravar o arquivo: "+ e.getMessage());
		}
		
	}

}