# language: pt
@Cadastro
Funcionalidade: Realizar testes de cadastro:
  1)Cadastrar novo cliente
  2)Atualizar cliente
  3)Excluir cliente

  Esquema do Cenario: Cadastro com sucesso
    Dado que esteja na tela inicial
    Quando cadastrar um novo cliente com os dados <nome>, <cpf>, <data_nascimento> e <email>
    Entao deve ser exibido a mensagem de cadastro efetuado

    Exemplos: 
      | nome                  | cpf           | data_nascimento | email             |
      | "Cliente cadastro um" | "4568734567"  | "20/01/2000"    | "teste@hotmail.co.com" |

  Esquema do Cenario: Atualizar cliente
    Dado que tenha ao menos um cliente cadastrado
    Quando atualizar os dados do cliente com <nome>, <cpf>, <data_nascimento> e <email>
    Entao deve ser exibido a mensagem de cadastro atualizado

    Exemplos: 
      | nome        | cpf           | data_nascimento | email                   |
      | "Novo nome" | 345566778888" | "10/06/1985"    | "atualizacao@hotmail.com.com" |

  Cenario: Excluir cliente
    Dado que tenha ao menos um cliente cadastrado
    Quando acessar e excluir o cliente
    Entao o cliente deve ser removido da tela inicial