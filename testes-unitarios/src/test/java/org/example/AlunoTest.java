package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunoTest {
    @Test
    public void NaoAlteraMatriculaComMenosDe11Digitos(){
        Aluno aluno = new Aluno(1, "Maria", 30, "01234567890", "012");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("012345"));
    }

    @Test
    public void NaoAlteraMatriculaSeTiverCaracterEspecial(){
        Aluno aluno = new Aluno(1, "Joana", 25, "01234567890", "012");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("@#234567890"));
    }


}
