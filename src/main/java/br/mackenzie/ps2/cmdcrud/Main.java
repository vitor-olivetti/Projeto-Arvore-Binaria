package br.mackenzie.ps2.cmdcrud;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import static br.mackenzie.ps2.utils.ES.*;

@SpringBootApplication
public class Main 
  implements CommandLineRunner {
    Arvore arvore = new Arvore();

    @Autowired
    private ServicoRepo servicoRepo;
    
    public static void main(String[] args) {
            SpringApplication.run(Main.class, args);

    }

    private void criarServico(Elemento ele) {

      print("\n## Criação de um novo serviço!");

      long id = inputLong("\n## Id do novo serviço: ");
      String endereco = inputString("\n## Endereço do serviço: ");
      String horario = inputString("\n## Horário do serviço: ");
      int preco = inputInt("\n## Preço do serviço: ");

      Servico novoServico = new Servico(id, endereco, horario, preco);
      servicoRepo.save(novoServico);

      arvore.inserir(ele, id);

      print("\n## Novo serviço criado com sucesso!!");
    }

    private void lerTodosServicos() {

      print("\n## Lista de todos os serviços: \n");

      Iterable<Servico> servicos = servicoRepo.findAll();
      
      for (Servico s: servicos) {

        print(String.format("- Serviço %d\n Enderço: %s\n Horário: %s\n Preço: %d\n",
        s.getIdServico(), s.getEndereco(), s.getHorario(), s.getPreco()));
      }
    }

    private void buscarServicoById(){
      print("\n## Buscar serviço por ID");

      long id = inputLong("\n## ID do serviço a ser buscado: ");
      servicoRepo.findById(id);
      Optional<Servico> opt = servicoRepo.findById(id);

      if (opt.isPresent()){
        print("\nServiço com ID "+ id +" foi encontrado!\n");

        Servico s = opt.get();
        print(String.format("- Serviço %d\n Enderço: %s\n Horário: %s\n Preço: %d\n",
        s.getIdServico(), s.getEndereco(), s.getHorario(), s.getPreco()));
      }
      else {
        print("\nServiço com ID "+ id +" não foi encontrado!\n");
      }
    }

    private void apagarServico() {

      print("\n## Remoção de um serviço");

      long id = inputLong("\n## ID do serviço a ser apagado: ");
      servicoRepo.findById(id);
      Optional<Servico> opt = servicoRepo.findById(id);

      if (opt.isPresent()) {

        Servico s = opt.get();
        servicoRepo.delete(s);

        print("\n## Serviço apagado com sucesso!!");
      }
      else{
        
        print("\n## Não existe um serviço com o ID " + id);
      }
      try {
        arvore.remover(id);
      } catch (NullPointerException ex) {
        print("");
      }
    }

    @Override
    public void run(String... args) {
        print("\n## GERENCIADOR DE SERVIÇOS ##");

        boolean sair = false;
        while (!sair) {

          print("\n## MENU");
          print("1 - Inserir um serviço");
          print("2 - Ler todos os serviços");
          print("3 - Apagar um serviço");
          print("4 - Buscar serviço por ID");
          print("0 - Sair");

          int op = inputInt("\nEscolha uma opção: ");

          switch(op) {

            case 1: criarServico(null); break;
            case 2: lerTodosServicos(); break;
            case 3: apagarServico(); break;
            case 4: buscarServicoById(); break;
            case 0: sair = true; break;
            default: print("\n## Opção inválida!!");
          }
        }

        print("\n## FIM DO PROGRAMA! ##");
    }
    
}
