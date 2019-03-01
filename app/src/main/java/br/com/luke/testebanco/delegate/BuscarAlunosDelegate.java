package br.com.luke.testebanco.delegate;

import java.util.List;

import br.com.luke.testebanco.dto.AlunoDTO;
import br.com.luke.testebanco.entity.Aluno;

public interface BuscarAlunosDelegate {

    void retornoAlunos(List<AlunoDTO> alunos);
}
