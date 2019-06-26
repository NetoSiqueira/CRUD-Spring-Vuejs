package npi.ufc.autoestudo.controler;

import npi.ufc.autoestudo.model.Contato;
import npi.ufc.autoestudo.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class PaginaIncialControler {


    @Autowired
    private ContatoService contatoService;


    @PostMapping("adicionar/")
    public Contato adicionarContato(@RequestBody Contato contato){

        return contatoService.salvar(contato);
    }

    @RequestMapping("listar/")
    public List<Contato> listarContatos(){
        return contatoService.Listar();
    }

    @RequestMapping("excluir/{id}")
    public void delete(@PathVariable Long id){
         contatoService.deletar(id);

    }


    @PutMapping("atualizar/{id}")
    public Contato atualizarPessoa(@PathVariable Long id, @Valid @RequestBody Contato contato) {
        return  contatoService.EditarContato(contato, id);

    }
}
