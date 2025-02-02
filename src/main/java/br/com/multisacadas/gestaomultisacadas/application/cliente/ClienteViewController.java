package br.com.multisacadas.gestaomultisacadas.application.cliente;

import br.com.multisacadas.gestaomultisacadas.core.cliente.Cliente;
import br.com.multisacadas.gestaomultisacadas.core.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClienteViewController {

    private final ClienteService clienteService;

    @GetMapping
    public String listarClientesView(Model model) {
        List<Cliente> clientes = clienteService.listarTodos();
        model.addAttribute("clientes", clientes);
        return "cliente/lista";
    }

    @GetMapping("/novo")
    public String novoClienteView(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editarClienteView(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        return "cliente/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String deletarClienteView(@PathVariable Long id) {
        clienteService.deletar(id);
        return "redirect:/clientes/view";
    }

}