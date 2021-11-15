/* Cifra simétrica: ROT13 */

package principal;

public class Simetrico{
    private String plaintext;
    private String MsgEncriptada;
    private String MsgDesencriptada;

    // construtor
    public Simetrico ( ) {
        this.plaintext = null;
        this.MsgEncriptada = null;
        this.MsgDesencriptada = null;
    }
    //obtem os valores de plaintext
    public String getPlaintext ( ){
        return this.plaintext;
    }
    //atualiza os valores de plaintext
    public void setPlainText(String plaintext) {
        this.plaintext = plaintext;
    }
    //obtem os valores de MsgEncriptada
    public String getMsgEncriptada( ){
        return this.MsgEncriptada;
    }
    //atualiza os valores de MsgEncriptada
    public void setMsgEncriptada(String MsgEncriptada) {
        this.MsgEncriptada = MsgEncriptada;
    }
    //obtem os valores de MsgDesencriptada
    public String getMsgDesencriptada( ){
        return this.MsgDesencriptada;
    }
    //atualiza os valores de MsgDesencriptada
    public void setMsgDesencriptada(String MsgDesencriptada) {
        this.MsgDesencriptada = MsgDesencriptada;
    }

    //Função algoritmo rot13 ->  Desloca cada caráter do plaintexto pelo seu 13 caráter.
    //O alfabeto é composto por 26 caracteres e a 13º caráter é o M.
    //Caso a letra a cifrar seja maior do que M então vai procurar a sua corresponde  (letra= letra - 13).
    //Caso a letra a cifrar seja menor do que M então vai procurar a sua corresponde (letra= letra + 13).
    public  String AlgoritmoRot13( ) {
        char[] caracteres = this.getPlaintext().toCharArray();//conversão da String em array de caracteres
        int c = 0;
        while (c < caracteres.length ){
            char letra = caracteres[c];
            if (letra >= 'A' && letra <= 'Z') {//apenas é considerado o alfabeto (A a z)
                Character rot = (letra > 'M') ? (letra -= 13): (letra += 13);
            }
            caracteres[c] = letra;
            c++;
        }
        return new String(caracteres);//converção de array em new String
    }
    //Função para Encriptar -> utiliza uma vez o algoritmo rot13
    public String Rot13Encriptar( ) {
        setMsgEncriptada(AlgoritmoRot13());
        return getMsgEncriptada();
    }
    //Função para Encriptar e Desencriptar -> utiliza duas vezes o algoritmo rot13
    public void Rot13EncriptarDesencriptar( ) {
        setMsgEncriptada(Rot13Encriptar());
        setPlainText(getMsgEncriptada());
        setMsgDesencriptada(AlgoritmoRot13());
    }
}
