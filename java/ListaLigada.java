public class ListaLigada implements EstruturaDeDados{
    private No inicio;

    public static void main(String[] args) {
        
        ListaLigada teste = new ListaLigada();
        System.out.println(teste.insert(10));
        System.out.println(teste.insert(10));
        System.out.println(teste.insert(10));
        System.out.println(teste.insert(10));
        System.out.println(teste.insert(32));
        System.out.println(teste.insert(10));
        System.out.println(teste.insert(10));
        System.out.println(teste.insert(10));


        System.out.println(teste.search(32));
        System.out.println(teste.delete(32));




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
        if(search(chave)){
           return searchNoDelete(inicio, chave);
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int maximum() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int sucessor(int chave) {
        if(search(chave)){

        }
        return 0;
    }

    @Override
    public int prodessor(int chave) {
        // TODO Auto-generated method stub
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
    
    public boolean searchNoDelete(No no, int chave){
        if(no.getValor() == chave){
            no.setProximo(null);
            return true;
        }
        else if(no.getProximo() == null){
            return false;
        }
        else{
            return searchNo(no.getProximo(), chave);
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
