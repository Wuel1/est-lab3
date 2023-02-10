public class ListaLigada implements EstruturaDeDados{
    private No inicio;

    public static void main(String[] args) {
        
        ListaLigada teste = new ListaLigada();
        System.out.println(teste.insert(2));
        System.out.println(teste.insert(10));
        System.out.println(teste.insert(10));
        System.out.println(teste.insert(20));
        System.out.println(teste.insert(32));
        System.out.println(teste.insert(10));
        System.out.println(teste.insert(35));
        System.out.println(teste.insert(1));
        System.out.println(teste.insert(10));

        System.out.println("-----------------");


        System.out.println(teste.search(31));
        System.out.println(teste.search(32));
        System.out.println(teste.sucessor(20));
        System.out.println(teste.sucessor(32));
        System.out.println(teste.prodessor(32));
        System.out.println(teste.delete(32));
        System.out.println(teste.search(32));
        System.out.println(teste.minimum());
        System.out.println(teste.maximum());




        // for (int i = 0; i < 100; i++) {
        //     System.out.println(i);
        //     if (i == 50){
        //         break;
        //     }
        // }
        // System.out.println("fim");
    }

    @Override
    public boolean insert(int chave) {
        if(inicio == null){
            inicio = new No(chave);
            return true;           
        }
        else{
            adicionar(inicio, chave);
            return true;
        }
    }

    @Override
    public boolean delete(int chave){
        if(searchNo(inicio, chave)){
            return searchDetele(inicio, chave);
        }
        return false;
    }

    @Override
    public boolean search(int chave){
        if(inicio.getValor() == chave){
            return true;
        }
        else{
            return searchNo(inicio.getProximo(), chave);
        }
    }

    @Override
    public int minimum() {
        int valor = 99999999;
        return ComparaMinimo(inicio, valor);
    }
    

    @Override
    public int maximum() {
        int valor = 0;
        return ComparaMaximo(inicio, valor);
    }

    @Override
    public int sucessor(int chave) {
        if(search(chave)){
            return searchSucessor(inicio, chave);
        }
        return -1;
    }

    @Override
    public int prodessor(int chave) {
        if(inicio.getProximo() == null){
            return -1;
        }
        else if(search(chave)){
            int anterior = searchAnterior(inicio, chave);
            return anterior;
        }
        return 0;
    }

    public boolean searchNo(No no, int chave){
        if(no.getValor() == chave){
            return true;
        }
        else if(no.getProximo() == null){
            return false;
        }
        else{
            return searchNo(no.getProximo(), chave);
        }
    }

    public void adicionar(No no, int chave){
        if(no.getProximo() == null){
            No novoNo = new No(chave);
            no.setProximo(novoNo);
        }
        else{
            adicionar(no.getProximo(), chave);
        }
    }
    
    public int searchSucessor(No no, int chave){
        if(no.getProximo() == null){            
            return -1;
        }
        else if(no.getValor() == chave){
            int NoSucessor = no.getProximo().getValor();
            return NoSucessor;
        }
        else{
            return searchSucessor(no.getProximo(), chave);
        }
    }

    public int searchAnterior(No no, int chave){
        if(no.getProximo().getValor() == chave){
            return no.getValor();
        }
        else if(no.getProximo() == null){
            return -1;
        }
        else{
            return searchAnterior(no.getProximo(), chave);
        }
    }

    public boolean searchDetele(No no, int chave){        
        if(no.getProximo().getValor() == chave){
            no.setProximo(no.getProximo().getProximo());
            return true;
        }
        else if(no.getProximo() == null){
            return false;
        }
        else{
            return searchDetele(no.getProximo(), chave);
        }
    }

    public int ComparaMaximo(No no, int chave){
        int valor = chave;
        if(no.getValor() > chave){
            valor = no.getValor();
            return ComparaMaximo(no.getProximo(), valor);
        }
        else if(no.getProximo() == null){
            return valor;
        }
        else{
            return ComparaMaximo(no.getProximo(), valor);
        }
    }

    public int ComparaMinimo(No no, int chave){
        int valor = chave;
        if(no.getValor() < chave){
            valor = no.getValor();
            return ComparaMinimo(no.getProximo(), valor);
        }
        else if(no.getProximo() == null){
            return valor;
        }
        else{
            return ComparaMinimo(no.getProximo(), valor);
        }
    }

        

    // public No RetornaNo(int chave){
    //     if(search(chave)){
    //         if(inicio.getValor() == chave){
    //             return inicio;
    //         }
    //         else if(searchNo(inicio.getProximo(), chave)){
    //             No no = new No(inicio.getProximo().getValor());
    //             return no;
    //         }                 
    //     }
    //     return null;
    // }
}
