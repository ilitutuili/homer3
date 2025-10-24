import java.util.Scanner;

public class ListaNomesSimples {
    
    static class No {
        String nome;
        No prox;
        
        public No(String nome) {
            this.nome = nome;
            this.prox = null;
        }
        
        @Override
        public String toString() {
            return nome;
        }
    }
    
    static class ListaNomes {
        private No cabeca;
        private int tamanho;
        
        public boolean estaVazia() {
            return cabeca == null;
        }
        
        public int tamanho() {
            return tamanho;
        }
        
        // Inserir no início
        public void inserirInicio(String nome) {
            No novo = new No(nome);
            novo.prox = cabeca;
            cabeca = novo;
            tamanho++;
            System.out.println("✅ " + nome + " inserido no início.");
        }
        
        // Inserir no fim
        public void inserirFim(String nome) {
            No novo = new No(nome);
            if (estaVazia()) {
                cabeca = novo;
            } else {
                No atual = cabeca;
                while (atual.prox != null) {
                    atual = atual.prox;
                }
                atual.prox = novo;
            }
            tamanho++;
            System.out.println("✅ " + nome + " inserido no fim.");
        }
        
        // Inserir na posição específica
        public void inserirPosicao(int posicao, String nome) {
            if (posicao < 0 || posicao > tamanho) {
                System.out.println("❌ Posição inválida!");
                return;
            }
            
            if (posicao == 0) {
                inserirInicio(nome);
                return;
            }
            
            if (posicao == tamanho) {
                inserirFim(nome);
                return;
            }
            
            No novo = new No(nome);
            No atual = cabeca;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.prox;
            }
            novo.prox = atual.prox;
            atual.prox = novo;
            tamanho++;
            System.out.println("✅ " + nome + " inserido na posição " + posicao + ".");
        }
        
        // Remover do início
        public void removerInicio() {
            if (estaVazia()) {
                System.out.println("❌ Lista vazia!");
                return;
            }
            String nomeRemovido = cabeca.nome;
            cabeca = cabeca.prox;
            tamanho--;
            System.out.println("✅ " + nomeRemovido + " removido do início.");
        }
        
        // Remover do fim
        public void removerFim() {
            if (estaVazia()) {
                System.out.println("❌ Lista vazia!");
                return;
            }
            
            if (cabeca.prox == null) {
                String nomeRemovido = cabeca.nome;
                cabeca = null;
                tamanho--;
                System.out.println("✅ " + nomeRemovido + " removido do fim.");
                return;
            }
            
            No atual = cabeca;
            while (atual.prox.prox != null) {
                atual = atual.prox;
            }
            String nomeRemovido = atual.prox.nome;
            atual.prox = null;
            tamanho--;
            System.out.println("✅ " + nomeRemovido + " removido do fim.");
        }
        
