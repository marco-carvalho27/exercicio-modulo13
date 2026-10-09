import java.util.Arrays;
import java.util.Scanner;

public class CadastroNotas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int qtdNotas = 2;
        final int qtdMedias = 4;
        String opcao = "s";
        Aluno[] aluno = new Aluno[0];
        int qtdTotalAlunos = 0;


        do{

            System.out.print("Digite a quantidade de alunos que deseja cadastrar: ");
            int qtdAluno = Integer.parseInt(input.nextLine());

            if(qtdAluno < 0){
                System.out.println("Digite uma quantidade maior que zero");
                continue;
            }

            aluno = Arrays.copyOf(aluno, aluno.length + qtdAluno);

            for(int y = 0; y < qtdAluno; y++){

                Aluno novoAluno = new Aluno();

                System.out.print("\nDigite o nome do aluno: ");
                String nome =  input.nextLine();
                novoAluno.setNome(nome);



                Float[][] nota = new Float[qtdMedias][qtdNotas];
                Float[] media = new Float[qtdMedias];

                float somaMedia = 0;

                for(int i = 0; i < qtdMedias; i++){

                    float somaNota = 0;
                    System.out.printf("\n  %dº Bimestre",(i+1));
                    System.out.println("");

                    for(int j = 0; j < qtdNotas; j++){
                        //System.out.printf("Digite a %dª nota: ",(j+1));
                        //nota[i][j] = Float.parseFloat(input.nextLine());
                        nota[i][j] = validarNota(input, String.format("Digite a %dª nota: ",(j+1)));

                        somaNota += nota[i][j];
                    }
                    media[i] = somaNota / qtdNotas;
                    somaMedia += media[i];
                }

                Float mediaAnual = somaMedia / qtdMedias;

                novoAluno.setNota(nota);
                novoAluno.setMedia(media);
                novoAluno.setMediaAnual(mediaAnual);

                aluno[qtdTotalAlunos] = novoAluno;

                qtdTotalAlunos++;

                System.out.println("\nCadastro realizado com sucesso");
            }

            System.out.println("\nDeseja cadastrar mais alunos? (s/n)");
            opcao = String.valueOf(input.nextLine().toLowerCase().charAt(0));
        }while(opcao.equals("s"));

        System.out.println("Alunos cadastrados:");

        for(int i = 0; i < qtdTotalAlunos; i++){
            System.out.printf("\n\nAluno: %s",aluno[i].getNome());

            Float[] media = aluno[i].getMedia();

            for(int j = 0; j < media.length; j++){
                System.out.printf("\nMédia do %d bimestre: %.2f",(j+1), media[j]);
            }

            System.out.printf("\nMedia anual: %.2f",aluno[i].getMediaAnual());
        }
        input.close();
    }

    private static float validarNota(Scanner input, String mensagem) {

        while (true) {

            System.out.print(mensagem);
            String entrada = input.nextLine().trim().replace(',', '.');

            try {
                float nota = Float.parseFloat(entrada);

                if (nota >= 0 && nota <= 10) {
                    return nota;
                }

                System.out.println("\nNota inválida! \nDigite um valor entre 0 e 10.");
                System.out.println("");

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }
}