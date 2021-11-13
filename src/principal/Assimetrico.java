/* algoritmo RSA */

package principal;

import java.math.BigInteger;
import java.util.Random;

public class Assimetrico {
    private String plaintext;
    private String MsgCriptada;
    private String MsgDecriptada ;
    private BigInteger p, q, n, d, e, phi;
    private final int bitlen ;
    // construtor
    public Assimetrico ( ){
        this.plaintext = null;
        this.MsgCriptada = null;
        this.MsgDecriptada = null;
        this.bitlen = 2048;
        this.p = null;
        this.q = null;
        this.n = null;
        this.d = null;
        this.e = null;
        this.phi=null;
    }
    //Obtem os valores de plaintext
    public String getplaintext ( ){
        return this.plaintext;
    }
    //Atualiza os valores de plaintext
    void setPlaintext (String plaintext){
        this.plaintext = plaintext;
    }
    //Obtem os valores de MsgCriptada
    public String getMsgcriptada ( ){
        return this.MsgCriptada;
    }
    //Atualiza os valores de MsgCriptada
    public  void setMsgcriptada (String Msgcriptada){
        this.MsgCriptada = Msgcriptada;
    }
    //Obtem os valores de MsgDecriptada
    public String getMsgDecriptada ( ){
        return this.MsgDecriptada;
    }
    //Atualiza os valores de MsgDecriptada
    public void setMsgDecriptada (String MsgDecriptada){
        this.MsgDecriptada = MsgDecriptada;
    }
    //Obtem os valores de bitlen
    int getbitlen ( ){
        return this.bitlen;
    }

    //Obtem os valores de p
    public BigInteger getP( ){
        return p;
    }
    //Atualiza os valores de p
    public void setP(BigInteger p){
        this.p = p;
    }
    //Obtem os valores de q
    public BigInteger getQ( ){
        return q;
    }
    //Atualiza os valores de q
    public void setQ(BigInteger q){
        this.q = q;
    }
    //Obtem os valores de n
    public BigInteger getN( ){
        return n;
    }
    //Atualiza os valores de n
    public void setN(BigInteger n){
        this.n = n;
    }
    //Obtem os valores de d
    public BigInteger getD( ){
        return d;
    }
    //Atualiza os valores de d
    public void setD(BigInteger d){
        this.d = d;
    }
    //Obtem os valores de e
    public BigInteger getE( ){
        return e;
    }
    //Atualiza os valores de e
    public void setE(BigInteger e){
        this.e = e;
    }
    //Obtem os valores de phi
    public BigInteger getPhi( ){
        return phi;
    }
    //Atualiza os valores de phi
    public void setPhi(BigInteger phi){
        this.phi = phi;
    }

    //Funcao algoritmo RSA
    public void AlgoritmoRSA () {

        //1 -> Escolher aleatoriamente  dois numeros primos (BigInteger) p e q
        setP(BigInteger.probablePrime(getbitlen() / 2, new Random()));
        setQ(BigInteger.probablePrime(getbitlen() / 2, new Random()));

        //2 -> descobrir o valor de  n = produto de "p" e "q"
        this.setN(getP().multiply(getQ()));

        //3 -> Descobrir phi(n) = (p -1) (q -1)
        this.setPhi((getP().subtract(BigInteger.ONE)).multiply(getQ().subtract(BigInteger.ONE)));

        //4 -> Escolher um numero  inteiro  e ( 1 < e < phi(n)) ,  de forma a que 'e' e phi(n) sejam primos entre si
        this.setE(new BigInteger("3"));
         do {
             this.setE(getE().add(new BigInteger("2")));

         } while(getPhi().gcd(getE()).intValue() > 1);

        //5 -> d = inverso multiplicativo de "e"
        this.setD(getE().modInverse(getPhi()));
    }
    //Funcao para Criptar
     public void  Criptar( String texto) {
         setPlaintext(texto);
         AlgoritmoRSA( );
         this.setMsgcriptada(new BigInteger(getplaintext().getBytes()).modPow(getE(), getN()).toString());
     }
     //Funcao para Criptar e Decriptar
    public void Criptar_Decriptar(String texto) {
        Criptar(texto);
        this.setMsgDecriptada(new String(new BigInteger(getMsgcriptada()).modPow(getD(), getN()).toByteArray()));
    }
}