        // Remover por posição
        public void removerPosicao(int posicao) {
            if (posicao < 0 || posicao >= tamanho || estaVazia()) {
                System.out.println("❌ Posição inválida!");
                return;
            }
            
            if (posicao == 0) {
                removerInicio();
                return;
            }
            
            No atual = cabeca;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.prox;
            }
            String nomeRemovido = atual.prox.nome;
            atual.prox = atual.prox.prox;
            tamanho--;
            System.out.println("✅ " + nomeRemovido + " removido da posição " + posicao + ".");
        }
        
        // Buscar por nome
        public boolean buscar(String nome) {
            No atual = cabeca;
            int posicao = 0;
            while (atual != null) {
                if (atual.nome.equals(nome)) {
                    System.out.println("✅ " + nome + " encontrado na posição " + posicao + ".");
                    return true;
                }
                atual = atual.prox;
                posicao++;
            }
            System.out.println("❌ " + nome + " não encontrado na lista.");
            return false;
        }
        
        // Buscar por posição
        public String buscarPorPosicao(int posicao) {
            if (posicao < 0 || posicao >= tamanho) {
                System.out.println("❌ Posição inválida!");
                return null;
            }
            
            No atual = cabeca;
            for (int i = 0; i < posicao; i++) {
                atual = atual.prox;
            }
            System.out.println("✅ Posição " + posicao + ": " + atual.nome);
            return atual.nome;
        }
        
        // Imprimir lista completa
        public void imprimir() {
            if (estaVazia()) {
                System.out.println("📋 Lista vazia.");
                return;
            }
            
            No atual = cabeca;
            System.out.print("📋 Lista: ");
            while (atual != null) {
                System.out.print(atual.nome);
                if (atual.prox != null) {
                    System.out.print(" → ");
                }
                atual = atual.prox;
            }
            System.out.println(" [Tamanho: " + tamanho + "]");
        }
        
        // Limpar lista
        public void limpar() {
            cabeca = null;
            tamanho = 0;
            System.out.println("🧹 Lista limpa.");
        }
    }
    
    public static void main(String[] args) {
        ListaNomes lista = new ListaNomes();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE LISTA DE NOMES ===");
        
        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Inserir nome");
            System.out.println("2. Inserir nome no início");
            System.out.println("3. Inserir nome em posição específica");
            System.out.println("4. Remover do início");
            System.out.println("5. Remover do fim");
            System.out.println("6. Remover por posição");
            System.out.println("7. Buscar nome");
            System.out.println("8. Buscar por posição");
            System.out.println("9. Imprimir lista");
            System.out.println("10. Limpar lista");
            System.out.println("11. Executar testes automáticos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            
            int opc = -1;
            try {
                opc = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("❌ Opção inválida.");
                continue;
            }
            
            if (opc == 0) {
                System.out.println("👋 Saindo...");
                break;
            }
            
            switch (opc) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine().trim();
                    if (!nome.isEmpty()) {
                        lista.inserirFim(nome);
                    } else {
                        System.out.println("❌ Nome não pode ser vazio.");
                    }
                    break;
                    
                case 2:
                    System.out.print("Digite o nome para inserir no início: ");
                    String nomeInicio = sc.nextLine().trim();
                    if (!nomeInicio.isEmpty()) {
                        lista.inserirInicio(nomeInicio);
                    } else {
                        System.out.println("❌ Nome não pode ser vazio.");
                    }
                    break;
                    
                case 3:
                    try {
                        System.out.print("Digite o nome: ");
                        String nomePos = sc.nextLine().trim();
                        System.out.print("Digite a posição: ");
                        int pos = Integer.parseInt(sc.nextLine().trim());
                        if (!nomePos.isEmpty()) {
                            lista.inserirPosicao(pos, nomePos);
                        } else {
                            System.out.println("❌ Nome não pode ser vazio.");
                        }
                    } catch (Exception e) {
                        System.out.println("❌ Posição inválida.");
                    }
                    break;
                    
                case 4:
                    lista.removerInicio();
                    break;
                    
                case 5:
                    lista.removerFim();
                    break;
                    
                case 6:
                    try {
                        System.out.print("Digite a posição para remover: ");
                        int posRemover = Integer.parseInt(sc.nextLine().trim());
                        lista.removerPosicao(posRemover);
                    } catch (Exception e) {
                        System.out.println("❌ Posição inválida.");
                    }
                    break;
                    
                case 7:
                    System.out.print("Digite o nome para buscar: ");
                    String nomeBuscar = sc.nextLine().trim();
                    if (!nomeBuscar.isEmpty()) {
                        lista.buscar(nomeBuscar);
                    } else {
                        System.out.println("❌ Nome não pode ser vazio.");
                    }
                    break;
                    
                case 8:
                    try {
                        System.out.print("Digite a posição para buscar: ");
                        int posBuscar = Integer.parseInt(sc.nextLine().trim());
                        lista.buscarPorPosicao(posBuscar);
                    } catch (Exception e) {
                        System.out.println("❌ Posição inválida.");
                    }
                    break;
                    
                case 9:
                    lista.imprimir();
                    break;
                    
                case 10:
                    lista.limpar();
                    break;
                    
                case 11:
                    executarTestesAutomaticos();
                    break;
                    
                default:
                    System.out.println("❌ Opção inválida.");
            }
        }
        
        sc.close();
    }
    
    // Método para executar testes automáticos baseados na descrição
    public static void executarTestesAutomaticos() {
        System.out.println("\n🎯 EXECUTANDO TESTES AUTOMÁTICOS\n");
        
        // Teste 1: Cenário básico
        System.out.println("=== TESTE 1 ===");
        ListaNomes lista1 = new ListaNomes();
        lista1.inserirFim("homer");
        lista1.inserirFim("Lisa");
        lista1.imprimir();
        lista1.limpar();
        
        // Teste 2: Inserções mistas
        System.out.println("\n=== TESTE 2 ===");
        ListaNomes lista2 = new ListaNomes();
        lista2.inserirFim("homer");
        lista2.inserirFim("Bart");
        lista2.inserirFim("Lisa");
        lista2.imprimir();
        System.out.println("Tamanho: " + lista2.tamanho());
        lista2.limpar();
        lista2.imprimir();
        
        // Teste 3: Inserção em posição específica
        System.out.println("\n=== TESTE 3 ===");
        ListaNomes lista3 = new ListaNomes();
        lista3.inserirFim("Marge");
        lista3.inserirFim("Lisa");
        lista3.inserirPosicao(1, "Bart");
        lista3.imprimir();
        lista3.limpar();
        
        // Teste 4: Buscas
        System.out.println("\n=== TESTE 4 ===");
        ListaNomes lista4 = new ListaNomes();
        lista4.inserirFim("homer");
        lista4.inserirFim("Lisa");
        lista4.imprimir();
        lista4.buscar("homer");
        lista4.buscar("Marge");
        lista4.buscar("Bart");
        lista4.buscar("Lisa");
        lista4.limpar();
        
        // Teste 5: Inserções no início e remoções
        System.out.println("\n=== TESTE 5 ===");
        ListaNomes lista5 = new ListaNomes();
        lista5.inserirInicio("Marge");
        lista5.inserirInicio("Bart");
        lista5.inserirFim("Bart");
        lista5.imprimir();
        lista5.removerFim();
        lista5.imprimir();
        
        // Teste 6: Remoções e verificações
        System.out.println("\n=== TESTE 6 ===");
        ListaNomes lista6 = new ListaNomes();
        lista6.inserirFim("homer");
        lista6.inserirFim("Lisa");
        lista6.imprimir();
        System.out.println("Tamanho: " + lista6.tamanho());
        lista6.buscar("homer");
        lista6.buscar("Marge");
        lista6.buscar("Bart");
        lista6.buscar("Lisa");
        lista6.removerFim();
        lista6.imprimir();
        System.out.println("Tamanho: " + lista6.tamanho());
        lista6.buscar("homer");
        lista6.buscar("Marge");
        lista6.buscar("Bart");
        lista6.buscar("Lisa");
        lista6.limpar();
        lista6.imprimir();
        
        System.out.println("\n🎯 TESTES CONCLUÍDOS");
    }
}