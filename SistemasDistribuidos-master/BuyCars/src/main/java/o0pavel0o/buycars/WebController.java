package o0pavel0o.buycars;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController{
	@Autowired
	private AnunciosRepository repository;
    

	@Autowired
	private CategoriaRepository categoriaRepository;
	

	@Autowired
	private CocheRepository cocheRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	
	@Autowired
	private VentaRepository ventaRepository;
	

	@GetMapping("/login")
    public String login() {
    	return "login";
    }
	
	
	@GetMapping("/nuevoUsuario")
    public String getUsuario(Model model, HttpServletRequest request,Pageable page) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
    	return "nuevoUsuario";
    }
    
	
	@GetMapping("/nuevoAnuncio")
    public String getAnuncio() {
    	return "nuevoAnuncio";
    }
    
	
	@GetMapping("/nuevaCategoria")
    public String getCategoria() {
    	return "nuevaCategoria";
    }
    
	
    @GetMapping("/loginerror")
    public String loginerror() {
    	return "loginerror";
    }

  
    
    
    @GetMapping("/home")
	public String home(Model model, HttpServletRequest request,Pageable page) { 
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("anuncios", repository.findAll(page));
		model.addAttribute("anunciosCount", repository.count());
		model.addAttribute("usuarios", usuarioRepository.count());
		model.addAttribute("categorias", categoriaRepository.count());
		model.addAttribute("coches", cocheRepository.count());
		
		return "home";
	
	}
}
