/* Cifra ROT13*/

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
    //obtem os valores de MsgCriptada
    public String getMsgEncriptada( ){
        return this.MsgEncriptada;
    }
    //atualiza os valores de MsgCriptada
    public void setMsgEncriptada(String MsgCriptada) {
        this.MsgEncriptada = MsgCriptada;
    }
    //obtem os valores de MsgDecriptada
    public String getMsgDesencriptada( ){
        return this.MsgDesencriptada;
    }
    //atualiza os valores de MsgDecriptada
    public void setMsgDesencriptada(String MsgDecriptada) {
        this.MsgDesencriptada = MsgDecriptada;
    }

    //Funcao algoritmo rot13 ->  Desloca cada caractere do plaintexto pelo seu 13 caractere.
    //O alfabeto é composto por 26 caracteres e a 13º caractere é o M.
    //Caso a letra a cifrar seja maior do que M então vai procurar a sua corresponde  (letra= letra - 13).
    //Caso a letra a cifrar seja menor do que M então vai procurar a sua corresponde (letra= letra + 13).
    public  String rot13( ) {
        char[] caracteres = this.getPlaintext().toCharArray();//conversão da String em array de caracteres
        int c = 0;
        while (c<caracteres.length ){
            char letra = caracteres[c];
            if (letra >= 'A' && letra <= 'Z') {//apanas é considerado o alfabeto (A a z)
                Character rot = (letra > 'M') ? (letra -= 13): (letra += 13);
            }
            caracteres[c] = letra;
            c++;
        }
        return new String(caracteres);//converção de array em new String
    }
    //Funcao para Criptar -> utiliza uma vez o algoritmo rot13
    public String rotEncriptacao( ) {
        setMsgEncriptada(rot13());
        return getMsgEncriptada();
    }
    //Funcao para Criptar e Decriptar  -> utiliza duas vezes o algoritmo rot13
    public void rotEnDe( ) {
        setMsgEncriptada(rotEncriptacao());
        setPlainText(getMsgEncriptada());
        setMsgDesencriptada(rot13());
    }
}
