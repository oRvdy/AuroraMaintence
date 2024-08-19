# Plugin de Manuntenção BungeeCord

O plugin `Maintence` é uma solução para gerenciar o modo de manutenção em servidores BungeeCord. Ele permite ativar ou desativar o modo de manutenção e gerenciar jogadores autorizados a acessar o servidor durante a manutenção.

## Funcionalidades

- **Ativar/Desativar Manutenção:** Permite alternar entre o modo de manutenção ativado e desativado.
- **Gerenciar Jogadores Autorizados:** Adicione ou remova jogadores da lista de permissão para que possam acessar o servidor durante a manutenção.
- **Mensagens Personalizadas:** As mensagens de manutenção exibidas no chat e na tela de ping do servidor são personalizadas e incluem o nome do servidor em roxo e a mensagem em verde.

## Comandos

- `/manutenção toggle`
    - Alterna o modo de manutenção entre ativado e desativado.

- `/manutenção add jogador`
    - Adiciona um jogador à lista de permissão.

- `/manutenção remove jogador`
    - Remove um jogador da lista de permissão.

## Instalação

1. Baixe o arquivo JAR do plugin.
2. Coloque o arquivo JAR na pasta `plugins` do seu servidor BungeeCord.
3. Reinicie o servidor BungeeCord.

## Configuração

O plugin utiliza um arquivo de configuração YAML chamado `config.yml` que é gerado automaticamente na primeira execução. Você pode editar este arquivo para ajustar as configurações, como a lista de jogadores autorizados.
