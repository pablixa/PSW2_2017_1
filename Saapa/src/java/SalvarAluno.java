
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author RA21553740
 */
public class SalvarAluno extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            try{
                
                String Nome = request.getParameter("nome"); //pega lá do formulário
                String Cpf = request.getParameter("cpf");
                String dt_nasc = request.getParameter("dt_nasc");
                String Sexo = request.getParameter("sexo");
                
                Aluno a = new Aluno();
                a.setCpf(Cpf);
                a.setNome(Nome);
                a.setSexo(Sexo);
                a.setDt_nascimento(dt_nasc);
               

                Session sessao = HibernateUtil.
                                    getSessionFactory()
                                    .openSession();

                Transaction tx = sessao.beginTransaction();
                
                try{
                
                sessao.save(a);
                sessao.flush();

                tx.commit();
            }
            catch (Exception e){
                System.out.println("Erro:" + e.getMessage());
                e.printStackTrace();
                tx.rollback();
            
            }
                sessao.close();
                
                out.println("Registro inserido com sucesso!");
            } catch (Exception ex) {
                out.println("Erro ao inserir aluno: " + ex.getMessage());
                
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
