package controle;
import entidade.Aluno;
import java.util.ArrayList;

public class ImpressaoAlunos {
    private static Aluno[] alunos;
    
    public static void main(String[] args){
        alunos = criarAlunos();
        imprimirAlunos("Alunos cadastrados", alunos);
        ArrayList<Aluno> alunos_selecionados = selecionarAlunos();
        imprimirAlunos("Alunos selecionados: ",
                alunos_selecionados.toArray(new Aluno[alunos_selecionados.size()]));
    }

    private static Aluno[] criarAlunos() {
        Aluno[] alunos = new Aluno[8];
        alunos[0] = new Aluno ("Ana Julia", 1995, 'F');
        alunos[0].setestadocivil(Aluno.EstadoCivil.solteiro);
        alunos[0].setestrangeiro(false);
        alunos[1] = new Aluno ("Joaquim", 1990, 'M');
        alunos[1].setestadocivil(Aluno.EstadoCivil.casado);
        alunos[1].setestrangeiro(true);
        alunos[2] = new Aluno ("Ana Ligia", 1998, 'F');
        alunos[2].setestadocivil(Aluno.EstadoCivil.solteiro);
        alunos[2].setestrangeiro(false);
        alunos[3] = new Aluno ("Mateus", 1991, 'M');
        alunos[3].setestadocivil(Aluno.EstadoCivil.solteiro);
        alunos[3].setestrangeiro(false);
        alunos[4] = new Aluno ("Livia", 1985, 'F');
        alunos[4].setestadocivil(Aluno.EstadoCivil.casado);
        alunos[4].setestrangeiro(true);
        alunos[5] = new Aluno ("Roberto", 1990, 'M');
        alunos[5].setestadocivil(Aluno.EstadoCivil.casado);
        alunos[5].setestrangeiro(false);
        alunos[6] = new Aluno ("Ana Maria", 1991, 'F');
        alunos[6].setestadocivil(Aluno.EstadoCivil.solteiro);
        alunos[6].setestrangeiro(false);
        alunos[7] = new Aluno ("Sandro", 1992, 'M');
        alunos[7].setestadocivil(Aluno.EstadoCivil.solteiro);
        alunos[7].setestrangeiro(true);
        return alunos;
    }

    private static ArrayList<Aluno> selecionarAlunos() {
        int ano_inicial = 1990;
        int ano_final = 1995;
        Aluno.EstadoCivil estado_civil;
        estado_civil = Aluno.EstadoCivil.solteiro;
        System.out.println("---Filtros de selecao: alunos nascidos entre: "
                + ano_inicial + "e" + ano_final + "com estado civil " + estado_civil + "\n");
        return filtrarAlunos(ano_inicial, ano_final, estado_civil);
    }

    private static ArrayList<Aluno> filtrarAlunos(int ano_inicial, int ano_final, Aluno.EstadoCivil estado_civil) {
        ArrayList<Aluno> alunos_selecionados = new ArrayList();
        for (int n=0; n<alunos.length; n++){
         int ano_nascimento = alunos[n].getanoNascimento();
         if((ano_nascimento >= ano_inicial)&&(ano_nascimento <= ano_final)
                 &&(alunos[n].getestadocivil() == estado_civil)){
             alunos_selecionados.add(alunos[n]);
         }
        }
        return alunos_selecionados;
    }

    private static void imprimirAlunos(String cabecalho, Aluno[] alunos) {
        System.out.println("---" + cabecalho);
        String dados_aluno;
        for(Aluno aluno : alunos){
            dados_aluno = aluno.getnome() + "   nasceu em : " + 
                    aluno.getanoNascimento() + "- sexo : ";
                    if (aluno.getsexo()=='F') dados_aluno += "Feminino";
                    else dados_aluno += "Masculino";
                    dados_aluno += "- estado civil : " + aluno.getestadocivil();
                    if (aluno.isEstrangeiro()) dados_aluno += "- estrangeiro.";
                    System.out.println(dados_aluno);
        }
        System.out.println();
    }
}
