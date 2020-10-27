package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import user.UserLogado;

@WebFilter(urlPatterns={"/pages/*"})    
public class FilterAutenticacao implements Filter{ 
 
	//faz alguma coisa quando a aplica��o � derrubada
	@Override
	public void destroy() {
		
	}

	//intercepta todas as requisi��es
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			
			String urlParaAutenticar = req.getServletPath();	
			// retorna null caso n�o esteja logado
		    UserLogado userLogado = (UserLogado) session.getAttribute("usuario");
		    
		    if (userLogado == null && !urlParaAutenticar.equalsIgnoreCase("/pages/ServletAutenticacao")){ // usu�rio n�o logado
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/autenticar.jsp?url="+urlParaAutenticar);
		    	dispatcher.forward(request, response);
		    	return;// para o processo para redirecionar
		    }
	 	
			// executa as a��es do request e response
			chain.doFilter(request, response);
		
	}

	// executa alguma coisa quando a aplica��o � iniciada
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
