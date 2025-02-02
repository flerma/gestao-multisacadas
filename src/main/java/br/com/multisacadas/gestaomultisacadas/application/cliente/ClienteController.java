package br.com.multisacadas.gestaomultisacadas.application.cliente;

import br.com.multisacadas.gestaomultisacadas.core.cliente.Cliente;
import br.com.multisacadas.gestaomultisacadas.core.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.listarTodos();
        model.addAttribute("clientes", clientes);
        return "cliente/lista";
    }

    @GetMapping("/novo")
    public String novoClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/formulario";
    }

    @PostMapping
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editarClienteForm(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        return "cliente/formulario";
    }

    @PostMapping("/editar/{id}")
    public String atualizarCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        cliente.setId(id);
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.deletar(id);
        return "redirect:/clientes";
    }
}
