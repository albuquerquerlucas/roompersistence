package br.com.luke.testebanco.delegate;

import java.util.List;

import br.com.luke.testebanco.dto.TurmaDTO;
import br.com.luke.testebanco.entity.Aluno;

public interface BuscarAlunosPorTurmaDelegate {

    void retornoAlunosPorTurma(List<TurmaDTO> turmas);
}
