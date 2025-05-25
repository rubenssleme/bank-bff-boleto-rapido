package br.com.bank.capd.bff.rapid.payment.adapter.output.log;

//import br.com.bank.enge.logcloud.canal.SrvCanalLogger;


public class LogServicoCanal {

    public static final String KIT_001 = "KIT001";
    //private final SrvCanalLogger canalLogger;

//    public LogServicoCanal(SrvCanalLogger canalLogger) {
//        this.canalLogger = canalLogger;
//    }

//    @Override
//    public void logConsultaTodosLivros(ReturnCode returnCode, List<?> livros) {
//        this.canalLogger.log(
//                SrvCanalLog.builder(returnCode)
//                        // Entrada é um campo mandatório do log
//                        .entrada("Entrada: Request para buscar a colecao de livros->: sem parametro")
//                        // Saida não é um campo mandatório
//                        .saida("Saida: Colecao de livros cadastrados nas base de dados->: " + livros)
//                        .codigoTransacao(KIT_001)
//                        .addMensagem(KIT_001, "Buscar colecao de livros")
//                        .build());
//    }

}
