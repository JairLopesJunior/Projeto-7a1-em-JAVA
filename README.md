Link para Testar o Projeto: https://repl.it/@jairlopes/Projeto-7-a-1

<b>“Projeto 7 a 1”</b>
No dia 23 de junho, a aula será para apresentação do código desenvolvido. Cada aluno terá cinco minutos para apresentar o código desenvolvido, explicando as funções criadas e tirando eventuais dúvidas do professor quando a sua estratégia de desenvolvimento. Neste ano, teremos Copa do Mundo. Temporada aberta para camisas verde e amarela, vuvuzelas e outras coisas típicas deste evento que ocorre a cada quatro anos. Um fato típico desta época são as figurinhas da copa do mundo. Neste projeto, você precisa desenvolver um software que controle as figurinhas já adquiridas do álbum e as figurinhas repetidas. Cada pacote de figurinha possui 5 figurinhas. O álbum completo possui espaço para colar figurinhas que vão de 1 até 681. Vez ou outra, ao abrir um pacote de figurinhas, pode surgir uma figurinha repetida. Sua aplicação precisará controlar estas figurinhas repetidas. Utilizando a(s) estrutura(s) de dados que achar mais conveniente.

<b>1.</b> Controle de figurinhas no álbum:
a) Crie uma função que receba uma figurinha e cole no álbum na posição correspondente.

b) Crie uma função para checar se a figurinha está colada no álbum ( esta função será útil ao conferir as repetidas).

<b>2.</b> Relatórios:
a) Crie uma função que imprima um relatório, informando quais são as figurinhas coladas no álbum.

b) Crie uma função que imprima um relatório, informando quais são as figurinhas estão faltando no álbum.

c) Crie uma função que receba uma determinada figurinha e returne true, caso a determinada figurinha esteja no álbum e false, caso contrário.

<b>3.</b> Armazenamento não volátil das informações:
a) Crie uma função que grave em um arquivo texto ( *.txt) as figurinhas faltantes (faltantes.txt) e as que estão no álbum ( eu_tenho.txt)

b) Crie uma função que leia os arquivos (faltantes.txt e eu_tenho.txt), carregando os dados na estrutura da sua aplicação.

<b>4.</b> Figurinhas repetidas:
a) Crie uma função armazene a figurinha em uma estrutura de figurinhas repetidas. Não há limites para o número de figurinhas repetidas.

b) Crie uma função que, ao receber o número da figurinha, retorne, true, informando que esta figurinha está presente no monte de figurinhas repetidas, ou false, caso não esteja.

c) Crie uma função que, ao receber o número da figurinha, retorne-a, removendo do monte de figurinhas repetidas. Esta função é útil em caso de troca de figurinhas.

d) Crie uma função que grave em um arquivo texto ( *.txt) as figurinhas repetidas (repetidas.txt).

e) Crie uma função que leia o arquivo (repetidas.txt), carregando os dados na estrutura da sua aplicação.

<b>5.</b> Pacotinho de figurinhas e trocas.
a) Crie uma função que preencha automaticamente 5 figurinhas ( número de figurinhas presente em um pacotinho). O número da figurinha deve ser um número randômico entre 1 e 681. Ao abir o pacotinho, sua função deverá decidir: Caso a figurinha NÃO esteja no álbum, preencher o álbum. Senão, armazenar no monte de figurinhas repetidas.

b) Faça uma função de troca. Esta função deve receber dois números: a figurinha que você não tem no seu álbum e uma que você tenha no monte das repetidas. Remova a do monte de repetidas e armazene a que você trocou no se álbum.

