package aplicacao;
import java.util.Scanner;

import utilitarios.GrafoListaAdj;
import utilitarios.GrafoMatrizAdj;
import utilitarios.LimparTela;

public class main {
    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

        //Definição numero de vertices do grafo
		    Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de vértices:");
        int numVertices = scanner.nextInt();
        int num;

        // Criação de um grafo por Matriz e lista de Adjacência
        GrafoMatrizAdj grafoMatrizAdj = new GrafoMatrizAdj(numVertices);
        GrafoListaAdj grafoListaAdj = new GrafoListaAdj(numVertices);

        //Definição de tipo
        System.out.println("\nDigite 1 para criar um garfo nao direcionado\nDigite 2 para criar um garfo direcionado");
        int EDirecionado = scanner.nextInt();



        switch (EDirecionado) {
          //NAO DERECIONADO
          case 1: 
          LimparTela.limpar_console();
          System.out.println("Um grafo com " + numVertices + " vértices foi criado usando Matriz e Lista de Adjacência.\n" );

          do{
            System.out.println("\nDigite 1 para CRIAR ARESTAS\nDigite 2 para REMOVER ARESTAS\nDigite 3 para IDENTIFICAR A VIZINHANÇA DE UM VÉRTICE\nDigite 4 para IDENTIFICAR O GRAU DE UM VÉRTICE\nDigite 5 para TESTAR O GRAFO\nDigite 6 para REPRESENTAÇÃO EM MATRIZ\nDigite 7 para REPRESENTAÇÃO EM LISTA\nDigite 0 para SAIR " );
            num = scanner.nextInt();

            switch (num) {

              case 1:
                LimparTela.limpar_console();
                System.out.println("Digite o vértice 1"); 
                int i = scanner.nextInt();

                System.out.println("Digite o vértice 2"); 
                int j = scanner.nextInt();

                grafoMatrizAdj.addAresta(i,j);
                grafoListaAdj.addAresta(i,j);
                
                break;

              case 2:
                LimparTela.limpar_console();
                System.out.println("Digite os vertices que deseja remover a aresta"); 
                int remove1 = scanner.nextInt();
                int remove2 = scanner.nextInt();

                grafoMatrizAdj.removeAresta(remove1, remove2);
                grafoListaAdj.removeAresta(remove1, remove2);
              
                break;

              case 3:
                LimparTela.limpar_console();
                System.out.println("Digite o vértice desejado"); 
                int verticeViznho = scanner.nextInt();

                System.out.println("A vizinhança de "+verticeViznho+ " são: "+grafoListaAdj.vizinhanca(verticeViznho));
                System.out.println("\nDe enter para continuar");
                new java.util.Scanner(System.in).nextLine(); //Pausa ate o enter
              
                break;

              case 4:
                LimparTela.limpar_console();
                System.out.println("Digite o vértice desejado"); 
                int verticeGrau = scanner.nextInt();

                System.out.println("\nO grau do vértice "+verticeGrau+" é: "+ grafoListaAdj.grauVertice(verticeGrau));
                System.out.println("\nDe enter para continuar");
                new java.util.Scanner(System.in).nextLine(); //Pausa ate o enter
               
               break;

              case 5:
                LimparTela.limpar_console();
                if (grafoListaAdj.isGrafoSimples()) {
                  System.out.println("O grafo é simples, ele não possui laços nem arestas paralelas.");
                } else {
                  System.out.println("O grafo não é simples.");
                }
                if (grafoListaAdj.isGrafoSimples()) {
                  int grauReferencia = grafoListaAdj.grauVertice(1); // Usamos o primeiro vértice como referência
                  System.out.println("O grafo é regular, todos os vértices têm o mesmo grau: " + grauReferencia);
                } else {
                  System.out.println("O grafo não é regular, seus vértices têm graus diferentes.");
                }
                if(grafoListaAdj.isGrafoSimples() == false){
                  System.out.println("O grafo não é completo pois não é simples");
                }
                if(grafoListaAdj.isGrafoSimples()){
                  if(grafoListaAdj.isGrafoCompleto()){
                    System.out.println("O grafo é completo, todos os vertices conectam com todos os outros.");
                  } 
                  else if (grafoListaAdj.isGrafoCompleto() == false) {
                  System.out.println("O grafo não é completo.");
                  }
                }
                if(grafoListaAdj.isGrafoBipartido()){
                  System.out.println("O grafo é bipartido.");
                }
                else{
                  System.out.println("O grafo não é bipartido.");
                }
                System.out.println("\nDe enter para continuar");
                new java.util.Scanner(System.in).nextLine(); //Pausa ate o enter
                              
                break;

              case 6:
                LimparTela.limpar_console();

                grafoMatrizAdj.imprimizrMatriz();

                System.out.println("\nDe enter para continuar");
                new java.util.Scanner(System.in).nextLine(); //Pausa ate o enter
              
                break;

              case 7:
                LimparTela.limpar_console();

                grafoListaAdj.imprimirLista();

                System.out.println("\nDe enter para continuar");
                new java.util.Scanner(System.in).nextLine(); //Pausa ate o enter
              
                break;

              default:
        
                break;
            }
           LimparTela.limpar_console();
          } while (num!=0);


          break;


          //DIRECIONADO 
          case 2:
          LimparTela.limpar_console();
          System.out.println("Um grafo direcionado com " + numVertices + " vértices foi criado usando Matriz e Lista de Adjacência.\n"); 
          
          do{
            System.out.println("\nDigite 1 para CRIAR ARESTAS\nDigite 2 para REMOVER ARESTAS\nDigite 3 para IDENTIFICAR OS SUCESSORES E PREDECESSORRES DE UM VÉRTICE\nDigite 4 para IDENTIFICAR O GRAU DE UM VÉRTICE\nDigite 5 para TESTAR O GRAFO\nDigite 6 para REPRESENTAÇÃO EM MATRIZ\nDigite 7 para REPRESENTAÇÃO EM LISTA\nDigite 0 para SAIR" );
            num = scanner.nextInt();

            switch (num) {
              case 1:
                LimparTela.limpar_console();
                System.out.println("Digite o vertice de origem"); 
                int origem = scanner.nextInt();

                System.out.println("Digite o vertice de destino"); 
                int destino = scanner.nextInt();

                grafoMatrizAdj.addArestaDir(destino, origem);
                grafoListaAdj.addArestaDirecionada(origem, destino);

                break;

              case 2:
                LimparTela.limpar_console();
                System.out.println("Digite os vertices que deseja remover a aresta"); 
                int remove1 = scanner.nextInt();
                int remove2 = scanner.nextInt();

                grafoMatrizAdj.removeAresta(remove1, remove2);
                grafoListaAdj.removeAresta(remove1, remove2);
                
                break;

              case 3:
                
                break;

              case 4:
                LimparTela.limpar_console();
                System.out.println("Digite o vértice desejado"); 
                int verticeGrau = scanner.nextInt();

                System.out.println("\nO grau de entrada do vértice "+verticeGrau+" é: "+ grafoListaAdj.grauEntrada(verticeGrau));
                System.out.println("O grau de saída do vértice "+verticeGrau+" é: "+ grafoListaAdj.grauVertice(verticeGrau));
                
                System.out.println("\nDe enter para continuar");
                new java.util.Scanner(System.in).nextLine(); //Pausa ate o enter
               
                
                break;

              case 5:
                LimparTela.limpar_console();
                if (grafoListaAdj.isGrafoSimples()) {
                  System.out.println("O grafo é simples, ele não possui laços.");
                } else {
                  System.out.println("O grafo não é simples.");
                }
                if (grafoListaAdj.isGrafoRegularDirecionado()) {
                  int grauReferenciaEntrada = grafoListaAdj.grauEntrada(1);
                  int grauReferenciaSaida = grafoListaAdj.grauSaida(1);
                  System.out.println("O grafo é regular, todos os vértices têm os mesmos graus: " +grauReferenciaEntrada+ " para grau de entrada e " +grauReferenciaSaida+ " para grau de saída");
                } else {
                  System.out.println("O grafo não é regular, seus vértices têm graus diferentes.");
                }
                if(grafoListaAdj.isGrafoSimples() == false){
                System.out.println("O grafo não é completo pois não é simples");
                }
                if(grafoListaAdj.isGrafoSimples()){
                  if(grafoListaAdj.isGrafoCompletoDirecionado()){
                    System.out.println("O grafo é completo, todos os vertices conectam com todos os outros.");
                  } 
                  else if (grafoListaAdj.isGrafoCompletoDirecionado() == false) {
                    System.out.println("O grafo não é completo.");
                  }
                }
                if(grafoListaAdj.isGrafoBipartidoDirecionado()){
                  System.out.println("O grafo é bipartido.");
                }
                else{
                  System.out.println("O grafo não é bipartido.");
                }
                System.out.println("\nDe enter para continuar");
                new java.util.Scanner(System.in).nextLine(); //Pausa ate o enter
                break;

              case 6:
                LimparTela.limpar_console();

                grafoMatrizAdj.imprimizrMatriz();

                System.out.println("\nDe enter para continuar");
                new java.util.Scanner(System.in).nextLine();
                
                break;

              case 7:

                LimparTela.limpar_console();

                grafoListaAdj.imprimirLista();

                System.out.println("\nDe enter para continuar");
                new java.util.Scanner(System.in).nextLine(); //Pausa ate o enter
                
                break;
          
              default:
        
                break;
            }
            LimparTela.limpar_console();
          } while (num !=0);

            break;
        
          default:
            break;
        }    
	}
   
}
