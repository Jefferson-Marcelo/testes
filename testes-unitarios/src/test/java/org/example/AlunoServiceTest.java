package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoDAO alunoDAO;

    @Test
    public void NaoInsereAlunoComMatriculaQueExiste(){
        Aluno aluno = new Aluno(1, "Jefferson", 34, "01234567890", "012");
        Mockito.doReturn(true).when(alunoDAO).existeMatriculaAtiva("01234567890");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno));

    }

    @Test
    public void NaoInsereAlunoComCPFQueExiste(){
        Aluno aluno2 = new Aluno(2, "Marcelo", 35, "01234567890", "012");
        Mockito.doReturn(true).when(alunoDAO).existeAlunoComCPF("012");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno2));
    }

    @Test void NaoInsereAlunoComIdadeMenorQue18Anos(){
        Aluno aluno3 = new Aluno(3, "Joao", 15, "01234567890", "012");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno3));
    }
}
