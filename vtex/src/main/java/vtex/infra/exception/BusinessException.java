package vtex.infra.exception;

import org.springframework.lang.NonNull;

/**
 * Classe que respresenta uma Excessão de Negócio
 */
public class BusinessException extends RuntimeException {

    public BusinessException(@NonNull String message) {
        super(message);
    }

//    public void sacar(Integer numConta, Double preco){
//        ///repositor.createTransaction()
//                //try{
//                    repository.initTransaction()
//                    Conta conta  = repository.find(numConta);
//                    if(conta == null) thow "conta invalida""
//                    if(conta.saldo < preco) thow "saldo insuficiente"
//                    conta.saldo = conta.sald - preco;
//                    repository.save(conta)
//                    //repositoyr.commiit()
//                //}catch(Exception e){
//                    //repositor.rollaback
//                //}finaly {
//                  //  repository.closeTransaction()
//                //}
//        }

//    @Transactional
//    @RollesAllowed({"ANDMIN","MANAGER"})
//    public void sacar(Integer numConta, Double preco){
//        Conta conta  = repository.find(numConta);
//        if(conta == null) thow "conta invalida""
//        if(conta.saldo < preco) thow "saldo insuficiente"
//        conta.saldo = conta.sald - preco;
//        repository.save(conta)
//    }


//    }

}
