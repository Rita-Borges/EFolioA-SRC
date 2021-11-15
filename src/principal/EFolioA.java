/*  E-fólio A
*   SEGURANÇA EM REDES E COMPUTADORES
*   21181
*   Realizado por Ana Rita Borges Pinho
*   nº 1800464
*   Licenciatura de engenharia informática
*/

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

    //Função que apresenta e as opções primárias e armazena a informação digitada pelo utilizador
    public  void  Opcoes() {
        Scanner texto = new Scanner(System.in);
        System.out.println("Digite: \n 1 -> Cifra ROT13 (Cifra Simétrica) \n 2 -> Cifra RSA (Cifra Assimétrica)\n 3 -> Exit ");
        setOpcao(texto.nextInt()); //le o input
        texto.nextLine();
        System.out.println("opção: " + getOpcao());//output
    }
    //Função que apresenta e as opções secundárias  e armazena a informação digitada pelo utilizador
    public  void  Opcoes1() {
        Scanner texto = new Scanner(System.in);//input
        System.out.println("Digite:\n 1 -> Apenas Encriptar \n 2 -> Encriptar e Desencriptar   \n 3 -> Exit");
        setOpcao (texto.nextInt()); //le o input
        texto.nextLine();
        System.out.println("opção: " + getOpcao());//output
    }
    //Função que apresenta e armazena o texto claro (plaintext)
    public  void  Plaintext() {
        Scanner texto = new Scanner(System.in);// input
        System.out.println("Digite o Plaintext Pretendido: ");
        setPlaintext(texto.nextLine());   //le o input
        System.out.println("Texto Claro: " + getPlaintext());  //Output
    }
    public  void  Exit() {
        System.out.println("Exit");
    }
    //Resultados dos cálculos matemáticos necessários para chegar a conclusão da cifra RSA
    public  void rsaVariaveis() {
        Assimetrico RSA = new Assimetrico();
        RSA.AlgoritmoRSA ();
        System.out.println("\nResultado do algoritmo RSA: ");// Output
        System.out.println("p = " + RSA.getP());// Output
        System.out.println("q = " + RSA.getQ());  // Output
        System.out.println("n = " + RSA.getN());  // Output
        System.out.println("d = " + RSA.getD());  // Output
        System.out.println("e = " + RSA.getE());  // Output
        System.out.println("phi = " + RSA.getPhi());  //Output
    }

    //Função principal
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
                        Rot13.Rot13Encriptar( );
                        System.out.println("Texto Encriptado: " + Rot13.getMsgEncriptada());// Output
                    }else if (principal.getOpcao() == 2) {
                        principal.Plaintext();
                        Rot13.setPlainText(principal.getPlaintext().toUpperCase());
                        Rot13.Rot13EncriptarDesencriptar( );
                        System.out.println("Texto Encriptado: " + Rot13.getMsgEncriptada());// Output
                        System.out.println("Texto Desencriptado: " + Rot13.getMsgDesencriptada());// Output
                    }else if (principal.getOpcao() == 3) {
                        principal.Exit();
                        break;
                    }
                } else if (principal.getOpcao() == 2) {
                    principal.Opcoes1();
                    Assimetrico RSA = new Assimetrico();
                    if (principal.getOpcao( ) == 1){
                        principal.Plaintext();
                        RSA.RsaEncriptar(principal.getPlaintext());
                        System.out.println("Texto Encriptado: " + RSA.getMsgEncriptada());
                    } else if (principal.getOpcao( ) == 2){
                        principal.Plaintext();
                        RSA.RsaEncriptarDesencriptar(principal.getPlaintext() );
                        System.out.println("Texto Encriptado: " + RSA.getMsgEncriptada());// Output
                        System.out.println("Texto Desencriptado: " + RSA.getMsgDesencriptada());// Output
                        principal.rsaVariaveis();
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
