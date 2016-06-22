package Autenticacao;


import Bean.CarrinhoBean;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Felipe Rodrigues
 */


@WebFilter(servletNames = {"Faces Servlet"})
public class ControleDeAcesso implements Filter {
    CarrinhoBean carrinho = new CarrinhoBean();
    

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
      

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        
        if(session.getAttribute("USUARIOLogado") != null && (req.getRequestURI().endsWith("/LowPriceCell/logar.xhtml"))) {
            redireciona("/LowPriceCell/index.xhtml", response);
        
        }if(session.getAttribute("USUARIOLogado") != null && (req.getRequestURI().endsWith("/LowPriceCell/cadastrocliente.xhtml"))) {
            redireciona("/LowPriceCell/index.xhtml", response);
            
        }if(session.getAttribute("USUARIOLogado") != null && (req.getRequestURI().endsWith("/LowPriceCell/finalizarcompra.xhtml"))) {
            redireciona("/LowPriceCell/payment.xhtml", response);  
      
        }if(session.getAttribute("USUARIOLogado") != null && (req.getRequestURI().endsWith("/LowPriceCell/endereco.xhtml"))) {
            chain.doFilter(request, response);
        
        }if(session.getAttribute("USUARIOLogado") != null && (req.getRequestURI().endsWith("/LowPriceCell/minhaconta.xhtml"))) {
            chain.doFilter(request, response);
        
            
        } else if ((session.getAttribute("USUARIOLogado") != null)
                || (req.getRequestURI().endsWith("/LowPriceCell/index.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/cadastrocliente.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/celularesapple.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/detalheproduto.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/celularessamsung.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/celulareslg.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/celularesmotorola.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/celularesmicrosoft.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/celularesentrada.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/celularesintermediario.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/celulareshighend.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/celularesios.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/celulareswindows.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/celularesandroid.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/logar.xhtml"))                
                || (req.getRequestURI().endsWith("/LowPriceCell/sobre.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/error.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/newjsf.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/pagamentocartao.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/boleto.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/pesquisar.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/payment.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/"))               
                || (req.getRequestURI().endsWith("/LowPriceCell/carrinho.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/cadastroproduto.xhtml"))
                || (req.getRequestURI().endsWith("/LowPriceCell/finalizarcompra.xhtml"))
                || (req.getRequestURI().contains("javax.faces.resource/"))
                || (req.getRequestURI().contains("resources/"))
                || (req.getRequestURI().contains("/resources/"))) {

            chain.doFilter(request, response);

        } else {
            redireciona("/LowPriceCell/index.xhtml", response);
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }

    private void redireciona(String url, ServletResponse response)
            throws IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(url);
    }
}
