package br.com.multisacadas.gestaomultisacadas.application.cliente;

import br.com.multisacadas.gestaomultisacadas.core.cliente.Cliente;
import br.com.multisacadas.gestaomultisacadas.core.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteViewController {

    private final ClienteService clienteService;

    @GetMapping
    public String listarClientesView(Model model) {
        List<Cliente> clientes = clienteService.listarTodos();
        model.addAttribute("clientes", clientes);
        return "clientes/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/formulario";
    }

    @PostMapping
    public String salvar(@ModelAttribute("cliente") Cliente cliente, Model model) {

        if (clienteService.existePorCpfCnpj(cliente.getCpfCnpj())) {
            model.addAttribute("erroCpfCnpj", "Já existe um cliente cadastrado com este CPF/CNPJ.");
            model.addAttribute("cliente", cliente);
            return "clientes/formulario";
        }

        clienteService.salvar(cliente);
        return "redirect:/clientes";

    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        return "clientes/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return "redirect:/clientes";
    }

}