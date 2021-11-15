/* Cifra Assimétrica: RSA */

package principal;

import java.math.BigInteger;
import java.util.Random;

public class Assimetrico {
    private String plaintext;
    private String MsgEncriptada;
    private String MsgDesencriptada;
    private BigInteger p, q, n, d, e, phi;
    private final int bitlen ;
    // construtor
    public Assimetrico ( ){
        this.plaintext = null;
        this.MsgEncriptada = null;
        this.MsgDesencriptada = null;
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
    //Obtem os valores de MsgEncriptada
    public String getMsgEncriptada( ){
        return this.MsgEncriptada;
    }
    //Atualiza os valores de MsgEncriptada
    public  void setMsgEncriptada(String MsgEncriptada){
        this.MsgEncriptada = MsgEncriptada;
    }
    //Obtem os valores de MsgDesencriptada
    public String getMsgDesencriptada( ){
        return this.MsgDesencriptada;
    }
    //Atualiza os valores de MsgDesencriptada
    public void setMsgDesencriptada(String MsgDesencriptada){
        this.MsgDesencriptada = MsgDesencriptada;
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

    //Função algoritmo RSA
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
    //Função para Encriptar ->  cálculo da potência modular(e,n)
     public void RsaEncriptar(String texto) {
         setPlaintext(texto);
         AlgoritmoRSA( );
         this.setMsgEncriptada(new BigInteger(getplaintext().getBytes()).modPow(getE(), getN()).toString());
     }
     //Função para Encriptar e Desencriptar ->  cálculo da potência modular(d,n)
    public void RsaEncriptarDesencriptar(String texto) {
        RsaEncriptar(texto);
        this.setMsgDesencriptada(new String(new BigInteger(getMsgEncriptada()).modPow(getD(), getN()).toByteArray()));
    }
}

