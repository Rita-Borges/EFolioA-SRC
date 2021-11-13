/*  Lei-EfolioA  */
package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

class EFolioA {
    private String plaintext;
    private int opcao;

    //construtor
    public EFolioA ( ) {
        this.plaintext = null;
        this.opcao = 0 ;
    }
    //Obtem os valores de plaintext
    public String getPlaintext ( ){
        return this.plaintext;
    }
    //Atualiza os valores de plaintext
    public void setPlaintext (String plaintext){
        this.plaintext = plaintext;
    }
    //Obtem os valores de opcao
    public int getOpcao ( ){
        return this.opcao;
    }
    //Atualiza os valores de opcao
    void setOpcao (int opcao){
        this.opcao = opcao;
    }

    //Funcao que apresenta e as opcoes primarias e armazena a informacao digitada pelo utilizador
    public  void  Opcoes() {
        Scanner texto = new Scanner(System.in);
        System.out.println("Digite: \n 1 -> Cifra ROT13 (Cifra Simétrica) \n 2 -> Cifra RSA (Cifra Assimétrica)\n 3 -> Exit ");
        setOpcao(texto.nextInt()); //le o input
        texto.nextLine();
        System.out.println("opção: " + getOpcao());//output
    }
    //Funcao que apresenta e as opcoes secundarias  e armazena a informacao digitada pelo utilizador
    public  void  Opcoes1() {
        Scanner texto = new Scanner(System.in);//input
        System.out.println("Digite:\n 1 -> Apenas Cifrar \n 2 -> Cifrar e Decifrar   \n 3 -> Exit");
        setOpcao (texto.nextInt()); //le o input
        texto.nextLine();
        System.out.println("opção: " + getOpcao());//output
    }
    //Funcao que apresenta e armazena o texto claro (plaintext)
    public  void  Plaintext() {
        Scanner texto = new Scanner(System.in);// input
        System.out.println("Digite o Plaintext Pretendido: ");
        setPlaintext(texto.nextLine());   //le o input
        System.out.println("Texto Claro: " + getPlaintext());  //Output
    }
    public  void  Exit() {
        System.out.println("Exit");
    }
    //Resultados dos calculos matematicos necessarios para chegar a conclusao da cifra RSA
    public  void  VariaveisRSA() {
        Assimetrico RSA = new Assimetrico();
        RSA.AlgoritmoRSA ();
        System.out.println("Resultado do algoritmo RSA: \n");// Output
        System.out.println("p = " + RSA.getP());// Output
        System.out.println("q = " + RSA.getQ());  // Output
        System.out.println("n = " + RSA.getN());  // Output
        System.out.println("d = " + RSA.getD());  // Output
        System.out.println("e = " + RSA.getE());  // Output
        System.out.println("phi = " + RSA.getPhi());  //Output
    }

    //funcao principal
    public static void main(String[] args) {
        try {
            EFolioA principal = new EFolioA();
            do {
                principal.Opcoes();
                if (principal.getOpcao() == 1) {
                    Simetrico Rot13 = new Simetrico();
                    principal.Opcoes1();
                    if (principal.getOpcao() == 1){
                        principal.Plaintext();
                        Rot13.setPlainText(principal.getPlaintext().toUpperCase());
                        Rot13.RotCrip( );
                        System.out.println("Texto Criptado: " + Rot13.getMsgCriptada());// Output
                    }else if (principal.getOpcao() == 2) {
                        principal.Plaintext();
                        Rot13.setPlainText(principal.getPlaintext().toUpperCase());
                        Rot13.RotEn_De( );
                        System.out.println("Texto Criptado: " + Rot13.getMsgCriptada());// Output
                        System.out.println("Texto Criptado: " + Rot13.getMsgDecriptada());// Output
                    }else if (principal.getOpcao() == 3) {
                        principal.Exit();
                        break;
                    }
                } else if (principal.getOpcao() == 2) {
                    principal.Opcoes1();
                    Assimetrico RSA = new Assimetrico();
                    if (principal.getOpcao( ) == 1){
                        principal.Plaintext();
                        RSA.Criptar(principal.getPlaintext());
                        System.out.println("Texto criptada: " + RSA.getMsgcriptada());
                    } else if (principal.getOpcao( ) == 2){
                        principal.Plaintext();
                        RSA.Criptar_Decriptar(principal.getPlaintext() );
                        System.out.println("Texto criptada: " + RSA.getMsgcriptada());// Output
                        System.out.println("Texto Decriptada: " + RSA.getMsgDecriptada());// Output
                        principal.VariaveisRSA();
                    } else if (principal.getOpcao( ) == 3){
                        principal.Exit();
                        break;
                    }
                }else if (principal.getOpcao() == 3){
                   principal.Exit();
                    break;
                }
            } while (principal.getOpcao() < 0 || principal.getOpcao() > 3);
        } catch (InputMismatchException error) {
            System.out.println("Tente novamente!");  // Output
        }
    }
}
